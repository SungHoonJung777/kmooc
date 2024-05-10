package bbs;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import common.JDBConnect;
import jakarta.servlet.ServletContext;

public class CmtDAO extends JDBConnect {
	public CmtDAO() {}
	public CmtDAO(ServletContext application) {
		super(application);
	}
	
	public int cmtTotalCount(int comu_idx) {
		int total_count = 0;
		
		StringBuilder sb = new StringBuilder();
		sb.append("Select count(*) from kmc_comment where comu_idx='"+comu_idx+"'");
		try {
			String sql = sb.toString();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			rs.next();
			total_count=rs.getInt(1);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("QNA 개수 조회 에러");
		}
		return total_count;
	}
	
	public List<CmtDTO> cmtList(int comu_idx){
		List<CmtDTO> list = new Vector<CmtDTO>();
		StringBuilder sb = new StringBuilder();
		sb.append("select comt_idx, comu_idx, comt_content, comt_reg_date, member_user_id, member_img from kmc_comment ");
		sb.append("where comu_idx = '"+comu_idx+"'");
		sb.append(" ORDER BY comt_reg_date DESC");
	
		try {
			String sql = sb.toString();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				CmtDTO dto = new CmtDTO();
				dto.setComt_idx(rs.getInt("comt_idx"));
				dto.setComu_idx(rs.getInt("comu_idx"));
				dto.setComt_content(rs.getString("comt_content"));
				dto.setComt_reg_date(rs.getString("comt_reg_date"));
				dto.setMember_user_id(rs.getString("member_user_id"));
				dto.setMember_img(rs.getString("member_img"));
				list.add(dto);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("게시물 리스트 조회 에러");
		}
		
		return list;
	}
	
	public void cmtRegist(CmtDTO dto) {
		StringBuilder sb = new StringBuilder();
		sb.append("insert into kmc_comment(comu_idx,comt_content,member_user_id,member_img) values (?,?,?,?)");
		try {
			psmt = conn.prepareStatement(sb.toString());
			psmt.setInt(1, dto.getComu_idx());
			psmt.setString(2, dto.getComt_content());
			psmt.setString(3, dto.getMember_user_id());
			psmt.setString(4, dto.getMember_img());
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("게시판 데이터 추가 오류");
			e.printStackTrace();
		}
		
	}
	
	public void cmtModify(CmtDTO dto) {
		StringBuilder sb = new StringBuilder();
		sb.append("update kmc_comment set comt_content =? where comt_idx = ?");
		try {
			psmt = conn.prepareStatement(sb.toString());
			psmt.setString(1, dto.getComt_content());
			psmt.setInt(2, dto.getComt_idx());
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("게시판 데이터 수정 오류");
			e.printStackTrace();
		}
		
	}
	public void cmtDelete(int comt_idx) {
		String sb = "delete from kmc_comment where comt_idx = ?";
		try {
			psmt = conn.prepareStatement(sb);
			psmt.setInt(1, comt_idx);
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("게시판 데이터 삭제 오류");
			e.printStackTrace();
		}
		
	}
}
