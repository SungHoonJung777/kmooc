package bbs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fileupload.FileDAO;
import fileupload.FileDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BbsDetailConn
 */
@WebServlet("/bbsdetail.do")
public class BbsDetailConn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BbsComuDAO dao = new BbsComuDAO(); 
		int idx = 0;
		idx = Integer.parseInt(request.getParameter("idx"));
		BbsComuDTO bbsView = dao.bbsView(idx);
		int preidx= idx-1;
		int nextidx= idx+1;
		BbsComuDTO prebbsView = dao.bbsView(preidx);
		BbsComuDTO nextbbsView = dao.bbsView(nextidx);
	
		while(prebbsView.getComu_idx() ==0 && preidx > 0) {
			System.out.print(prebbsView.getComu_idx());
			prebbsView = dao.bbsView(preidx);
			preidx--;
		}
		int lastidx=dao.lastInsertId();
		while(nextbbsView.getComu_idx() ==0  && nextidx <= lastidx) {
			nextbbsView = dao.bbsView(nextidx);
			nextidx++;
		}
		request.setAttribute("lastidx",lastidx);
		dao.close();
		
		String user_id="";
		String reg_date="";
		String title="";
		String content="";
		String modify_date="";	
		
		String user_id1="";
		String reg_date1="";
		String title1="";
		String content1="";
		String modify_date1="";
		
		String user_id2="";
		String reg_date2="";
		String title2="";
		String content2="";
		String modify_date2="";
		if(bbsView!=null){
			user_id=bbsView.getMember_user_id();
			if(reg_date!=null && reg_date!=""){
				reg_date=bbsView.getComu_reg_date().toString();
			}
			title=bbsView.getComu_title();
			content=bbsView.getComu_content();
			reg_date=bbsView.getComu_reg_date();
			modify_date=bbsView.getComu_modify_date();
			content = (content!=null ? content.replace("\n\r","<br>"):"");
			content = (content!=null ? content.replace(" ","&nbsp"):"");
			
			request.setAttribute("idx", idx);
			request.setAttribute("user_id", user_id);
			request.setAttribute("title", title);
			request.setAttribute("content", content);
			request.setAttribute("reg_date", reg_date);
			request.setAttribute("modify_date", modify_date);
		}
		
		if(prebbsView!=null){
			user_id1=prebbsView.getMember_user_id();
			if(reg_date1!=null && reg_date1!=""){
				reg_date1=prebbsView.getComu_reg_date().toString();
			}
			title1=prebbsView.getComu_title();
			content1=prebbsView.getComu_content();
			reg_date1=prebbsView.getComu_reg_date();
			modify_date1=prebbsView.getComu_modify_date();
			content1 = (content1!=null ? content1.replace("\n\r","<br>"):"");
			content1 = (content1!=null ? content1.replace(" ","&nbsp"):"");
			
			request.setAttribute("preidx", preidx);
			request.setAttribute("user_id1", user_id1);
			request.setAttribute("title1", title1);
			request.setAttribute("content1", content1);
			request.setAttribute("reg_date1", reg_date1);
			request.setAttribute("modify_date1", modify_date1);
		}
		if(nextbbsView!=null){
			user_id2=nextbbsView.getMember_user_id();
			if(reg_date2!=null && reg_date2!=""){
				reg_date2=nextbbsView.getComu_reg_date().toString();
			}
			title2=nextbbsView.getComu_title();
			content2=nextbbsView.getComu_content();
			reg_date2=nextbbsView.getComu_reg_date();
			modify_date2=nextbbsView.getComu_modify_date();
			content2 = (content2!=null ? content2.replace("\n\r","<br>"):"");
			content2 = (content2!=null ? content2.replace(" ","&nbsp"):"");
			
			request.setAttribute("nextidx", nextidx);
			request.setAttribute("user_id2", user_id2);
			request.setAttribute("title2", title2);
			request.setAttribute("content2", content2);
			request.setAttribute("reg_date2", reg_date2);
			request.setAttribute("modify_date2", modify_date2);
		}
		FileDAO dao2 =new FileDAO();
		List<FileDTO> fileLists = dao2.fileList(request.getParameter("idx"));
		if(fileLists!=null){
			request.setAttribute("fileLists", fileLists);
		}
		
		CmtDAO dao3 = new CmtDAO();
		int comu_idx = idx;
		int cmt_total = dao3.cmtTotalCount(comu_idx);
		request.setAttribute("cmt_total", cmt_total);
		List<CmtDTO> cmtList = new ArrayList<CmtDTO>();
		cmtList = dao3.cmtList(comu_idx);
		request.setAttribute("cmtList", cmtList);
		
		request.getRequestDispatcher("/bbs/bbsDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
