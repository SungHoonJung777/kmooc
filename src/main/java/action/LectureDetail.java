package action;

import java.io.IOException;
import java.util.ArrayList;

import dao.CartDAO;
import dao.HeartDAO;
import dao.LectureDAO;
import dto.LectureDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mainController.Action;

public class LectureDetail implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int lecture_idx =  Integer.parseInt(request.getParameter("lecture_idx"));  
		String url = "/lecture/lecture_detail.jsp";
		
		LectureDAO dao = new LectureDAO();
		ArrayList<LectureDTO> lecture_detail = dao.lectureDetail(lecture_idx);

		String categoryDetail = dao.categoryDetail(lecture_idx);
		 System.out.println(categoryDetail+"#################");
		request.setAttribute("lectureDetail", lecture_detail);
		request.setAttribute("categoryDetail", categoryDetail);
		
		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("userId");
		if(memberId !=null && !memberId.isEmpty()) {
			CartDAO cartDao = new CartDAO();
			int check_Cart = cartDao.countMemberCart(lecture_idx,memberId);
			request.setAttribute("checkCart", check_Cart);
			System.out.println("############# 카트확인 ");
			
			HeartDAO heartDao = new HeartDAO();
			int check_Heart = heartDao.countMemberHeart(lecture_idx,memberId);
			request.setAttribute("checkHeart", check_Heart);
			System.out.println("############# 찜하기 확인 ");
		}

		request.setAttribute("memberId", memberId);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	

}
