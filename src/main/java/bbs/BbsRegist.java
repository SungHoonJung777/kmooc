package bbs;

import java.io.IOException;
import java.util.ArrayList;

import common.CommonUtil;
import fileupload.FileUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BbsRegist
 */
@MultipartConfig(
		maxFileSize = 1024*1024*1,
		maxRequestSize = 1024*1024*10
)
@WebServlet("/regist.do")
public class BbsRegist extends HttpServlet {
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
		String directory = getServletContext().getRealPath("/upload");

		BbsComuDAO dao = new BbsComuDAO();
		BbsComuDTO dto = new BbsComuDTO();
		String a = (String)request.getParameter("category").trim();
		String b = (String)request.getParameter("user_id").trim();
		String c = (String)request.getParameter("title").trim();
		String d = (String)request.getParameter("content").trim();
		dto.setMember_user_id(b);
		dto.setComu_title(c);
		dto.setComu_content(d);
		int idx = 0;
		System.out.println("a="+a+"b="+b+"c="+c+"d="+d);
		if(CommonUtil.isValue(a)&&CommonUtil.isValue(b)&&CommonUtil.isValue(c)){
			dto.setComu_category(a);
			dto.setMember_user_id(b);
			dto.setComu_title(c);
			dto.setComu_content(d);
			dao.bbsRegist(dto);
			if(request.getPart("file")!=null) {
			ArrayList<String> arrFileName = FileUtil.uploadFile2(request, directory);
			idx = dao.lastInsertId();
			for(String orgFileName:arrFileName) {
				
				FileUtil.registFile(request, orgFileName, orgFileName,idx);
				}
			}
			else {
				System.out.print("파일이 없습니다.");
			}
			response.sendRedirect("comu.do");
		}
		else{
			response.sendRedirect("comu.do?result=fail");
		}
		dao.close();
	}

}
