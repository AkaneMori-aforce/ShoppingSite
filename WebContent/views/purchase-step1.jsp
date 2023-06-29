<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<%@ page import="java.util.List" %>
<%@ page import="jp.co.aforce.bean.AddressInfo" %>

<% List<AddressInfo> address_list = (List<AddressInfo>)request.getAttribute("address_list"); %>
<% String msg = (String)request.getAttribute("not_select"); %>

<ol class="timeline">
    <li class="current">step1</li>
    <li>step2</li>
    <li>step3</li>
</ol>

<h2 class="purchase-h2">ご注文手続き</h2>

<div class="purchase-select-div">
<%--<h2 style="text-align:center; margin-bottom:20px">注文</h2>--%>

	<form action="/ShoppingSite/jp.co.aforce.servlet/confirm" method="post">
	<div class="address-all-div">
		<h3 style="text-align:center">お届け先</h3>
		<%if(msg != null) {%>
			<font color="red"><%= msg %></font>
		<%} %>
		<c:choose>
			<c:when test="${address_list.size()>0}">
			<c:set var="address_number" value="${0}"/>
				<c:forEach var="address" items="${address_list}">
					<div class="address-select-div">
					<input type="radio" name="address_select" value="${address.getAddressId()}" required>
						<div class="address-div">
							<p><c:set var="address_number" value="${address_number + 1}"/>
							お届け先<c:out value="${address_number}"/></p>
							<p>〒${address.getPostCode()}</p>
							<p>${address.getState()} ${address.getCity()}
							${address.getAddressLine()}</p>
							<p font-size="20px">${address.getReceiverLastName()} 
							${address.getReceiverFirstName()}</p>
						</div>
					<a href="" class="linkbtn2"><i class="fa-solid fa-pen"></i></a>
					</div>
				</c:forEach>
			</c:when>
		</c:choose>
		<a href="/ShoppingSite/views/insert-address.jsp" class="add-address">
			<div class="add-address-div">
				<i class="fa-solid fa-plus"></i>新規お届け先を追加
			</div>
		</a>
	</div>

	<div class="payment-select-div">
		<h3 style="text-align:center">お支払い方法</h3>
		<div><input type="radio" name="payment" value="クレジットカード" checked>クレジットカード</div>
		<div><input type="radio" name="payment" value="銀行振込">銀行振込</div>
		<div><input type="radio" name="payment" value="代金引換">代金引換</div>
	</div>

	<div class="next-btn-div">
		<button type="button" class="back-btn" onclick="history.back()">戻る</button>
		<input type="submit" value="次へ" class="next-btn"></button>
	</div>
	</form>
	
</div>

<%@ include file="footer.jsp" %>
