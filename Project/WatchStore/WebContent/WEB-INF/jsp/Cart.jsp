<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="watch.css">
<title>買い物かご</title>
</head>
<body>
<jsp:include page="/base/header.jsp" />
 <div class="container">
 <div class="center font-size">${cartActionMessage}</div>
<h3 class="center">買い物かご</h3>
<br>
<br>
 <div class="row">
 	<c:forEach var="item" items="${cart}"  varStatus="status" >
		<div class="col s3">
		<div class="card">
		<div class="card-image he">
		<a href="ItemDetailServlet?id=${item.id}"><img src="img/${item.fileName}"></a>
		</div>
		</div>
			<div class="center">${item.itemName}</div>
			<div class="center"><fmt:formatNumber value="${item.price}" pattern="###,###" />円</div>
			<br>
			<form action="CartDeleteServlet?id=${item.id}" method="POST">
			<div class="col s12 center">
			<button class="btn  waves-effect waves-light  col s4"
					type="submit" name="action">削除</button></div>
		</div>
		</form>
		</c:forEach>
		</div>

<br>
<br>
<br>
	<div class="row">
		<div class="col s4 left">
			<a href="SearchServlet" class="waves-effect waves-light btn-large">買い物を続ける</a>
		</div>
		<div class="col s4 right">
			<a href="BuyConfirmServlet"
				class="waves-effect waves-light btn-large"><i
				class="material-icons left">shopping_basket</i>購入手続きへ</a>
		</div>
		</div>
		</div>
		<br>
	<br>
		<jsp:include page="/base/hooder.jsp" /></body>
</html>