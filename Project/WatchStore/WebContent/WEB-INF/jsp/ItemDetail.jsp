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

<title>商品詳細</title>
</head>
<body>
<jsp:include page="/base/header.jsp" />
 <div class="container">
<h3 class="center">商品詳細</h3>
<br>
<br>
		<div class="row">
		<div class="col s6">
		<div class="card">
		<div class="card-image">
		<img src="img/${itemDate.fileName}">
		</div>
		</div>
		</div>
		<div class="col s6">
			<h3 class="center">${itemDate.itemName}</h3>
			<br>
			<h4 class="center"><fmt:formatNumber value="${itemDate.price}" pattern="###,###" />円</h4>
			<br>
			<h5 class="center">${itemDate.detail}</h5>
			<br>
			<br>
			<br>
			<form action="ItemDetailServlet" method="POST">
						<input type="hidden" name="id" value="${itemDate.id}">
				<button class="center btn-large  waves-effect waves-light  col s4 offset-s4"
					type="submit" name="action">買い物かごに入れる</button>
					</form>
			</div>
</div>
</div>
<br>
		<br>
		<jsp:include page="/base/hooder.jsp" />
					</body>
</html>