package tae.member.control;

import java.util.ArrayList;
import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import tae.member.action.MemberAction;
import tae.member.dao.MemberDAO;
import tae.member.dto.MemberDTO;

public class MemberSelect implements MemberAction{
	 private static final Log log = LogFactory.getLog(MemberSelect.class);

	@Override
	public void execute(Scanner scanner) {
		ArrayList<MemberDTO> arrayList = new ArrayList<MemberDTO>();
		MemberDAO memberDAO = new MemberDAO();
		arrayList = memberDAO.memberSelectAll();
		log.info("데이터 확인 - " + arrayList);
		boolean check = false;
		
		for (MemberDTO memberDTO : arrayList) {
			String umail = memberDTO.getUmail();
			String upw = memberDTO.getUpw();
			String uname = memberDTO.getUname();
			String joinday = memberDTO.getJoinday();
			System.out.println("이메일 : "+umail + " " + "비밀번호 : "+upw + " "+"닉네임 : "+uname+" "+"가입일 : "+joinday);
			check = true;
		}
		if (check==false) {
			System.out.println("등록한 회원이 없습니다.");
		}
	}

}
