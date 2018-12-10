<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<title>買い物かご</title>
</head>
<body>
<nav class="#2e7d32 green darken-3">
    <div class="nav-wrapper">
      <a href="#!" class="brand-logo"><i class="large material-icons">store</i>勝時計店</a>
      <ul class="right hide-on-med-and-down">
        <li><a href="sass.html"><i class="material-icons">watch</i></a></li>
        <li><a href="badges.html"><i class="material-icons">account_circle</i></a></li>
        <li><a href="collapsible.html"><i class="material-icons">shopping_cart</i></a></li>
        <li><a href="collapsible.html"><i class="material-icons">add</i></a></li>
      </ul>
    </div>
  </nav>
 <div class="container">
<h3 class="center">買い物かご</h3>
<br>
<br>
 <div class="row">
		<div class="col s3">
		<div class="card">
		<div class="card-image">
		<a href="ItemDetailServlet?id=${item.id}"><img src="img/GW.jpg"height="400"></a>
		</div>
		</div>
			<div class="center">${item.itemName}</div>
			<div class="center">${item.price}円</div>
			<br>
			<button class="btn  waves-effect waves-light  col s6 offset-s4 center"
					type="submit" name="action">削除</button>
		</div>
		<div class="col s3">
		<div class="card">
		<div class="card-image">
		<a href="ItemDetailServlet?id=${item.id}"><img src="img/timex.jpg"height="400"></a>
		</div>
		</div>
			<div class="center">${item.itemName}</div>
			<div class="center">${item.price}円</div>
			<br>
			<button class="btn  waves-effect waves-light  col s6 offset-s4 center"
					type="submit" name="action">削除</button>
		</div>
		<div class="col s3">
		<div class="card">
		<div class="card-image">
		<a href="ItemDetailServlet?id=${item.id}"><img src="img/paulsmith2.jpg"height="400"></a>
		</div>
		</div>
			<div class="center">${item.itemName}</div>
			<div class="center">${item.price}円</div>
			<br>
			<button class="btn  waves-effect waves-light  col s6 offset-s4 center"
					type="submit" name="action">削除</button>
		</div>
				</div>
<br>
<br>
<br>
				<div class="col s4 left">
				<a class="waves-effect waves-light btn-large">買い物を続ける</a>
			</div>
				<div class="col s4 right">
				<a class="waves-effect waves-light btn-large"><i class="material-icons left">shopping_basket</i>購入手続きへ</a>
			</div>
</body>
</html>