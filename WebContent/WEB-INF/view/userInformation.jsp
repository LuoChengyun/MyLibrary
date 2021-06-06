<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户信息</title>
</head>
<body style="background-color:beige">
<a href="<c:url value="/" />">返回首页</a>
<h1>个人信息</h1>
姓名:<c:out value="${user.userName }" ></c:out><br/><br/>
账号: <c:out value="${user.userAccount}"></c:out><br/><br/>
密码: <c:out value="${user.userPassword }" ></c:out><br/><br/>

</body>
</html>