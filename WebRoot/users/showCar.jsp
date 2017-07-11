<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showCar.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   	 这里显示购物车：也就是购买商品的列表显示
   	 <table>
    		<tr>
    			<td>商品名称</td>
    			<td>商品价格</td>
    			<td>商品数量</td>
    			<td>删除</td>
    		</tr>
    	
    	<c:forEach items="${sessionScope.forder.sorders}" var="sorder">
    		<tr>
    			<td>${sorder.sname}</td>
    			<td>${sorder.sprice}</td>
    			<td>${sorder.snumber}</td>
    		</tr>
    	</c:forEach>
    	</table>
    	<div>总价:</div>
  </body>
  </body>
</html>
