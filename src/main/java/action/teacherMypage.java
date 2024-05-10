package action;

import java.io.IOException;
import java.util.ArrayList;

import Criteria.Criteria;
import Criteria.PageMakerDTO;
import dao.LectureDAO;
import dto.LectureDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mainController.Action;

public class teacherMypage implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		String memberId = (String) session.getAttribute("userId");

		ArrayList<LectureDTO> list = new ArrayList<>();
		LectureDAO dao = new LectureDAO();

		// 리스트 총 갯수
		int total_count = dao.teacherMypageCount(memberId);
		System.out.println("total_count"+total_count);
		
		Criteria cri = new Criteria();

		String pageNumStr = request.getParameter("pageNum");
		int pageNum = 1; // 기본 페이지 번호는 1로 설정
		if (pageNumStr != null) {
			pageNum = Integer.parseInt(pageNumStr);
		}

		cri.setPageNum(pageNum);

		
		
		PageMakerDTO pageMake = new PageMakerDTO(cri, total_count);
	     
        request.setAttribute("pageMaker", pageMake);
		
        list = dao.teacherMypage(memberId,cri,total_count);
		request.setAttribute("lecture_list", list);
		String url = "/mypage/teacherMypage.jsp";

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
