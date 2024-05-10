package controller.member;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import member.MemberDAO;

@WebServlet("/member/idcheck.do")
public class IdcheckController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		MemberDAO dao = new MemberDAO();
		req.setAttribute("result", dao.idcheck(id));
		
		dao.close();
		req.getRequestDispatcher("/member/idcheck.jsp").forward(req, resp);
	}
	
}
