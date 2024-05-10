package controller.lecture;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lecture.LectureDAO;
import lecture.LectureDTO;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.BbsPage;

@WebServlet("/lecture/lecture_main.do")
public class LectureMainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int total_count = 0; // 전체 게시글 수
		int total_page = 1; // 전체 페이지 개수 = ceil(total_count/page_size)
		int page_no = 1; // 현재 페이지 = total_page/page_size
		int page_size = 20; // db limit에 들어갈 값들
		int page_skip_cnt = 10; // db limit에 들어갈 값들 size*skip?
		int page_block_size = 10;
		int page_block_start = 1; // page_no
		int page_block_end = 1;

		// 카테고리 한글말 전환 맵
		Map<String, Object> params = new HashMap<String, Object>();

		// JSP 페이지에 전달할 앱 객체 설정
		Map<String, String> category_map = new HashMap<String, String>();
		category_map.put("10000", "인문");
		category_map.put("20000", "사회");
		category_map.put("30000", "교육");
		category_map.put("40000", "공학");
		category_map.put("50000", "자연");
		category_map.put("60000", "의약");
		category_map.put("70000", "예체능");
		category_map.put("80000", "융합");

		category_map.put("10100", "언어문학");
		category_map.put("10200", "인문과학");
		category_map.put("20100", "경영경제");
		category_map.put("20200", "법률");
		category_map.put("20300", "사회과학");
		category_map.put("30100", "교육일반");
		category_map.put("30200", "유아교육");
		category_map.put("30300", "초등교육");
		category_map.put("30400", "중등교육");
		category_map.put("30500", "고등교육");
		category_map.put("40100", "건축");
		category_map.put("40200", "전기");
		category_map.put("40300", "전자");
		category_map.put("40400", "컴퓨터");
		category_map.put("50100", "농림");
		category_map.put("50200", "화학");
		category_map.put("50300", "생명");
		category_map.put("60100", "의료");
		category_map.put("60200", "간호");
		category_map.put("70100", "디자인");
		category_map.put("70200", "영화");
		category_map.put("70300", "미술");
		category_map.put("80100", "융합");

		String result_category = category_map.get(req.getParameter("search_category"));
		String result_category_detail = category_map.get(req.getParameter("search_category_detail"));
		req.setAttribute("result_category", result_category);
		req.setAttribute("result_category_detail", result_category_detail);

		// 검색 옵션
		String search_option = req.getParameter("search_option");
		String search_word = req.getParameter("search_word");
		// 선택 옵션
		String search_state = req.getParameter("search_state");
		String search_category = req.getParameter("search_category");
		String search_category_detail = req.getParameter("search_category_detail");
		String search_period = req.getParameter("search_period");

		// 페이징 옵션
		page_no = (req.getParameter("page_no") != null ? Integer.parseInt(req.getParameter("page_no")) : 1);
		page_skip_cnt = (page_no - 1) * page_size;

		// 검색 파라미터 설정(검색)
		if (search_word != null) {
			params.put("search_option", search_option);
			params.put("search_word", search_word);
		}

		// 검색 파라미터 설정(카테고리)
		if (true) {
			params.put("search_state", search_state);
			params.put("search_category", search_category);
			params.put("search_category_detail", search_category_detail);
			params.put("search_period", search_period);
		}
		// 정렬 옵션
		String c = "";
		
		if (req.getParameter("order_by") != null) {
			c = req.getParameter("order_by");
			System.out.println("####"+c);
			// 정렬 설정
			if (c != null && c.equals("order_by_1")) {
				params.put("order_by", c);
			} else if (c != null && c.equals("order_by_2")) {
				params.put("order_by", c);
			}
		}

		

		// 페이징 파라미터 설정
		params.put("page_no", page_no);
		params.put("page_size", page_size);
		params.put("page_skip_cnt", page_skip_cnt);

		// 게시판 테이블 조회
		LectureDAO lec_dao = new LectureDAO();
		total_count = lec_dao.lectureTotalCount(params);
		List<LectureDTO> lectureList = lec_dao.lectureList(params);

		// 페이징 파라미터 설정
		total_page = (int) Math.ceil(total_count / (double) page_size);
		page_block_size = 10;
		page_block_start = (int) Math.floor((page_no - 1) / (double) page_size) * page_size + 1;
		page_block_end = (int) Math.ceil(page_no / (double) page_size) * page_size;
		page_block_end = (page_block_end > total_page ? total_page : page_block_end);

		params.put("total_count", total_count);
		params.put("total_page", total_page);
		params.put("page_block_size", page_block_size);
		params.put("page_block_start", page_block_start);
		params.put("page_block_end", page_block_end);

//		String pagingArea = BbsPage.pagingArea(total_page, page_no, page_block_start, page_block_end,
//				"lecture_main.do?", "");
		
		String pagingArea = BbsPage.pagingArea(total_page, page_no, page_block_start, page_block_end,
				"lecture_main.do?", search_option, search_word, search_state, search_category, search_category_detail, search_period);

		params.put("paging", pagingArea);

		req.setAttribute("lectureList", lectureList);
		req.setAttribute("params", params);
		req.setAttribute("category_map", category_map);

		req.getRequestDispatcher("/lecture/lecture_main.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
