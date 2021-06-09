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
<title>管理图书</title>
<%@ page language="java" import="java.lang.*"%>
<%String base="/MyLibrary/resources/css/"; %>
</head>
<link href="<%=base %>userlist.css" type="text/css" rel="stylesheet">
<body class="body">
<jsp:include page="managerNavigation.jsp"></jsp:include>
<div class="search">
	<form method="GET" action="managersearchbook" method="GET">
		<input type="text" class="input" placeholder="请输入书名" name="bookname"/>
		<input type="submit" class="search" value="搜索"  />
	</form>
</div>  
<div class="list">
	<h1 class="titletype">图书列表</h1>
	<table width=100%   id=customers >
		<tr align="center">
  			<th>书名</th>
  			<th>ISBN</th>
  	 		<th>价格</th>
  	 		<th>作者</th>
  			<th>出版社</th>
  			<th>类型</th>
    		<th >删除</th>
    		<th >修改</th>
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
					<c:out value="${book.bookAuthor.getAuthorName()}" />
				</td>
				<td >
					<c:out value="${book.bookPublish.getPublishName()}" />
				</td>
				<td >
					<c:out value="${book.bookType.getTypeName()}" />
				</td> 
 				<td>
					<a href="<c:url value="deletebook?id=${book.bookId }" />">删除</a>
				</td>
				<td>
					<a href="<c:url value="alterbook?bookid=${book.bookId }" />">修改</a>
				</td>
			</tr>
		</c:forEach>
	</table>
每页${bookpaginationSupport.pageSize}本书，第${bookpaginationSupport.currentPageNo }/${userpaginationSupport.totalPageCount }页，共${bookpaginationSupport.totalCount }本书
	<c:if test="${bookpaginationSupport.previousPage}">
		<a href="<c:url value="/manager/managebook?pageNo=${bookpaginationSupport.currentPageNo-1}" />" >上一页</a>
	</c:if>
	<c:if test="${bookpaginationSupport.nextPage}">
		<a href="<c:url value="/manager/managebook?pageNo=${bookpaginationSupport.currentPageNo+1}" />" >下一页</a>
	</c:if>
</div>
<div class="adduser">
	<h1 class="titletype">添加书籍</h1>
	<sf:form method="GET" commandName="book" action="addbook" >
		<%-- <sf:errors path="*" cssClass="error" /><br/> --%>
		书名: <sf:input path="bookName"   /><sf:errors path="bookName" cssClass="error" ></sf:errors><br/>
		ISBN: <sf:input path="bookISBN"   /><sf:errors path="bookISBN" cssClass="error" ></sf:errors><br/>
		简介: <sf:input path="bookDesc"   /><sf:errors path="bookDesc" cssClass="error" ></sf:errors><br/>
		价格: <sf:input path="bookPrice"   /><sf:errors path="bookPrice" cssClass="error" ></sf:errors><br/>
		出版时间: <sf:input path="bookRelease"   /><sf:errors path="bookRelease" cssClass="error" ></sf:errors><br/>
		位置: <sf:input path="bookLocation"   /><sf:errors path="bookLocation" cssClass="error" ></sf:errors><br/>	
		作者: <sf:input path="bookAuthor"   /><sf:errors path="bookAuthor" cssClass="error" ></sf:errors><br/>
		出版社: <sf:input path="bookPublish"   /><sf:errors path="bookPublish" cssClass="error" ></sf:errors><br/>
		类型: <sf:input path="bookType"   /><sf:errors path="bookType" cssClass="error" ></sf:errors><br/>
		<input type="submit" class="search" value="添加"  />
	</sf:form>
</div >   
 
</body>
</html>