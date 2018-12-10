<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" %>
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
<title>ユーザ情報</title>
</head>
<body>
<nav class="#2e7d32 green darken-3">
    <div class="nav-wrapper">
      <a href="#!" class="brand-logo"><i class="large material-icons">store</i>勝時計店</a>
      <ul class="right hide-on-med-and-down">
        <li><a href="SearchServlet"><i class="material-icons">watch</i></a></li>
        <li><a href="UserdateDetailServlet"><i class="material-icons">account_circle</i></a></li>
        <li><a href="collapsible.html"><i class="material-icons">shopping_cart</i></a></li>
        <li><a href="NewuserServlet"><i class="material-icons">add</i></a></li>
        <li>${userInfo.user_name} さん </li>
     </ul>
    </div>
  </nav>
  <li class="right"><a href="LogoutServlet">ログアウト</a></li>
 <div class="container">

<h3 class="center">ユーザ削除確認</h3>
<div class="center">
ユーザ名:${userDate.user_name}<br>
を本当に削除してよろしいでしょうか。
</div>
<br>
<br>
<br>
		<div class="row">
		<form action="UserDateDeleteServlet?id=${userDate.id}" method="POST">
			<div class="col s6">
				<button class="btn  waves-effect waves-light  col s6 offset-s4"
					type="submit" name="action">OK</button>
			</div>
			</form>
			<form action="UserdateDetailServlet" method="POST">
			<div class="col s6">
				<button class="btn  waves-effect waves-light  col s6 offset-s4"
					type="submit" name="action">キャンセル</button>
			</div>
			</form>
	</div>
		</body>
</html>