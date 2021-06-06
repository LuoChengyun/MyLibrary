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
  <!-- <h1 class="titletype">查询用户</h1>  -->

	
	<form method="GET" action="searchuser">
	<input type="text" class="input" placeholder="请输入账号" name="useraccount"/>
	<input type="submit" class="search" value="搜索"  />
	</form>
</div>  
<%-- <div class="adduser">
<h1 class="titletype">添加用户</h1>


<sf:form method="GET" commandName="user" action="adduser" >
<sf:errors path="*" cssClass="error" /><br/>
姓: <sf:input path="LastName"   /><sf:errors path="LastName" cssClass="error" ></sf:errors><br/>
名:  <sf:input  path="FirstName"/><sf:errors path="FirstName" cssClass="error" ></sf:errors><br/>
电话:  <sf:input  path="PhoneNum"/><sf:errors path="PhoneNum" cssClass="error" ></sf:errors><br/>
头像:  <sf:input  path="Picture"/><sf:errors path="Picture" cssClass="error" ></sf:errors><br/>
用户名: <sf:input   path="Account" /> <sf:errors path="Account" cssClass="error" ></sf:errors><br/>
状态:  <sf:password   path="Status" /><sf:errors path="Status" cssClass="error" ></sf:errors><br/>
身份:  <sf:password   path="Identity" /><sf:errors path="Identity" cssClass="error" ></sf:errors><br/>
<input type="submit" class="search" value="添加"  />
</sf:form>
</div > --%>  
<div class="list">
<!-- <h1 class="titletype">用户名单</h1> -->

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
</td>
<td>
	<a href="<c:url value="deleteuser?id=${user.userId }" />">删除</a>
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

 
</body>
</html>