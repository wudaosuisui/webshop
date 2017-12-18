<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.fairy.bookonline.entity.Admin" %>
<%@ page import="com.fairy.bookonline.entity.Book" %>
<%@ page import="com.fairy.bookonline.entity.Page" %>
<%@ page import ="java.util.List" %>
<%@ page import = " java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BG indext</title>
</head>
<!-- CSS样式 -->
<link rel="stylesheet" type="text/css" href="../Css/BGindext.css">
<body>
<%Admin admin = (Admin)session.getAttribute("admin");

if(admin!=null){
//创建bookList(nunll)
List<Book> bookList = new ArrayList<Book>();
//从session获取
bookList = (List<Book>) session.getAttribute("bookList");
//判空
if(bookList==null){
	%>
	<h1>图书列表获取失败!</h1>
	<h1>请从新登陆</h1>
	<h1><a href="../BackGround/login.jsp">前往登陆</a></h1>
	<%
}else{
%>
<%@ include file="head.jsp" %> 
<!-- 已经登陆 可以进行操作 -->
<div id="bookShowTable">
<table width="750px">
<tr>
<th>ID</th><th>书名</th><th>图书类型</th>
<th>出版社</th><th>作者</th><th>价格/元</th>
<th>上架状态</th><th>删除</th><th>修改</th>
</tr>
<!-- 循环输出图书信息 -->
<%
int i = 0;
for(Book book : bookList){ %>
<tr>
<td><%=book.getId() %></td><td><%=book.getName() %></td><td><%=book.getCategory().getName() %></td>
<td><%=book.getPress() %></td><td><%=book.getAuthor() %></td><td><%=book.getPress() %></td>
<td><%=book.isSell() %></td><td><a href="../book/deletebook?i=<%=i %>">删除</a></td>
<td><a href="../book/changepage?i=<%=i %>">修改</a></td>
</tr>
<%
i++;}//循环图书信息的for 
%>
</table><br>
<div id="page">
<%
Page page1 = (Page)session.getAttribute("page");
%>
	<a href="../book/changePageNum?pageN=<%=page1.getCurrentPageNum()-1 %>">上一页</a>
	&nbsp;&nbsp;&nbsp;
	<%
	for(int j =0 ;j<page1.getTotalPageNum();j++){
	%>
	<a href="../book/changePageNum?pageN=<%=j+1 %>"><%=j+1 %></a>&nbsp;&nbsp;&nbsp;
	<%} %>
	<a href="../book/changePageNum?pageN=<%=page1.getCurrentPageNum()+1 %>">下一页</a>
	</div>
<h2><a href="../book/addpage">添加图书</a></h2><!-- 
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -->
<h2><a href="../BackGround/addCategory.jsp">添加图书种类</a></h2>
</div>

<%
}//判空的if
}else{ %>
<h1>请先登录  再操作</h1>
<a href="login.jsp">前往登陆</a>
<%} %>
</body>
</html>