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
<title>管理作者</title>
<%@ page language="java" import="java.lang.*"%>
<%String base="/MyLibrary/resources/css/"; %>
</head>
<link href="<%=base %>userlist.css" type="text/css" rel="stylesheet">
<body class="body">
<jsp:include page="managerNavigation.jsp"></jsp:include>
<div class="list">
	<h1 class="titletype">作者列表</h1> 
	<table width=100%   id=customers >
		<tr align="center">
  			<th>作者姓名</th>
  			<th>作者性别</th>
  			<th>作者介绍</th>
    		<th colspan="2">操作</th>	
		</tr>
		<c:forEach items="${authorpaginationSupport.items}" var="author">
			<tr align="center">
				<td>
					<c:out value="${author.authorName}" />
				</td>
				<td>
					<c:out value="${author.authorSex eq 0 ? '男':author.authorSex eq 1 ? '女':''}" />
				</td>
				<td>
					<c:out value="${author.authorIntroduct}" />
				</td>
				<td>
					<a href="<c:url value="alterauthor?id=${author.authorId }" />">修改</a>
				</td>
				<td>
					<a href="<c:url value="deleteauthor?id=${author.authorId }" />">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	每页${authorpaginationSupport.pageSize}个作者，第${authorpaginationSupport.currentPageNo }/${authorpaginationSupport.totalPageCount }页，共${authorpaginationSupport.totalCount }个作者
	<c:if test="${authorpaginationSupport.previousPage}">
		<a href="<c:url value="/manager/manageauthor?pageNo=${authorpaginationSupport.currentPageNo-1}" />" >上一页</a>
	</c:if>
	<c:if test="${authorpaginationSupport.nextPage}">
		<a href="<c:url value="/manager/manageauthor?pageNo=${authorpaginationSupport.currentPageNo+1}" />" >下一页</a>
	</c:if>
</div>
<div class="adduser">
	<h1 class="titletype">添加分类</h1>
	<sf:form method="GET" commandName="author" action="addauthor" >
		<%-- <sf:errors path="*" cssClass="error" /><br/> --%>
		作者姓名: <sf:input path="authorName"   /><sf:errors path="authorName" cssClass="error" ></sf:errors><br/>
		作者性别:<sf:select path="authorSex">
					<option value="0" <c:if test="${'0' eq author.authorName}">selected</c:if> >男</option>
					<option value="1" <c:if test="${'1' eq author.authorName}">selected</c:if> >女</option>
				</sf:select><sf:errors path="authorSex" cssClass="error" ></sf:errors><br/>
	<%-- 	作者性别: <sf:input path="authorSex"   /><sf:errors path="authorSex" cssClass="error" ></sf:errors><br/> --%>
		作者介绍: <sf:input path="authorIntroduct"   /><sf:errors path="authorIntroduct" cssClass="error" ></sf:errors><br/>
		<input type="submit" class="search" value="添加"  />
	</sf:form>
</div >   
 
</body>
</html>