<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>提示</title>
<%@ page language="java" import="java.lang.*"%>
<%String base="/Mylibrary/resources/css/"; %>
</head>
<link href="<%=base %>tips.css" type="text/css" rel="stylesheet">
<body>

<div class="login-container">
  <a style="font-size:150%;" href="<c:url value="/" />">返回首页</a>   
<h2 class="tips"><c:out value="${tipMessage}" ></c:out></h2><br/><br/>
</div>
		
</body>
</html>