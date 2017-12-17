<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.fairy.bookonline.entity.UserInfo" %>
<%@ page import="com.fairy.bookonline.entity.Book" %>
<%@ page import="com.fairy.bookonline.entity.Orders" %>
<%@ page import="com.fairy.bookonline.entity.OrdersItem" %>
<%@ page import="java.util.List" %>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Orders</title>
</head>
<link rel="stylesheet" type="text/css" href="../Css/shop.css">
<body>
<%@ include file="head.jsp" %> 
<%UserInfo userInfo = (UserInfo)session.getAttribute("userInfo") ;
Orders orders = (Orders)session.getAttribute("orders");
if(userInfo==null){
	%> 
	<h1>请先登录</h1>
	<h1><a href="../Login/login.jsp">前往登陆</a></h1>
	<%
}else{
	if(orders==null){
		%><h1>~~~ 订单获取失败 ~~~</h1><br><h1><a href="shop.jsp">商城</a></h1> 
		<%
	}else{
%>
<table>
<tr><td closepan="5">订单号：<%=orders.getId() %></td></tr>
<tr><td closepan="2">下单时间：<%=orders.getTime() %></td><td closepan="3">用户账号：<%=orders.getUserInfo().getUserLogin().getLoginname() %></td></tr>
<tr>
<td>图书代码</td><td>书名</td><td>单价/元</td><td>购买数量</td><td>此书总价/元</td>
</tr>
<%
int bookNumber = 0;
int Price = 0;
int i=0;
for(OrdersItem Item : orders.getItem()){
	bookNumber += Item.getNumber();
	Price += Item.getPrice();
	%>
	<tr>
	<td><%=Item.getBook().getId() %></td><td><%=Item.getBook().getName() %></td>
	<td><%=Item.getBook().getPrice() %></td>
	<td><%=Item.getNumber() %></td><td><%=Item.getPrice()%></td></tr>
<%
i++;
} //循环ItemList
%>
<tr>
<td></td><td closepan="2">共 <%=bookNumber %>本</td><td closepan="2">总价：<%=Price %>/元</td></tr>
<tr>
<td></td>
<td closepan="2"><a href="../book/showcart">返回</a></td>
<td ></td>
<td closepan="2"><a href="../orders/gotopay">付款</a></td></tr>
</form>
</table>
<%
		}//判断购物车是否为空
	}//判断是否已登陆
	%>
<%@ include file="floor.jsp" %> 
</body>
</html>