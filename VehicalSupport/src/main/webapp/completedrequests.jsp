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
                        <li><a href="employee">Employees</a></li>
                        <li><a href="adminlogout">Logout</a></li>
                        
                    </ul>        
                </div>
            </div>
        </div>
    </header>
    
    
    <section class="title">
        <div class="container">
            <div class="row-fluid">
                <div class="span6">
                    <h3 >Welcome ${adminname} </h3>
                </div>                
            </div>
        </div>
    </section>
 
 		<%
 		model obj = new model();
 		obj.adminreuquestcompleted();
 		session.setAttribute("completedobj", obj.admincompletedreqobj);
 		%>
 
 		<h1 style="text-align: center;">Completed Requests</h1>
 		<c:forEach items="${completedobj}" var="req">
 		<div class="admin-requests">
 		<label> <strong>Request ID:</strong> ${req.reqid} </label>
 		<label> <strong>Customer Name:</strong> ${req.custname} </label>
 		<label> <strong>Customer Contactnumber:</strong> ${req.cusphone} </label>
 		<label> <strong>Employee ID:</strong> ${req.empid}</label>
 		<label> <strong>Employee Name:</strong>${req.empname}</label>
 		
 		<label> <strong>Assistance Type:</strong>${req.assisttype}</label>		
 		<label> <strong>Feedback:</strong>${req.feedback}</label>
 		<label> <strong>Amount Paid:</strong>${req.amtpaid}</label>
 		
 	
 		</div>
 		</c:forEach>
	
	
</body>

</html>