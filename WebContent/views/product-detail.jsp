<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<% String product_id = (String)request.getAttribute("product_id"); %>
<% String product_name = (String)request.getAttribute("product_name"); %>
<% String category = (String)request.getAttribute("category"); %>
<% String price = (String)request.getAttribute("price"); %>
<% int stock = (Integer)request.getAttribute("stock"); %>
<% String description = (String)request.getAttribute("description"); %>
<% String img_name = (String)request.getAttribute("img_name"); %>

<div class="detail-div">
<div id="detail-img-div">
		<img src="/ShoppingSite/img/<%= img_name %>" class="detail_img"></td>
</div>
<div id="detail-form-div">
	<c:choose>
	<c:when test="${user_id == null}">
		<form action="/ShoppingSite/views/user-login.jsp" onClick="return login_check()">
	</c:when>
	<c:otherwise>
		<form action="/ShoppingSite/jp.co.aforce.servlet/cart-add?id=<%= product_id %>" method="post">
	</c:otherwise>
	</c:choose>
	<h2><%= product_name %></h2>
	<span class="detail-category">
	<c:choose>
		<c:when test="${category == \"100\"}">
			ごはん
		</c:when>
		<c:when test="${category == \"200\"}">
			おやつ
		</c:when>
		<c:when test="${category == \"300\"}">
			おもちゃ
		</c:when>
		<c:when test="${category == \"400\"}">
			犬具
		</c:when>
		<c:when test="${category == \"500\"}">
			ベッド
		</c:when>
		<c:when test="${category == \"600\"}">
			日用品
		</c:when>
	</c:choose>
	</span><br>
	<p style="margin-top:10px"><font color="#ef4868"><%= price %>円</font></p>
	<p style="margin-top:10px; font-size:14px"><%= description %></p>
	<div class="add-count-div">
	<span style="font-size:13px">数量</span>
	<select name="cartcount">
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		<option value="4">4</option>
		<option value="5">5</option>
	</select>
	<font size="1" color="#948779">※おひとり様5個まで</font>
	</div>
	<div class="cart-add-btn-div">
	<% if(stock > 0) {%>
		<input type="submit" name="in_cart" value="カートに入れる" class="cart-add-btn">
	<%} else if(stock == 0) { %>
		<input type="submit" name="in_cart" value="売り切れ" class="soldout-btn" disabled>
	<%} %>
	</div>
</div>
</form>
</div>

<div class="back-search-div">
<button type="button" onclick="location.href='/ShoppingSite/jp.co.aforce.servlet/product-all'" class="back-search-btn">戻る</button>
</div>

<%@ include file="footer.jsp" %>
