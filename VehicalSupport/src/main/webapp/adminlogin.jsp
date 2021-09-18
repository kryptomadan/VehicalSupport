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
    <link rel="stylesheet" href="css/logincss.css">
    <script src="js/loginjs.js"></script>
</head>
<body>
<div class="login-page">
  <div class="form">
   	<h1>Admin Login</h1> <br>
    <form class="login-form" action="adminlogin" method="post">
      <input type="text" placeholder="username" name="usrname"  />
      <input type="password" placeholder="password" name="pass"/>
      <button type="submit" >login</button> <br> <br>
      <a href="adminforgotpasswordemail.jsp"><button type="button" >Forgot Password</button></a>
      
	  <p class="message">Home Page <a href="index.html">Home Page</a></p>
    </form>
  </div>
</div>
</body>
</html>