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

@WebServlet("/userlogin")
public class userlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
	PrintWriter out = res.getWriter();
	model obj = new model();
	HttpSession ses = req.getSession();
	String usrname = req.getParameter("usrname");
	String pass = req.getParameter("pass");
	String cusid;
	try {
		if(obj.userlogin(usrname, pass))
		{
			cusid = obj.getcusid(usrname);
			ses.setAttribute("idactive", cusid);
			obj.getname(cusid);
			ses.setAttribute("name", obj.username);
			ses.setAttribute("phone", obj.phone);
			ses.setAttribute("email", obj.email);
			res.sendRedirect("user.jsp");
			
			
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('check your Credentials');");
		    out.println("location='login.html';");
		    out.println("</script>");
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
		
	}

}
