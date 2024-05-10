package controller.mypage;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import member.MemberDAO;


@WebServlet("/mypage/modifyMypage.do")
public class ModifyMypageController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		System.out.print(id+","+pwd+","+email+","+phone);
		MemberDAO dao = new MemberDAO();
		int result = dao.pwdChange(phone,email,id,pwd);
		if(result > 0) {
			session.invalidate();
			req.getRequestDispatcher("/mypage/modify_ok.jsp").forward(req, resp);
		}
		else {
			System.out.println("오류");
			req.getRequestDispatcher("/mypage/mypage_info.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		String id = req.getParameter("#id");
		String pwd = req.getParameter("#pwd");
		String email = req.getParameter("#email");
		String phone = req.getParameter("#phone");
		System.out.print(id+","+pwd+","+email+","+phone);
		MemberDAO dao = new MemberDAO();
		int result = dao.pwdChange(phone,email,id,pwd);
		if(result > 0) {
			session.invalidate();
			req.getRequestDispatcher("/mypage/modify_ok.jsp").forward(req, resp);
		}
		else {
			System.out.println("오류");
			req.getRequestDispatcher("/mypage/mypage_info.jsp").forward(req, resp);
		}
	}
}
