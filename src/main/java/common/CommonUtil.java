package common;

import jakarta.servlet.http.HttpSession;

public class CommonUtil {
	public static boolean isNumeric(String str) {
		return str!=null && !str.isEmpty() && !str.isBlank() && str.matches("[0-9]+");
	}
	public static boolean loginCheck(HttpSession session) {
		return session.getAttribute("userId") != null;
	}
	
	public static boolean isValue(String str) {
		return str!=null && !str.isEmpty() && !str.isBlank() ;
	}
}
