package bbs;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cmtregist.do")
public class CmtRegist extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.print("cmt테스트");
		CmtDAO dao = new CmtDAO();
		CmtDTO dto = new CmtDTO();
		String a = (String)request.getParameter("idx").trim();
		String b = (String)request.getParameter("user_id").trim();
		String c = (String)request.getParameter("cmtContent").trim();
		dto.setMember_user_id(b);
		dto.setComt_content(c);
		dto.setComu_idx(Integer.parseInt(a));
		dao.cmtRegist(dto);
		response.sendRedirect("bbsdetail.do?idx="+a);
		dao.close();
	}
}
