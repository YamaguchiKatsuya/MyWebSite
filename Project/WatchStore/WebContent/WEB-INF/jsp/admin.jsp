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
<nav class="#2e7d32 green darken-3">
    <div class="nav-wrapper">
      <a href="TopLoginServlet?id=${userInfo.id}" class="brand-logo"><i class="large material-icons">store</i>勝時計店</a>
      <ul class="right hide-on-med-and-down">
        <li><a href="SearchServlet"><i class="material-icons">watch</i></a></li>
        <c:if test="${userInfo==null}" >
        <li><a href="LoginServlet"><i class="material-icons">vpn_key</i></a></li>
        </c:if>
        <c:if test="${userInfo!= null}" >
        <li><a href="UserdateDetailServlet?id=${userInfo.id}"><i class="material-icons">account_circle</i></a></li>
        </c:if>
        <li><a href="collapsible.html"><i class="material-icons">shopping_cart</i></a></li>
        <li><a href="NewuserServlet"><i class="material-icons">add</i></a></li>
        <c:if test="${userInfo!= null}" >
        <li>${userInfo.user_name} さん </li>
        </c:if>
     </ul>
    </div>
  </nav>
  <li class="right"><a href="LogoutServlet">ログアウト</a></li>
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