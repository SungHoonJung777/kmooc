package controller.member;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import member.MemberDAO;
import member.MemberDTO;

@WebServlet("/member/login_ok.do")
public class LoginOkController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession(true);
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		System.out.println("id : "+id+" ,pwd:" + pwd);
		MemberDAO dao = new MemberDAO();
		MemberDTO dto =	dao.getMemberInfo(id,pwd);
		dao.close();
		
		if(dto.getMember_user_id() != null){
			session.setAttribute("userId",dto.getMember_user_id());
			session.setAttribute("userName",dto.getMember_name());
			session.setAttribute("member_category", dto.getMember_category());
			resp.sendRedirect("/Project4/kmocMain.do?command=main");
		}
		else {
			req.getRequestDispatcher("login_ok.jsp").forward(req, resp);
		}
	}
}
