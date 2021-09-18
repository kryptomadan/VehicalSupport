package Home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.model;


@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		model obj = new model();
		PrintWriter out = res.getWriter();
		String vehical = req.getParameter("vehical");
		String firstname = req.getParameter("name");
		String lastname = req.getParameter("name2");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String usrname = req.getParameter("usrname");
		String pass = req.getParameter("pass");
		int csid = (int)(Math.random()*(4000-1500+1)+1500);
		String Customerid = String.valueOf(csid);
		
		try {
			if(obj.checkusername(usrname))
			{
				out.println("<script type=\"text/javascript\">");
			    out.println("alert('username is already taken');");
			    out.println("location='register.html';");
			    out.println("</script>");
			}
			else {
			obj.userregister("CUS"+Customerid,vehical, firstname, lastname, email, usrname, pass, phone);
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Your are Successfully registered');");
		    out.println("location='register.html';");
		    out.println("</script>");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}

}
