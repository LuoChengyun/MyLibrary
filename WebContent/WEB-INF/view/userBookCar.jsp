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
<title>用户借阅车</title>
<%@ page language="java" import="java.lang.*"%>
<%String base="/MyLibrary/resources/css/"; %>
</head>
<link href="<%=base %>userlist.css" type="text/css" rel="stylesheet">
<body>
<jsp:include page="userNavigation.jsp"></jsp:include>
<div class="list">
	<h1 class="titletype">我的借阅车</h1> 
	<table width=100%   id=customers >
		<tr align="center">
  			<th>书名</th>
    		<th>操作</th>	
		</tr>
		<c:forEach items="${lendcarpaginationSupport.items}" var="lendcar">
			<tr align="center">
				<td>
					<c:out value="${lendcar.lendCarBook.getBookName()}" />
				</td>
				<td>
					<a href="<c:url value="deletelendcar?lendCarId=${lendcar.lendCarId }" />">下车</a>
					<a href="<c:url value="applybook?bookId=${lendcar.lendCarId }&userId=${user.userId }" />">借书</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	每页${lendcarpaginationSupport.pageSize}个记录，第${lendcarpaginationSupport.currentPageNo }/${lendcarpaginationSupport.totalPageCount }页，共${lendcarpaginationSupport.totalCount }个记录
	<c:if test="${lendcarpaginationSupport.previousPage}">
		<a href="<c:url value="/user/userlendcar?pageNo=${lendcarpaginationSupport.currentPageNo-1}" />" >上一页</a>
	</c:if>
	<c:if test="${userpaginationSupport.nextPage}">
		<a href="<c:url value="/user/userlendcar?pageNo=${lendcarpaginationSupport.currentPageNo+1}" />" >下一页</a>
	</c:if>
</div>
</body>
</html>