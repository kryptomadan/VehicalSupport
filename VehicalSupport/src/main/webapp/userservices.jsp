<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-responsive.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/main.css">
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
                    <h1 >Services</h1>
                </div>
                
            </div>
        </div>
    </section>
    <!-- / .title -->       

    <section class="services">
        <div class="container">
            <div class="row-fluid">
                <div class="span4">
                    <div class="center">
                        <img height="80px" width="80px" src="images/keysunlock.jpg"/>
                        <p> </p>
                        <h4>KEY LOST OR LOCKED</h4>
                        <p>Lost your keys? Keys locked in? Our lockout experts will provide on-site help 24X7.</p>
                        
                    </div>
                </div>
                <div class="span4">
                    <div class="center">
                        <img height="80px" width="80px" src="images/mechanic.png"/>
                        <p> </p>
                        <h4>NEED ANY MECHANIC</h4>
                        <p>A mechanic is a person who builds or repairs engines or other machines. Mechanics are trained to use special tools and often work in shops or garages..</p>
                    </div>
                </div>
                <div class="span4">
                    <div class="center">
                        <<img height="80px" width="80px" src="images/towing.jpg"/>
                        <p> </p>
                        <h4>VEHICLE TOWING</h4>
                        <p>In case on-site repair is not possible, we will provide towing facility to the nearest authorized workshop as per applicable plan</p>
                        
                    </div>
                </div>
            </div>
            <hr>
            <div class="row-fluid">
                <div class="span4">
                    <div class="center">
                        <img height="80px" width="80px" src="images/Pic1.png"/>
                        <p> </p>
                        <h4>FUELING</h4>
                        <p>We will remedy incorrect fuelling. Additionally, 5 litres of fuel (chargeable separately) can be delivered to you anytime anywhere, if required</p>
                        
                    </div>
                </div>
               
                <div class="span4">
                    <div class="center">
                    	<img height="80px" width="80px" src="images/flattyre.png"/>
                        <p> </p>
                        <h4>FLAT TYRE</h4>
                        <p>Our technicians will replace your vehicle's flat tyre with your spare. In case you do not have enough spare tyre(s), we will get them repaired from the nearest tyre repair shop.</p>
                        
                    </div>
                </div>
            </div>
            <hr>
            <div class="center">
                <a class="btn btn-primary btn-large" href="#">See Pricing</a>
            </div>
            <p>&nbsp;</p>
        </div>
    </section>

    <!--Bottom-->
    <section id="bottom" class="main">
        <!--Container-->
        <div class="container">
            <!--row-fluids-->
            <div class="row-fluid">
                <!--Contact Info-->
                <div class="span3">
                    <h4>CONTACT US</h4>
                    <ul class="unstyled address">
                        <li>
                            <i class="icon-home"></i><strong>Address:</strong> Carrera 7 # 72-01<br>Bogot? D.C., Colombia
                        </li>
                        <li>
                            <i class="icon-envelope"></i>
                            <strong>Email: </strong> <a href="mailto:company@domain.com">company@domain.com</a>
                        </li>
                        <li>
                            <i class="icon-globe"></i>
                            <strong>Website:</strong> <a href="http://www.domain.com">www.domain.com</a>
                        </li>
                        <li>
                            <i class="icon-phone"></i>
                            <strong>Telephone:</strong> 123-456-7890
                        </li>
                    </ul>
                </div>
                <!--End Contact Info-->
                <!--Important Links-->
                <div id="tweets" class="span3">
                    <h4>COMPANY NAME</h4>
                    <div>
                        <ul class="arrow">
                            <li><a href="#">About Us</a></li>
                            <li><a href="#">Services</a></li>
                            <li><a href="#">Portfolio</a></li>
                            <li><a href="#">Erro 404</a></li>
                            <li><a href="#">Privacy Policy</a></li>
                            <li><a href="#">Contact Us</a></li>
                        </ul>
                    </div>  
                </div>
                <!--Important Links-->
                <div id="archives" class="span2">
                    <h4>ARCHIVES</h4>
                    <div>
                        <ul class="arrow">
                            <li><a href="#">Link No. 1</a></li>
                            <li><a href="#">Link No. 2</a></li>
                            <li><a href="#">Link No. 3</a></li>
                            <li><a href="#">Link No. 4</a></li>
                            <li><a href="#">Link No. 5</a></li>
                            <li><a href="#">Link No. 6</a></li>
                        </ul>
                    </div>
                </div>
                <!--End Links-->
                
            </div>
            <!--/row-fluid-->
        </div>
        <!--/container-->
    </section>
    <!--/bottom-->

    <!--Footer-->
    <footer id="footer">
        <div class="container">
            <div class="row-fluid">
                <div class="span5 cp">
                    &copy; 2016 <a target="_blank" href="http://www.domain.com/">Your Company</a>. All Rights Reserved.
                </div>
                <div class="span6">
                    <ul class="social pull-right">
                        <li><a href="#"><i class="icon-facebook"></i></a></li>
                        <li><a href="#"><i class="icon-twitter"></i></a></li>
                        <li><a href="#"><i class="icon-pinterest"></i></a></li>
                        <li><a href="#"><i class="icon-linkedin"></i></a></li>
                        <li><a href="#"><i class="icon-google-plus"></i></a></li>                       
                        <li><a href="#"><i class="icon-youtube"></i></a></li>
                        <li><a href="#"><i class="icon-instagram"></i></a></li>                   
                    </ul>
                </div>
                <div class="span1">
                    <a id="gototop" class="gototop pull-right" href="#"><i class="icon-angle-up"></i></a>
                </div>
            </div>
        </div>
    </footer>
    <!--/Footer-->

    <script src="js/vendor/jquery-1.9.1.min.js"></script>
    <script src="js/vendor/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
</body>
</html>