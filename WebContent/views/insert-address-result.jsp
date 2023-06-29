<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<div style="text-align:center; margin:80px">

<%--登録成功--%>
<%String success_msg = (String)request.getAttribute("success");%>
<% if (success_msg != null) {%>
    <%= success_msg %><br>
<%} %>

<%--登録失敗--%>
<%String failure_msg = (String)request.getAttribute("failure");%>
<% if (failure_msg != null) {%>
    <%= failure_msg %><br>
<%} %>

</div>

<div class="top-btn-div">
	<a href="/ShoppingSite/views/mypage.jsp">
		<button type="button" class="next-btn">マイページへ</button>
	</a>
</div>

<%@ include file="footer.jsp" %>