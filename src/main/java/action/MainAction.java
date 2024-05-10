package action;

import java.io.IOException;
import java.util.ArrayList;

import dao.LectureDAO;
import dto.LectureDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mainController.Action;

public class MainAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "/main.jsp";

		LectureDAO dao = new LectureDAO();
		
		
		ArrayList<LectureDTO> bestLectureList  = dao.listBestLecture();
		ArrayList<LectureDTO> recommendLectureList = dao.listRecommendLecture();
		
		request.setAttribute("bestLectureList", bestLectureList);
		request.setAttribute("recommendLectureList", recommendLectureList);
		
		System.out.println("Best 상품 조회 리스트" + bestLectureList);
		System.out.println("recommend 상품 조회 리스트" + recommendLectureList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
		
	}
	
}	
