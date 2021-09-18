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
 		obj.checkaccepted();
 		session.setAttribute("acceptedreqobjs", obj.acceptedreqobj);
 		%>
 
 		<h1 style="text-align: center;">Accepted Requests</h1>
 		<c:forEach items="${acceptedreqobjs}" var="req">
 		<div class="admin-requests">
 		<label> <strong>Name:</strong> ${req.name} </label>
 		<label> <strong>Email:</strong> ${req.email}</label>
 		<label> <strong>Phone:</strong>${req.phone}</label>
 		
 		<label> <strong>Assistance Type:</strong>${req.service}</label>
 		<button> <a href="${req.location}" target="_blank" >View Location </a> </button>
 		<c:set value="${req.reqid}" scope="session" var="id"></c:set> 		
 		<input type="hidden" value="${req.service}" name="assitype">
 		<input type="hidden" value="${req.reqid}" name="reqid">		
 		<input type="hidden" value="${req.assiid}" name="assitantid">
 		<label> <strong>Assisted by:</strong>${req.assiname}</label>
 		
 	
 		</div>
 		</c:forEach>
	
	
</body>

</html>