<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Login</title>
</head>
<link rel="stylesheet" type="text/css" href="../Css/adminLogin.css">
<body>
<br><br>
<h1>There is Admin Login Page!</h1>
<div id="body">
<form action="../admin/login" method="post">
loginName:<br/>
<input type="text" name="loginName" value="admin" ><br/>
password:<br/>
<input type="password" name="password" value="123"><br/><br/>

<input type="submit" name="button" value="login">

</form>
</div>
</body>
</html>