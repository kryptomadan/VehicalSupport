<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="DAO.model" %>   
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="refresh" content="3">
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
    
    <% model obj = new model(); 
    String reqid = session.getAttribute("activereqid").toString();
    obj.searchassitantdetailsforuser(reqid);
    session.setAttribute("usrassitantobj", obj.userassistantobj);
    if(obj.checkuseracceptedrequest(reqid))
    {
    %>
    <c:forEach items="${usrassitantobj}" var="emp">
    <div class="userrequest-success">
    <h1>Your Request is Accepted </h1>
    <h2> ${emp.empname} is on his way to Assist you</h2>
    <h3>Your Assistant Details Are</h3>
    <label>  <strong>Assistant ID:</strong> ${emp.empid}</label>
    <label> <strong>Name:</strong> ${emp.empname}</label>
    <label> <strong> Phone Number:</strong>${emp.phone} </label>
    <label> <strong>Assistant Type:</strong> ${emp.service}</label>
   	<button id="servicedone">Done With Service</button>
    </div>
    </c:forEach>
    <div class="request-query" style="text-align: center;">
    <h3><mark> Please Pay The amount to the Assistant and make sure to update the same to us</mark></h3>
    <h3><mark>If you find the amount that your Assistant is asking is not reasonable you can contact us Anytime</mark></h3>
    <h3> <mark> 080-125467892</mark> </h3>
    </div>
    <% } if(obj.checkuserrequest(reqid)) {%>
    
    <div class="userrequest-pending"> 
    <h1> Your Request is yet to be Accepted </h1>
    <h2>Please wait!!</h2>
    </div>
    <% } %>
    
    <%  
    
    if(obj.checkusercompletedrequests(reqid))
    {
    %>
    <div class="thankyou" style="text-align: center; margin-top:50px;">
    <h1 >Thank You</h1>
    <h1>Your Assistance Request is Completed</h1>
    <h1>Please Visit Again</h1>
    </div>
    
    <% } %>
    
    
    
    
    <div class="done-with-service">
    	<div class="done-service-contents">
    	<form action="feedback" method="post">
    	<div id="subjectclose" class="close" > + </div>
    	<h1>Feed Back</h1> <br> <br>
    	<p> <label>Amount Paid (in rupees)</label> <input type="text" name="amtpaid"> </p>
    	<p><label>Regarding Service</label>    
    	<select name="feedback" style="width: 242px;">
  		<option value="Awesome(5 star)">Awesome (5 star)</option>
  		<option value="Nice(4 star)">Nice (4 star)</option>
  		<option value="Not bad (3 star)">Not bad (3 star)</option>
  		<option value="Bad (2 star)">Bad (2 star)</option>
  		<option value="VeryBad(1 star)">VeryBad (1 star)</option>
    	</select>
    	</p>
    	
    	<button type="submit" id="submit-feedback">Submit</button>
    	
    	</form>
    	</div>
    </div>
    
    
    <script type="text/javascript">
    document.getElementById('servicedone').addEventListener('click',function(){
	  	   document.querySelector('.done-with-service').style.display='flex';
	  	   window.stop();
	     }
	  	 );
	document.getElementById('subjectclose').addEventListener('click',function(){
	  	   document.querySelector('.done-with-service').style.display='none';
	     }
	  	 );
    </script>
</body>
</html>