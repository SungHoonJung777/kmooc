package action;

import java.io.IOException;

import dao.CartDAO;
import dto.CartDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mainController.Action;

public class cartDelete implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String imgUrl  = request.getParameter("imgUrl");
		String title  = request.getParameter("title");
		String teacherName  = request.getParameter("name");
		int idx =Integer.parseInt( request.getParameter("idx"));
	
		HttpSession session = request.getSession();
		
		String memberId = (String) session.getAttribute("userId");
		
		CartDAO dao = new CartDAO();
		CartDTO dto = new CartDTO();
		
		int deleteResult = dao.cartDelete(idx, memberId);
		
		String url = "/kmocMain.do?command=lectureDetail&lecture_idx=" + idx;
		
		if(deleteResult == 1){
			request.getRequestDispatcher(url).forward(request, response);
		} else {
			request.getRequestDispatcher(url).forward(request, response);
			System.out.println("카트 삭제 실패");
		}
		
	}
	
}
