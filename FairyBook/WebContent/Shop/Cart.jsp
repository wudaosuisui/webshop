<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.fairy.bookonline.entity.UserInfo" %>
<%@ page import="com.fairy.bookonline.entity.Book" %>
<%@ page import="com.fairy.bookonline.entity.OrdersItem" %>
<%@ page import="java.util.List" %>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>  
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cart</title>
</head>
<link rel="stylesheet" type="text/css" href="../Css/shop.css">
<body>
<%@ include file="head.jsp" %> 
<%
UserInfo userInfo = (UserInfo)session.getAttribute("userInfo") ;
if(userInfo==null){
	out.write("<h1>请先登录</h1><h1><a href=\"../Login/login.jsp\">前往登陆</a></h1><h1><a href=\"shop.jsp\">前往商城</a></h1> ");
}else{
	List<Book> bookList = userInfo.getCart();
	if(bookList==null){
		out.write("<h1>~~~ 购物车为空 ~~~</h1><br><h1><a href=\"shop.jsp\">前往商城</a></h1>");
	}else{
		Object list  =session.getAttribute("ItemList");
		//List<OrdersItem> ItemList = (List<OrdersItem>)session.getAttribute("ItemList");
		if(list==null){
			response.sendRedirect("../book/showcart");
		}else{
			List<OrdersItem> ItemList = (List<OrdersItem>)list;
%>

<table>
<form action="../orders/produceorders">
<tr>
<td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;图书代码&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;书名&nbsp;&nbsp;</td><td>&nbsp;&nbsp;单价/元&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;添加&nbsp;&nbsp;</td><td>&nbsp;&nbsp;购买数量&nbsp;&nbsp;</td>
<td>&nbsp;&nbsp;减少&nbsp;&nbsp;</td><td>&nbsp;&nbsp;此书总价/元&nbsp;&nbsp;</td>
</tr>
<%
int bookNumber = 0; 
int Price = 0; 
int i=0;
for(OrdersItem Item : ItemList){
	bookNumber = bookNumber+Item.getNumber();
	Price = Price+Item.getPrice();
	%>
	<tr><td><input type="checkbox" value="<%=i %>" name="i"/></td>
	<td>&nbsp;&nbsp;<%=Item.getBook().getId() %></td>
	<td>&nbsp;&nbsp;<%=Item.getBook().getName() %></td>
	<td>&nbsp;&nbsp;&nbsp;&nbsp;<%=Item.getBook().getPrice() %></td>
	<td>&nbsp;&nbsp;
	<a href="../orders/addone?bookId=<%=Item.getBook().getId() %>&i=<%=i %>">添加</a>
	&nbsp;&nbsp;</td>
	<td>&nbsp;&nbsp;&nbsp;&nbsp;<%=Item.getNumber() %></td>
	<td>&nbsp;&nbsp;
	<a href="../orders/cutone?bookId=<%=Item.getBook().getId() %>&i=<%=i %>">减少</a>
	&nbsp;&nbsp;</td><td><%=Item.getPrice()%></td></tr>
<%
i++;
} //循环ItemList
%>
<tr>
<td colspan="4"></td><td colspan="2">共 <%=bookNumber %>本</td><td colspan="2">总价：<%=Price %>/元</td></tr>
<tr> 
<td colspan="2"></td>
<td colspan="2"><a href="../Shop/shop.jap">返回</a></td>
<td colspan="2"><input type="submit" name="sub" value="支付选中商品"></td>
<td colspan="2"><input type="submit" name="sub" value="支付全部商品"></td></tr>
</form>
</table>
<%			}
		}//判断购物车是否为空
	}//判断是否已登陆
	%>
</body>
</html>
