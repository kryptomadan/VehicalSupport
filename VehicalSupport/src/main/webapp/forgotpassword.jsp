<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgot Password</title>
 
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="viewport" content="width=device-width">
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
   	<h1>Forgot Password</h1> <br>
    <form class="login-form" action="forgotpassword" method="post">
      <input type="email" placeholder="Registered Email" name="email"  />
      
      <button>Send OTP</button> <br> <br>
      
      <p class="message">Enter Your Registered Mail ID</p>
	 
	  
    </form>
  </div>
</div>


</body>
</html>