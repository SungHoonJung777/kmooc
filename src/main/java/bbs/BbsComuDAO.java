package bbs;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import common.JDBConnect;
import jakarta.servlet.ServletContext;

public class BbsComuDAO extends JDBConnect{
	public BbsComuDAO() {}
	public BbsComuDAO(ServletContext application) {
		super(application);
	}
	
	public int bbsTotalCount(String category) {
		int total_count = 0;
		
		StringBuilder sb = new StringBuilder();
		sb.append("Select count(*) from kmc_community ");
		if(category != null ) {
			sb.append(" where comu_category="+ "'"+category+"'");
		}
		try {
			String sql = sb.toString();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			rs.next();
			total_count=rs.getInt(1);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("comu 개수 조회 에러");
		}
		return total_count;
	}
	
	public int bbsTotalCount2(String search_category, String search_word) {
		int total_count = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("Select count(*) from kmc_community ");
		if(!search_category.trim().equals("tc") && search_category !=null && !search_category.isEmpty() && search_word != null && !search_word.isEmpty()) {
			sb.append(" where " +search_category+" Like '%"+search_word+"%'");
		}
		if(search_category.trim().equals("tc")) {
			sb.append(" where comu_title Like '%"+search_word+"%'" +" || comu_content Like '%"+search_word+"%'");
		}
		try {
			String sql = sb.toString();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			rs.next();
			total_count=rs.getInt(1);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("comu 개수 조회 에러");
		}
		return total_count;
	}
	
	public List<BbsComuDTO> bbsList(String category, int page_skip_cnt, int page_size){
		List<BbsComuDTO> list = new Vector<BbsComuDTO>();
		StringBuilder sb = new StringBuilder();
		sb.append("select comu_idx, comu_category, comu_title, comu_content, member_user_id, comu_reg_date, comu_modify_date from kmc_community ");
		if(category != null) {
			sb.append(" where comu_category=" + "\""+category+"\"");
		}
		sb.append(" ORDER BY comu_idx DESC");
		sb.append(" limit "+ page_skip_cnt+", "+page_size);
		System.out.print(sb);
		try {
			String sql = sb.toString();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				BbsComuDTO dto = new BbsComuDTO();
				dto.setComu_idx(rs.getInt("comu_idx"));
				dto.setComu_category(rs.getString("comu_category"));
				dto.setComu_title(rs.getString("comu_title"));
				dto.setComu_content(rs.getString("comu_content"));
				dto.setMember_user_id(rs.getString("member_user_id"));
				dto.setComu_reg_date(rs.getString("comu_reg_date"));
				dto.setComu_modify_date(rs.getString("comu_modify_date"));
				list.add(dto);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("게시물 리스트 조회 에러");
		}
		
		return list;
	}
	
	public List<BbsComuDTO> bbsList2(String search_category, String search_word, int page_skip_cnt, int page_size){
		List<BbsComuDTO> list = new Vector<BbsComuDTO>();
		StringBuilder sb = new StringBuilder();
		sb.append("select comu_idx, comu_category, comu_title, comu_content, member_user_id, comu_reg_date, comu_modify_date from kmc_community ");
		
		
		if(!search_category.trim().equals("tc") && search_category !=null && !search_category.isEmpty() && search_word != null && !search_word.isEmpty()) {
			sb.append(" where " +search_category+" Like '%"+search_word+"%'");
		}
		if(search_category.trim().equals("tc")) {
			sb.append(" where comu_title Like '%"+search_word+"%'" +" || comu_content Like '%"+search_word+"%'");
		}
		
		sb.append(" ORDER BY comu_idx DESC");
		sb.append(" limit "+ page_skip_cnt+", "+page_size);
		try {
			String sql = sb.toString();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				BbsComuDTO dto = new BbsComuDTO();
				dto.setComu_idx(rs.getInt("comu_idx"));
				dto.setComu_category(rs.getString("comu_category"));
				dto.setComu_title(rs.getString("comu_title"));
				dto.setComu_content(rs.getString("comu_content"));
				dto.setMember_user_id(rs.getString("member_user_id"));
				dto.setComu_reg_date(rs.getString("comu_reg_date"));
				dto.setComu_modify_date(rs.getString("comu_modify_date"));
				list.add(dto);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("게시물 리스트 조회 에러");
		}
		
		return list;
	}
	
