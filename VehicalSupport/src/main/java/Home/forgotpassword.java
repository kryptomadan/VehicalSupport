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


@WebServlet("/forgotpassword")
public class forgotpassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		String email = req.getParameter("email");
		PrintWriter out = res.getWriter();
		HttpSession ses = req.getSession();
		model obj = new model();
		
		try {
			if(obj.checkemailforotp(email))
			{
				ses.setAttribute("otp", obj.onetimepassword);
				ses.setAttribute("otpcusid", obj.otpid);
				res.sendRedirect("setforgotpassword.jsp");
				
			}else 
			{
					out.println("<script type=\"text/javascript\">");
			      out.println("alert('Your are Email is not registered Kindly check properly');");
			      out.println("location='forgotpassword.jsp';");
			      out.println("</script>");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	}

}
