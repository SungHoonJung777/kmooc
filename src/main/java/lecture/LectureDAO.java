package lecture;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import common.JDBConnect;
import jakarta.servlet.ServletContext;


public class LectureDAO extends JDBConnect {
	public LectureDAO() {
		
	}
	
	public LectureDAO(ServletContext application) {
		super(application);
	}
	
	public int lectureTotalCount(Map<String, Object> map) {
		int total_count = 0;
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT COUNT(*) FROM kmc_lecture");
		
		//검색필터 총합(where 조건절)
				sb.append(" WHERE ");
					//검색
					if ( map.get("search_word") != null && map.get("search_word") != "" ) {
						
						if ( map.get("search_option").equals("search_title") ) {
							sb.append("lecture_title");
							sb.append(" LIKE '%" + map.get("search_word") + "%'");
						}
						else if ( map.get("search_option").equals("search_teacher") ) {
							sb.append("member_name");
							sb.append(" LIKE '%" + map.get("search_word") + "%'");
						}
						
					}
					else {
						sb.append(" (1=1)");
					}
					
					
					
					//선택 1.개강상태
					sb.append(" && ");
					if ( map.get("search_state") != null && map.get("search_state") != "" ) {
						switch (map.get("search_state").toString()) {
						case "state_ing":
							sb.append("NOW() BETWEEN lecture_start_date AND lecture_end_date");
							break;
						case "state_before":
							sb.append("NOW() < lecture_start_date");
							break;
						case "state_after":
							sb.append("NOW() > lecture_end_date");
							break;
						}
					}
					else {
						sb.append(" (1=1)");
					}

						
					//선택 2.카테고리 
					sb.append(" && ");
					if ( map.get("search_category") != null && map.get("search_category") != "" ) {
						sb.append("lecture_category=" + map.get("search_category"));
					}
					else {
						sb.append(" (1=1)");
					}
							
					//선택 3.카테고리_중분류
					sb.append(" && ");
					if ( map.get("search_category_detail") != null && map.get("search_category_detail") != "" ) {
						sb.append("lecture_category_detail=" + map.get("search_category_detail"));
					}
					else {
						sb.append(" (1=1)");
					}
					
					//선택 4.학습기간
					sb.append(" && ");
					if ( map.get("search_period") != null && map.get("search_period") != "" ) {
						switch (map.get("search_period").toString()) {
						case "period_short":
							sb.append("datediff(lecture_end_date, lecture_start_date) < 15");
							break;
						case "period_mid":
							sb.append("datediff(lecture_end_date, lecture_start_date) > 15 && datediff(lecture_end_date, lecture_start_date) < 29");
							break;
						case "period_long":
							sb.append("datediff(lecture_end_date, lecture_start_date) > 29");
							break;
						}
					}
					else {
						sb.append(" (1=1)");
					}//검색 끝
		
		try {
			psmt = conn.prepareStatement(sb.toString());
			// psmt.setString(1, map.get("search");	//위에서 했으므로 필요x
			rs = psmt.executeQuery();
			rs.next();
			total_count = rs.getInt(1);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("강의 개수 조회 에러");
		}
		
		return total_count;
	}
	
	
	
	
	public List<LectureDTO> lectureList(Map<String, Object> map) {
		List<LectureDTO> list = new Vector<LectureDTO>();
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT lecture_idx, lecture_img, lecture_title, member_name");
		sb.append(", member_company, lecture_start_date, lecture_end_date");
		sb.append(", lecture_category, lecture_category_detail, lecture_reg_date");
		
		sb.append(" FROM kmc_lecture");	//kmc 강의 테이블
		
		//검색필터 총합(where 조건절)
		sb.append(" WHERE ");
			//검색
			if ( map.get("search_word") != null && map.get("search_word") != "" ) {
				
				if ( map.get("search_option").equals("search_title") ) {
					sb.append("lecture_title");
					sb.append(" LIKE '%" + map.get("search_word") + "%'");
				}
				else if ( map.get("search_option").equals("search_teacher") ) {
					sb.append("member_name");
					sb.append(" LIKE '%" + map.get("search_word") + "%'");
				}
				
			}
			else {
				sb.append(" (1=1)");
			}
			
			
			//선택 1.개강상태
			sb.append(" && ");
			if ( map.get("search_state") != null && map.get("search_state") != "" ) {
				switch (map.get("search_state").toString()) {
				case "state_ing":
					sb.append("NOW() BETWEEN lecture_start_date AND lecture_end_date");
					break;
				case "state_before":
					sb.append("NOW() < lecture_start_date");
					break;
				case "state_after":
					sb.append("NOW() > lecture_end_date");
					break;
				}
			}
			else {
				sb.append(" (1=1)");
			}

				
			//선택 2.카테고리 
			sb.append(" && ");
			if ( map.get("search_category") != null && map.get("search_category") != "" ) {
				sb.append("lecture_category=" + map.get("search_category"));
			}
			else {
				sb.append(" (1=1)");
			}
					
			//선택 3.카테고리_중분류
			sb.append(" && ");
			if ( map.get("search_category_detail") != null && map.get("search_category_detail") != "" ) {
				sb.append("lecture_category_detail=" + map.get("search_category_detail"));
			}
			else {
				sb.append(" (1=1)");
			}
			
			//선택 4.학습기간
			sb.append(" && ");
			if ( map.get("search_period") != null && map.get("search_period") != "" ) {
				switch (map.get("search_period").toString()) {
				case "period_short":
					sb.append("datediff(lecture_end_date, lecture_start_date) < 15");
					break;
				case "period_mid":
					sb.append("datediff(lecture_end_date, lecture_start_date) > 15 && datediff(lecture_end_date, lecture_start_date) < 29");
					break;
				case "period_long":
					sb.append("datediff(lecture_end_date, lecture_start_date) > 29");
					break;
				}
			}
			else {
				sb.append(" (1=1)");
			}//검색 끝
		
			
			//정렬 설정
			if ( map.get("order_by") != null && map.get("order_by") != "" ) {
				if( map.get("order_by").equals("order_by_1") ) {
					sb.append(" ORDER BY lecture_reg_date desc");
				}
				else if( map.get("order_by").equals("order_by_2") ) {
					sb.append(" ORDER BY lecture_title desc");
				}
				else {
					sb.append(" ORDER BY lecture_reg_date desc");
				}
				
			}
			
			
		//페이징
		if ( map.get("page_skip_cnt") != null && map.get("page_size") != null ) {
			sb.append(" LIMIT "+ map.get("page_skip_cnt") +", "+ map.get("page_size"));
		}
		
		System.out.println("sql : " + sb.toString());	//쿼리 출력
		
		
		try {
			psmt = conn.prepareStatement(sb.toString());
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				LectureDTO lec_dto = new LectureDTO();
				lec_dto.setLecture_idx(rs.getInt("lecture_idx"));
				lec_dto.setLecture_img(rs.getString("lecture_img"));
				lec_dto.setLecture_title(rs.getString("lecture_title"));
				lec_dto.setMember_name(rs.getString("member_name"));
				lec_dto.setMember_company(rs.getString("member_company"));
				lec_dto.setLecture_start_date(rs.getDate("lecture_start_date"));
				lec_dto.setLecture_end_date(rs.getDate("lecture_end_date"));
				lec_dto.setLecture_category(rs.getString("lecture_category"));
				lec_dto.setLecture_category_detail(rs.getString("lecture_category_detail"));
				lec_dto.setLecture_reg_date(rs.getDate("lecture_reg_date"));
				
				list.add(lec_dto);
				
			}
		} catch(Exception e) {
			System.out.println("강의 리스트 조회 에러");
			e.printStackTrace();
		}
		return list;
	}
	
	
	
}
