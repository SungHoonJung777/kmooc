package lecture;

import java.sql.Date;

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
	private String lecture_question;
	private String lecture_youtube_url;
	private String lecture_category;
	private String lecture_category_detail;
	private int member_idx;
	private int heart_count;
	private String recommendyn;
	private String bestyn;
	private Date lecture_reg_date;
	/**
	 * @return the lecture_idx
	 */
	public int getLecture_idx() {
		return lecture_idx;
	}
	/**
	 * @param lecture_idx the lecture_idx to set
	 */
	public void setLecture_idx(int lecture_idx) {
		this.lecture_idx = lecture_idx;
	}
	/**
	 * @return the lecture_title
	 */
	public String getLecture_title() {
		return lecture_title;
	}
	/**
	 * @param lecture_title the lecture_title to set
	 */
	public void setLecture_title(String lecture_title) {
		this.lecture_title = lecture_title;
	}
	/**
	 * @return the member_name
	 */
	public String getMember_name() {
		return member_name;
	}
	/**
	 * @param member_name the member_name to set
	 */
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	/**
	 * @return the member_company
	 */
	public String getMember_company() {
		return member_company;
	}
	/**
	 * @param member_company the member_company to set
	 */
	public void setMember_company(String member_company) {
		this.member_company = member_company;
	}
	/**
	 * @return the lecture_start_date
	 */
	public Date getLecture_start_date() {
		return lecture_start_date;
	}
	/**
	 * @param lecture_start_date the lecture_start_date to set
	 */
	public void setLecture_start_date(Date lecture_start_date) {
		this.lecture_start_date = lecture_start_date;
	}
	/**
	 * @return the lecture_end_date
	 */
	public Date getLecture_end_date() {
		return lecture_end_date;
	}
	/**
	 * @param lecture_end_date the lecture_end_date to set
	 */
	public void setLecture_end_date(Date lecture_end_date) {
		this.lecture_end_date = lecture_end_date;
	}
	/**
	 * @return the lecture_img
	 */
	public String getLecture_img() {
		return lecture_img;
	}
	/**
	 * @param lecture_img the lecture_img to set
	 */
	public void setLecture_img(String lecture_img) {
		this.lecture_img = lecture_img;
	}
	/**
	 * @return the lecture_endPrize
	 */
	public String getLecture_endPrize() {
		return lecture_endPrize;
	}
	/**
	 * @param lecture_endPrize the lecture_endPrize to set
	 */
	public void setLecture_endPrize(String lecture_endPrize) {
		this.lecture_endPrize = lecture_endPrize;
	}
	/**
	 * @return the lecture_star
	 */
	public int getLecture_star() {
		return lecture_star;
	}
	/**
	 * @param lecture_star the lecture_star to set
	 */
	public void setLecture_star(int lecture_star) {
		this.lecture_star = lecture_star;
	}
	/**
	 * @return the lecture_content
	 */
	public String getLecture_content() {
		return lecture_content;
	}
	/**
	 * @param lecture_content the lecture_content to set
	 */
	public void setLecture_content(String lecture_content) {
		this.lecture_content = lecture_content;
	}
	/**
	 * @return the lecture_plan
	 */
	public String getLecture_plan() {
		return lecture_plan;
	}
	/**
	 * @param lecture_plan the lecture_plan to set
	 */
	public void setLecture_plan(String lecture_plan) {
		this.lecture_plan = lecture_plan;
	}
	/**
	 * @return the lecture_content_detail
	 */
	public String getLecture_content_detail() {
		return lecture_content_detail;
	}
	/**
	 * @param lecture_content_detail the lecture_content_detail to set
	 */
	public void setLecture_content_detail(String lecture_content_detail) {
		this.lecture_content_detail = lecture_content_detail;
	}
	/**
	 * @return the lecture_question
	 */
	public String getLecture_question() {
		return lecture_question;
	}
	/**
	 * @param lecture_question the lecture_question to set
	 */
	public void setLecture_question(String lecture_question) {
		this.lecture_question = lecture_question;
	}
	/**
	 * @return the lecture_youtube_url
	 */
	public String getLecture_youtube_url() {
		return lecture_youtube_url;
	}
	/**
	 * @param lecture_youtube_url the lecture_youtube_url to set
	 */
	public void setLecture_youtube_url(String lecture_youtube_url) {
		this.lecture_youtube_url = lecture_youtube_url;
	}
	/**
	 * @return the lecture_category
	 */
	public String getLecture_category() {
		return lecture_category;
	}
	/**
	 * @param lecture_category the lecture_category to set
	 */
	public void setLecture_category(String lecture_category) {
		this.lecture_category = lecture_category;
	}
	/**
	 * @return the lecture_category_detail
	 */
	public String getLecture_category_detail() {
		return lecture_category_detail;
	}
	/**
	 * @param lecture_category_detail the lecture_category_detail to set
	 */
	public void setLecture_category_detail(String lecture_category_detail) {
		this.lecture_category_detail = lecture_category_detail;
	}
	/**
	 * @return the member_idx
	 */
	public int getMember_idx() {
		return member_idx;
	}
	/**
	 * @param member_idx the member_idx to set
	 */
	public void setMember_idx(int member_idx) {
		this.member_idx = member_idx;
	}
	/**
	 * @return the heart_count
	 */
	public int getHeart_count() {
		return heart_count;
	}
	/**
	 * @param heart_count the heart_count to set
	 */
	public void setHeart_count(int heart_count) {
		this.heart_count = heart_count;
	}
	/**
	 * @return the recommendyn
	 */
	public String getRecommendyn() {
		return recommendyn;
	}
	/**
	 * @param recommendyn the recommendyn to set
	 */
	public void setRecommendyn(String recommendyn) {
		this.recommendyn = recommendyn;
	}
	/**
	 * @return the bestyn
	 */
	public String getBestyn() {
		return bestyn;
	}
	/**
	 * @param bestyn the bestyn to set
	 */
	public void setBestyn(String bestyn) {
		this.bestyn = bestyn;
	}
	/**
	 * @return the lecture_reg_date
	 */
	public Date getLecture_reg_date() {
		return lecture_reg_date;
	}
	/**
	 * @param lecture_reg_date the lecture_reg_date to set
	 */
	public void setLecture_reg_date(Date lecture_reg_date) {
		this.lecture_reg_date = lecture_reg_date;
	}
	
}
