<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<ol class="timeline">
    <li class="prev">step1</li>
    <li class="current">step2</li>
    <li>step3</li>
</ol>

<h2 class="purchase-h2">ご注文内容の確認</h2>

<% String post_code = (String)request.getAttribute("post_code"); %>
<% String state = (String)request.getAttribute("state"); %>
<% String city = (String)request.getAttribute("city"); %>
<% String address_line = (String)request.getAttribute("address_line"); %>
<% String last_name = (String)request.getAttribute("receiver_last_name"); %>
<% String first_name = (String)request.getAttribute("receiver_first_name"); %>
<% String payment = (String)request.getAttribute("select_payment"); %>

<div class="purchase-comfirm-div">

	<div class="purchase-cart-div">
		<table class="purchase-cart-table">
			<tr>
				<th colspan="2" height="35px">商品</th>
				<th width="90px">単価</th>
				<th width="60px">数量</th>
				<th width="90px">小計</th>
			</tr>
			<c:forEach var="item" items="${cart}">
				<tr class="purchase-cart-item">
					<td style="padding:5px 0 5px 10px">
						<div class="purchase-img-div" >
							<img src="/ShoppingSite/img/${item.getProductInfo().getImgName()}" class="purchase-img"> 
						</div>
					</td>
					<td width="300px" style="padding-left:20px">
						${item.getProductInfo().getProductName()}
					</td>
					<td align="center">${item.getProductInfo().getPrice()}円</td>
					<td align="center">${item.getItemCount()}</td>
					<td align="right" style="padding-right:10px">${item.getProductInfo().getPrice() * item.getItemCount()}円</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5" align="right" class="purchase-total" style="padding:10px"">
					<b>お支払い金額　
						<c:set var="total" value="${0}"/>
						<c:forEach var="item" items="${cart}">
							<c:set var="total" value="${total + item.getProductInfo().getPrice() * item.getItemCount()}" />
						</c:forEach>
						<c:out value="${total}"></c:out>円
					</b>
				</td>
			</tr>
		</table>
	</div>
	
	<div class="purchase-info-div">
		<div>
		<table class="purchase-address-table">
			<tr>
				<th width="400px" height="35px">お届け先</th>
			</tr>
			<tr>
				<td style="padding:10px">
					〒<%= post_code %><br>
					<%= state %>
					<%= city %>
					<%= address_line %><br>
					<%= last_name %> 
					<%= first_name %>
				</td>
			</tr>
		</table>
		</div>
		<div>
		<table class="purchase-payment-table">
			<tr>
				<th width="180px" height="35px">お支払い方法</th>
			</tr>
			<tr>
				<td style="padding:10px" align="center"><%= payment %></td>
			</tr>
		</table>
		</div>
	</div>

</div>



<div class="next-btn-div">
	<button type="button" class="back-btn" onclick="history.back()">戻る</button>
	<a href="/ShoppingSite/views/purchase-step3.jsp">
		<button type="button" class="next-btn" onClick="return confirm_check()">注文を確定する</button>
	</a>
</div>



<%@ include file="footer.jsp" %>
