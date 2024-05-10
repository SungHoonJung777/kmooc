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

public class heartAdd implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String imgUrl  = request.getParameter("imgUrl");
		String title  = request.getParameter("title");
		String teacherName  = request.getParameter("name");
		int idx =Integer.parseInt( request.getParameter("idx"));
	
		HttpSession session = request.getSession();
		
		String memberId = (String) session.getAttribute("userId");
		
		String url = "/kmocMain.do?command=lectureDetail&lecture_idx=";
		HeartDAO dao = new HeartDAO();
		HeartDTO dto = new HeartDTO();
		
		System.out.println(memberId);
		System.out.println(dto.getMember_user_id());
		
		dto.setMember_user_id(memberId);
		dto.setLecture_idx(idx);
		dto.setLecture_title(title);
		dto.setLecture_teacher(teacherName);
		dto.setLecture_img(imgUrl);
		
		
		int hResult = dao.heartRegist(dto); 
		dao.close();

		url +=idx;

		if(hResult == 1){
			request.getRequestDispatcher(url).forward(request, response);
		} else {
			request.getRequestDispatcher(url).forward(request, response);
			System.out.println("찜하기  실패");
		}
	}
	
}
