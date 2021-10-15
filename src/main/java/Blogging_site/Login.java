package Blogging_site;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email, pass;
		email = request.getParameter("email");
		pass = request.getParameter("password");
		Database db = new Database();
		if (db.login_user(email, pass)) {
			HttpSession sess = request.getSession();
			sess.setAttribute("Valid", "true");
			response.sendRedirect("add_blog.jsp");
		} else {
			response.sendRedirect("login.jsp");
		}

	}

}
