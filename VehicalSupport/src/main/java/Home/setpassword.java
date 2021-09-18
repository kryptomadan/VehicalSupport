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

@WebServlet("/setpassword")
public class setpassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		String pass = req.getParameter("pass");
		String pass2 = req.getParameter("pass2");
		HttpSession ses = req.getSession();
		PrintWriter out = res.getWriter();
		String otpcusid = ses.getAttribute("otpcusid").toString();
		
		model obj = new model();
		
		if(pass.equals(pass2))
		{
			try {
				obj.changepassword(otpcusid, pass2);
				out.println("<script type=\"text/javascript\">");
			      out.println("alert('password Changes Succesfully');");
			      out.println("location='login.html';");
			      out.println("</script>");
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}else {
			out.println("<script type=\"text/javascript\">");
		      out.println("alert('password does not match');");
		      out.println("location='setpassword.jsp';");
		      out.println("</script>");
		}
	}

}
