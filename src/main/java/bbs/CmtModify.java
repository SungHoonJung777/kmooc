package bbs;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cmtmodify.do")
public class CmtModify extends HttpServlet {
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
		int a = 0;
		int b = 0;
		String c = null;
		if((String)request.getParameter("cmtidx")!=null) {
		a =Integer.parseInt((String)request.getParameter("cmtidx"));
		}
		if((String)request.getParameter("idx")!=null) {
		b =Integer.parseInt((String)request.getParameter("idx"));
		}
		if((String)request.getParameter("cmtmodifycontent") != null) {
		c = (String)request.getParameter("cmtmodifycontent").trim();
		}
		
		dto.setComt_idx(a);
		dto.setComu_idx(b);
		dto.setComt_content(c);
		dao.cmtModify(dto);
		response.sendRedirect("bbsdetail.do?idx="+b);
		dao.close();
	}
}
