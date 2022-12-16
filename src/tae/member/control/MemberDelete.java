package tae.member.control;

import java.util.ArrayList;
import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import tae.member.action.MemberAction;
import tae.member.dao.MemberDAO;
import tae.member.dto.MemberDTO;

public class MemberDelete implements MemberAction{
	 private static final Log log = LogFactory.getLog(MemberDelete.class);

	@Override
	public void execute(Scanner scanner) {
		MemberDAO memberDAO = new MemberDAO();
		ArrayList<MemberDTO> arrayList = new ArrayList<MemberDTO>();
		System.out.println("삭제할 회원을 입력해주세요.");
		System.out.print("이메일 : ");
		String umail = scanner.next();
		arrayList = memberDAO.memberSelectAll();
		log.info("데이터 확인 - " + arrayList);
		boolean check = false;
		for (MemberDTO memberDTO2 : arrayList) {
			if (memberDTO2.getUmail().equals(umail)) {
				MemberDTO memberDTO = new MemberDTO();
				memberDTO = memberDAO.memberDelete(umail);
				log.info("데이터 확인 - " + memberDTO);
				System.out.println("삭제를 완료하였습니다.");
				check = true;
				break;
			}
		}
		if (check == false) {
			System.out.println("삭제할 회원이 없습니다.");
		}
	}

}
