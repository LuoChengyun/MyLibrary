<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改作者</title>
<%@ page language="java" import="java.lang.*"%>
<%String base="/MyLibrary/resources/"; %>
</head>
<link href="<%=base %>css/alter.css" type="text/css" rel="stylesheet">
<body>
<div class="container">
	<div class="box-title">
            <h1>作者编辑</h1>
        </div>
        <div class="info-container">
        	<form method="GET" class="info-form" name="AuthorForm" action="alterauthor">
        		<div class="item">
                    <label class="info-text">作者名:</label>
                    <input type="text" name="authorName" autocomplete="off"  placeholder="作者姓名" maxlength="20" value="<c:if test="${not empty author }">${author.authorName }</c:if>" class="info-input">
                </div>
                <%-- <div class="item">
                    <label class="info-text">作者性别:</label>
                    <input type="text" name="authoSex" autocomplete="off"  placeholder="作者姓名" maxlength="20" value="<c:if test="${not empty author }">${author.authorSex eq 0 ? '男':author.authorSex eq 1 ? '女':'' }</c:if>" class="info-input">
                </div> --%>
                <div class="item">
                	 <label class="info-text">作者性别:</label>
                	 <select name="authorSex">
                	 	<option value="0" <c:if test="${'0' eq author.authorSex}">selected</c:if> >男</option>
						<option value="1" <c:if test="${'1' eq author.authorSex}">selected</c:if> >女</option>
                	 </select>
                </div>
                <div class="item">
                    <label class="info-text">作者简介:</label>
                    <input type="text" name="authorIntroduct" autocomplete="off"  placeholder="作者简介" maxlength="20" value="<c:if test="${not empty author }">${author.authorIntroduct }</c:if>" class="info-input">
                </div>
                <div class="item">
                    <div class="info-line"></div>
                    <div class="info-btn-box">
                        <input type="submit" class="info-btn" value="提    交" onclick="return postAuthor();">
                    </div>
                </div>
        	</form>
        </div>
</div>
	<script src="<c:url value="/resources/js/alterAuthor.js"/>"></script>
</body>
</html>