	public BbsComuDTO bbsView(int idx) {
		BbsComuDTO dto = new BbsComuDTO();
		
		StringBuilder sb = new StringBuilder();
		sb.append("select comu_idx, comu_category, comu_title, comu_content, member_user_id, comu_reg_date, comu_modify_date from kmc_community ");
		sb.append(" where comu_idx = ?");
		try {
			psmt = conn.prepareStatement(sb.toString());
			psmt.setInt(1, idx);
			rs = psmt.executeQuery();
			if(rs.next()) {
				dto.setComu_idx(rs.getInt("comu_idx"));
				dto.setComu_category(rs.getString("comu_category"));
				dto.setComu_title(rs.getString("comu_title"));
				dto.setComu_content(rs.getString("comu_content"));
				dto.setMember_user_id(rs.getString("member_user_id"));
				dto.setComu_reg_date(rs.getString("comu_reg_date"));
				dto.setComu_modify_date(rs.getString("comu_modify_date"));
			}
		} catch (SQLException e) {
			System.out.println("게시판 데이터 조회 오류");
			e.printStackTrace();
		}
		
		return dto;
	}
	public void bbsRegist(BbsComuDTO dto) {
		StringBuilder sb = new StringBuilder();
		sb.append("insert into kmc_community(comu_category, comu_title, comu_content, member_user_id) values (?,?,?,?)");
		try {
			psmt = conn.prepareStatement(sb.toString());
			psmt.setString(1, dto.getComu_category());
			psmt.setString(2, dto.getComu_title());
			psmt.setString(3, dto.getComu_content());
			psmt.setString(4, dto.getMember_user_id());
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("게시판 데이터 추가 오류");
			e.printStackTrace();
		}
		
	}
	
	public void bbsModify(BbsComuDTO dto) {
		StringBuilder sb = new StringBuilder();
		sb.append("update kmc_community set comu_category =?, comu_title =?, comu_content = ? where comu_idx = ?");
		try {
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String str = format.format(date);
			
			psmt = conn.prepareStatement(sb.toString());
			psmt.setString(1, dto.getComu_category());
			psmt.setString(2, dto.getComu_title());
			psmt.setString(3, dto.getComu_content());
			psmt.setInt(4, dto.getComu_idx());
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("게시판 데이터 수정 오류");
			e.printStackTrace();
		}
		
	}
	public void bbsDelete(int idx) {
		String sb = "delete from kmc_community where comu_idx = ?";
		try {
			psmt = conn.prepareStatement(sb);
			psmt.setInt(1, idx);
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("게시판 데이터 삭제 오류");
			e.printStackTrace();
		}	
	}
	
	public int lastInsertId() {
		String sql = "SELECT LAST_INSERT_ID(comu_idx) FROM kmc_community ORDER BY comu_idx desc LIMIT 1";
		int last = 0;
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			rs.next();
			last =rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("마지막번호 조회 오류");
			e.printStackTrace();
		}
		return last;
	}
	
	
//	public void bbsCmtView() {
//		BbsComuDTO dto = new BbsComuDTO();
//		
//		StringBuilder sb = new StringBuilder();
//		sb.append("select comu_idx, comu_category, comu_title, comu_content, member_user_id, comu_reg_date, comu_modify_date from kmc_community ");
//		sb.append(" where comu_idx = ?");
//		try {
//			psmt = conn.prepareStatement(sb.toString());
//			psmt.setInt(1, idx);
//			rs = psmt.executeQuery();
//			if(rs.next()) {
//				dto.setComu_idx(rs.getInt("comu_idx"));
//				dto.setComu_category(rs.getString("comu_category"));
//				dto.setComu_title(rs.getString("comu_title"));
//				dto.setComu_content(rs.getString("comu_content"));
//				dto.setMember_user_id(rs.getString("member_user_id"));
//				dto.setComu_reg_date(rs.getString("comu_reg_date"));
//				dto.setComu_modify_date(rs.getString("comu_modify_date"));
//			}
//		} catch (SQLException e) {
//			System.out.println("게시판 데이터 조회 오류");
//			e.printStackTrace();
//		}
//		
//		return dto;
//	}
}
