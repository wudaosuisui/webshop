<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.fairy.bookonline.entity.Book" %>
<%@ page import="com.fairy.bookonline.entity.Category" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book XinagQing Page</title>
<!-- div的显示 -->
<link rel="stylesheet" type="text/css" href="../Css/shop.css">
</head>
<body>
<% Book book = (Book)session.getAttribute("book");%>
<% if(book==null){
	%><h1>Book 获取失败 !</h1><h1>请返回 ，从新选择图书查看~</h1><%
}else{
%>
<!-- head -->
<%@ include file="head.jsp" %> 
<!-- body -->
<div id="body" class="div" >
<table>
	<tr>
	<td width="100%" height="100%"><!-- 不知道为什么 但是改这里之后就对了 -->
	<div id="show" class="div">
	<div class="div">
	<table>
	<tr>
		<td><img alt="图书图片" src="<%=book.getImg() %>"></td>
		<td>
		图书编号：<%=book.getId() %> &nbsp;&nbsp;&nbsp;图书类别：<%=book.getCategory().getName() %><br>
		书名：<%=book.getName() %><br>
		作者：<%=book.getAuthor() %> &nbsp;&nbsp;&nbsp;出版社：<%=book.getPress() %><br>
		价格：<%=book.getPrice() %><br>
		<a href="../book/addCart?book=<%=book.getId() %>&ServletPath=<%=request.getServletPath() %>"><img alt="加入购物车" src="../img/car.jpg"></a><br>
		</td>
	</tr>
	<tr>
	<td colspan="2">
	<h4>作者简介</h4>
	<p>Bruce Eckel是MindView公司（www.MindView.net）的总裁，该公司向客户提供软件咨询和培训。他是C++标准委员会拥有表决权的成员之一，
	拥有应用物理学学士和计算机工程硕士学位。除本书外，他还是《C++编程思想》的作者，并与人合著了《C++编程思想 第2卷》（这两本书的英文影印版及中文版均已
	由机械工业出版社引进出版）及其他著作。他已经发表了150多篇论文，还经常参加世界各地的研讨会并进行演讲。</p>
	<h4>内容简介</h4>
	<p>《Java编程思想（第4版）》赢得了全球程序员的广泛赞誉，即使是最晦涩的概念，在Bruce Eckel的文字亲和力和小而直接的编程示例面前也会化解于无形。
	从Java的基础语法到最高级特性（深入的面向对象概念、多线程、自动项目构建、单元测试和调试等），《Java编程思想（第4版）》都能逐步指导你轻松掌握。
	从java编程思想这本书获得的各项大奖以及来自世界各地的读者评论中，不难看出这是一本经典之作。本书的作者拥有多年教学经验，对C、C++以及Java语言都有独到、
	深入的见解，以通俗易懂及小而直接的示例解释了一个个晦涩抽象的概念。《Java编程思想（第4版）》共22章，包括操作符、控制执行流程、访问权限控制、复用类、多态、
	接口、通过异常处理错误、字符串、泛型、数组、容器深入研究、Java I/O系统、枚举类型、并发以及图形化用户界面等内容。这些丰富的内容，包含了Java语言基础语法
	以及高级特性，适合各个层次的Java程序员阅读，同时也是高等院校讲授面向对象程序设计语言以及Java语言的绝佳教材和参考书。
	第4版特点：
	Java编程思想(第4版)这本书特别适合初学者与专业人员的经典的面向对象叙述方式，为更新的Java SE5/6增加了新的示例和章节。
	�8�7 测验框架显示程序输出。
	�8�7 设计模式贯穿于众多示例中：适配器、桥接器、职责链、命令、装饰器、外观、工厂方法、享元、点名、数据传输对象、空对象、代理、单例、状态、策略、模板方法以及访问者。
	�8�7 为数据传输引入了XML，为用户界面引入了SWT和Flash。
	�8�7 重新撰写了有关并发的章节，有助于读者掌握线程的相关知识。
	�8�7 专门为第4版以及Java SE5/6重写了700多个编译文件中的500多个程序。
	�8�7 支持网站包含了所有源代码、带注解的解决方案指南、网络日志以及多媒体学习资料。
	�8�7 覆盖了所有基础知识，同时论述了高级特性。
	�8�7 详细地阐述了面向对象原理。
	�8�7 在线可获得Java讲座CD，其中包含Bruce Eckel的全部多媒体讲座。
	在www.MindView.net网站上可以观看现场讲座、咨询和评论。
	专门为第4版以及Java SE5/6重写了700多个编译文件中的500多个程序。
	支持网站包含了所有源代码、带注解的解决方案指南、网络日志以及多媒体学习资料。
	覆盖了所有基础知识，同时论述了高级特性。
	详细地阐述了面向对象原理。
	在线可获得Java讲座CD，其中包含Bruce Eckel的全部多媒体讲座。
	在www.MindView.net网站上可以观看现场讲座、咨询和评论。</p>
	</td>
	</tr>
	</table>
	<%}%>
	</div>
	</td>
	</tr>
</table>
</div>
<!-- bottom -->
<div id="bottom" class="div">
<h1>This is bottom</h1>height:200px;
</div>
</body>
</html>