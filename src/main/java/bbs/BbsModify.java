package bbs;

import java.io.IOException;
import java.util.ArrayList;

import fileupload.FileUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BbsModify
 */
@MultipartConfig(
		maxFileSize = 1024*1024*1,
		maxRequestSize = 1024*1024*10
)
@WebServlet("/modify.do")
public class BbsModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String directory = getServletContext().getRealPath("/upload");
		BbsComuDAO dao = new BbsComuDAO(); 
		int idx = Integer.parseInt(request.getParameter("idx"));
		BbsComuDTO bbsView = dao.bbsView(idx);
		bbsView.setComu_category((String)request.getParameter("category"));
		bbsView.setComu_idx(idx);
		bbsView.setComu_title((String)request.getParameter("title"));
		bbsView.setComu_content((String)request.getParameter("content"));
		dao.bbsModify(bbsView);
		
		if(request.getPart("file")!=null) {
		ArrayList<String> arrFileName = FileUtil.uploadFile2(request, directory);

		for(String orgFileName:arrFileName) {
			
			FileUtil.registFile(request, orgFileName, orgFileName,idx);
			}
		}
		else {
			System.out.print("파일이 없습니다.");
		}
		dao.close();
		response.sendRedirect("comu.do");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
