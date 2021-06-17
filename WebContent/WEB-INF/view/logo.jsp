<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>logo</title>
<%@ page language="java" import="java.lang.*"%>
<%String base="/MyLibrary/resources/css/"; %>
</head>
<link href="<%=base %>logo.css" type="text/css" rel="stylesheet">
<body>
<div class="nav">
	<h1>Welcome  Administrator: ${sessionScope.user.userAccount }</h1>
</div>
</body>
</html> 