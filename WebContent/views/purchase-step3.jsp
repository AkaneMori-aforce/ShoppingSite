<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<%@ page import="java.util.List" %>
<%@ page import="jp.co.aforce.bean.UserInfo" %>

<% List<UserInfo> address_list = (List<UserInfo>)request.getAttribute("address_list"); %>

<ol class="timeline">
    <li class="prev">step1</li>
    <li class="prev">step2</li>
    <li class="current">step3</li>
</ol>

<h2 class="purchase-h2">ご注文ありがとうございます</h2>

<div class="purchase-finalize-div">

	<div class="purchase-finalize-table-div">
		<table class="purchase-finalize-table">
			<tr>
				<td style="padding:0 0 5px 10px">ご購入内容</td>
			</tr>
			<c:forEach var="item" items="${cart}">
				<tr class="purchase-tr-top">
					<td colspan="2" width="400px"  style="padding:5px 10px 0 10px">
						${item.getProductInfo().getProductName()}
					</td>
				<tr>
					<td colspan="2" style="padding-left:10px">1点 ${item.getProductInfo().getPrice() * item.getItemCount()}円</td>
				</tr>
				<tr class="purchase-tr-bottom">
					<td style="padding:0 0 5px 10px">数量：${item.getItemCount()}</td>
					<td align="right" style="padding:0 10px 5px 0">小計　${item.getProductInfo().getPrice() * item.getItemCount()}円</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="2" align="right" class="purchase-total" style="padding:10px"">
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
	</div>

</div>

<c:remove var="cart" scope="session" />

<div class="top-btn-div">
	<a href="/ShoppingSite/views/top.jsp">
		<button type="button" class="next-btn">トップへ</button>
	</a>
</div>

<%@ include file="footer.jsp" %>
