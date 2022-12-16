package tae.member.control;

import java.util.ArrayList;
import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import tae.member.action.MemberAction;
import tae.member.dao.MemberDAO;
import tae.member.dto.MemberDTO;

public class MemberInsert implements MemberAction {
	private static final Log log = LogFactory.getLog(MemberInsert.class);

	@Override
	public void execute(Scanner scanner) {
		System.out.println();
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();
		ArrayList<MemberDTO> arrayList = new ArrayList<MemberDTO>();
		System.out.println("회원 정보를 입력하세요.");
		System.out.print("이메일 : ");
		String umail = scanner.next();
		arrayList = memberDAO.memberSelectAll();
		log.info("데이터 확인 - " + arrayList);
		for (MemberDTO memberDTO2 : arrayList) {
			if (memberDTO2.getUmail().equals(umail)) {
				System.out.println("이미 등록된 회원이 있습니다.");
				return;
			}
		}
		System.out.print("비밀번호 : ");
		String upw = scanner.next();
		System.out.print("닉네임 : ");
		String uname = scanner.next();

		memberDTO = memberDAO.memberInsert(umail, upw, uname);
		log.info("데이터 확인 - " + memberDTO);
		System.out.println("회원 가입이 완료되었습니다.");
	}
}
