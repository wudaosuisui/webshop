<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.fairy.bookonline.entity.UserInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>head</title>
</head>
<body>
<div id="head"class="div" >

<div id="headtitle" class="div">
<a href="../book/showcart">购物车</a>&nbsp;&nbsp;&nbsp;&nbsp;
<%UserInfo userInfoh = (UserInfo)session.getAttribute("userInfo");
if(userInfoh==null){
	%> <a href="../Login/login.jsp">登陆</a>&nbsp;&nbsp;|
	&nbsp;&nbsp;<a href="../Login/register.jsp">注册</a><%
}else{
	%>
	<a href="../Login/user.jsp"><%=userInfoh.getName() %></a>
	&nbsp;&nbsp;||&nbsp;&nbsp;
	<a href="../user/logout">退出登陆</a>
	<%
}
%>
</div>
</div>
</body>
</html>