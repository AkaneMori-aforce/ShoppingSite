<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<div id="user-login-div">

<h2 style="text-align:center; margin-top:30px" class="login-h2">ログイン</h2>

<form action="/ShoppingSite/jp.co.aforce.servlet/user-login" method="post" class="login-form">
<div class="user-login-item">
	<input type="text" name="user_id" placeholder="ID" required>
</div>
<div class="user-login-item">
	<input type="password" name="password" placeholder="password" required>
</div>
<%String msg = (String)request.getAttribute("failure"); %>
<% if (msg != null) {%>
    <font color="red" size="2px"><%= msg %></font>
<%} %>
<div class="user-login-btn-div">
	<input type="submit" value="LOG IN" class="user-login-btn">
</div>
</form>
<div class="user-login-footer">
<p><a href="">会員登録</a></p>
</div>
</div>

<%@ include file="footer.jsp" %>
