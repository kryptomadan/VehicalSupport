<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html class="no-js"> 
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Online vehicle Assistance</title>
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-responsive.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/sl-slide.css">
    <script src="js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
    <link rel="shortcut icon" href="images/favicon.png">
</head>

<body>
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
	

    <section class="no-margin">
        <div id="map" style="height:10px;"></div>
    </section>

    <section id="tweets" class="container">
        <div class="row-fluid">
            <div class="span8"  style="position:absolute; left:800px; width:600px;">
                <h4>Registration Form</h4>
                <div class="status alert alert-success" style="display: none"></div>
                
                    <div class="row-fluid">
                        <div class="span5">
                        	<form action="addadmin"  method="post" >
                        	
                                                             
                           
                            <br>    
                            <label>Name</label>
                            <input type="text" class="input-block-level" required="required" placeholder="Your First Name"  name="name">
                            
                            <label>Email</label>
                            <input type="text" class="input-block-level" required="required" placeholder="Your Email"  name="email">
                            <label>User Name</label>
                            <input type="text" class="input-block-level" required="required" placeholder="Your User Name"  name="usrname">
                            <label>Password</label>
                            <input type="password" class="input-block-level" required="required" placeholder="Your Password"  name="pass"> 
                            <label>Telephone</label>
                            <input type="number" class="input-block-level" required="required" placeholder="Your Telephone" name="phone">
                            <input type="submit" class="btn btn-primary btn-large pull-left" value="Add Admin">
                             </form>
                        </div>
                        
                    </div>
                    
               
            </div>
            
        </div>
    </section>

  

    <script src="js/vendor/jquery-1.9.1.min.js"></script>
    <!--<script src="js/vendor/bootstrap.min.js"></script>-->
    <script src="js/main.js"></script>
    <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
    <script>
    
    </script>

</body>
</html>