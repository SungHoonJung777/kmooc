package bbs;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.BbsPage;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BbsQnaConn
 */
@WebServlet("/qna.do")
public class BbsQnaConn extends HttpServlet {
	private static final long serialVersionUID = 1L;
      

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int total_count = 0;
		int total_page = 1;
		int page_no = 1;
		int page_size = 10;
		int page_skip_cnt = 10;
		int page_block_size = 10;
		int page_block_start = 1;
		int page_block_end = 1;
		String qna_category = null;
		String qna_category2 = null;
		Map<Object,String> cateList = new HashMap<Object,String>();
		cateList.put("0","회원가입");cateList.put("1","로그인");cateList.put("2","수강신청");cateList.put("3","강좌수강");
		cateList.put("4","성적");cateList.put("5","기술적문제");cateList.put("6","기타");
		if(request.getParameter("category") != null){
			qna_category2 = request.getParameter("category");
			qna_category = cateList.get(request.getParameter("category").trim());		
		}
		Map<String,Object> params = new HashMap<String, Object>();
		
		params.put("qna_category",qna_category);
		page_no = (request.getParameter("page_no")!=null ? Integer.parseInt(request.getParameter("page_no")) : 1);
		page_skip_cnt = (page_no-1)*page_size;
		
		params.put("page_skip_cnt", page_skip_cnt);
		params.put("page_size", page_size);
		params.put("page_no", page_no);
		BbsQnaDAO dao = new BbsQnaDAO();
		total_count = dao.bbsTotalCount(qna_category);
		List<BbsQnaDTO> bbsList = dao.bbsList(qna_category, page_skip_cnt,page_size );
		dao.close();
		
		total_page = (int)Math.ceil(total_count/(double)page_size);
		page_block_size = 10;
	    page_block_start = (int)Math.floor((page_no-1)/(double)page_size)*page_size +1;
		page_block_end = (int)Math.ceil(page_no/(double)page_size)*page_size;
		page_block_end = (page_block_end>total_page?total_page:page_block_end);
		
		params.put("total_count", total_count);
		params.put("total_page", total_page);
		params.put("page_block_start", page_block_start);
		params.put("page_block_end", page_block_end);
		params.put("page_block_size", page_block_size);
		
		String pagingArea = BbsPage.pagingArea(total_page,page_no, page_block_start, page_block_end, "./qna.do?", qna_category2);
		params.put("paging", pagingArea);
		
		request.setAttribute("bbsList", bbsList);
		request.setAttribute("params",params);
	
		request.getRequestDispatcher("./bbs/bbsQna.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
