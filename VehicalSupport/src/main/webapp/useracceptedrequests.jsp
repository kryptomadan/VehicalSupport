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
<%if(session.getAttribute("idactive") == null)
	{
	response.sendRedirect("login.html");
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
                    	<li><a href="user.jsp">User</a></li>
                    	<li><a href="useracceptedrequests.jsp">Sent Requests</a></li>
                        <li><a href="userservices.jsp">Services</a></li>
                        <li><a href="userlogout">Logout</a></li>
                        
                    </ul>        
                </div>
            </div>
        </div>
    </header>
    <!-- /header -->
    
    <section class="title">
        <div class="container">
            <div class="row-fluid">
                <div class="span6">
                    <h3 >Welcome ${name} </h3>
                </div>
                
            </div>
        </div>
    </section>
    
   
    <h1 style="text-align: center;">Sent Requests</h1>
 		
 		<%
 		model obj =new model();
 		String cusid = session.getAttribute("idactive").toString();
 		obj.useracceptedrequests(cusid);
 		session.setAttribute("usracceptedreqobj", obj.useracceptedreqobj);
 		%>
 	<div class="contents-useraccepted">
 		<c:forEach items="${usracceptedreqobj}" var="req">		
 		<div class="user-requests">
 		<form action="useracceptedrequests" method="post" id="accepted${req.reqid}">
 		<input type="hidden" value="${req.reqid}" name="reqid">
 		</form>
 		<a href="javascript:{}" onclick="document.getElementById('accepted${req.reqid}').submit();">
 		<label> <strong>Name:</strong> ${req.name} </label>
 		<label> <strong>Email:</strong> ${req.email}</label>
 			
 		<label> <strong>Assistance Type:</strong>${req.service}</label> 						
 			 		
 		<label> <strong>Assisted by:</strong>${req.assiname}</label>
 		<label> <strong>Accepted:</strong>${req.accepted}</label>
 		</a>	
 		</div></c:forEach>
 	</div>	
</body>
</html>