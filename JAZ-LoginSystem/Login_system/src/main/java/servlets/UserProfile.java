package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/userprofile")
public class UserProfile extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		String printResponse = "";
		HttpSession session = request.getSession(true);
		Object name = session.getAttribute("user");
		Object level = session.getAttribute("level");
		printResponse = createHtmlResponseString(name, level, printResponse);
		response.setContentType("text/html");
		response.getWriter().print(printResponse);
	}

	private String createPremiumAccessButton(Object level, String printResponse) {
		if (level.toString().equals(UserLevel.PREMIUM.toString()) || level.toString().equals(UserLevel.ADMIN.toString())) {
			printResponse += "<input type=\"submit\" name=\"premium\" value=\"Premium Site\" formaction=\"Premium.jsp\" />";
		}
		return printResponse;
	}

	private String createManagerAccessButton(Object level, String printResponse) {
		if (level.toString().equals(UserLevel.ADMIN.toString())) {
			printResponse += "<input type=\"submit\" name=\"manager\" value=\"Account Manager\" formaction=\"Manager.jsp\" />";
		}
		return printResponse;
	}

	private String createTitleHtmlCode(String printResponse) {
		printResponse += "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"><title>User Profile</title></head><body>";
		return printResponse;
	}

	private String createLogOutButton(String printResponse) {
		printResponse += "<form method=\"Post\"><input type=\"submit\" name=\"logout\" value=\"Log Out\" formaction=\"logout\" />";
		return printResponse;
	}

	private String createBasicInfoHtmlCode(Object name, Object level, String printResponse) {
		printResponse += "Username: " + name.toString() + "<br>Account level: " + level.toString();
		return printResponse;
	}

	private String createHtmlCodeClosure(String printResponse) {
		printResponse += "</form></body></html>";
		return printResponse;
	}

	private String createHtmlResponseString(Object name, Object level, String printResponse) {
		printResponse = createTitleHtmlCode(printResponse);
		printResponse = createBasicInfoHtmlCode(name, level, printResponse);
		printResponse = createLogOutButton(printResponse);
		printResponse = createPremiumAccessButton(level, printResponse);
		printResponse = createManagerAccessButton(level, printResponse);
		printResponse = createHtmlCodeClosure(printResponse);
		return printResponse;
	}
}
