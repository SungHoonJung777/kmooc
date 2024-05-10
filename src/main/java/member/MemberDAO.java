package member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import common.JDBConnect;
import dto.CartDTO;
import dto.HeartDTO;
import lecture.LectureDTO;

public class MemberDAO extends JDBConnect {
	public MemberDAO() {
		
	}
	
	public MemberDAO(String driver, String url, String id, String pwd) {
		super(driver, url, id, pwd);	
	}
	
	public MemberDTO getMemberInfo(String id) {
		MemberDTO dto = new MemberDTO();
		String sql = "SELECT * FROM kmc_member WHERE Member_user_id=?";
		try	{
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				dto.setMember_user_id(rs.getString("member_user_id"));
				dto.setMember_name(rs.getString("member_name"));
				dto.setMember_pwd(rs.getString("member_pwd"));
				dto.setMember_phone(rs.getString("member_phone"));
				dto.setMember_email(rs.getString("member_email"));
				if(rs.getString("member_category").equals("1")) {
					dto.setMember_category("학생");
				}
				else {
					dto.setMember_category("강사");
				}
				if(dto.getMember_category().equals("강사")) {
					dto.setMember_company_num(rs.getString("member_company_num"));
					dto.setMember_company(rs.getString("member_company"));
				}
				dto.setMember_birth(rs.getString("member_birth"));	
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	public MemberDTO getMemberInfo(String id,String pwd) {
		MemberDTO dto = new MemberDTO();
		String sql = "SELECT * FROM kmc_member WHERE Member_user_id=?";
		try	{
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("Member_pwd").equals(pwd) ) {
					dto.setMember_user_id(rs.getString("Member_user_id"));
					dto.setMember_name(rs.getString("Member_name"));
					dto.setMember_category(rs.getString("member_category"));
				}	
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	public boolean idcheck(String id){
		boolean check = false;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT COUNT(*)");
		sb.append(" FROM kmc_member");
		sb.append(" WHERE member_user_id='"+id.trim()+"'");
		int result = 0;
		/* sb.append(" LIMIT "+10*(a-1)+", "+10); */
		try {
			psmt = conn.prepareStatement(sb.toString());
			rs = psmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		if(result >= 1) {
			check = false;
		}
		else {
			check =true;
		}
		
		return check;
	}
	
	public String pwdconfirm(String id){
		boolean check = false;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT member_pwd");
		sb.append(" FROM kmc_member");
		sb.append(" WHERE member_user_id='"+id.trim()+"'");
		String result = "";
		/* sb.append(" LIMIT "+10*(a-1)+", "+10); */
		try {
			psmt = conn.prepareStatement(sb.toString());
			rs = psmt.executeQuery();
			if(rs.next()) {
				result = rs.getString(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	public boolean emailcheck(String email){
		boolean check = false;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT COUNT(*)");
		sb.append(" FROM kmc_member");
		sb.append(" WHERE member_email='"+email.trim()+"'");
		int result = 0;
		/* sb.append(" LIMIT "+10*(a-1)+", "+10); */
		try {
			psmt = conn.prepareStatement(sb.toString());
			rs = psmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		if(result >= 1) {
			check = false;
		}
		else {
			check =true;
		}
		
		return check;
	}
	
	public boolean compnumcheck(String compnum){
		boolean check = false;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT COUNT(*)");
		sb.append(" FROM kmc_member");
		sb.append(" WHERE compnum='"+compnum.trim()+"'");
		int result = 0;
		/* sb.append(" LIMIT "+10*(a-1)+", "+10); */
		try {
			psmt = conn.prepareStatement(sb.toString());
			rs = psmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		if(result >= 1) {
			check = false;
		}
		else {
			check =true;
		}
		
		return check;
	}
	
	
	public int join(MemberDTO dto){
		String name = dto.getMember_name();
		String id = dto.getMember_user_id();
		String pwd = dto.getMember_pwd();
		String birth = dto.getMember_birth();
		String tel = dto.getMember_phone();
		String email = dto.getMember_email();
		String memtype = dto.getMember_category();
		String compnum = dto.getMember_company_num();
		String compname = dto.getMember_company();
		int result = 0;
		
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO kmc_member(member_name, member_user_id, member_pwd, member_phone,");
		sb.append("member_email, member_category, member_company_num, member_company, member_birth, member_info_update)");
		sb.append(" VALUES(?,?,?,?,?,?,?,?,?,NOW())");
		
		try {
			if(id.trim() !="" && name.trim()!= "" && pwd.trim()!=""&&
			birth.trim() !="" && tel.trim()!= "" && email.trim()!=""&&
			memtype.trim() !="") {
			psmt = conn.prepareStatement(sb.toString());
			psmt.setString(1, name);
			psmt.setString(2, id);
			psmt.setString(3, pwd);
			psmt.setString(4, tel);
			psmt.setString(5, email);
			psmt.setString(6, memtype);
			psmt.setString(7, compnum);
			psmt.setString(8, compname);
			psmt.setString(9, birth);
			
			result = psmt.executeUpdate();
			
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public List<HashMap<String, Object>> getCartInfo(String id) {
		
		
		HashMap<String, Object> param = new HashMap<String, Object>();
		List<HashMap<String, Object>> params = new ArrayList<HashMap<String, Object>>();
		
		int i = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT A.lecture_idx, A.lecture_title, B.member_email, B.member_name,lecture_teacher, C.lecture_start_date, C.lecture_end_date,C.lecture_img");
		sb.append(" FROM kmc_cart AS A");
		sb.append(" INNER JOIN kmc_member AS B ON A.member_user_id = B.member_user_id");
		sb.append(" INNER JOIN kmc_lecture AS C ON A.lecture_idx = C.lecture_idx");
		sb.append(" WHERE A.member_user_id = ?");
				
		try	{
			psmt = conn.prepareStatement(sb.toString());
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			while(rs.next()) {
					MemberDTO memdto = new MemberDTO();
					LectureDTO lecdto = new LectureDTO();
					CartDTO cartdto = new CartDTO();
					memdto.setMember_email(rs.getString("B.member_email"));
					memdto.setMember_name(rs.getString("B.member_name"));
					cartdto.setLecture_title(rs.getString("A.lecture_title"));
					cartdto.setLecture_teacher(rs.getString("lecture_teacher"));
					lecdto.setLecture_idx(rs.getInt("A.lecture_idx"));;
					lecdto.setLecture_start_date(rs.getDate("C.lecture_start_date"));;
					lecdto.setLecture_end_date(rs.getDate("C.lecture_end_date"));
					lecdto.setLecture_img(rs.getString("C.lecture_img"));
					
					param.put(i+"memdto", memdto);
					param.put(i+"cartdto", cartdto);
					param.put(i+"lecdto", lecdto);
					params.add(param);
					
					i++;
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return params;
	}
	
	public List<HashMap<String, Object>> getHeartInfo(String id) {
		
		
		HashMap<String, Object> param = new HashMap<String, Object>();
		List<HashMap<String, Object>> params = new ArrayList<HashMap<String, Object>>();
		
		int i = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT A.lecture_idx, A.lecture_title,lecture_teacher, C.lecture_start_date, C.lecture_end_date,C.lecture_img");
		sb.append(" FROM kmc_heart AS A");
		sb.append(" INNER JOIN kmc_member AS B ON A.member_user_id = B.member_user_id");
		sb.append(" INNER JOIN kmc_lecture AS C ON A.lecture_idx = C.lecture_idx");
		sb.append(" WHERE A.member_user_id = ?");
				
		try	{
			psmt = conn.prepareStatement(sb.toString());
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			while(rs.next()) {
					LectureDTO lecdto = new LectureDTO();
					CartDTO cartdto = new CartDTO();
					cartdto.setLecture_title(rs.getString("A.lecture_title"));
					cartdto.setLecture_teacher(rs.getString("lecture_teacher"));
					lecdto.setLecture_idx(rs.getInt("A.lecture_idx"));;
					lecdto.setLecture_start_date(rs.getDate("C.lecture_start_date"));;
					lecdto.setLecture_end_date(rs.getDate("C.lecture_end_date"));
					lecdto.setLecture_img(rs.getString("C.lecture_img"));
					
					param.put(i+"cartdto", cartdto);
					param.put(i+"lecdto", lecdto);
					params.add(param);
					
					i++;
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return params;
	}
	
	public int pwdChange(String phone, String email, String memberId,String pwd) {
		String sql = "update kmc_member set member_pwd = ?, member_phone = ? , member_email = ? where member_user_id =? ;"
				+ "";
		int rResult = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,pwd);
			psmt.setString(2,phone);
			psmt.setString(3,email);
			psmt.setString(4,memberId);
			rResult = psmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("일치하는 PWD 없음");
			e.printStackTrace();
		}
		return rResult;
	}
	
	public int DeleteMember(String id) {
		String sql = "delete from kmc_member where member_user_id = ?";
		int result = 0;

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			result = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
}
