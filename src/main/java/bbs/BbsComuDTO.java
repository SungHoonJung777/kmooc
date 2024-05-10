package bbs;

public class BbsComuDTO {
	private int comu_idx;
	private String comu_category;
	private String comu_title;
	private String comu_content;
	private String member_user_id;
	private String comu_reg_date;
	private String comu_modify_date;
	
	public BbsComuDTO(){
		
	}
	/**
	 * @return the comu_category_code
	 */
	public String getComu_category() {
		return comu_category;
	}
	/**
	 * @param comu_category_code the comu_category_code to set
	 */
	public void setComu_category(String comu_category) {
		this.comu_category = comu_category;
	}
	/**
	 * @return the comu_title
	 */
	public String getComu_title() {
		return comu_title;
	}
	/**
	 * @param comu_title the comu_title to set
	 */
	public void setComu_title(String comu_title) {
		this.comu_title = comu_title;
	}
	/**
	 * @return the comu_content
	 */
	public String getComu_content() {
		return comu_content;
	}
	/**
	 * @param comu_content the comu_content to set
	 */
	public void setComu_content(String comu_content) {
		this.comu_content = comu_content;
	}
	/**
	 * @return the member_user_id
	 */
	public String getMember_user_id() {
		return member_user_id;
	}
	/**
	 * @param member_user_id the member_user_id to set
	 */
	public void setMember_user_id(String member_user_id) {
		this.member_user_id = member_user_id;
	}
	/**
	 * @return the comu_reg_date
	 */
	public String getComu_reg_date() {
		return comu_reg_date;
	}
	/**
	 * @param comu_reg_date the comu_reg_date to set
	 */
	public void setComu_reg_date(String comu_reg_date) {
		this.comu_reg_date = comu_reg_date;
	}
	/**
	 * @return the comu_modify_date
	 */
	public String getComu_modify_date() {
		return comu_modify_date;
	}
	/**
	 * @param comu_modify_date the comu_modify_date to set
	 */
	public void setComu_modify_date(String comu_modify_date) {
		this.comu_modify_date = comu_modify_date;
	}
	/**
	 * @return the comu_idx
	 */
	public int getComu_idx() {
		return comu_idx;
	}
	/**
	 * @param comu_idx the comu_idx to set
	 */
	public void setComu_idx(int comu_idx) {
		this.comu_idx = comu_idx;
	}
}
