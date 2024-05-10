package controller.mypage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dto.CartDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lecture.LectureDTO;
import member.MemberDAO;
import member.MemberDTO;

@WebServlet("/mypage/mypage.do")
public class MypageController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(true);
		
		String id = (String)session.getAttribute("userId");
		List<HashMap<String, Object>> param = new ArrayList<HashMap<String,Object>>();
		List<HashMap<String, Object>> heartparam = new ArrayList<HashMap<String,Object>>();
		MemberDAO dao = new MemberDAO();
		MemberDTO memdto = new MemberDTO();
		
		memdto = dao.getMemberInfo(id);
		String name = memdto.getMember_user_id();
		String email = memdto.getMember_email();
		List<String> emailList = new ArrayList<String>();
		List<String> nameList = new ArrayList<String>();
		List<String> titleList = new ArrayList<String>();
		List<String> teacherList = new ArrayList<String>();
		List<Date> strdateList = new ArrayList<Date>();
		List<Date> enddateList = new ArrayList<Date>();
		List<Integer> idxList = new ArrayList<Integer>();
		List<String> imgList = new ArrayList<String>();
		param = dao.getCartInfo(id);
		
		
		for(int i = 0; i<param.size(); i++) {
			
			LectureDTO lecdto = new LectureDTO();
			CartDTO cartdto = new CartDTO();
			
			
			lecdto = (LectureDTO)param.get(i).get(i+"lecdto");
			cartdto = (CartDTO)param.get(i).get(i+"cartdto");
			
			
			titleList.add(cartdto.getLecture_title());
			teacherList.add(cartdto.getLecture_teacher());
			strdateList.add(lecdto.getLecture_start_date());
			enddateList.add(lecdto.getLecture_end_date());
			idxList.add(lecdto.getLecture_idx());
			imgList.add(lecdto.getLecture_img());
			
		}
		
		List<String> hearttitleList = new ArrayList<String>();
		List<String> heartteacherList = new ArrayList<String>();
		List<Date> heartstrdateList = new ArrayList<Date>();
		List<Date> heartenddateList = new ArrayList<Date>();
		List<Integer> heartidxList = new ArrayList<Integer>();
		List<String> heartimgList = new ArrayList<String>();
		heartparam = dao.getHeartInfo(id);
		
		for(int i = 0; i<heartparam.size(); i++) {
			
			LectureDTO lecdto = new LectureDTO();
			CartDTO cartdto = new CartDTO();
			
			lecdto = (LectureDTO)heartparam.get(i).get(i+"lecdto");
			cartdto = (CartDTO)heartparam.get(i).get(i+"cartdto");
			
			hearttitleList.add(cartdto.getLecture_title());
			heartteacherList.add(cartdto.getLecture_teacher());
			heartstrdateList.add(lecdto.getLecture_start_date());
			heartenddateList.add(lecdto.getLecture_end_date());
			heartidxList.add(lecdto.getLecture_idx());
			heartimgList.add(lecdto.getLecture_img());
			
		}
		
		Map<String, Object> params = new HashMap<String,Object>();
		Map<String, Object> params1 = new HashMap<String,Object>();
		
		
		
		params.put("email", email);
		params.put("name", name);
		params.put("id", id);
		params.put("titleList", titleList);
		params.put("teacherList", teacherList);
		params.put("strdateList", strdateList);
		params.put("enddateList", enddateList);
		params.put("idxList", idxList);
		params.put("imgList", imgList);
		
		
		params1.put("titleList", hearttitleList);
		params1.put("teacherList", heartteacherList);
		params1.put("strdateList", heartstrdateList);
		params1.put("enddateList", heartenddateList);
		params1.put("idxList", heartidxList);
		params1.put("imgList", heartimgList);
		
		
		
		req.setAttribute("params", params);
		req.setAttribute("params1", params1);
		dao.close();
		req.getRequestDispatcher("/mypage/mypage.jsp").forward(req, resp);
	}
	
}
