package tae.member.view;

import java.util.Scanner;

import tae.member.control.MemberDelete;
import tae.member.control.MemberInsert;
import tae.member.control.MemberSelect;
import tae.member.control.MemberSelectDetail;
import tae.member.control.MemberUpdate;

public class MemberMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println();
			System.out.println("번호를 선택하세요.");
			System.out.println("1.회원 전체 조회 "+"2.회원 등록 "+"3.부서 수정 "+"4.회원 삭제 "+"5.회원 상세 조회 "+"6.종료");
			String menu = scanner.next();
			switch (menu) {
			case "1":
				MemberSelect memberSelect = new MemberSelect();
				memberSelect.execute(scanner);
				break;
			case "2":
				MemberInsert memberInsert = new MemberInsert();
				memberInsert.execute(scanner);
				break;
			case "3":
				MemberUpdate memberUpdate = new MemberUpdate();
				memberUpdate.execute(scanner);
				break;
			case "4":
				MemberDelete memberDelete = new MemberDelete();
				memberDelete.execute(scanner);
				break;
			case "5":
				MemberSelectDetail memberSelectDetail = new MemberSelectDetail();
				memberSelectDetail.execute(scanner);
				break;
			case "6":
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			default:
				System.out.println("1번에서 6번 중의 번호를 선택하세요.");
				break;
			}
		} while (true);
	}

}
