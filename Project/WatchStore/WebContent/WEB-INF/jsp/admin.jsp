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

<title>管理用画面</title>
</head>
<body>
<jsp:include page="/base/header.jsp" />
<div class="container">
<h4>管理画面</h4>
<br>
<br>
<br>
<div class="row">
		<form action="ListServlet" method="GET">
			<div class="col s3">
				<button class="btn  waves-effect waves-light  col s6 offset-s4"
					type="submit" name="action">ユーザ一覧</button>
			</div>
			</form>
			<form action="ItemListServlet" method="GET">
			<div class="col s3">
				<button class="btn  waves-effect waves-light  col s6 offset-s4"
					type="submit" name="action">商品一覧</button>
			</div>
			</form>
			<form action="NewitemServlet" method="GET">
			<div class="col s3">
				<button class="btn  waves-effect waves-light  col s6 offset-s4"
					type="submit" name="action">商品登録</button>
			</div>
			</form>
			<form action="TopLoginServlet?id=${userInfo.id}" method="POST">
			<div class="col s3">
				<button class="btn  waves-effect waves-light  col s6 offset-s4"
					type="submit" name="action">Topページ</button>
			</div>
			</form>
	</div>
	</div>
</body>
</html>