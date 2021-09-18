package Home;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.model;


@WebServlet("/removeemployee")
public class removeemployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String empid = req.getParameter("empid");
		model obj = new model();
		
		try {
			obj.removeemployee(empid);
			res.sendRedirect("employees.jsp");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
