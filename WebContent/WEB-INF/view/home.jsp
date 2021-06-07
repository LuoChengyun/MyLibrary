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
<title>首页</title>
</head>
<body >
<jsp:include page="userNavigation.jsp"></jsp:include><br></br>
<!-- <div class="search">
  <h1 class="titletype">查询用户</h1> 

	
	<form method="GET" action="searchbook">
	<input type="text" class="input" placeholder="请输入书名" name="bookname"/>
	<input type="submit" class="search" value="搜索"  />
	</form>
</div>  -->
 <div class="list">
<!-- <h1 class="titletype">用户名单</h1> -->

	<table width=100%   id=customers >
	<tr align="center">
  	<th>书名</th>
  	<th>ISBN</th>
  	 <th>价格</th>
  	 <th>作者</th>
  	<th>出版社</th>
  	<th>类型</th>
    <th colspan="2">操作</th>
  	
</tr>
<c:forEach items="${bookpaginationSupport.items}" var="book">
<tr align="center">
<td>
<c:out value="${book.bookName}" />
</td>
<td >
<c:out value="${book.bookISBN}" />
</td>
<td >
<c:out value="${book.bookPrice}" />
</td>
<td >
<c:out value="${author.authorName}" />
</td>
<td >
<c:out value="${publishment.publishName}" />
</td>
<td >
<c:out value="${type.typeName}" />
</td> 
 <td >
${user.userIdentity eq 0 ? '普通用户':user.userIdentity eq 1?'管理员':'' }
</td>
<td>
 ${user.userState eq 0 ? '可用':user.userState eq 1?'不可用':'' }
</td> 
 <td>
<a href="<c:url value="checkuser?id=${user.userId }" />">详情</a>
</td>
<td>
	<a href="<c:url value="deleteuser?id=${user.userId }" />">加车</a>
</td>
</tr>
</c:forEach>
</table>
每页${userpaginationSupport.pageSize}本书，第${userpaginationSupport.currentPageNo }/${userpaginationSupport.totalPageCount }页，共${userpaginationSupport.totalCount }本书
<c:if test="${userpaginationSupport.previousPage}">
<a href="<c:url value="/user/booklist?pageNo=${userpaginationSupport.currentPageNo-1}" />" >上一页</a>
</c:if>
<c:if test="${userpaginationSupport.nextPage}">
<a href="<c:url value="/user/booklist?pageNo=${userpaginationSupport.currentPageNo+1}" />" >下一页</a>
</c:if>
</div>

  
</body>
</html>