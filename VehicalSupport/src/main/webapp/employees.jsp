<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="DAO.model" %> 
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online vehicle Assistance</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-responsive.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/sl-slide.css">
    <script src="js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
    <link rel="shortcut icon" href="images/favicon.png">
</head>
<body>
<%if(session.getAttribute("adminid") == null)
	{
	response.sendRedirect("adminlogin.jsp");
	}%>

<!--Header-->
    <header class="navbar navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container">
                <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </a>
                <a id="logo" class="pull-left" href="#"></a>
                <div class="nav-collapse collapse pull-right">
                    <ul class="nav">
                    	<li><a href="admin">Admin</a></li>
                    	<li><a href="addadmin.jsp">Add Admin</a></li>
                    	<li><a href="completedrequests.jsp">Completed Requests</a></li>
                    	<li><a href="acceptedrequests.jsp">Accepted Requests</a></li>
                        <li><a href="employees.jsp">Employees</a></li>
                        <li><a href="adminlogout">Logout</a></li>
                        
                    </ul>        
                </div>
            </div>
        </div>
    </header>
   
   
   <button class="add-employee" id="addemployee">Add Employee</button> 
   <button class="add-employee" id="removeemployee">Remove Employee</button> 
 	
 <!-- employee section -->  
<div class="employee-section">

 <div class="EMP-available">
  <div class="contents">
  	<h2>Available Employees</h2>
 	<table style="width: 100%;">
 		<tr>
 		<th>Employee ID</th>
 		<th>Employee Name</th>
 		<th>Phone Number</th>
 		<th>Assistance Type</th>
 		</tr>
 		<%
 		model obj = new model();
 		obj.empobj2();
 		session.setAttribute("empobj", obj.empobj);
 		%>
 		<c:forEach items="${empobj}" var="emp">
 		<tr>
 			<td>${emp.empid }</td>
 			<td>${emp.empname}</td>
 			<td>${emp.phone}</td>
 			<td>${emp.service}</td>			
 		</tr>
 		</c:forEach>
 	</table>
 </div>	
 </div>
 
 <div class="EMP-onduty" >
 <div class="contents">
 	<h2>Onduty Employees</h2>
 	<table  style="width: 100%;"> 	
 		
 		<tr>
 		<th>Employee ID</th>
 		<th>Employee Name</th>
 		<th>Phone Number</th>
 		<th>Assistance Type</th>
 		</tr>
 		<c:forEach items="${ondutyempobj}" var="emp">
 		<tr>
 			<td>${emp.empid }</td>
 			<td>${emp.empname}</td>
 			<td>${emp.phone}</td>
 			<td>${emp.service}</td>			
 		</tr>
 		</c:forEach>
 	</table>
 	
</div>
 </div>
</div>
  
<!-- end of employee section -->	


<!-- add employee container -->
<div class="addemployee-bg">
	<div class="addemployee-contents">
		<div class="addemployee-main">
		
			<div id="subjectclose" class="close" > + </div>
			<h1>Add Employee</h1>
			<br> <br> <br>
			<form action="addemployee" method="post">
				<label style="display: inline-block;font-weight: bold;font-size: 20px;color:black;">Employee Name</label> <input type="text" name="empname">
				<label style="display: inline-block;font-weight: bold;font-size: 20px;color:black;">Contact Number</label> <input type="text" name="phone">
				<label style="display: inline-block;font-weight: bold;font-size: 20px;color:black;">Assistance Type</label>
				<select name="service" style="width: 242px;">
	  			<option value="KEY LOST OR LOCKED">KEY LOST OR LOCKED</option>
	  			<option value="NEED ANY MECHANIC">NEED ANY MECHANIC</option>
	  			<option value="VEHICLE TOWING">VEHICLE TOWING</option>
	  			<option value="FUELING">FUELING</option>
	  			<option value="flat-tyre">FLAT TYRE</option>
	  			</select>
	  			<button type="submit" >Add</button>
			</form>
		</div>	
	</div>
</div>

<!-- remove employee container -->
<div class="removeemployee-bg">
<div class="removeemployee-contents">
<div id="removesubjectclose" class="close" > + </div>
<br>
		<h1>Available Assistants</h1>
		<%
		model obj2 = new model();
		obj2.empobjsall();
		session.setAttribute("removeemployeeobjs", obj2.empobj);
		
		%>
		<c:forEach items="${removeemployeeobjs}" var="emp">
		<div class="assistant">
		<form action="removeemployee" id="remove${emp.empid}" >
		<input type="hidden" value="${emp.empid}" name="empid">
		<input type="hidden" value="${emp.empname}" name="empname">
		<a href="javascript:{}" onclick="document.getElementById('remove${emp.empid}').submit();"><label> <strong>Name:</strong>${emp.empname} <span style="display: inline-block; width: 10px;"></span> <strong>phone:</strong>${emp.phone} <span style="display: inline-block; width: 10px;"></span> <strong>Assistance Type:</strong>${emp.service} </label></a>
		</form>
		</div>
		</c:forEach>
</div>
</div>

<script type="text/javascript">
document.getElementById('addemployee').addEventListener('click',function(){
	   document.querySelector('.addemployee-bg').style.display='flex';
  }
	 );

document.getElementById('removeemployee').addEventListener('click',function(){
	   document.querySelector('.removeemployee-bg').style.display='flex';
}
	 );
	 
document.getElementById('removesubjectclose').addEventListener('click',function(){
	   document.querySelector('.removeemployee-bg').style.display='none';
}
	 );		 
document.getElementById('subjectclose').addEventListener('click',function(){
	   document.querySelector('.addemployee-bg').style.display='none';
}
	 );	 
</script>
</body>
</html>