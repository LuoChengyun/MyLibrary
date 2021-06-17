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
<title>管理出版社</title>
<%@ page language="java" import="java.lang.*"%>
<%String base="/MyLibrary/resources/css/"; %>
</head>
<link href="<%=base %>userlist.css" type="text/css" rel="stylesheet">
<body class="body">
<jsp:include page="managerNavigation.jsp"></jsp:include>
<div class="list">
	<h1 class="titletype">出版社列表</h1> 
	<table width=100%   id=customers >
		<tr align="center">
  			<th>出版社名</th>
  			<th>出版社地址</th>
  		<!-- 	<th>出版电话</th> -->
    		<th colspan="2">操作</th>	
		</tr>
		<c:forEach items="${publishmentpaginationSupport.items}" var="publishment">
			<tr align="center">
				<td>
					<c:out value="${publishment.publishName}" />
				</td>
				<td>
					<c:out value="${publishment.publishLocal}" />
				</td>
				<td>
					<a href="<c:url value="alterpublishpage?publishId=${publishment.publishId }" />">修改</a>
				</td>
				<td>
					<a href="<c:url value="deletepublishment?id=${publishment.publishId }" />">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	每页${publishmentpaginationSupport.pageSize}个出版社，第${publishmentpaginationSupport.currentPageNo }/${publishmentpaginationSupport.totalPageCount }页，共${publishmentpaginationSupport.totalCount }个出版社
	<c:if test="${publishmentpaginationSupport.previousPage}">
		<a href="<c:url value="/manager/managepublishment?pageNo=${publishmentpaginationSupport.currentPageNo-1}" />" >上一页</a>
	</c:if>
	<c:if test="${publishmentpaginationSupport.nextPage}">
		<a href="<c:url value="/manager/managepublishment?pageNo=${publishmentpaginationSupport.currentPageNo+1}" />" >下一页</a>
	</c:if>
</div>
<div class="adduser">
	<h1 class="titletype">添加出版社</h1>
	<sf:form method="GET" commandName="publishment" action="addpublishment" >
		<%-- <sf:errors path="*" cssClass="error" /><br/> --%>
		出版社名: <sf:input path="publishName"   /><sf:errors path="publishName" cssClass="error" ></sf:errors><br/>
		出版社地址: <sf:input path="publishLocal"   /><sf:errors path="publishLocal" cssClass="error" ></sf:errors><br/>
		<input type="submit" class="search" value="添加"  />
	</sf:form>
</div >   
 
</body>
</html>