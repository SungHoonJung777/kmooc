package bbs;

import java.io.IOException;

import common.CommonUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class bbsModifyConn
 */
@WebServlet("/modifyConn.do")
public class bbsModifyConn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		BbsComuDAO dao = new BbsComuDAO();
		BbsComuDTO dto = new BbsComuDTO();
		dto = dao.bbsView(Integer.parseInt(request.getParameter("idx")));
		if(CommonUtil.loginCheck(hs)) {
			request.setAttribute("idx", dto.getComu_idx());
			request.setAttribute("category", dto.getComu_category());
			request.setAttribute("title", dto.getComu_title());
			request.setAttribute("content", dto.getComu_content());
	
			request.getRequestDispatcher("bbs/bbsModify.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("./member/login.do");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
