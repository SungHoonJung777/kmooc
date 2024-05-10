package controller.member;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/member/joinChoiceOk.do")

public class JoinChoiceOkController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession(true);
		String type = req.getParameter("type");
		session.setAttribute("type",type);
		if(type.equals("child")) {
			req.getRequestDispatcher("/member/agreement.do").forward(req, resp);
		}else if(type.equals("user")) {
			req.getRequestDispatcher("/member/termsagree.do").forward(req, resp);
		}
	}
}
