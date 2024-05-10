package mainController;

import action.LectureDetail;
import action.MainAction;
import action.cartAdd;
import action.cartDelete;
import action.heartAdd;
import action.heartDelete;
import action.idSearch;
import action.pwdSearch;
import action.teacherMypage;

public class MainActionFactory {

	private static MainActionFactory instance = new MainActionFactory();

	private MainActionFactory() {
		super();
	}

	public static MainActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		System.out.println("Action 입력받음");

		if (command.equals("main")) {
			action = new MainAction();
		} 
		else if (command.equals("lectureDetail")) {
			action = new LectureDetail();
		}
		else if (command.equals("cartAdd")) {
			action = new cartAdd();
		}
		else if (command.equals("heartAdd")) {
			action = new heartAdd();
		}
		else if (command.equals("cartDelete")) {
			action = new cartDelete();
		}
		else if (command.equals("heartDelete")) {
			action = new heartDelete();
		}
		else if (command.equals("idSearch")) {
			action = new idSearch();
		}
		else if (command.equals("pwdSearch")) {
			action = new pwdSearch();
		}
		else if (command.equals("teacherMypage")) {
			action = new teacherMypage();
		}
		System.out.println(action);
		return action;
	}
}
