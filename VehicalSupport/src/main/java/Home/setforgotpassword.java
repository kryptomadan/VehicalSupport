package Home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




@WebServlet("/setforgotpassword")
public class setforgotpassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		int otp =  Integer.parseInt(req.getParameter("otp")) ;
		HttpSession ses = req.getSession();
		
		int otpsession = Integer.parseInt(ses.getAttribute("otp").toString());
		
		PrintWriter out = res.getWriter();
		
		if(otp == otpsession)
		{
			res.sendRedirect("setpassword.jsp");
		}
		else {
			
			 out.println("<script type=\"text/javascript\">");
		      out.println("alert('Incorrect OTP check properly');");
		      out.println("location='setforgotpassword.jsp';");
		      out.println("</script>");
		}
	}

}
