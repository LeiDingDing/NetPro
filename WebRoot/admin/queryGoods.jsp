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
    <form action="/shopping/GoodsSer" method="post">
    	查询：<input type="text" name="gname"/><br/>
    	<input type="submit" value="提交"/> 
    	<input type="hidden"value="queryGoods" name="status"/>
    </form>
    <c:if test="${requestScope.goodss!=null }">
    <table>
    	<tr>
    		<td>编号</td>
    		<td>商品图片</td>
    		<td>商品名</td>
    		<td>商品价格</td>
    		<td>品牌</td>
    		<td>商品描述</td>
    		<td>上架日期</td>
    		<td>是否推荐</td>
    		<td>是否有效</td>
    		<td>所属客服</td>
    	</tr>
    	<c:forEach items="${requestScope.goodss}" var="goods" varStatus="null">
    			<tr>
    				<td>${goods.gid}</td>
    				<td>${goods.gpic} </td>
    				<td>${goods.gname}</td>
    				<td>${goods.gprice}</td>
    				<td>${goods.gremark}</td>
    				<td>${goods.gxremark}</td>
    				<td>${goods.gdate}</td>
    				<td>
						<c:choose>
							<c:when test="${goods.giscommend=='true' }">
								<input type="checkbox" checked="checked" value="true" disabled="disabled"/>
							</c:when>
							<c:otherwise>
								<input type="checkbox"  value="true" disabled="disabled"/>
							</c:otherwise>
						</c:choose>
					</td>
					<td>
						<c:choose>
							<c:when test="${goods.gisopen=='true' }">
								<input type="checkbox" checked="checked" value="true" disabled="disabled"/>
							</c:when>
							<c:otherwise>
								<input type="checkbox"  value="true" disabled="disabled"/>
							</c:otherwise>
						</c:choose>
					</td>
    			</tr>
    	</c:forEach>
    </table>
    </c:if>
  </body>
</html>
