package dao;

import java.util.ArrayList;

import common.JDBConnect;
import jakarta.servlet.ServletContext;
import member.MemberDTO;

public class MemberSearchDAO extends JDBConnect {
	public MemberSearchDAO() {
	}

	public MemberSearchDAO(ServletContext application) {
		super(application);

	}
	
	public int idSearch(String phone, String email) {
		String sql = "select count(*) as A from kmc_member where member_phone = ? and member_email =  ? ";
		int rResult = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, phone);
			psmt.setString(2, email);
			rs = psmt.executeQuery();
			if (rs.next()) {
				int count = rs.getInt("A");
				if (count > 0) {
					rResult = 1;
				}
			}
		} catch (Exception e) {
			System.out.println("일치하는 ID 없음");
			e.printStackTrace();
		}
		return rResult;
	}
	
	public String idSearchFind(String phone, String email){
		String sql = "select member_user_id from kmc_member where member_phone = ? and member_email =  ? ";
		String rResult = "";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, phone);
			psmt.setString(2, email);
			rs = psmt.executeQuery();
			if (rs.next()) {
				rResult = rs.getString("member_user_id");
				
			}
		} catch (Exception e) {
			System.out.println("일치하는 ID 없음");
			e.printStackTrace();
		}
		
		return rResult;
	}
	public int pwdSearch(String phone, String email, String memberId) {
		String sql = "select count(*) as A from kmc_member where member_phone = ? and member_email =  ? and member_user_id = ? ";
		int rResult = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, phone);
			psmt.setString(2, email);
			psmt.setString(3, memberId);
			rs = psmt.executeQuery();
			if (rs.next()) {
				int count = rs.getInt("A");
				if (count > 0) {
					rResult = 1;
				}
			}
		} catch (Exception e) {
			System.out.println("일치하는 PWD 없음");
			e.printStackTrace();
		}
		return rResult;
	}     
	
	public int pwdRandomChange(String phone, String email, String memberId) {
		String sql = "update kmc_member set member_pwd = concat('kmooc',floor(rand()*50000) +1 ) where member_phone = ? and member_email =  ?  AND member_user_id =? ;\r\n"
				+ "";
		int rResult = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, phone);
			psmt.setString(2, email);
			psmt.setString(3, memberId);
			rResult = psmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("일치하는 PWD 없음");
			e.printStackTrace();
		}
		return rResult;
	}  
	public String pwdChangeValue(String phone, String email, String memberId) {
		String sql = "select member_pwd from kmc_member where member_phone = ? and member_email =  ? AND member_user_id =? ";
		String rResult = "";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, phone);
			psmt.setString(2, email);
			psmt.setString(3, memberId);
			rs = psmt.executeQuery();
			if (rs.next()) {
				rResult = rs.getString("member_pwd");
				
			}
		} catch (Exception e) {
			System.out.println("일치하는 PWD 없음");
			e.printStackTrace();
		}
		
		
		
		return rResult;
	}
}
