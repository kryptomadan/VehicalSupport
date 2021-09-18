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

@WebServlet("/selectedassistant")
public class selectedassistant extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		HttpSession ses =req.getSession();
		model obj = new model();
		String empid = req.getParameter("empid");
		String empname = req.getParameter("empname");
		String reqid = ses.getAttribute("reqid").toString();
		
		try {
			obj.setassistedtrue(reqid,empid,empname);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		ses.setAttribute(reqid+"selectedassistantid", empid);
		ses.setAttribute(reqid+"selectedassistantname", empname);
		
		res.sendRedirect("admin"); 
		
	}

}
