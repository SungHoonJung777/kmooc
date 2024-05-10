package bbs;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cmtdelete.do")
public class CmtDelete extends HttpServlet {
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
		
		CmtDAO dao = new CmtDAO();
		int a = 0;
		int b = 0;
		if((String)request.getParameter("cmtidx")!=null) {
		a =Integer.parseInt((String)request.getParameter("cmtidx"));
		}
		if((String)request.getParameter("idx")!=null) {
		 b =Integer.parseInt((String)request.getParameter("idx"));
		}
		dao.cmtDelete(a);
		response.sendRedirect("bbsdetail.do?idx="+b);
		dao.close();
	}
}
