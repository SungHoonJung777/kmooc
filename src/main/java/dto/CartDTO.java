package dto;

import java.util.Date;

public class CartDTO {

	private int cart_idx;
	private String member_user_id;
	private int lecture_idx;
	private String lecture_title;
	private String lecture_teacher;
	private String lecture_img;
	private String cart_result;
	private Date cart_reg_date;

	public int getCart_idx() {
		return cart_idx;
	}

	public void setCart_idx(int cart_idx) {
		this.cart_idx = cart_idx;
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

	public String getCart_result() {
		return cart_result;
	}

	public void setCart_result(String cart_result) {
		this.cart_result = cart_result;
	}

	public Date getCart_reg_date() {
		return cart_reg_date;
	}

	public void setCart_reg_date(Date cart_reg_date) {
		this.cart_reg_date = cart_reg_date;
	}

	@Override
	public String toString() {
		return "CartDTO [cart_idx=" + cart_idx + ", member_user_id=" + member_user_id + ", lecture_idx=" + lecture_idx
				+ ", lecture_title=" + lecture_title + ", lecture_teacher=" + lecture_teacher + ", lecture_img="
				+ lecture_img + ", cart_result=" + cart_result + ", cart_reg_date=" + cart_reg_date + "]";
	}

	public CartDTO() {
	}

	public CartDTO(int cart_idx, String member_user_id, int lecture_idx, String lecture_title, String lecture_teacher,
			String lecture_img, String cart_result, Date cart_reg_date) {
		super();
		this.cart_idx = cart_idx;
		this.member_user_id = member_user_id;
		this.lecture_idx = lecture_idx;
		this.lecture_title = lecture_title;
		this.lecture_teacher = lecture_teacher;
		this.lecture_img = lecture_img;
		this.cart_result = cart_result;
		this.cart_reg_date = cart_reg_date;
	}

}
