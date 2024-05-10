package bbs;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import common.JDBConnect;
import jakarta.servlet.ServletContext;

public class BbsQnaDAO extends JDBConnect{
	public BbsQnaDAO() {}
	public BbsQnaDAO(ServletContext application) {
		super(application);
	}
	
	public int bbsTotalCount(String qna_category) {
		int total_count = 0;
		
		StringBuilder sb = new StringBuilder();
		sb.append("Select count(*) from kmc_qna");
		if(qna_category != null ) {
			sb.append(" where qna_category="+ "'"+qna_category+"'");
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
			System.out.println("QNA 개수 조회 에러");
		}
		return total_count;
	}
	
	public List<BbsQnaDTO> bbsList(String qna_category, int page_skip_cnt, int page_size){
		List<BbsQnaDTO> list = new Vector<BbsQnaDTO>();
		StringBuilder sb = new StringBuilder();
		sb.append("select qna_idx, qna_category, qna_title, qna_answer, qna_reg_date from kmc_qna ");
		if(qna_category !=null) {
			sb.append(" where qna_category=" + "'"+qna_category+"'");
		}
		sb.append(" ORDER BY qna_idx DESC");
		sb.append(" limit "+ page_skip_cnt+", "+page_size);
	
		try {
			String sql = sb.toString();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				BbsQnaDTO dto = new BbsQnaDTO();
				dto.setQna_idx(rs.getInt("qna_idx"));
				dto.setQna_category(rs.getString("qna_category"));
				dto.setQna_title(rs.getString("qna_title"));
				dto.setQna_answer(rs.getString("qna_answer"));
				dto.setQna_reg_date(rs.getString("qna_reg_date"));
				list.add(dto);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("게시물 리스트 조회 에러");
		}
		
		return list;
	}
	
	public BbsQnaDTO bbsView(int idx) {
		BbsQnaDTO dto = new BbsQnaDTO();
		
		StringBuilder sb = new StringBuilder();
		sb.append("select qna_idx, qna_category, qna_title, qna_answer, qna_reg_date from kmc_qna ");
		sb.append(" where qna_idx = ?");
		try {
			psmt = conn.prepareStatement(sb.toString());
			psmt.setInt(1, idx);
			rs = psmt.executeQuery();
			if(rs.next()) {
				dto.setQna_idx(rs.getInt("qna_idx"));
				dto.setQna_category(rs.getString("qna_category"));
				dto.setQna_title(rs.getString("qna_title"));
				dto.setQna_answer(rs.getString("qna_answer"));
				dto.setQna_reg_date(rs.getString("qna_reg_date"));
			}
		} catch (SQLException e) {
			System.out.println("게시판 데이터 조회 오류");
			e.printStackTrace();
		}
		
		return dto;
	}
	public void bbsRegist(BbsQnaDTO dto) {
		StringBuilder sb = new StringBuilder();
		sb.append("insert into kmc_qna(qna_category,qna_title,qna_answer) values (?,?,?)");
		try {
			psmt = conn.prepareStatement(sb.toString());
			psmt.setString(1, dto.getQna_category());
			psmt.setString(2, dto.getQna_title());
			psmt.setString(3, dto.getQna_answer());
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("게시판 데이터 추가 오류");
			e.printStackTrace();
		}
		
	}
	
	public void bbsModify(BbsQnaDTO dto) {
		StringBuilder sb = new StringBuilder();
		sb.append("update kmc_qna set qna_category =?, qna_title =?, qna_answer = ? where qna_idx = ?");
		try {
			psmt = conn.prepareStatement(sb.toString());
			psmt.setString(1, dto.getQna_category());
			psmt.setString(2, dto.getQna_title());
			psmt.setString(3, dto.getQna_answer());
			psmt.setInt(4, dto.getQna_idx());
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("게시판 데이터 수정 오류");
			e.printStackTrace();
		}
		
	}
	public void bbsDelete(int idx) {
		String sb = "delete from kmc_qna where qna_idx = ?";
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
}
