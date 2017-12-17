<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import="com.fairy.bookonline.entity.UserInfo" %>
<%@ page import="com.fairy.bookonline.entity.Book" %>
<%@ page import="com.fairy.bookonline.entity.Category" %>
<%@ page import="com.fairy.bookonline.entity.Page" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>There is shop</title>
<!-- div的显示 -->
<link rel="stylesheet" type="text/css" href="../Css/shop.css">
</head>
<body>

<%@ include file="head.jsp" %> 
<% Object booklist = session.getAttribute("bookList");%>
<% if(booklist==null){
	Page page1 = new Page(1,12);
	session.setAttribute("page", page1);
	response.sendRedirect("../book/indext");
}else{
%>
<%! List<Book> booklist2 = new ArrayList<Book>();%>
<% booklist2 = (List<Book>)booklist ;%>

<div id="body" class="div" >
<table>
	<tr>
	<td>
	<div id="JS"class="div" >
	</div>
	</td>
	<td width="100%" height="100%"><!-- 不知道为什么 但是改这里之后就对了 -->
	<div id="show" class="div">
	<%for(Book book : booklist2){ %>
	<div class="div show">
	<img alt="图书图片" src="<%=book.getImg() %>"><br>
	书名：<%=book.getName() %>&nbsp;&nbsp;&nbsp;
	价格：<%=book.getPrice() %><br>
	<a href="../book/xiangqing?book=<%=book.getId() %>"><img alt="详情" src="../img/xiangqing.jpg"></a>
	&nbsp;&nbsp;&nbsp;
	<a href="../book/addCart?book=<%=book.getId() %>&ServletPath=<%=request.getServletPath() %>"><img alt="加入购物车" src="../img/car.jpg"></a><br>
	</div>
	<%} %> 
	</div>
	</td>
	</tr>
</table>
<div id="page">
<%
Page page1 = (Page)session.getAttribute("page");
%>
	<a href="../book/changePageNum?pageN=<%=page1.getCurrentPageNum()-1 %>">上一页</a>
	&nbsp;&nbsp;&nbsp;
	<%
	for(int i =0 ;i<page1.getTotalPageNum();i++){
	%>
	<a href="../book/changePageNum?pageN=<%=i+1 %>"><%=i+1 %></a>&nbsp;&nbsp;&nbsp;
	<%} %>
	<a href="../book/changePageNum?pageN=<%=page1.getCurrentPageNum()+1 %>">下一页</a>
	</div>

<%} %> 
<%@ include file="floor.jsp" %> 
</body>
</html>