package action;

import java.io.IOException;

import common.CommonUtil;
import dao.CartDAO;
import dao.LectureDAO;
import dto.CartDTO;
import dto.LectureDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mainController.Action;

public class cartAdd implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String imgUrl  = request.getParameter("imgUrl");
		String title  = request.getParameter("title");
		String teacherName  = request.getParameter("name");
		int idx =Integer.parseInt( request.getParameter("idx"));
	
		HttpSession session = request.getSession();
		
		String memberId = (String) session.getAttribute("userId");
		
		String url = "/kmocMain.do?command=lectureDetail&lecture_idx=";
		CartDAO dao = new CartDAO();
		CartDTO dto = new CartDTO();
		
		dto.setMember_user_id(memberId);
		dto.setLecture_idx(idx);
		dto.setLecture_title(title);
		dto.setLecture_teacher(teacherName);
		dto.setLecture_img(imgUrl);
		
		
		int cResult = dao.cartRegist(dto); 
		dao.close();

		url +=idx;

		if(cResult == 1){
			request.getRequestDispatcher(url).forward(request, response);
		} else {
			request.getRequestDispatcher(url).forward(request, response);
			System.out.println("카트 수강 실패");
		}
		
		
	}
	
}
