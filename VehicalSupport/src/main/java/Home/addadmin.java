package Home;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.model;

@WebServlet("/addadmin")
public class addadmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		model obj = new model();
		String name = req.getParameter("name");
		String email  =req.getParameter("email");
		String usrname = req.getParameter("usrname");
		String pass = req.getParameter("pass");
		String phone = req.getParameter("phone");
		int admid = (int)(Math.random()*(4000-1500+1)+1500);
		String adminid = String.valueOf(admid); 
		
		try {
			obj.adminadd("AD"+adminid, name, email, phone, usrname, pass);
			res.sendRedirect("admin.jsp");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
