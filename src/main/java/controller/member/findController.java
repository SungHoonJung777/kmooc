package controller.member;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/member/find.do")
public class findController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String search = (String)req.getParameter("search");
		req.setAttribute("search",search);
		req.getRequestDispatcher("/member/find.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String search = (String)req.getParameter("search");
		req.setAttribute("search",search);
		req.getRequestDispatcher("/member/find.jsp").forward(req, resp);
	}
}
