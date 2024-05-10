package member;

import java.sql.Date;

public class MemberDTO {
	private int member_idx;
	private String member_name;
	private String member_user_id;
	private String member_pwd;
	private String member_phone;
	private String member_email;
	private String member_category;
	private String member_company_num;
	private String member_company;
	private String member_lecture_now;
	private String member_lecture_upload;
	private Date member_info_upload;
	private String member_birth;
	
	public MemberDTO() {
		
	}

	public int getMember_idx() {
		return member_idx;
	}

	public void setMember_idx(int member_idx) {
		this.member_idx = member_idx;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_user_id() {
		return member_user_id;
	}

	public void setMember_user_id(String member_user_id) {
		this.member_user_id = member_user_id;
	}

	public String getMember_pwd() {
		return member_pwd;
	}

	public void setMember_pwd(String member_pwd) {
		this.member_pwd = member_pwd;
	}

	public String getMember_phone() {
		return member_phone;
	}

	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}

	public String getMember_email() {
		return member_email;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}

	public String getMember_category() {
		return member_category;
	}

	public void setMember_category(String member_category) {
		this.member_category = member_category;
	}

	public String getMember_company_num() {
		return member_company_num;
	}

	public void setMember_company_num(String member_company_num) {
		this.member_company_num = member_company_num;
	}

	public String getMember_company() {
		return member_company;
	}

	public void setMember_company(String member_company) {
		this.member_company = member_company;
	}

	public String getMember_lecture_now() {
		return member_lecture_now;
	}

	public void setMember_lecture_now(String member_lecture_now) {
		this.member_lecture_now = member_lecture_now;
	}

	public String getMember_lecture_upload() {
		return member_lecture_upload;
	}

	public void setMember_lecture_upload(String member_lecture_upload) {
		this.member_lecture_upload = member_lecture_upload;
	}

	public Date getMember_info_upload() {
		return member_info_upload;
	}

	public void setMember_info_upload(Date member_info_upload) {
		this.member_info_upload = member_info_upload;
	}

	public String getMember_birth() {
		return member_birth;
	}

	public void setMember_birth(String member_birth) {
		this.member_birth = member_birth;
	}
}
