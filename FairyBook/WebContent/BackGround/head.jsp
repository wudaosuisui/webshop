<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.fairy.bookonline.entity.Admin" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BG head</title>
</head>
<link rel="stylesheet" type="text/css" href="../Css/BGindext.css">
<body>
<div id="head">
<div id="headline">
<%
Admin adminh = (Admin)session.getAttribute("admin");
%>
<%=adminh.getLoginName() %>&nbsp;||&nbsp;&nbsp;<a href="../admin/logout">退出</a>
</div>
</div>
</body>
</html>