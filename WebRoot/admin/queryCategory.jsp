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
    
    <title>My JSP 'queryCategory.jsp' starting page</title>
    
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
    <form action="/shopping/CategorySer" method="post">
    	查询：<input type="text" name="ctype"/><br/>
    	<input type="submit" value="提交"/> 
    	<input type="hidden"value="queryCategory" name="status"/>
    </form>
    <c:if test="${requestScope.categorys!=null }">
    <table>
    	<tr>
    		<td>编号</td>
    		<td>类别名</td>
    		<td>类是否热点</td>
    		<td>所属客服</td>
    	</tr>
    	<c:forEach items="${requestScope.categorys}" var="category" varStatus="null">
    			<tr>
    				<td>${category.cid}</td>
    				<td>${category.ctype} </td>
    				<td>
						<c:choose>
							<c:when test="${category.chot=='true' }">
								<input type="checkbox" checked="checked" value="true" disabled="disabled"/>
							</c:when>
							<c:otherwise>
								<input type="checkbox"  value="true" disabled="disabled"/>
							</c:otherwise>
						</c:choose>
					</td>
    				<td>${category.account.alogin}</td>
    			</tr>
    	</c:forEach>
    </table>
    </c:if>
  </body>
</html>
