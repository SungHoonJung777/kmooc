package dto;

import java.util.Date;

public class HeartDTO {

	private int heart_idx;
	private String member_user_id;
	private int lecture_idx;
	private String lecture_title;
	private String lecture_teacher;
	private String lecture_img;
	private int heart_count;
	
	
	public int getHeart_idx() {
		return heart_idx;
	}
	public void setHeart_idx(int heart_idx) {
		this.heart_idx = heart_idx;
	}
	public String getMember_user_id() {
		return member_user_id;
	}
	public void setMember_user_id(String member_user_id) {
		this.member_user_id = member_user_id;
	}
	public int getLecture_idx() {
		return lecture_idx;
	}
	public void setLecture_idx(int lecture_idx) {
		this.lecture_idx = lecture_idx;
	}
	public String getLecture_title() {
		return lecture_title;
	}
	public void setLecture_title(String lecture_title) {
		this.lecture_title = lecture_title;
	}
	public String getLecture_teacher() {
		return lecture_teacher;
	}
	public void setLecture_teacher(String lecture_teacher) {
		this.lecture_teacher = lecture_teacher;
	}
	public String getLecture_img() {
		return lecture_img;
	}
	public void setLecture_img(String lecture_img) {
		this.lecture_img = lecture_img;
	}
	public int getHeart_count() {
		return heart_count;
	}
	public void setHeart_count(int heart_count) {
		this.heart_count = heart_count;
	}
	@Override
	public String toString() {
		return "HeartDTO [heart_idx=" + heart_idx + ", member_user_id=" + member_user_id + ", lecture_idx="
				+ lecture_idx + ", lecture_title=" + lecture_title + ", lecture_teacher=" + lecture_teacher
				+ ", lecture_img=" + lecture_img + ", heart_count=" + heart_count + "]";
	}
	
	
	public HeartDTO() {
		// TODO Auto-generated constructor stub
	}
	public HeartDTO(int heart_idx, String member_user_id, int lecture_idx, String lecture_title, String lecture_teacher,
			String lecture_img, int heart_count) {
		super();
		this.heart_idx = heart_idx;
		this.member_user_id = member_user_id;
		this.lecture_idx = lecture_idx;
		this.lecture_title = lecture_title;
		this.lecture_teacher = lecture_teacher;
		this.lecture_img = lecture_img;
		this.heart_count = heart_count;
	}
}
