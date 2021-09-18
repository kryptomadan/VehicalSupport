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
                    	<li><a href="admin.jsp">Admin</a></li>
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
 
 		
	
	<div class="assistant-list-bg">
	<div class="assistants-list">
		<% model obj = new model();
			String assitype= session.getAttribute("assitype").toString();
			obj.empobjs(assitype);
			session.setAttribute("empobj", obj.empobj);
		%>
		<div id="subjectclose" class="close" ><a href="admin"> +</a> </div>
		<h1>Available Assistants</h1>
		
		<c:forEach items="${empobj}" var="emp">
		<div class="assistant">
		<form action="selectedassistant" id="selectassistant${emp.empid}" >
		<input type="hidden" value="${emp.empid}" name="empid">
		<input type="hidden" value="${emp.empname}" name="empname">
		<a href="javascript:{}" onclick="document.getElementById('selectassistant${emp.empid}').submit();"><label> <strong>Name:</strong>${emp.empname} <span style="display: inline-block; width: 10px;"></span> <strong>phone:</strong>${emp.phone} <span style="display: inline-block; width: 10px;"></span> <strong>Assistance Type:</strong>${emp.service} </label></a>
		</form>
		</div>
		</c:forEach>
	</div>
    </div>
    
   
   
</body>

</html>