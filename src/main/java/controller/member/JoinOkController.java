package controller.member;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import member.MemberDAO;
import member.MemberDTO;

@WebServlet("/member/join_ok.do")
public class JoinOkController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String pwd = req.getParameter("password");
		String birth = req.getParameter("birth");
		String tel = req.getParameter("phone");
		String email = req.getParameter("email");
		String memtype = req.getParameter("memtype");
		String compnum = req.getParameter("compnum");
		String compname = req.getParameter("compname");
		
		
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO();
		dto.setMember_name(name);
		dto.setMember_user_id(id);
		dto.setMember_pwd(pwd);
		dto.setMember_phone(tel);
		dto.setMember_email(email);
		dto.setMember_category(memtype);
		dto.setMember_company_num(compnum);
		dto.setMember_company(compname);
		dto.setMember_birth(birth);
		
		
		int result = dao.join(dto);
		
		
		dao.close();
		
		try {
			if(result >0){
				req.setAttribute("name", name);
				req.setAttribute("id", id);
				req.setAttribute("email", email);
				req.getRequestDispatcher("/member/join_ok.jsp").forward(req, resp);
			}
			else{
				req.setAttribute("errmsg", "회원가입 실패");
				req.getRequestDispatcher("/member/join.do").forward(req, resp);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("errmsg", "회원가입 실패");
			req.getRequestDispatcher("/member/join.do").forward(req, resp);
		}
		
		
	}
}
