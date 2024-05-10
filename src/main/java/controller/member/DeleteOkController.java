package controller.member;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import member.MemberDAO;

@WebServlet("/Project4/member/deletecheck.do")
public class DeleteOkController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession(true);
		
		String id = (String) session.getAttribute("userId");
		MemberDAO dao = new MemberDAO();
		int result = dao.DeleteMember(id);
		dao.close();
		if(result>0) {
			session.invalidate();
			req.getRequestDispatcher("/Project4/member/deleteOk.jsp").forward(req, resp);
		}
		else {
			req.setAttribute("errMsg", "오류");
			resp.sendRedirect("/mypage/mypage.jsp");
		}
	}
}
