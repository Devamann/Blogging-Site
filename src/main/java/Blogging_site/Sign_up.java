package Blogging_site;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Sign_up
 */
@WebServlet("/Sign_up")
public class Sign_up extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		String nam,email,pas,pas1;
   		nam=request.getParameter("User_name");
   		email=request.getParameter("Uemail");
   		pas=request.getParameter("Password");
   		pas1=request.getParameter("Password1");
   		Database db=new Database();
   		db.add_user(nam,email,pas);
   		
	}

}
