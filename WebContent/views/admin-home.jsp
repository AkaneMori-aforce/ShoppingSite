<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="admin-header.jsp" %>

<div class="admin-info-div">

	<div class="admin-info-card-div">
		<div class="admin-div">
			<i class="fa-solid fa-user-tie" style="font-size:50px"></i>
			<h2>管理者</h2>
		</div>

<% String admin_id = (String)session.getAttribute("admin_id"); %>
<% String admin_name = (String)session.getAttribute("admin_name"); %>

		<div>
			管理者ID：<%= admin_id %><br>
			名前：<%= admin_name %>
		</div>
	</div>

<a href="/ShoppingSite/jp.co.aforce.servlet/admin-list">商品管理</a>

</div>

</body>
</html>