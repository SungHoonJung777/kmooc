package dto;

import java.util.Date;

public class LectureDTO {
	private int lecture_idx;
	private String lecture_title;
	private String member_name;
	private String member_company;
	private Date lecture_start_date;
	private Date lecture_end_date;
	private String lecture_img;
	private String lecture_endPrize; 
	private int lecture_star;
	private String lecture_content;
	private String lecture_plan;
	private String lecture_content_detail;
	private String  lecture_question;
	private String  lecture_youtube_url;
	private String  lecture_category;
	private String  lecture_category_detail;
	private int member_idx;
	private int heart_count;
	private String recommendyn;
	private String bestyn;
	private Date lecture_reg_date;
	private String member_phone;
	private String member_user_id;
	
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
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_company() {
		return member_company;
	}
	public void setMember_company(String member_company) {
		this.member_company = member_company;
	}
	public Date getLecture_start_date() {
		return lecture_start_date;
	}
	public void setLecture_start_date(Date lecture_start_date) {
		this.lecture_start_date = lecture_start_date;
	}
	public Date getLecture_end_date() {
		return lecture_end_date;
	}
	public void setLecture_end_date(Date lecture_end_date) {
		this.lecture_end_date = lecture_end_date;
	}
	public String getLecture_img() {
		return lecture_img;
	}
	public void setLecture_img(String lecture_img) {
		this.lecture_img = lecture_img;
	}
	public String getLecture_endPrize() {
		return lecture_endPrize;
	}
	public void setLecture_endPrize(String lecture_endPrize) {
		this.lecture_endPrize = lecture_endPrize;
	}
	public int getLecture_star() {
		return lecture_star;
	}
	public void setLecture_star(int lecture_star) {
		this.lecture_star = lecture_star;
	}
	public String getLecture_content() {
		return lecture_content;
	}
	public void setLecture_content(String lecture_content) {
		this.lecture_content = lecture_content;
	}
	public String getLecture_plan() {
		return lecture_plan;
	}
	public void setLecture_plan(String lecture_plan) {
		this.lecture_plan = lecture_plan;
	}
	public String getLecture_content_detail() {
		return lecture_content_detail;
	}
	public void setLecture_content_detail(String lecture_content_detail) {
		this.lecture_content_detail = lecture_content_detail;
	}
	public String getLecture_question() {
		return lecture_question;
	}
	public void setLecture_question(String lecture_question) {
		this.lecture_question = lecture_question;
	}
	public String getLecture_youtube_url() {
		return lecture_youtube_url;
	}
	public void setLecture_youtube_url(String lecture_youtube_url) {
		this.lecture_youtube_url = lecture_youtube_url;
	}
	public String getLecture_category() {
		return lecture_category;
	}
	public void setLecture_category(String lecture_category) {
		this.lecture_category = lecture_category;
	}
	public String getLecture_category_detail() {
		return lecture_category_detail;
	}
	public void setLecture_category_detail(String lecture_category_detail) {
		this.lecture_category_detail = lecture_category_detail;
	}
	public int getMember_idx() {
		return member_idx;
	}
	public void setMember_idx(int member_idx) {
		this.member_idx = member_idx;
	}
	public int getHeart_count() {
		return heart_count;
	}
	public void setHeart_count(int heart_count) {
		this.heart_count = heart_count;
	}
	public String getRecommendyn() {
		return recommendyn;
	}
	public void setRecommendyn(String recommendyn) {
		this.recommendyn = recommendyn;
	}
	public String getBestyn() {
		return bestyn;
	}
	public void setBestyn(String bestyn) {
		this.bestyn = bestyn;
	}
	public Date getLecture_reg_date() {
		return lecture_reg_date;
	}
	public void setLecture_reg_date(Date lecture_reg_date) {
		this.lecture_reg_date = lecture_reg_date;
	}
	public String getMember_phone() {
		return member_phone;
	}
	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}
	public String getMember_user_id() {
		return member_user_id;
	}
	public void setMember_user_id(String member_user_id) {
		this.member_user_id = member_user_id;
	}
	public LectureDTO() {
		// TODO Auto-generated constructor stub
	}
	public LectureDTO(int lecture_idx, String lecture_title, String member_name, String member_company,
			Date lecture_start_date, Date lecture_end_date, String lecture_img, String lecture_endPrize,
			int lecture_star, String lecture_content, String lecture_plan, String lecture_content_detail,
			String lecture_question, String lecture_youtube_url, String lecture_category,
			String lecture_category_detail, int member_idx, int heart_count, String recommendyn, String bestyn,
			Date lecture_reg_date, String member_phone, String member_user_id) {
		super();
		this.lecture_idx = lecture_idx;
		this.lecture_title = lecture_title;
		this.member_name = member_name;
		this.member_company = member_company;
		this.lecture_start_date = lecture_start_date;
		this.lecture_end_date = lecture_end_date;
		this.lecture_img = lecture_img;
		this.lecture_endPrize = lecture_endPrize;
		this.lecture_star = lecture_star;
		this.lecture_content = lecture_content;
		this.lecture_plan = lecture_plan;
		this.lecture_content_detail = lecture_content_detail;
		this.lecture_question = lecture_question;
		this.lecture_youtube_url = lecture_youtube_url;
		this.lecture_category = lecture_category;
		this.lecture_category_detail = lecture_category_detail;
		this.member_idx = member_idx;
		this.heart_count = heart_count;
		this.recommendyn = recommendyn;
		this.bestyn = bestyn;
		this.lecture_reg_date = lecture_reg_date;
		this.member_phone = member_phone;
		this.member_user_id = member_user_id;
	}
	@Override
	public String toString() {
		return "LectureDTO [lecture_idx=" + lecture_idx + ", lecture_title=" + lecture_title + ", member_name="
				+ member_name + ", member_company=" + member_company + ", lecture_start_date=" + lecture_start_date
				+ ", lecture_end_date=" + lecture_end_date + ", lecture_img=" + lecture_img + ", lecture_endPrize="
				+ lecture_endPrize + ", lecture_star=" + lecture_star + ", lecture_content=" + lecture_content
				+ ", lecture_plan=" + lecture_plan + ", lecture_content_detail=" + lecture_content_detail
				+ ", lecture_question=" + lecture_question + ", lecture_youtube_url=" + lecture_youtube_url
				+ ", lecture_category=" + lecture_category + ", lecture_category_detail=" + lecture_category_detail
				+ ", member_idx=" + member_idx + ", heart_count=" + heart_count + ", recommendyn=" + recommendyn
				+ ", bestyn=" + bestyn + ", lecture_reg_date=" + lecture_reg_date + ", member_phone=" + member_phone
				+ ", member_user_id=" + member_user_id + "]";
	}
}
