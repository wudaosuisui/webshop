<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pay Page</title>
</head>
<link rel="stylesheet" type="text/css" href="../Css/BGindext.css">
<link rel="stylesheet" type="text/css" href="../Css/shop.css">
<body>
<%@ include file="head.jsp" %> 
<br>
<br>
<div id="bookShowTable">
<h2>Pay~</h2>
请输入6位支付密码<br>
<form action="../orders/havepay"> 
<input type="text" >&nbsp;&nbsp;&nbsp;
<input type="submit" value="支付">
</form>
</div>
<%@ include file="floor.jsp" %> 
</body>
</html>