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
    <form class="login-form" action="adminsetpassword" method="post">
      <input type="password" placeholder="Password" name="pass"  />
      <input type="password" placeholder="Confirm Password" name="pass2"  />
     
      <button>Change Password </button>
      
	  
    </form>
  </div>
</div>
</body>
</html>