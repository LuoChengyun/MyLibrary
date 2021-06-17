<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改出版社</title>
<%@ page language="java" import="java.lang.*"%>
<%String base="/MyLibrary/resources/"; %>
</head>
<link href="<%=base %>css/alter.css" type="text/css" rel="stylesheet">
<body>
<div class="container">
	<div class="box-title">
            <h1>出版社编辑</h1>
        </div>
        <div class="info-container">
        	<form method="GET" class="info-form" name="PublishmentForm" action="alterpublishment">
        		<div class="item">
                    <label class="info-text">出版社名:</label>
                    <input type="text" name="publishName" autocomplete="off"  placeholder="出版社名称" maxlength="20" value="<c:if test="${not empty publishment }">${publishment.publishName }</c:if>" class="info-input">
                </div>
                <div class="item">
                    <label class="info-text">出版社地址:</label>
                    <input type="text" name="publishLocal" autocomplete="off"  placeholder="出版社名称" maxlength="20" value="<c:if test="${not empty publishment }">${publishment.publishLocal }</c:if>" class="info-input">
                </div>
                <div class="item">
                    <div class="info-line"></div>
                    <div class="info-btn-box">
                        <input type="submit" class="info-btn" value="提    交" onclick="return postPublishment();">
                    </div>
                </div>
        	</form>
        </div>
</div>
	<script src="<c:url value="/resources/js/alterPublishment.js"/>"></script>
</body>
</html>