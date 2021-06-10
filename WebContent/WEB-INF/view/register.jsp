<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

<%@ page session="false" %>
<html>
  <head>
    <title>注册</title>
   <%@ page language="java" import="java.lang.*"%>
<%String base="/MyLibrary/resources/css/"; %>
  </head>
  <link href="<%=base %>register.css" type="text/css" rel="stylesheet">
  <body class="body">
  <div class="regbox">
  <div class="backhome">
  		<a class="backtext" href="/MyLibrary/loginpage">去登录</a>
  </div>
    <h1 class="title">注册</h1>
    <div class="logo"></div>
    <sf:form method="GET" commandName="user" action="/MyLibrary/user/register" class="login-form">
    <sf:errors path="*" cssClass="error"/><br/><br/>
    <div class="form-item">
        姓名:<sf:input path="userName" id="uname" placeholder="姓名" /><sf:errors path="userName" cssClass="error"/><br/>
    </div>
    <div class="form-item">
        账号:<sf:input path="userAccount" id="acct" placeholder="账号" /><sf:errors path="userAccount" cssClass="error"/><br/>
    </div>
    <div class="form-item">
        密码:<sf:input path="userPassword" id="pwd" placeholder="密码" /><sf:errors path="userPassword" cssClass="error"/><br/>
    </div>
    <input type="submit"  class="submit"  value="提 交" />
     <h3 class="logerror">${logined}</h3>
     </sf:form>
</div>
  </body>
</html>
