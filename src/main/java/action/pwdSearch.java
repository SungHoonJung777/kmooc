package action;

import java.io.IOException;

import dao.MemberSearchDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mainController.Action;

public class pwdSearch implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phone = request.getParameter("tel");
		String email = request.getParameter("email");
		String memberId = request.getParameter("id");

		MemberSearchDAO dao = new MemberSearchDAO();
		int sResult = dao.pwdSearch(phone, email, memberId);

		if (sResult == 1) {
			int pwdChange = dao.pwdRandomChange(phone, email, memberId);
			
			if(pwdChange == 1) {
				String pwdChangeValue = dao.pwdChangeValue(phone, email, memberId);
				request.setAttribute("pwdChange", pwdChangeValue);
			}
		} else {
			System.out.println("일치하는 회원정보 없음");
			request.setAttribute("pwdChange", "nullPwd");
		}

		String url = "/member/find.do?search=2";

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
