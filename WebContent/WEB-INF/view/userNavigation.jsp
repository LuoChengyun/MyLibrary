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
    		<li><a href="<c:url value="userlendcar?userId=${user.userId }" />" class="nav-item">借阅车</a></li>
    		<li><a href="<c:url value="userapply?userId=${user.userId }" />" class="nav-item">申请记录</a></li>
    		<li><a href="<c:url value="userreading?userId=${user.userId }" />" class="nav-item">我读的书</a></li>
    		<li><a href="<c:url value="userlend?userId=${user.userId }" />" class="nav-item">借书记录</a></li>
    		<li><a href="<c:url value="/user/usercenter" />" class="nav-item">${user.userAccount }</a></li>
    		<li><a href="<c:url value="/" />" class="nav-item btn">注销</a></li>
    		
		</ul>
    </nav>
</div>
</body>
</html>