package Home;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.model;


@WebServlet("/addemployee")
public class addemployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		model obj = new model();
		int emid = (int)(Math.random()*(4000-1500+1)+1500);
		String Employeeid = String.valueOf(emid); 
		String empname = req.getParameter("empname");
		String empphone = req.getParameter("phone");
		String empassi = req.getParameter("service");
		
		try {
			obj.addemployee("EMP"+Employeeid, empname, empphone, empassi);
			res.sendRedirect("employee");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
