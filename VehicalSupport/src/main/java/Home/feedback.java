package Home;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.model;


@WebServlet("/feedback")
public class feedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		HttpSession ses = req.getSession();
		model obj = new model();
		String reqid= ses.getAttribute("activereqid").toString();
		String feedback = req.getParameter("feedback");
		String amtpaid = req.getParameter("amtpaid");
		try {
			obj.requestcompleted(amtpaid, reqid, feedback);
			res.sendRedirect("userrequest.jsp");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
	}

}
