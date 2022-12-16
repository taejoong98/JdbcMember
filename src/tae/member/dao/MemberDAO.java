package tae.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import tae.jdbc.dbcp.Context;
import tae.member.dto.MemberDTO;
import tae.member.service.MemberService;

public class MemberDAO implements MemberService {
	private static final Log log = LogFactory.getLog(MemberDAO.class);

	@Override
	public ArrayList<MemberDTO> memberSelectAll() {
		ArrayList<MemberDTO> arrayList = new ArrayList<MemberDTO>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			Context context = new Context();
			DataSource dataSource = context.basicDataSource;
			connection = dataSource.getConnection();
			String sql = "select umail, upw, uname, to_char(joinday, 'yyyy/mm/dd')joinday from member";
			log.info("SQL - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				MemberDTO memberDTO = new MemberDTO();
				memberDTO.setUmail(resultSet.getString("umail"));
				memberDTO.setUpw(resultSet.getString("upw"));
				memberDTO.setUname(resultSet.getString("uname"));
				memberDTO.setJoinday(resultSet.getString("joinday"));
				arrayList.add(memberDTO);
				log.info("조회 데이터 확인 - " + memberDTO);
			}
			resultSet.getRow();
			if (resultSet.getRow() == 0) {
				log.info("등록한 부서가 없습니다.");
			}
		} catch (Exception e) {
			log.info("전체 회원 조회 실패 - " + e);
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arrayList;
	}

	@Override
	public MemberDTO memberSelect(String umail) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		MemberDTO memberDTO = new MemberDTO();

		try {
			Context context = new Context();
			DataSource dataSource = context.basicDataSource;
			connection = dataSource.getConnection();
			String sql = "select umail, upw, uname from member ";
			sql += " where umail = ? ";
			log.info("SQL - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, umail);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				memberDTO.setUmail(resultSet.getString("umail"));
				memberDTO.setUpw(resultSet.getString("upw"));
				memberDTO.setUname(resultSet.getString("uname"));
			}
		} catch (Exception e) {
			log.info("예외 확인 - " + e);
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return memberDTO;
	}

	@Override
	public MemberDTO memberInsert(String umail, String upw, String uname) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setUmail(umail);
		memberDTO.setUpw(upw);
		memberDTO.setUname(uname);

		try {
			Context context = new Context();
			DataSource dataSource = context.basicDataSource;
			connection = dataSource.getConnection();
			String sql = "insert into member(umail, upw, uname, joinday)";
			sql += " values (?, ?, ?, sysdate)";
			log.info("SQL - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberDTO.getUmail());
			preparedStatement.setString(2, memberDTO.getUpw());
			preparedStatement.setString(3, memberDTO.getUname());

			int count = preparedStatement.executeUpdate();
			log.info("입력 데이터 확인 - " + memberDTO);

			if (count > 0) {
				connection.commit();
				log.info("커밋");
			} else {
				connection.rollback();
				log.info("롤백");
			}
		} catch (SQLException e) {
			log.info("입력 실패 - " + e);
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return memberDTO;
	}

	@Override
	public MemberDTO memberUpdate(String umail, String upw, String uname) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setUmail(umail);
		memberDTO.setUpw(upw);
		memberDTO.setUname(uname);

		try {
			Context context = new Context();
			DataSource dataSource = context.basicDataSource;
			connection = dataSource.getConnection();
			String sql = "update member set upw = ?, uname = ? where umail = ?";
			log.info("SQL - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberDTO.getUpw());
			preparedStatement.setString(2, memberDTO.getUname());
			preparedStatement.setString(3, memberDTO.getUmail());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			log.info("예외 확인 - " + e);
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return memberDTO;
	}

	@Override
	public MemberDTO memberDelete(String umail) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setUmail(umail);

		try {
			Context context = new Context();
			DataSource dataSource = context.basicDataSource;
			connection = dataSource.getConnection();
			String sql = "delete from member ";
			sql += " where umail = ?";
			log.info("SQL - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, umail);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			log.info("예외 확인 - " + e);
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return memberDTO;
	}

}
