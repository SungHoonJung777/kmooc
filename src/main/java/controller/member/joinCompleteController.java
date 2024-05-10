package controller.member;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/member/join_complete.do")
public class joinCompleteController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String email = req.getParameter("email");
		
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("name", name);
		params.put("id", id);
		params.put("email", email);
		req.setAttribute("params",params);
		req.getRequestDispatcher("/member/join_complete.jsp").forward(req, resp);
	}
}
