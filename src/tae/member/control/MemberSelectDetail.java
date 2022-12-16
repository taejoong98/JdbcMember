package tae.member.control;

import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import tae.member.action.MemberAction;
import tae.member.dao.MemberDAO;
import tae.member.dto.MemberDTO;

public class MemberSelectDetail implements MemberAction {
	private static final Log log = LogFactory.getLog(MemberSelectDetail.class);

	@Override
	public void execute(Scanner scanner) {
		MemberDTO memberDTO = new MemberDTO();
		MemberDAO memberDAO = new MemberDAO();
		System.out.println("검색할 이메일을 입력하세요.");
		System.out.print("이메일 : ");
		String umail = scanner.next();

		memberDTO = memberDAO.memberSelect(umail);
		log.info("데이터 확인 - " + memberDTO);
		umail = memberDTO.getUmail();
		String upw = memberDTO.getUpw();
		String uname = memberDTO.getUname();
		if (memberDTO.getUmail() == null) {
			System.out.println("등록된 회원이 없습니다.");
		} else {
			System.out.println("이메일 : " +umail + " " + "비밀번호 : " + upw + " " + "닉네임 : " + uname);
		}
	}

}
