<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="admin-header.jsp" %>

<div class="product-admin-div">
<h2>商品登録</h2>

<div width="500px">
<form action="/ShoppingSite/jp.co.aforce.servlet/regist-product" method="post" enctype="multipart/form-data">
<ul>
<li>商品名</li>
<input type="text" name="product_name" required><br>
<li>商品画像をアップロード</li>
<input type="file" name="img_file" accept="image/*" required><br>
<li>商品画像名前<li>
<input type="text" name="img_name" required><br>
<li>カテゴリ</li>
<select name="category" required>
	<option value="">--</option>
	<option value="100">ごはん</option>
	<option value="200">おやつ</option>
	<option value="300">おもちゃ</option>
	<option value="400">犬具</option>
	<option value="500">ベッド</option>
	<option value="600">日用品</option>
</select>
<li>商品価格</li>
<input type="text" name="price" pattern="^[1-9][0-9]*$" required><br>
<li>在庫</li>
<input type="text" name="stock" pattern="^[0-9]*$" required><br>
<li>商品説明</li>
<textarea name="description"></textarea >
</ul>
<input type="submit" value="登録" style="margin-top:10px" onClick="return product_regist_check()">
</form>

<br>
<button type="button" onclick="history.back()">戻る</button>
</div>

</div>

</body>
</html>
