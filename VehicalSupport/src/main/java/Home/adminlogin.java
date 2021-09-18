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


@WebServlet("/adminlogin")
public class adminlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		model obj = new model();
		HttpSession ses = req.getSession();
		PrintWriter out = res.getWriter();
		String usrname = req.getParameter("usrname");
		String pass = req.getParameter("pass");
		
		try {
			if(obj.adminlogin(usrname, pass))
			{
				obj.requestobj();
				ses.setAttribute("adminname", obj.adminname);
				ses.setAttribute("adminid", obj.adminid);
				ses.setAttribute("reqobj", obj.reqobj);
				res.sendRedirect("admin.jsp");
			}
			else {
				out.println("<script type=\"text/javascript\">");
			    out.println("alert('Invalid Credentials');");
			    out.println("location='adminlogin.jsp';");
			    out.println("</script>");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
