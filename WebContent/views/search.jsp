<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<%@ page import="java.util.List" %>
<%@ page import="jp.co.aforce.bean.ProductInfo" %>

<h2 style="text-align:center; margin-top:30px">商品検索</h2>

<form action="/ShoppingSite/jp.co.aforce.servlet/search" method="post">
<input type="text" name="product_keyword" placeholder="キーワード検索" id="search_box" autocomplete="off">
<button type="submit" name="search" id="search_btn"><i class="fa-solid fa-magnifying-glass"></i></button>
<div id="sort-div">
カテゴリー <select name="category">
	<option value="">未選択</option>
	<option value="100">ごはん</option>
	<option value="200">おやつ</option>
	<option value="300">おもちゃ</option>
	<option value="400">犬具</option>
	<option value="500">ベッド</option>
	<option value="600">日用品</option>
</select>
　並び替え <select name="sort">
	<option value="new_sort">新着順</option>
	<option value="row_sort">安い順</option>
	<option value="high_sort">高い順</option>
</select>
</div>
</form>

<% List<ProductInfo> list = (List<ProductInfo>)request.getAttribute("list"); %>
<div id="p_all_list">
<% if(list != null){ %>
	<%for(ProductInfo p : list){ %>
	<div class="p_list">
		<a href="/ShoppingSite/jp.co.aforce.servlet/product-detail?id=<%= p.getProductId() %>" style="text-decoration: none">
			<div class="search_img_div">
			<img src="/ShoppingSite/img/<%= p.getImgName() %>" class="search_img">
			</div>
			<p style="padding-top:10px"><%=p.getProductName() %></p>
		</a>
		<p><font color="#ef4868"><%=p.getPrice() %>円</font></p>
	</div>
	<%} %>
<%} %>

<% String failure_msg = (String)request.getAttribute("failure"); %>
<% if(failure_msg != null) {%>
	<%= failure_msg %>
<%} %>

</div>

<%@ include file="footer.jsp" %>
