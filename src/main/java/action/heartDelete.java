package action;

import java.io.IOException;

import dao.CartDAO;
import dao.HeartDAO;
import dto.CartDTO;
import dto.HeartDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mainController.Action;

public class heartDelete implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String imgUrl  = request.getParameter("imgUrl");
		String title  = request.getParameter("title");
		String teacherName  = request.getParameter("name");
		int idx =Integer.parseInt( request.getParameter("idx"));
	
		HttpSession session = request.getSession();
		
		String memberId = (String) session.getAttribute("userId");
		
		HeartDAO dao = new HeartDAO();
		HeartDTO dto = new HeartDTO();
		
		int deleteResult = dao.heartDelete(idx, memberId);
		
		String url = "/kmocMain.do?command=lectureDetail&lecture_idx=" + idx;
		
		if(deleteResult == 1){
			request.getRequestDispatcher(url).forward(request, response);
		} else {
			request.getRequestDispatcher(url).forward(request, response);
			System.out.println("하트 삭제 실패");
		}
		
	}
	
}
