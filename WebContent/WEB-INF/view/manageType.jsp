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
<body class="body">
<jsp:include page="managerNavigation.jsp"></jsp:include>
<div class="list">
	<h1 class="titletype">分类列表</h1> 
	<table width=100%   id=customers >
		<tr align="center">
  			<th>分类名</th>
    		<th colspan="2">操作</th>	
		</tr>
		<c:forEach items="${typepaginationSupport.items}" var="type">
			<tr align="center">
				<td>
					<c:out value="${type.typeName}" />
				</td>
				<td>
					<a href="<c:url value="altertype?id=${type.typeId }" />">修改</a>
				</td>
				<td>
					<a href="<c:url value="deletetype?id=${type.typeId }" />">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	每页${typepaginationSupport.pageSize}个分类，第${typepaginationSupport.currentPageNo }/${typepaginationSupport.totalPageCount }页，共${typepaginationSupport.totalCount }个分类
	<c:if test="${typepaginationSupport.previousPage}">
		<a href="<c:url value="/manager/managetype?pageNo=${typepaginationSupport.currentPageNo-1}" />" >上一页</a>
	</c:if>
	<c:if test="${userpaginationSupport.nextPage}">
		<a href="<c:url value="/manager/managetype?pageNo=${typepaginationSupport.currentPageNo+1}" />" >下一页</a>
	</c:if>
</div>
<div class="adduser">
	<h1 class="titletype">添加分类</h1>
	<sf:form method="GET" commandName="type" action="addtype" >
		<%-- <sf:errors path="*" cssClass="error" /><br/> --%>
		分类名: <sf:input path="typeName"   /><sf:errors path="typeName" cssClass="error" ></sf:errors><br/>
		<input type="submit" class="search" value="添加"  />
	</sf:form>
</div >   
 
</body>
</html>