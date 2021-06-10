<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书详情</title>
<%@ page language="java" import="java.lang.*"%>
<%String base="/MyLibrary/resources/css/"; %>
</head>
<link href="<%=base %>bookinformation.css" type="text/css" rel="stylesheet">
<body class="body">
<div class="infor">
	<a class="back" href="<c:url value="booklist" />">返回首页</a><br/>
	<h1 class="title">图书详情</h1>
	<c:forEach items="${bookpaginationSupport.items}" var="book">
	书名:<c:out value="${book.bookName }" ></c:out><br/><br/>
	ISBN: <c:out value="${book.bookISBN}"></c:out><br/><br/>
	介绍: <c:out value="${book.bookDesc }"   ></c:out><br/><br/>
	价格: <c:out value="${book.bookPrice }"   ></c:out><br/><br/>
	出版时间: <c:out value="${book.bookRelease }"   ></c:out><br/><br/>
	位置: <c:out value="${book.bookLocation }"   ></c:out><br/><br/>
	状态: <c:out value="${book.bookState eq 0 ? '可借':book.bookState eq 1 ? '不可借':book.bookState eq 2 ? '不可借':'' }"   ></c:out><br/><br/>
	作者: <c:out value="${book.bookAuthor.getAuthorName() }"   ></c:out><br/><br/>
	出版社: <c:out value="${book.bookPublish.getPublishName() }"   ></c:out><br/><br/>
	分类: <c:out value="${book.bookType.getTypeName() }"   ></c:out><br/><br/>
	</c:forEach>
	<a class="add" href="<c:url value="addlendcar?bookid=${book.bookId }&userid=${user.userId }" />">加车</a>
	<a class="lendbook" href="<c:url value="addapply?bookid=${book.bookId }&userid=${user.userId }" />">借书</a>
</div>
</body>
</html>