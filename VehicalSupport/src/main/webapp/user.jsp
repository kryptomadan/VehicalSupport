<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    
    <div class="request-body">
    <div class="request-form">
    <h1 style="color:blue;">Request Assistance</h1>
    <br>
   <form action="sendrequest" method="post">
    <p > <label style="display: inline-block;font-weight: bold;font-size: 20px;color:black;">Name:</label> <span style="display: inline-block; width: 135px"></span> <input type="text" value="${name}"  name="name"> </p>
    <p > <label style="display: inline-block;font-weight: bold;font-size: 20px;color:black;">Email:</label> <span style="display: inline-block; width: 135px"></span> <input type="text" value="${email}" name="email"> </p>
    <p > <label style="display: inline-block;font-weight: bold;font-size: 20px;color:black;">Contact Number:</label> <span style="display: inline-block; width: 35px"></span> <input type="text" value="${phone}"  name="phone"> </p>
    <p > <label style="display: inline-block;font-weight: bold;font-size: 20px;color:black;">Assistance Location:</label>  <input type="text" name="location" placeholder="Paste Location url"> </p>
  	<p> 
  		<label style="display: inline-block;font-weight: bold;font-size: 20px;color:black;">Assistance Type:</label><span style="display: inline-block; width: 35px"></span>
  		<select name="service" style="width: 242px;">
  		<option value="KEY LOST OR LOCKED">KEY LOST OR LOCKED</option>
  		<option value="NEED ANY MECHANIC">NEED ANY MECHANIC</option>
  		<option value="VEHICLE TOWING">VEHICLE TOWING</option>
  		<option value="FUELING">FUELING</option>
  		<option value="flat-tyre">FLAT TYRE</option>
  	</select> </p>
  	<div class="map-buttons">
  	<button id="add-location" type="button">How to add location?</button> <br>
    <button id="map" type="button" > <a href="https://maps.google.com/" target="_blank">Open Google maps</a></button>
    </div> <br>
    <button type="submit" id="sendrequest">Send Request</button>
    </form>
    </div>
    </div>  
   

<!-- how to add location window -->
	<div class="addlocation-bg">
	<div class="addlocation-content">	
	<div class="contents-location">
	<div id="subjectclose" class="close" > + </div>
	<h1>How to add location</h1>
	<p>1.On your Android phone or tablet, open the Google Maps app Maps and sign in. Learn how to sign in.</p>
	<p>2.Tap your profile picture or initial Account Circle and then Location sharing and then New share Add people.</p>
	<p>3.To copy your Location sharing link, tap Copy to clipboard.</p>
	<p>4.Paste the copied url in the assistance location tab</p>
	<p>5.After request we process your request and validate your location and provide you with the service</p>
	<p><strong>That's it !!!!!</strong></p>
	<p><strong>Enjoy the Service</strong></p>	
	<p> <mark>Even after following steps incase of any assistance you can contact us using contact us page provided in our application</mark>  </p>
	
	</div>
	</div>
	</div>	
	
	<script type="text/javascript">
	document.getElementById('add-location').addEventListener('click',function(){
	  	   document.querySelector('.addlocation-bg').style.display='flex';
	     }
	  	 );
	document.getElementById('subjectclose').addEventListener('click',function(){
	  	   document.querySelector('.addlocation-bg').style.display='none';
	     }
	  	 );
	
	
	</script>
</body>
</html>