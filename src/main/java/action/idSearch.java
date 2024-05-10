package action;

import java.io.IOException;
import java.util.ArrayList;

import dao.MemberSearchDAO;
import dto.LectureDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mainController.Action;
import member.MemberDTO;

public class idSearch implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phone = request.getParameter("tel");
		String email = request.getParameter("email");
		
		MemberSearchDAO dao = new MemberSearchDAO();
		int sResult = dao.idSearch(phone,email);
		
		if(sResult == 1) {
			String memberId = dao.idSearchFind(phone,email);
			request.setAttribute("memberId", memberId);
		} else {
			System.out.println("일치하는 회원정보 없음");
			request.setAttribute("memberId", "nullId");
		}
		
		String url = "/member/find.do?search=1";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}
	
}
