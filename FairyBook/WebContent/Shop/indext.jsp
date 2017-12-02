<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>indext Page</title>
<!-- div的显示 -->
<style typr="text/css">
.div{
border:1px solid red ;
width:200px;
}
</style>
</head>
<body>
	<c:forEach items="${sessionScope.booklist }" var="book">
		<div class="div">
			书名${book.name },书的种类${book.cakeType.name }<br>
		</div>
	</c:forEach>

</body>
</html>