<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/ShoppingSite/css/style.css">
<title>Insert title here</title>
</head>
<body bgcolor="#f5f5f5">

<div class="admin-login-div">

<div class="admin-login-form-div">
<h2 style="margin-bottom:15px">管理者ログイン</h2>

<form action="/ShoppingSite/jp.co.aforce.servlet/admin-login" method="post">
<input type="text" name="admin_id" placeholder="ID" class="admin-login-form" required><br>
<input type="password" name="admin_password" placeholder="password" class="admin-login-form" required><br>
<%String msg = (String)request.getAttribute("failure"); %>
<% if (msg != null) {%>
    <font color="red"><%= msg %></font><br>
<%} %>
<input type="submit" style="margin-top:10px" value="ログイン">
</form>
</div>

</div>

</body>
</html>