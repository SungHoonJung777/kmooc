package controller.member;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import member.MemberDAO;

@WebServlet("/member/emailcheck.do")
public class emailcheckController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = req.getParameter("email");
		MemberDAO dao = new MemberDAO();
		req.setAttribute("result", dao.emailcheck(email));
		dao.close();
		req.getRequestDispatcher("/member/emailcheck.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = req.getParameter("email");
		MemberDAO dao = new MemberDAO();
		req.setAttribute("result", dao.emailcheck(email));
		dao.close();
		req.getRequestDispatcher("/member/emailcheck.jsp").forward(req, resp);
	}
}
