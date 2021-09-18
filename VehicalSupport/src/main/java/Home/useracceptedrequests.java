package Home;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/useracceptedrequests")
public class useracceptedrequests extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		HttpSession ses = req.getSession();
		String reqid=req.getParameter("reqid");
		
		ses.setAttribute("activereqid", reqid);
		res.sendRedirect("userrequest.jsp");
	}

}
