<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h2 style="text-align:center; margin-top:30px">マイページ</h2>
<div class="mypage-div">
	<i class="fa-solid fa-circle-user" style="font-size:100px; margin-bottom:5px; color:#4c444d"></i>
	<br><%= user_id %>
</div>

<div class="mypage-btn-div">
	<button type="button" onclick="location.href='/ShoppingSite/jp.co.aforce.servlet/user-information'" class="user-info-btn">
		<i class="fas fa-address-book" style="font-size:25px; margin-bottom:5px"></i><br>会員情報
	</button>
	<button type="button" onclick="location.href=''" class="purchase-history-btn">
		<i class="fas fa-shopping-bag" style="font-size:25px; margin-bottom:5px"></i><br>購入履歴
	</button>
</div>

<div class="user-delete">
<p><a href="">退会</a></p>
</div>

<%@ include file="footer.jsp" %>
