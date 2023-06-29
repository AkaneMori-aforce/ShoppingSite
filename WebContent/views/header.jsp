<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<html>
<head>
<meta charset="UTF-8">
<%--js--%>
<script type="text/javascript" src="/ShoppingSite/js/script.js"></script>
<%--css--%>
<link rel="stylesheet" href="/ShoppingSite/css/style.css">
<%--fontawesome--%>
<link rel ="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<%--ロゴフォント--%>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poiret+One&display=swap" rel="stylesheet">
<%--h2フォント--%>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Zen+Kaku+Gothic+New:wght@700&display=swap" rel="stylesheet">
<title>meongmeong</title>
</head>
<div class="footerFixed">
<header class="user-header">
	<h1 class="headline">
    <a href="/ShoppingSite/views/top.jsp" class="logo" title="トップへ">meongmeong</a>
    </h1>
	<% String user_id = (String)session.getAttribute("user_id"); %>
	<nav class="header-nav">
	<ul class="header-list">
	<li class="header-item">
		<a href="/ShoppingSite/jp.co.aforce.servlet/product-all" class="linkbtn" title="検索">
    	<i class="fa-solid fa-magnifying-glass"></i>
    	</a>
    </li>
    
    <c:choose>
    	<c:when test="${user_id == null}">
    		<li class="header-item">
    			<a href="/ShoppingSite/views/user-login.jsp" class="linkbtn" title="ログイン">
    			<i class="fa-solid fa-right-to-bracket"></i>
    			</a>
    		</li>
    	</c:when>
    	<c:otherwise>
    		<li class="header-item">
    			<a href="/ShoppingSite/jp.co.aforce.servlet/user-logout" class="linkbtn" title="ログアウト" onClick="return logout_check()">
    			<i class="fa-solid fa-right-from-bracket"></i>
    			</a>
    		</li>
    	</c:otherwise>
    </c:choose>
    
    <li class="header-item">
    	<c:choose>
    		<c:when test="${user_id == null}"> 
    			<a href="/ShoppingSite/views/user-login.jsp" class="linkbtn" title="マイページ" onClick="return login_check()">
    		</c:when>
    		<c:otherwise>
    			<a href="/ShoppingSite/views/mypage.jsp" class="linkbtn" title="マイページ">
    		</c:otherwise>
    	</c:choose>
    	<i class="fa-solid fa-circle-user"></i>
    	</a>
    </li>
    
    <li class="header-item">
    	<c:choose>
    		<c:when test="${user_id == null}">
    			<a href="/ShoppingSite/views/user-login.jsp" class="linkbtn" title="カート" onClick="return login_check()">
    		</c:when>
    		<c:otherwise>
    			<a href="/ShoppingSite/views/cart.jsp" class="linkbtn" title="カート">
    		</c:otherwise>
    	</c:choose>
    	<i class="fa-solid fa-cart-shopping"></i>
    	</a>
    </li>
    </ul>
    </nav>
</header>
<body>
