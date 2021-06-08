<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理分类</title>
<%@ page language="java" import="java.lang.*"%>
<%String base="/MyLibrary/resources/css/"; %>
</head>
<link href="<%=base %>userlist.css" type="text/css" rel="stylesheet">
<body>
<jsp:include page="managerNavigation.jsp"></jsp:include>
<div class="list">
	<h1 class="titletype">我的借阅车</h1> 
	<table width=100%   id=customers >
		<tr align="center">
  			<th>书名</th>
    		<th>操作</th>	
		</tr>
		<c:forEach items="${typepaginationSupport.items}" var="lendcar">
			<tr align="center">
				<td>
					<c:out value="${lendcar.lendcarBook.getBookName()}" />
				</td>
				<td>
					<a href="<c:url value="deletecar?id=${lendcar.lendcarId }" />">下车</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>