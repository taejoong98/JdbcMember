package tae.member.dto;

public class MemberDTO {
	
	private String umail;
	private String upw;
	private String uname;
	private String joinday;
	public String getUmail() {
		return umail;
	}
	public void setUmail(String umail) {
		this.umail = umail;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getJoinday() {
		return joinday;
	}
	public void setJoinday(String joinday) {
		this.joinday = joinday;
	}
	@Override
	public String toString() {
		return "MemberDTO [umail=" + umail + ", upw=" + upw + ", uname=" + uname + ", joinday=" + joinday + "]";
	}
	
	
	

}
