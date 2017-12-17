<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.fairy.bookonline.entity.Category" %>
<%@ page import ="java.util.List" %>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Book</title>
</head>
<!-- CSS样式 -->
<link rel="stylesheet" type="text/css" href="../Css/BGindext.css">
<body>

<% 
List<Category> categoryList = (List<Category>)session.getAttribute("cateogryList");
if(categoryList==null){
	%> 
	<h1>Category List 获取失败 </h1>
	<h1>请返回上一页 再次加载 </h1>	<%
}else{
%> 

<div id="bookShowTable">
<form action="../book/addbook" method="post">

书名:
<input type="text" name="Name" value="JavaBook1"><br>
图书类型：
<select name="Category">
		<%for(Category cat : categoryList){ %>
		<option value="<%=cat.getId() %>"><%=cat.getName() %></option>
		<% }%>
</select><br>
图片:
<input type="file" name="Img" ><br>
出版社:
<input type="text" name="Press" value="ChuBanshe"><br>
作者:
<input type="text" name="Author" value="ZuoZhe" ><br>
价格:
<input type="text" name="Price" value ="45">（单位/元）<br>
上架状态
<input type="radio" name="Sell" value="true" >上架 &nbsp;&nbsp;&nbsp;
<input type="radio" name="Sell" value="false">不上架<br>
<input type="submit" name="button" value="submit"> &nbsp;&nbsp;&nbsp;
<input type="submit" name="button" value="Back">
</form>
</div>
<%} %>
</body>
</html>