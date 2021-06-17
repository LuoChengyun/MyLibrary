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
<title>我的申请</title>
<%@ page language="java" import="java.lang.*"%>
<%String base="/MyLibrary/resources/css/"; %>
</head>
<link href="<%=base %>userlist.css" type="text/css" rel="stylesheet">
<body class="body">
<jsp:include page="userNavigation.jsp"></jsp:include>
<div class="list">
	<h1 class="titletype">我的申请记录</h1> 
	<table width=100%   id=customers >
		<tr align="center">
  			<th>书名</th>
  			<th>借书进度</th>
    		<th>操作</th>	
		</tr>
		<c:forEach items="${lendpaginationSupport.items}" var="lend">
			<tr align="center">
				<td>
					<c:out value="${lend.lendBook.getBookName()}" />
				</td>
				<td>
					<c:out value="${lend.lendState eq 0 ? '待审核': lend.lendState eq 2 ? '申请还书':''}" />
				</td>
				<td>
            	<a href="<c:url value="canclelend?lendId=${lend.lendId }" />">取消申请</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	每页${lendpaginationSupport.pageSize}个记录，第${lendpaginationSupport.currentPageNo }/${lendpaginationSupport.totalPageCount }页，共${lendpaginationSupport.totalCount }个记录
	<c:if test="${lendpaginationSupport.previousPage}">
		<a href="<c:url value="/user/userapply?pageNo=${lendpaginationSupport.currentPageNo-1}" />" >上一页</a>
	</c:if>
	<c:if test="${userpaginationSupport.nextPage}">
		<a href="<c:url value="/user/userapply?pageNo=${lendpaginationSupport.currentPageNo+1}" />" >下一页</a>
	</c:if>
</div> 
</body>
</html>