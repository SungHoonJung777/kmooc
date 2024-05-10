package controller.mypage;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import member.MemberDAO;

@WebServlet("/mypage/mypage_change_password.do")
public class pwdChangeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		System.out.println(id);
		MemberDAO dao = new MemberDAO();
		req.setAttribute("pwd", dao.pwdconfirm(id));
		dao.close();
		req.getRequestDispatcher("/mypage/mypage_change_password.jsp").forward(req, resp);
	}
}
