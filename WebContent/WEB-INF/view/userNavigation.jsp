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
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>管理员导航栏</title>
<%@ page language="java" import="java.lang.*"%>
<%String base="/MyLibrary/resources/css/"; %>
</head>
<link href="<%=base %>navigation.css" type="text/css" rel="stylesheet">
<body>
<div class="nav">
    <nav class="nav-bar">
        <ul class="nav-items">
    		<li><a href="<c:url value="booklist" />" class="nav-item">首页</a></li>
    		<li><a href="<c:url value="bendcar" />" class="nav-item">借阅车</a></li>
    		<li><a href="<c:url value="myrecord" />" class="nav-item">借书记录</a></li>
    		<li><a href="<c:url value="/user/usercenter" />" class="nav-item">${user.userAccount }</a></li>
    		<li><a href="<c:url value="/" />" class="nav-item btn">注销</a></li>
    		<%-- <div class="nav-btn">
             <c:choose>
            	<c:when test="${not empty sessionScope.user }">
            	<a href="<c:url value="/user/usercenter" />" class="nav-item">${sessionScope.user.userAccount }</a>
                <a href="<c:url value="logoutpage" />" class="nav-item btn">退出</a>
                </c:when>
                <c:otherwise>
                 <a href="<c:url value="loginpage" />" class="nav-item btn">登录</a>
                <a href="<c:url value="/user/registerpage" />" class="nav-item btn">注册</a>
                </c:otherwise>
                </c:choose> 
            </div> --%>
		</ul>
    </nav>
</div>
</body>
</html>