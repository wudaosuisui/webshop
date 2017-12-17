<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.fairy.bookonline.entity.Book" %>
<%@ page import="com.fairy.bookonline.entity.Category" %>
<%@ page import ="java.util.List" %>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Change Book</title>
</head>
<!-- CSS样式 -->
<link rel="stylesheet" type="text/css" href="../Css/BGindext.css">
<body>
<%
//从session获取
Book book = (Book)session.getAttribute("book");
List<Category> categoryList = (List<Category>)session.getAttribute("cateogryList");
if((book==null)||(categoryList==null)){
	out.write("book get null!");
	%>
	<h1>列表内容获取失败!</h1>
	<h1>请从新登陆</h1>
	<h1><a href="../BackGround/login.jsp">前往登陆</a></h1>
	<%
}else{
	//创建categoryList(nunll)
	//List<Category> categoryList = new ArrayList<Category>();
	//赋值
	//categoryList = (List<Category>) list;
%>
<div id="bookShowTable">
<form action="../book/changebook" method="post">
ID:<%=book.getId() %>(此项不可更改)
<input type="hidden" name="Id" value="<%=book.getId() %>"><br>
图书类型：
<select name="Category">
		<option value="<%=book.getCategory().getId() %>" selected="selected"><%=book.getCategory().getName() %></option>
		<%for(Category cat : categoryList){ %>
		<option value="<%=cat.getId() %>"><%=cat.getName() %></option>
		<% }%>
</select><br>
书名:
<input type="text" name="Name" value="<%=book.getName() %>"><br>
图片:原图片<br>
<img src="<%=book.getImg() %>"><br>
<input type="file" name="Img" value="<%=book.getImg() %>"><br>
出版社:
<input type="text" name="Press" value="<%=book.getPress() %>"><br>
作者:
<input type="text" name="Author" value="<%=book.getAuthor() %>"><br>
价格:
<input type="text" name="Price" value="<%=book.getPress() %>">（单位/元）<br>
上架状态
<input type="radio" name="Sell" value="true" >上架 &nbsp;&nbsp;&nbsp;
<input type="radio" name="Sell" value="false">不上架<br>
<input type="submit" name="button" value="submit">&nbsp;&nbsp;&nbsp;
<input type="submit" name="button" value="Back">
</form>
<%} %>
</div>
</body>
</html>