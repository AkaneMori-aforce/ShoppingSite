<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<%@ page import="java.util.List" %>
<%@ page import="jp.co.aforce.bean.UserInfo" %>

<h2 style="text-align:center; margin-top:30px">会員情報</h2>

<% String last_name = (String)session.getAttribute("last_name"); %>
<% String first_name = (String)session.getAttribute("first_name"); %>
<% String birth_year = (String)session.getAttribute("birth_year"); %>
<% String birth_month = (String)session.getAttribute("birth_month"); %>
<% String birth_day = (String)session.getAttribute("birth_day"); %>
<% String email_address = (String)session.getAttribute("email_address"); %>
<% String phone_number = (String)session.getAttribute("phone_number"); %>
<% List<UserInfo> address_list = (List<UserInfo>)request.getAttribute("address_list"); %>

<div class="tab_contents_box">
<div class="tab-contents-div">

	<input id="tab_a" type="radio" name="tab_menu" checked>
	<label class="tab_menu" for="tab_a">基本情報</label>
	<input id="tab_b" type="radio" name="tab_menu">
	<label class="tab_menu" for="tab_b">お届け先住所</label>
	
	<div id="tab_a_content" class="tab_content">
		
		<div class="user-info-div">
			<div class="info-table-div">
				<a href="" class="linkbtn3"><i class="fa-solid fa-gear"></i></a>
				<table style="margin-left:5px; border-collapse:collapse">
					<tr bgcolor="#f5f5f5">
						<td width="150px">ID</td>
						<td width="250px"><%= user_id %></td>
					</tr>
					<tr>
						<td>お名前</td>
						<td><%= last_name %> <%= first_name %></td>
					</tr>
					<tr bgcolor="#f5f5f5">
						<td>生年月日</td>
						<td><%= birth_year %>年<%= birth_month %>月<%= birth_day %>日</td>
					</tr>
					<tr>
						<td>メールアドレス</td>
						<td><%= email_address %></td>
					</tr>
					<tr bgcolor="#f5f5f5">
						<td>電話番号</td>
					<td><%= phone_number %></td>
				</table>
			</div>
		</div>
		
	</div>
	
	<div id="tab_b_content" class="tab_content">
		
		<div class="user-info-div">
		<%--繰り返し--%>
			<c:choose>
				<c:when test="${address_list.size()>0}">
				<c:set var="address_number" value="${0}"/>
					<c:forEach var="address" items="${address_list}">
						<div class="address-table-div">
							<div class="address-info">
								<c:set var="address_number" value="${address_number + 1}"/>
								<b>お届け先<c:out value="${address_number}"/></b>
								<a href="" class="linkbtn2"><i class="fa-solid fa-pen"></i></a><br>
								
								〒${address.getPostCode()}<br>
								${address.getState()}
								${address.getCity()}
								${address.getAddressLine()}<br>
								${address.getReceiverLastName()} ${address.getReceiverFirstName()}</td>
							</div>
							<div>
								<form action="/ShoppingSite/jp.co.aforce.servlet/delete-address?id=${address.getAddressId()}" method="post" onClick="return delete_address_check()">
									<button type="submit" name="remove" id="cart-remove-btn"><i class="fa-solid fa-xmark"></i></button>
								</form>
							</div>
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
		
	</div>
	
</div>
</div>

<div class="next-btn-div" style="margin-bottom:15px">
	<botton type="button" class="back-btn" onclick="history.back()">戻る</botton>
</div>

<%@ include file="footer.jsp" %>
