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

@WebServlet("/admin")
public class admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		
		model obj = new model();
		HttpSession ses = req.getSession();
		try {
			obj.requestobj();
			ses.setAttribute("reqobj", obj.reqobj);
			res.sendRedirect("admin.jsp");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	

}
