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
<title>購入確認</title>
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
<h3 class="center">購入確認</h3>
<form action="BuyResultServlet?id=${userSelectDMB.id}" method="post">
		<div class="row">
			<table class="bordered">
				<thead>
					<tr>
						<th class="center" style="width: 20%">商品名</th>
						<th class="center">単価</th>
						<th class="center" style="width: 20%">小計</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${cart}">
						<tr>
							<td class="center">${item.itemName}</td>
							<td class="center">${item.price}円</td>
							<td class="center">${item.price}円</td>
						</tr>
					</c:forEach>
					<tr>
							<td class="center">${userSelectDMB.method}</td>
							<td class="center"></td>
							<td class="center">${userSelectDMB.price}円</td>
						</tr>
					<tr>
							<td class="center"></td>
							<td class="center">合計</td>
							<td class="center">${totalPrice+userSelectDMB.price}円</td>
						</tr>
				</tbody>
			</table>
			<br>
			<div class="row">
								<div class="col s12">
									<button class="btn  waves-effect waves-light  col s4 offset-s4" type="submit" name="action">購入</button>
								</div>
							</div>
							</form>
		</div>
</body>
</html>