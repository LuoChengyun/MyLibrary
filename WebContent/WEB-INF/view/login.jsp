<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
  <head>
    <title>登录界面</title>
    <%@ page language="java" import="java.lang.*"%>
<%String base="/MyLibrary/resources/css/"; %>
  </head>
  <link href="<%=base %>login.css" type="text/css" rel="stylesheet">
  <body>
 <div class="dowebox">
  <h1 class="title">账号密码登录</h1>
  <h3 class="logerror">${logined}</h3>
  <div class="logo"></div>
  <form method="GET" class="login-form" action="login" >
  <div class="form-item">
    <input id="username" type="text" name="account" autocomplete="off" placeholder="账号">
  </div>
  <div class="form-item">
    <input id="password" type="password" name="password" autocomplete="off" placeholder="密码">
  </div>
  <div class="sel-bar">
    <select class="choose" >
      <option value="用户">用户</option>
      <option value="管理员">管理员</option>
    </select>
  </div>
  <div class="form-item"><button id="submit">登 录</button></div>
  </form>
  <div class="reg-bar">
    <a href="<c:url value="/user/registerpage" />" class="reg">注册</a>
    <a class="forget" href="index.html">忘记密码</a>
  </div>
</div>
  </body>
</html>
