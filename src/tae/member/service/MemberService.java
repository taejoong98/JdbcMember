package tae.member.service;

import java.util.ArrayList;

import tae.member.dto.MemberDTO;

public interface MemberService {
	
	public ArrayList<MemberDTO> memberSelectAll();
	public MemberDTO memberSelect(String umail);
	public MemberDTO memberInsert(String umail, String upw, String uname);
	public MemberDTO memberUpdate(String umail, String upw, String uname);
	public MemberDTO memberDelete(String umail);
}
