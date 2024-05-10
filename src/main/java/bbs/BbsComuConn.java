package bbs;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class BbsComuConn
 */
@WebServlet("/comu.do")
public class BbsComuConn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

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
		BbsComuDAO dao = new BbsComuDAO();
		String category = null;
		String category2 = null;
		String search_category = request.getParameter("search_category");
		String search_word = request.getParameter("search_word");
		page_no = (request.getParameter("page_no")!=null ? Integer.parseInt(request.getParameter("page_no")) : 1);
		page_skip_cnt = (page_no-1)*page_size;
		List<BbsComuDTO> bbsList = new ArrayList<BbsComuDTO>();
		Map<String,Object> params = new HashMap<String, Object>();
		Map<Object,String> cateList = new HashMap<Object,String>();
		params.put("category",category);
		
		params.put("page_skip_cnt", page_skip_cnt);
		params.put("page_size", page_size);
		params.put("page_no", page_no);
		
		cateList.put("1","자유게시판");cateList.put("2","공지사항");
		if(request.getParameter("category") != null){
			category2 = request.getParameter("category");
			category = cateList.get(request.getParameter("category").trim());
		}
		total_count = dao.bbsTotalCount(category);
		bbsList = dao.bbsList(category,page_skip_cnt,page_size );
		if((search_category !=null && !search_category.isEmpty() && search_word != null && !search_word.isEmpty())){
			params.put("search_category",search_category.trim());
			params.put("search_word",search_word.trim());
			total_count = dao.bbsTotalCount2(search_category,search_word);
			bbsList = dao.bbsList2(search_category,search_word, page_skip_cnt,page_size );
		}
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
		
		String pagingArea = BbsPage.pagingArea(total_page,page_no, page_block_start, page_block_end, "comu.do?",category2,search_category,search_word);
		params.put("paging", pagingArea);
		
		request.setAttribute("bbsList", bbsList);
		request.setAttribute("params",params);
		
		request.getRequestDispatcher("./bbs/bbsComu.jsp").forward(request, response);			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
