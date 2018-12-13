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
<title>検索画面</title>
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
<h3 class="center">商品検索</h3>
<br>
<form action="SearchServlet" method="post">
<div class="row">
    <div class="col s12">
      <div class="row">
        <div class="input-field col s12">
          <i class="material-icons prefix">search</i>
          <input type="text" name="search_word" class="autocomplete">
          <label for="autocomplete-input">商品名など</label>
        </div>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col s12">
        <div class="input-field col s5">
          <i class="material-icons prefix">attach_money</i>
          <input type="text" name="price1" class="autocomplete">
          <label for="autocomplete-input">値段</label>
        </div>
		<div class="col s2">
		～
		</div>
        <div class="input-field col s5">
          <input type="text" name="price2" class="autocomplete">
          <label for="autocomplete-input">値段</label>
        </div>
        </div>
        </div>


  <div class="col s4 right">
				<button class="btn  waves-effect waves-light  col s8 offset-s4"
					type="submit" name="action">検索</button>
			</div>
</form>

  <br>
  <br>
  <div class="row">
  <c:forEach var="item" items="${itemList}" >
		<div class="col s3">
		<div class="card">
		<div class="card-image">
		<a href="ItemDetailServlet?id=${item.id}"><img src="img/${item.fileName}"class="searchheight"></a>
		</div>
		</div>
			<div class="center large">${item.itemName}</div>
			<div class="center large">${item.price}円</div>
		</div>
				</c:forEach>
				</div>
</div>



</body>
</html>