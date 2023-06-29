<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="admin-header.jsp" %>

<% String product_id = (String)request.getAttribute("product_id"); %>
<% String product_name = (String)request.getAttribute("product_name"); %>
<% String category = (String)request.getAttribute("category"); %>
<% String price = (String)request.getAttribute("price"); %>
<% int stock = (Integer)request.getAttribute("stock"); %>
<% String description = (String)request.getAttribute("description"); %>
<% String img_name = (String)request.getAttribute("img_name"); %>

<div class="product-admin-div">
<h2>商品情報編集</h2>

<div>
<form action="/ShoppingSite/jp.co.aforce.servlet/update-product" method="post" enctype="multipart/form-data">
<ul>
<li>商品ID</li>
<input type="text" name="product_id" value="<%= product_id %>" class="noedit" readonly><br>
<li>商品名</li>
<input type="text" name="product_name" value="<%= product_name %>" required><br>
<li>商品画像をアップロード</li>
<input type="file" name="img_file" accept="image/*"><br>
<li>商品画像名前<li>
<input type="text" name="img_name" value="<%= img_name %>" required><br>
<li>カテゴリ</li>
<select name="category" required>
	<option value="100" <%if(category.equals("100")){%>selected<%} %>>ごはん</option>
	<option value="200" <%if(category.equals("200")){%>selected<%} %>>おやつ</option>
	<option value="300" <%if(category.equals("300")){%>selected<%} %>>おもちゃ</option>
	<option value="400" <%if(category.equals("400")){%>selected<%} %>>犬具</option>
	<option value="400" <%if(category.equals("500")){%>selected<%} %>>ベッド</option>
	<option value="400" <%if(category.equals("600")){%>selected<%} %>>日用品</option>
</select>
<li>商品価格</li>
<input type="text" name="price" pattern="^[1-9][0-9]*$" value="<%= price %>" required><br>
<li>在庫</li>
<input type="text" name="stock" pattern="^[1-9][0-9]*$" value="<%= stock %>" required><br>
<li>商品説明</li>
<textarea name="description"><%= description %></textarea >
</ul>
<input type="submit" name="regist" value="更新" onClick="return product_update_check()">
</form>

<br>
<button type="button" onclick="history.back()">戻る</button>
</div>
</div>

</body>
</html>
