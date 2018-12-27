<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>割引登録完了</title>
</head>
<body>
<jsp:include page="/base/header.jsp" />
 <div class="container">

<h3 class="center">割引登録完了</h3>
<br>
<br>
<br>
		<div class="row">

			<div class="col s6">
				<a href ="NewSaleServlet" class="waves-effect waves-light btn col s6 offset-s4">引き続き登録する</a>
			</div>

			<div class="col s6">
				<a href ="SaleListServlet" class="waves-effect waves-light btn col s6 offset-s4">一覧に戻る</a>
			</div>

	</div>
	</div>
	<br>
		<br>
		<jsp:include page="/base/hooder.jsp" />
		</body>
</html>