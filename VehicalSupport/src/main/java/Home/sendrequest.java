package Home;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.model;


@WebServlet("/sendrequest")
public class sendrequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		model obj = new model();
		HttpSession ses = req.getSession();
		String cusid = ses.getAttribute("idactive").toString();
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String location = req.getParameter("location");
		String service = req.getParameter("service");
		int rqid = (int)(Math.random()*(4000-1500+1)+1500);
		String requestid = String.valueOf(rqid); 
		try {
			obj.addrequest("REQ"+requestid,cusid,name, email, phone, service, location);
			ses.setAttribute("activereqid", obj.activereqid);
			res.sendRedirect("userrequest.jsp");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

}
