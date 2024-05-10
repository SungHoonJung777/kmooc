package bbs;

public class BbsQnaDTO {
	private int qna_idx;
	private String qna_category;
	private String qna_title;
	private String qna_answer;
	private String qna_reg_date;
	/**
	 * @return the qna_category
	 */
	public BbsQnaDTO(){}
	
	public String getQna_category() {
		return qna_category;
	}
	/**
	 * @param qna_category the qna_category to set
	 */
	public void setQna_category(String qna_category) {
		this.qna_category = qna_category;
	}
	/**
	 * @return the qna_title
	 */
	public String getQna_title() {
		return qna_title;
	}
	/**
	 * @param qna_title the qna_title to set
	 */
	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}
	/**
	 * @return the qna_answer
	 */
	public String getQna_answer() {
		return qna_answer;
	}
	/**
	 * @param qna_answer the qna_answer to set
	 */
	public void setQna_answer(String qna_answer) {
		this.qna_answer = qna_answer;
	}
	/**
	 * @return the qna_reg_date
	 */
	public String getQna_reg_date() {
		return qna_reg_date;
	}
	/**
	 * @param qna_reg_date the qna_reg_date to set
	 */
	public void setQna_reg_date(String qna_reg_date) {
		this.qna_reg_date = qna_reg_date;
	}

	/**
	 * @return the qna_idx
	 */
	public int getQna_idx() {
		return qna_idx;
	}

	/**
	 * @param qna_idx the qna_idx to set
	 */
	public void setQna_idx(int qna_idx) {
		this.qna_idx = qna_idx;
	}
	
	
}
