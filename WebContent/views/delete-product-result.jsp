<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="admin-header.jsp" %>

<div style="text-align:center; margin:30px">

<%--削除成功--%>
<%String success_msg = (String)request.getAttribute("success");%>
<% if (success_msg != null) {%>
    <%= success_msg %><br>
<%} %>

<%--削除失敗--%>
<%String failure_msg = (String)request.getAttribute("failure");%>
<% if (failure_msg != null) {%>
    <%= failure_msg %><br>
<%} %>

<br>
<a href="/ShoppingSite/jp.co.aforce.servlet/admin-list">商品管理</a>

</div>

</body>
</html>