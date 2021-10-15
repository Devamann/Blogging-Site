package Blogging_site;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Add_blog")
public class Add_blog extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sess=request.getSession(false);
		String isvalid=(String) sess.getAttribute("Valid");
		if(isvalid==null) {
			response.sendRedirect("login.jsp");
			return;
		}
		String head, body;
		head = request.getParameter("Heading");
		body = request.getParameter("Body");
		Database db = new Database();
		db.add_blog(head, body);
		response.setContentType("text/html");
		response.getWriter().println("Blog Added <a href=\"add_blog.jsp\">Continue</a>");
	}

}
