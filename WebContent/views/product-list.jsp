<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="admin-header.jsp" %>

<%@ page import="java.util.List" %>
<%@ page import="jp.co.aforce.bean.ProductInfo" %>

<div class="admin-list-all-div">

<h2 style="margin-bottom:15px">商品管理</h2>

<button type="button" onclick="location.href='/ShoppingSite/views/regist-product.jsp'">
商品を登録</button>
<br>

<% List<ProductInfo> list = (List<ProductInfo>)request.getAttribute("list"); %>

<div class="admin-list-div">
<table border="1" class="admin-list-table">
	<tr height="40px" bgcolor="#dcdcdc">
		<th width="60px">商品ID</th>
		<th>商品画像</th>
		<th width="300px">商品名</th>
		<th width="90px">カテゴリー</th>
		<th width="70px">価格</th>
		<th width="360px">商品説明</th>
		<th width="40px">在庫</th>
		<th width="40px"></th>
	</tr>
<% if(list != null){ %>
	<%for(ProductInfo p : list){ %>
	<tr>
		<td><%=p.getProductId() %></td>
		<td>
			<div class="admin-img-div">
				<img src="/ShoppingSite/img/<%= p.getImgName() %>" class="admin-img">
			</div>
		</td>
		<td align="left" style="padding-left:15px"><%=p.getProductName() %></td>
		<td>
			<% if(p.getCategory().equals("100")){ %>
				ごはん
			<%}else if(p.getCategory().equals("200")){ %>
				おやつ
			<%}else if(p.getCategory().equals("300")){ %>
				おもちゃ
			<%}else if(p.getCategory().equals("400")){ %>
				犬具
			<%}else if(p.getCategory().equals("500")){ %>
				ベッド
			<%}else if(p.getCategory().equals("600")){ %>
				日用品
			<%} %>
		</td>
		<td><%=p.getPrice() %>円</td>
		<td align="left" style="padding:0 15px"><%=p.getDescription() %></td>
		<td><% if(p.getStock() > 0) {%>〇<%}else if(p.getStock() == 0) {%>×<%} %>
		</td>
		<td>
			<form method="post" action="/ShoppingSite/jp.co.aforce.servlet/update-product-detail?id=<%=p.getProductId() %>">
    			<input type="submit" name="edit" value="編集"><br>
    		</form>
    		<form method="post" action="/ShoppingSite/jp.co.aforce.servlet/delete-product?id=<%=p.getProductId() %>" onClick="return product_delete_check()">
    			<input type="submit" name="delete" value="削除">
    		</form>
    	</td>
	</tr>
	<%} %>
<%} %>
</table>
</div>

</div>

</body>
</html>
