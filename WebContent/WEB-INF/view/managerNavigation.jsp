<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>普通用户导航栏</title>
<%@ page language="java" import="java.lang.*"%>
<%String base="/MyLibrary/resources/css/"; %>
</head>
<link href="<%=base %>navigation.css" type="text/css" rel="stylesheet">
<body>
<div class="nav">
    <nav class="nav-bar">
        <ul class="nav-items">
            <li> <a href="<c:url value="userlist" />" class="nav-item" >用户管理</a></li>
             <li> <a href="<c:url value="backbook" />"class="nav-item" >还书管理</a></li>
              <li> <a href="<c:url value="bendrecord" />"class="nav-item" >借书记录管理</a></li>
              <div class="nav-btn">
            <c:choose>
            	<c:when test="${not empty sessionScope.user }">
            	<a href="<c:url value="/manager/usercenter" />" class="nav-item">${sessionScope.user.userAccount }</a>
                <a href="<c:url value="logoutpage" />" class="nav-item btn">退出</a>
                </c:when>
                </c:choose>
            </div>
        </ul>
    </nav>
</div>
</body>
</html> 