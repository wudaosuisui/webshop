<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<link rel="stylesheet" type="text/css" href="../Css/adminLogin.css">
<body>
<br><br>
<h1>There is Login Page!</h1>
<div id="body">
<form action="../user/login" method = "post">
loginName:<br/>
<input type="text" name="loginName" value="user3"><br/>
password:<br/>
<input type="password" name="password" value="123"><br/>
${errorinfo }<br>
<input type="submit" name="button" value="  login  ">&nbsp;&nbsp;
<input type="submit" name="button" value=" register ">&nbsp;&nbsp;<br><br>
<input type="submit" name="button" value="backGround"><br>
</form>
</div>
</body>
</html>