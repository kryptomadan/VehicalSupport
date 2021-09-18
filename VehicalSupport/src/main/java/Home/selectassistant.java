package Home;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/selectassistant")
public class selectassistant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		String reqid = req.getParameter("reqid");
		String assitype= req.getParameter("assitype");
		HttpSession ses = req.getSession();
		ses.setAttribute("assitype", assitype);
		ses.setAttribute("reqid", reqid);
		
		res.sendRedirect("selectassistant.jsp");
		
		
		
		
		//String empid = req.getParameter("empid");
		//String empname = req.getParameter("empname");
		//HttpSession ses = req.getSession();
		//ses.setAttribute("selectedassistantid", empid);
		//ses.setAttribute("selectedassistantname", empname);
		//res.sendRedirect("selectassistant.jsp");
	}

}
