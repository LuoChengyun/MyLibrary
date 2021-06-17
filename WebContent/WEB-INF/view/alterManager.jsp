<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改管理员信息</title>
<%@ page language="java" import="java.lang.*"%>
<%String base="/MyLibrary/resources/"; %>
</head>
<link href="<%=base %>css/alter.css" type="text/css" rel="stylesheet">
<body style="background-color:beige">
<div class="container">
 <div class="box-title">
            信息编辑
        </div>
        <div class="info-container">
        	<form method="GET" class="info-form" name="managerInformationForm" action="altermanager">
        		<div class="item">
                    <label class="info-text">姓名:</label>
                    <input type="text" name="userName" autocomplete="off"  placeholder="姓名" maxlength="20" value="<c:if test="${not empty user }">${user.userName }</c:if>" class="info-input">
                </div>
                <div class="item">
                    <label class="info-text">账号:</label>
                    <input type="text" name="userAccount" autocomplete="off"  placeholder="账号" maxlength="20" value="<c:if test="${not empty user }">${user.userAccount }</c:if>" class="info-input">
                </div>
                <div class="item">
                    <label class="info-text">密码:</label>
                    <input type="password" name="userPassword" autocomplete="off"  placeholder="密码" maxlength="20" value="<c:if test="${not empty user }">${user.userPassword }</c:if>" class="info-input">
                </div>
                 <div class="item">
                    <div class="info-line"></div>
                    <div class="info-btn-box">
                        <input type="submit" class="info-btn" value="提    交" onclick="return postManager();">
                    </div>
                </div>
        	</form>
        </div>
</div>
	<script src="<c:url value="/resources/js/alterManager.js"/>"></script>
	
</body>
</html>