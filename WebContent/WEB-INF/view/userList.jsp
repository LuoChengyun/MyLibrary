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
<title>管理用户</title>
<%@ page language="java" import="java.lang.*"%>
<%String base="/MyLibrary/resources/css/"; %>
</head>
<link href="<%=base %>userlist.css" type="text/css" rel="stylesheet">
<body>
<jsp:include page="managerNavigation.jsp"></jsp:include><br></br>
 <div class="search">
	<form method="GET" action="searchuser">
		<input type="text" class="input" placeholder="请输入用户姓名" name="username"/>
		<input type="submit" class="search" value="搜索"  />
	</form>
</div>  
<div class="list">
	<h1 class="titletype">用户名单</h1> 
	<table width=100%   id=customers >
		<tr align="center">
  			<th>姓名</th>
  			<th>账号</th>
  	 		<th>用户身份</th>
  			<th>用户状态</th>
    		<th colspan="2">操作</th>
		</tr>
		<c:forEach items="${userpaginationSupport.items}" var="user">
			<tr align="center">
				<td>
					<c:out value="${user.userName}" />
				</td>
				<td >
					<c:out value="${user.userAccount }" />
				</td>
				<td >
					${user.userIdentity eq 0 ? '普通用户':user.userIdentity eq 1?'管理员':'' }
				</td>
				<td>
					${user.userState eq 0 ? '可用':user.userState eq 1?'不可用':'' }
				</td>
				<td>
					<a href="<c:url value="checkuser?id=${user.userId }" />">禁用</a>
					<a href="<c:url value="backuser?id=${user.userId }" />">解禁</a>
				</td>
				<td>
					<a href="<c:url value="deleteuser?id=${user.userId }" />">删除</a>
					<a href="<c:url value="alteruser?id=${user.userId }" />">修改</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	每页${userpaginationSupport.pageSize}个用户，第${userpaginationSupport.currentPageNo }/${userpaginationSupport.totalPageCount }页，共${userpaginationSupport.totalCount }个用户
	<c:if test="${userpaginationSupport.previousPage}">
		<a href="<c:url value="/manager/userlist?pageNo=${userpaginationSupport.currentPageNo-1}" />" >上一页</a>
	</c:if>
	<c:if test="${userpaginationSupport.nextPage}">
		<a href="<c:url value="/manager/userlist?pageNo=${userpaginationSupport.currentPageNo+1}" />" >下一页</a>
	</c:if>
</div>
<div class="adduser">
	<h1 class="titletype">添加用户</h1>
		<sf:form method="GET" commandName="user" action="adduser" >
			姓名: <sf:input path="userName"   /><sf:errors path="userName" cssClass="error" ></sf:errors><br/>
			账号:  <sf:input  path="userAccount"/><sf:errors path="userAccount" cssClass="error" ></sf:errors><br/>
			密码:  <sf:input  path="userPassword" type="password"/><sf:errors path="userPassword" type="password" cssClass="error" ></sf:errors><br/>
			<input type="submit" class="search" value="添加"  />
		</sf:form>
</div > 
 
</body>
</html>