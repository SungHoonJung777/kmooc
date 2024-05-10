package controller.member;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import member.MemberDAO;

@WebServlet("/member/compnumcheck.do")
public class compnumcheckController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String compnum = req.getParameter("compnum");
		MemberDAO dao = new MemberDAO();
		req.setAttribute("result", dao.idcheck(compnum));
		
		dao.close();
		req.getRequestDispatcher("/member/compnumcheck.jsp").forward(req, resp);
	}
	
}
