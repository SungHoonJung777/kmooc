package dao;

import common.JDBConnect;
import dto.CartDTO;
import dto.LectureDTO;
import jakarta.servlet.ServletContext;
import member.MemberDTO;

public class CartDAO extends JDBConnect {
	public CartDAO() {
	}

	public CartDAO(ServletContext application) {
		super(application);

	}
	
	public int cartRegist(CartDTO dto) {

		int result = 0;
		String sql = "insert into KMC_CART (member_user_id , lecture_idx , lecture_title, lecture_teacher, lecture_img, cart_result) " 
		+ "values (?,?,?,?,?,?) ";

		try {
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, dto.getMember_user_id());
			psmt.setInt(2, dto.getLecture_idx());
			psmt.setString(3, dto.getLecture_title());
			psmt.setString(4, dto.getLecture_teacher());
			psmt.setString(5, dto.getLecture_img());
			psmt.setString(6, "2");

			result = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public int countMemberCart(int lecture_idx , String memberId) {
		String sql = "select count(*) as A from kmc_cart where lecture_idx = ? and member_user_id = ?";
		int rResult = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, lecture_idx);
			psmt.setString(2, memberId);
			rs = psmt.executeQuery();
			if (rs.next()) {
				int count = rs.getInt("A");
				if (count > 0) {
					rResult = 1;
				}
			}
		} catch (Exception e) {
			System.out.println("회원이 카트에 안담긴 강좌임");
			e.printStackTrace();
		}

		return rResult;
	}
	public int cartDelete(int lecture_idx, String memberId) {
		String sql = "delete from KMC_cart where lecture_idx = ? and member_user_id = ?";

		int result = 0;

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, lecture_idx);
			psmt.setString(2, memberId);
			result = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

}
