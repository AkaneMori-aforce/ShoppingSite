<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h2 style="text-align:center; margin-top:30px">カート</h2>

<c:choose>
	<c:when test="${cart.size()>0}">
		<table class="cart-table">
		
			<tr>
				<th width="80" >商品画像</th>
				<th width="180">商品名</th>
				<th width="60">単価</th>
				<th width="70">数量</th>
				<th width="70">小計</th>
				<th></th>
			</tr>
			<c:forEach var="item" items="${cart}">
			<tr class="item-cell">
				<td style="text-align:center; height:50px; width:50px">
					<a href="/ShoppingSite/jp.co.aforce.servlet/product-detail?id=${item.getProductInfo().getProductId()}">
						<img src="/ShoppingSite/img/${item.getProductInfo().getImgName()}" class="cart-img">
					</a>
				</td>
				<td>${item.getProductInfo().getProductName()}</td>
				<td style="text-align:right">${item.getProductInfo().getPrice()}円</td>
				<td style="text-align:center">
					<div id="count-div">
						<c:choose>
							<c:when test="${item.getItemCount() == 1}">
								<form action="/ShoppingSite/jp.co.aforce.servlet/cart-remove?id=${item.getProductInfo().getProductId()}" method="post" onClick="return cart_remove_check()">
								<button type="submit" name="minus" id="minus-btn"><i class="fas fa-minus-circle"></i></button>
								</form>
							</c:when>
							<c:otherwise>
								<form action="/ShoppingSite/jp.co.aforce.servlet/count-minus?id=${item.getProductInfo().getProductId()}" method="post">
								<button type="submit" name="minus" id="minus-btn"><i class="fas fa-minus-circle"></i></button>
								</form>
							</c:otherwise>
						</c:choose>
						${item.getItemCount()}
						<c:choose>
							<c:when test="${item.getItemCount() >= 5}">
								<button type="submit" name="plus" id="plus-btn" onClick="return count_check()"><i class="fas fa-plus-circle"></i></button>
							</c:when>
							<c:otherwise>
								<form action="/ShoppingSite/jp.co.aforce.servlet/count-plus?id=${item.getProductInfo().getProductId()}" method="post">
								<button type="submit" name="plus" id="plus-btn"><i class="fas fa-plus-circle"></i></button>
								</form>
							</c:otherwise>
						</c:choose>
					</div>
				</td>
				<td style="text-align:right">${item.getProductInfo().getPrice() * item.getItemCount()}円</td>
				<td>
					<form action="/ShoppingSite/jp.co.aforce.servlet/cart-remove?id=${item.getProductInfo().getProductId()}" method="post" onClick="return cart_remove_check()">
					<button type="submit" name="remove" id="cart-remove-btn"><i class="fa-solid fa-xmark"></i></button>
					</form>
				</td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="6" class="total-cell" style="text-align:right">
					<b>合計　 
						<c:set var="total" value="${0}"/>
						<c:forEach var="item" items="${cart}">
							<c:set var="total" value="${total + item.getProductInfo().getPrice() * item.getItemCount()}" />
						</c:forEach>
						<c:out value="${total}"></c:out>円
					</b>
			</td>
			</tr>
		</table>
		<div class="cart-botton-div">
		<button type="button" onclick="location.href='/ShoppingSite/jp.co.aforce.servlet/product-all'" class="go-shopping">
		買い物を続ける</button>
		<button type="button" onclick="location.href='/ShoppingSite/jp.co.aforce.servlet/purchase-select'" class="go-buy">
		購入手続きへ進む</button>
		</div>
	</c:when>
	<c:otherwise>
		<p style="text-align:center; margin-top:200px">カートに商品がありません</p>
	</c:otherwise>
</c:choose>



<%@ include file="footer.jsp" %>
