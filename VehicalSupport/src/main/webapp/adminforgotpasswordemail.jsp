<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgot Password</title>
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
   	<h1>Admin ForgotPassword</h1> <br>
    <form class="login-form" action="adminforgotpassword" method="post">
      <input type="email" placeholder="Enter Registered Mail id" name="email"  />
     
      <button>Send Otp</button>
      
	  <p class="message">Home Page <a href="index.html">Home Page</a></p>
    </form>
  </div>
</div>

</body>
</html>