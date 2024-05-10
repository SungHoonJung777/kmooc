package controller.mypage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import member.MemberDAO;
import member.MemberDTO;

@WebServlet("/mypage/mypage_info.do")
public class MypageInfoController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession(true);
		String id = (String)session.getAttribute("userId");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto =	dao.getMemberInfo(id);
		String name = dto.getMember_name();
		String email = dto.getMember_email();
		String tel = dto.getMember_phone();
		String category = dto.getMember_category();
		dao.close();
		
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("id", id);
		params.put("name", name);
		params.put("email", email);
		params.put("tel", tel);
		params.put("category", category);
		
		req.setAttribute("params", params);
		req.getRequestDispatcher("mypage_info.jsp").forward(req, resp);
		
	}
}
