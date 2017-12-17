<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.fairy.bookonline.entity.UserInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
%>
账号<%=userInfo.getUserLogin().getLoginname() %>
昵称<%=userInfo.getName() %>
签名<%=userInfo.getSlogan() %>
</body>
</html>