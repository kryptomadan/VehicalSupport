package Home;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.model;


@WebServlet("/adminsetpassword")
public class adminsetpassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String pass = req.getParameter("pass");
		String pass2 = req.getParameter("pass2");
		HttpSession ses = req.getSession();
		PrintWriter out = res.getWriter();
		String adminotpid = ses.getAttribute("adminotpid").toString();
		
		model obj = new model();
		if(pass.equals(pass2))
		{
			try {
				obj.adminchangepassword(adminotpid, pass2);
				out.println("<script type=\"text/javascript\">");
			      out.println("alert('password Changes Succesfully');");
			      out.println("location='adminlogin.html';");
			      out.println("</script>");
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}else {
			out.println("<script type=\"text/javascript\">");
		      out.println("alert('password does not match');");
		      out.println("location='setadminpassword.jsp';");
		      out.println("</script>");
		}
	}

}
