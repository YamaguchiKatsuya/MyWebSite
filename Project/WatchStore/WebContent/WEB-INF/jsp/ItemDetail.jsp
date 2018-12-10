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

<title>商品詳細</title>
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
<h3 class="center">商品詳細</h3>
<br>
<div class="row">
<div class="col s4 right">
				<button class="btn  waves-effect waves-light  col s6 offset-s4"
					type="submit" name="action">買い物かごに入れる</button>
			</div>
			</div>
		<div class="row">
		<div class="col s6">
		<div class="card">
		<div class="card-image">
		<img src="img/${itemDate.fileName}">
		</div>
		</div>
		</div>
		<div class="col s6">
			<h4>${itemDate.itemName}</h4>
			<h5>${itemDate.price}</h5>
			<h6>${itemDate.detail}</h6>
			</div>
</div>
					</body>
</html>