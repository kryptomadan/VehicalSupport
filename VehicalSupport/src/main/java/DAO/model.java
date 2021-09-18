package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import classes.completedrequests;
import classes.employee;
import classes.requests;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class model 
{
database obj = new database();
public String username;
public String email;
public String phone;
public String adminname;
public String adminid;
public String activereqid;
public int onetimepassword;
public String otpid;
public int adminonetimepassword;
public String adminotpid;
public ArrayList<employee> empobj = new ArrayList<employee>();
public ArrayList<employee> ondutyempobj = new ArrayList<employee>();
public ArrayList<completedrequests> admincompletedreqobj = new ArrayList<completedrequests>();

public ArrayList<employee> userassistantobj = new ArrayList<employee>();
public ArrayList<requests> reqobj = new ArrayList<requests>();
public ArrayList<requests> acceptedreqobj = new ArrayList<requests>();
public ArrayList<requests> useracceptedreqobj = new ArrayList<requests>();

	public void userregister(String CustomerId,String vehical,String Fname,String Lname,String email,String usrname,String pass,String phone) throws SQLException
	{
		obj.connect();	
		if( checkid(CustomerId)) 
		{
			int csid = (int)(Math.random()*(4000-1500+1)+1500);
			String checkedCustomerid = String.valueOf(csid);
			userregister("CUS"+checkedCustomerid, vehical, Fname, Lname, email, usrname, pass, phone);
		}
		else {
		String query2 = "insert into users values(?,?,?,?,?,?,?,?)";
		PreparedStatement stm2 = obj.con.prepareStatement(query2);
		stm2.setString(1, CustomerId);
		stm2.setString(2, vehical);
		stm2.setString(3, Fname);
		stm2.setString(4, Lname);
		stm2.setString(5, email);
		stm2.setString(6, phone);
		stm2.setString(7, usrname);
		stm2.setString(8, pass);
		stm2.executeUpdate();	
		}
	}

	public boolean checkid(String csid) throws SQLException
	{
		obj.connect();
		String query = "select * from users where CustomerId=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, csid);
		ResultSet rs = stm.executeQuery();
		if(rs.next())
		{
			return true;			
		}
		return false;
		
	}
	
	public String getcusid(String usrname) throws SQLException
	{
		obj.connect();
		String query="select * from users where usrname=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, usrname);
		ResultSet rs = stm.executeQuery();
		if(rs.next())
		{
			return rs.getString(1);
		}
		return null;
	}
	public boolean userlogin(String usrname,String pass) throws SQLException
	{
		obj.connect();
		String query ="select * from users where usrname=? and password =?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, usrname);
		stm.setString(2, pass);
		ResultSet rs = stm.executeQuery();
		if(rs.next())
		{
			return true;
		}
		return false;
	}
	
	public boolean checkusername(String usrname) throws SQLException
	{
		obj.connect();
		String query = "select * from users where usrname=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, usrname);
		ResultSet rs= stm.executeQuery();
		if(rs.next())
		{
			return true;
		}
		return false;
				
	}
	
	public void getname(String cusid) throws SQLException
	{
		obj.connect();
		String query ="select * from users where CustomerId=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, cusid);
		ResultSet rs = stm.executeQuery();
		if(rs.next())
		{
			username = rs.getString(3)+" "+rs.getString(4);
			email = rs.getString(5);
			phone = rs.getString(6);
		}
	}
	
	
	public boolean adminlogin(String usrname,String pass) throws SQLException
	{
		obj.connect();
		getadminname(usrname, pass);
		String query = "select * from admin where username=? and password=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, usrname);
		stm.setString(2, pass);
		ResultSet rs = stm.executeQuery();
		if(rs.next())
		{
			return true;
		}
		return false;
	}
	
	public void getadminname(String usrname,String pass) throws SQLException
	{
		obj.connect();
		String query ="select * from admin where username =? and password =?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, usrname);
		stm.setString(2, pass);
		ResultSet rs = stm.executeQuery();
		
		if(rs.next())
		{
			adminname = rs.getString(2);
			adminid = rs.getString(1);
		}
	}
	
	public void addemployee(String empid,String empname,String empphone,String service) throws SQLException
	{
		obj.connect();
		
		if(checkempid(empid))
		{
			int emid = (int)(Math.random()*(4000-1500+1)+1500);
			String Employeeid = String.valueOf(emid); 
			addemployee("EMP"+Employeeid, empname, empphone,service);
		}
		else {
			String onduty="false";
			String query = "insert into employee values(?,?,?,?,?) ";
			PreparedStatement stm = obj.con.prepareStatement(query);
			stm.setString(1, empid);
			stm.setString(2, empname);
			stm.setString(3, empphone);
			stm.setString(4, service);
			stm.setString(5, onduty);
			stm.executeUpdate();
		}
		
	}
	
	public boolean checkempid(String empid) throws SQLException
	{
		obj.connect();
		String query = "select * from employee where EmployeeID =?";
		PreparedStatement stm  = obj.con.prepareStatement(query);
		stm.setString(1, empid);
		ResultSet rs = stm.executeQuery();
		if(rs.next())
		{
			return true;
		}
			return false;
		}
		
	
	public void empobjs(String assitype) throws SQLException
	{
		obj.connect();
		String query="select * from employee where AssistanceType=? and onduty=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, assitype);
		stm.setString(2, "false");
		ResultSet rs = stm.executeQuery();
		while(rs.next())
		{
			empobj.add(new employee(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
		}
		
		
	}
	
	public void empobjsall() throws SQLException
	{
		obj.connect();
		String query="select * from employee ";
		PreparedStatement stm = obj.con.prepareStatement(query);
		
		ResultSet rs = stm.executeQuery();
		while(rs.next())
		{
			empobj.add(new employee(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
		}
	}
	public void empobj2() throws SQLException
	{
		obj.connect();
		String onduty="false";
		String query="select * from employee where onduty=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, onduty);
		ResultSet rs = stm.executeQuery();
		while(rs.next())
		{
			empobj.add(new employee(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
		}
	}
	
	public void removeemployee(String empid) throws SQLException
	{
		obj.connect();
		String query ="delete from employee where EmployeeID=?";
		PreparedStatement stm  = obj.con.prepareStatement(query);
		stm.setString(1, empid);
		stm.executeUpdate();
	}
	
	public void ondutyemp() throws SQLException
	{
		obj.connect();
		String onduty="true";
		String query="select * from employee where onduty=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, onduty);
		ResultSet rs = stm.executeQuery();
		while(rs.next())
		{
			ondutyempobj.add(new employee(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
		}
	}
	
	public void addrequest(String reqid,String cusid,String name,String email,String phone,String service,String location) throws SQLException
	{
		obj.connect();
		if(checkreqid(reqid))
		{
			int rqid = (int)(Math.random()*(4000-1500+1)+1500);
			String requestid = String.valueOf(rqid); 
			addrequest("REQ"+requestid,cusid,name, email, phone,service,location);
		}
		else {
			String assisted="no";
			activereqid = reqid;
			String query="insert into requests values(?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stm = obj.con.prepareStatement(query);
			stm.setString(1, reqid);
			stm.setString(2, cusid);
			stm.setString(3, name);
			stm.setString(4, email);
			stm.setString(5, phone);
			stm.setString(6, service);
			stm.setString(7, location);
			stm.setString(8, assisted);
			stm.setString(9, assisted);
			stm.setString(10, assisted);
			stm.setString(11,assisted);
			stm.setString(12,assisted);
			stm.executeUpdate();
		}
	}
	public boolean checkreqid(String reqid) throws SQLException
	{
		obj.connect();
		String query ="select * from requests where RequestID=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, reqid);
		ResultSet rs = stm.executeQuery();
		if(rs.next())
		{
			return true;
		}
		return false;
	}
	
	public void requestobj() throws SQLException
	{
		obj.connect();
		String update="no";
		String query="select * from requests where Accepted=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, update);
		ResultSet rs = stm.executeQuery();
		while(rs.next())
		{
			reqobj.add(new requests(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12)));
		}
		
	}
	
	
	public void setassistedtrue(String reqid,String empid,String empname) throws SQLException
	{
		obj.connect();
		String update="yes";
		String query = " update requests set Assisted=? ,AssistantID=?,AssistantName=?  where RequestID=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, update);
		stm.setString(2, empid);
		stm.setString(3, empname);
		stm.setString(4, reqid);
		stm.executeUpdate();
	}
	
	public boolean search(String reqid) throws SQLException
	{
		obj.connect();
		
		String query ="select * from requests where RequestID=? and Assisted=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, reqid);
		stm.setString(2, "yes");
		ResultSet rs = stm.executeQuery();
		if(rs.next())
		{
			
			
				return true;
			
		}
		return false;
	}
	
	public void acceptrequest(String reqid) throws SQLException
	{
		obj.connect();
		String update="yes";
		String query = " update requests set Accepted=? where RequestID=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, update);	
		stm.setString(2, reqid);
		stm.executeUpdate();
	}
	
	public void checkaccepted() throws SQLException
	{
		obj.connect();
		String query = "select * from requests where Accepted=? and Completed=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, "yes");
		stm.setString(2, "no");
		ResultSet rs = stm.executeQuery();
		while(rs.next())
		{
			
						
				acceptedreqobj.add(new requests(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12)));		
			
		}
		
	}
	
	public void setonduty(String assid) throws SQLException
	{
		obj.connect();
		String query ="update employee set onduty=? where EmployeeID=?" ;
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, "true");
		stm.setString(2, assid);
		stm.executeUpdate();
	}
	
	public void useracceptedrequests(String cusid) throws SQLException
	{
		obj.connect();
		String query = "select * from requests where Cusid=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, cusid);
		ResultSet rs = stm.executeQuery();
		while(rs.next())
		{
			useracceptedreqobj.add(new requests(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12)));		
		}
		
	}
	
	public boolean checkuseracceptedrequest(String reqid) throws SQLException
	{
		obj.connect();
		
		String query ="select * from requests where RequestID=? and Accepted=? and Completed=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, reqid);
		stm.setString(2, "yes");
		stm.setString(3, "no");
		ResultSet rs = stm.executeQuery();
		
		if(rs.next())
		{
			return true;
		}		
		return false;
	}
	public boolean checkusercompletedrequests(String reqid) throws SQLException
	{
		obj.connect();
		String query ="select * from requests where RequestID=? and Accepted=? and Completed=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, reqid);
		stm.setString(2, "yes");
		stm.setString(3, "yes");
		ResultSet rs = stm.executeQuery();
		
		if(rs.next())
		{
			return true;
		}		
		return false;
	}
	
	public boolean checkuserrequest(String reqid) throws SQLException
	{
		obj.connect();
		String query ="select * from requests where RequestID=? and Accepted=? and Completed=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, reqid);
		stm.setString(2, "no");
		stm.setString(3, "no");
		ResultSet rs = stm.executeQuery();
		
		if(rs.next())
		{
			return true;
		}		
		return false;
	}
	public void searchassitantdetailsforuser(String reqid) throws SQLException
	{
		obj.connect();
		String empid ;
		String query = "select * from requests where RequestID=?";
		PreparedStatement stm= obj.con.prepareStatement(query);
		stm.setString(1, reqid);
		ResultSet rs = stm.executeQuery();
		if(rs.next())
		{
			empid = rs.getString(9);
			assitantdetails(empid);
		}
		
	}
	
	public void assitantdetails(String empid) throws SQLException
	{
		obj.connect();
		String query = "select * from employee where EmployeeID=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, empid);
		ResultSet rs = stm.executeQuery();
		while(rs.next())
		{
			userassistantobj.add(new employee(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
		}
	}
	public void requestcompleted(String amtpaid,String reqid,String feedback) throws SQLException
	{
	obj.connect();
	String empname;
	String empid;
	String query="update requests set Completed=? where RequestID=?";
	PreparedStatement stm = obj.con.prepareStatement(query);
	stm.setString(1, "yes");
	stm.setString(2, reqid);
	stm.executeUpdate();
	
	String query2="select * from requests where RequestID=?";
	PreparedStatement stm2 = obj.con.prepareStatement(query2);
	stm2.setString(1, reqid);
	ResultSet rs = stm2.executeQuery();
	if(rs.next())
	{
		empid = rs.getString(9);
		empname = rs.getString(10);
		setondutyfalse(empid);
		addfeedbackandamtpaid(amtpaid, empid, reqid, empname, feedback);
	}
	
		
	}
	
	public void setondutyfalse(String empid) throws SQLException
	{
		obj.connect();
		String query="update employee set onduty=? where EmployeeID=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, "false");
		stm.setString(2, empid);
		stm.executeUpdate();
	}
	
	public void addfeedbackandamtpaid(String amtpaid,String empid,String reqid, String empname,String feedback) throws SQLException
	{
		obj.connect();
		String query="insert into feedback values(?,?,?,?,?)";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, reqid);
		stm.setString(2, empid);
		stm.setString(3, empname);
		stm.setString(4, feedback);
		stm.setString(5, amtpaid);
		stm.executeUpdate();
	}
	
	
	public void adminreuquestcompleted() throws SQLException
	{
		obj.connect();
		String reqid;
		String empid;
		String empname;
		String feedback;
		String amtpaid;
		String query ="select * from feedback";
		PreparedStatement stm = obj.con.prepareStatement(query);
		ResultSet rs = stm.executeQuery();
		while(rs.next())
		{
			reqid=rs.getString(1);
			empid = rs.getString(2);
			empname = rs.getString(3);
			feedback = rs.getString(4);
			amtpaid = rs.getString(5);
						
			setcompletedcompletedreqobj(reqid, empid, empname, feedback, amtpaid);
		}
	}
	
	public void setcompletedcompletedreqobj(String reqid,String empid,String empname,String feedback,String amtpaid) throws SQLException
	{
		obj.connect();
		String query ="select * from requests where RequestID=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, reqid);
		ResultSet rs = stm.executeQuery();
		if(rs.next())
		{
			String cusname = rs.getString(3);
			String assistype = rs.getString(6);
			String cusphone = rs.getString(5);
			admincompletedreqobj.add(new completedrequests(reqid,cusname,assistype,cusphone,amtpaid,empname,empid,feedback) );
		}
		
	}
	
	public void adminadd(String admid,String name,String email,String phone,String usrname,String pass) throws SQLException
	{
		obj.connect();
		String query="insert into admin values(?,?,?,?,?,?)";
		
		
		if(checkadminid(admid))
		{
			int admnid = (int)(Math.random()*(4000-1500+1)+1500);
			String adminid = String.valueOf(admnid); 
			adminadd("AD"+adminid, name, email, phone, usrname, pass);
		}
		
		else {
			PreparedStatement stm = obj.con.prepareStatement(query);
			stm.setString(1, admid);
			stm.setString(2, name);
			stm.setString(3, email);
			stm.setString(4, phone);
			stm.setString(5, usrname);
			stm.setString(6, pass);
			stm.executeUpdate();
		}
		
		
	}
	public boolean checkadminid(String adminid) throws SQLException
	{
		obj.connect();
		String query ="select * from admin where AdminID=?";
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, adminid);
		ResultSet rs = stm.executeQuery();
		if(rs.next())
		{
			return true;
		}
		return false;
		
		
	}
	
	
	public boolean checkemailforotp(String email) throws SQLException
	{
		obj.connect();
		String query = "select * from users where Email=?";
		
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, email);
		
		ResultSet rs = stm.executeQuery();
		if(rs.next())
		{
			
			System.out.print("found");
			otpid=rs.getString(1);
			sendotp(email);
			return true;
			
		}
		
		return false;
	}
	
	public void sendotp(String email)
	{
		onetimepassword = (int)(Math.random()*(2000-1500+1)+1500);
		
		
		
		
		String subject = "Forgot Password";
		String msg = "your otp to change your password is:"+" "+onetimepassword;
		
		final String user = "smartclassklebca@gmail.com";
				
		final String password = "smartclass123";
		String host = "smtp.gmail.com";
		
		Properties props = new Properties();  
		props.put("mail.smtp.starttls.enable", "true"); 
		props.put("mail.smtp.auth", "true"); 
		props.setProperty("mail.smtp.host", host); 
		props.put("mail.smtp.ssl.enable","true");
		props.put("mail.debug", "true"); 
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory"); 
		props.put("mail.smtp.socketFactory.port", "465"); 
		props.put("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.transport.protocol", "smtp");  
		
		Session session = Session.getDefaultInstance(props,  
				 new javax.mail.Authenticator() {  
				  protected PasswordAuthentication getPasswordAuthentication() 
				  {  
				   return new PasswordAuthentication(user,password);  
				   }  
				}); 
		
		try {  
			
			 MimeMessage message = new MimeMessage(session);  
			 message.setFrom(new InternetAddress(user));  
			 message.addRecipient(Message.RecipientType.TO,new InternetAddress(email));  
			 message.setSubject(subject);  
			 message.setText(msg);  
			   
			 
			 Transport.send(message);  
			  
			 System.out.println("Done");  
			  
			 } catch (MessagingException e) {  
			    throw new RuntimeException(e);  
			 }  
		
		
	}
	
	public void changepassword(String cusid,String pass) throws SQLException
	{
		obj.connect();
		String query="update users set password=? where CustomerId=?";
		PreparedStatement stm =obj.con.prepareStatement(query);
		stm.setString(1, pass);
		stm.setString(2, cusid);
		stm.executeUpdate();
	}
	
	public boolean admincheckemailforotp(String email) throws SQLException
	{
		obj.connect();
		String query = "select * from admin where email=?";
		
		PreparedStatement stm = obj.con.prepareStatement(query);
		stm.setString(1, email);
		
		ResultSet rs = stm.executeQuery();
		if(rs.next())
		{
			
			System.out.print("found");
			adminotpid=rs.getString(1);
			adminsendotp(email);
			return true;
			
		}
		
		return false;
	}
	
	public void adminsendotp(String email)
	{
		adminonetimepassword = (int)(Math.random()*(2000-1500+1)+1500);
		
		
		
		
		String subject = "Forgot Password";
		String msg = "your otp to change your password is:"+" "+adminonetimepassword;
		
		final String user = "smartclassklebca@gmail.com";
				
		final String password = "smartclass123";
		String host = "smtp.gmail.com";
		
		Properties props = new Properties();  
		props.put("mail.smtp.starttls.enable", "true"); 
		props.put("mail.smtp.auth", "true"); 
		props.setProperty("mail.smtp.host", host); 
		props.put("mail.smtp.ssl.enable","true");
		props.put("mail.debug", "true"); 
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory"); 
		props.put("mail.smtp.socketFactory.port", "465"); 
		props.put("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.transport.protocol", "smtp");  
		
		Session session = Session.getDefaultInstance(props,  
				 new javax.mail.Authenticator() {  
				  protected PasswordAuthentication getPasswordAuthentication() 
				  {  
				   return new PasswordAuthentication(user,password);  
				   }  
				}); 
		
		try {  
			
			 MimeMessage message = new MimeMessage(session);  
			 message.setFrom(new InternetAddress(user));  
			 message.addRecipient(Message.RecipientType.TO,new InternetAddress(email));  
			 message.setSubject(subject);  
			 message.setText(msg);  
			   
			 
			 Transport.send(message);  
			  
			 System.out.println("Done");  
			  
			 } catch (MessagingException e) {  
			    throw new RuntimeException(e);  
			 }  
				
	}
	
	public void adminchangepassword(String adminid,String pass) throws SQLException
	{
		obj.connect();
		String query="update admin set password=? where AdminID=?";
		PreparedStatement stm =obj.con.prepareStatement(query);
		stm.setString(1, pass);
		stm.setString(2, adminid);
		stm.executeUpdate();
	}
}//end of class
