package Home;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.model;

@WebServlet("/acceptrequest")
public class acceptrequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		model obj = new model();
		String reqid = req.getParameter("reqid");
		String assiid = req.getParameter("assitantid");
		
		try {
			obj.acceptrequest(reqid);
			obj.setonduty(assiid);
			res.sendRedirect("admin");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
