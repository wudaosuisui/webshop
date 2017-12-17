<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>register</title>
</head>
<link rel="stylesheet" type="text/css" href="../Css/adminLogin.css">
<body>
<br><br>
<h1>There is Register Page!</h1>
<div id="body">
<form action="../user/register" method = "post">
登陆账号:<br/>
<input type="text" name="loginName" value = "user6"><br/>
密码:<br/>
<input type="password" name="password" value="123" ><br/>
再次输入密码:<br/>
<input type="password" name="password2" value="123"><br/>
昵称:<br/>
<input type="text" name="name" value="user5name"><br/>
签名：(20字以内)<br>
<input type="text" name="slogan" value="I'm user5!!!" >
<br/>${errorinfo }<br>
<input type="submit" value="注册">
</form>
</div>
</body>
</html>