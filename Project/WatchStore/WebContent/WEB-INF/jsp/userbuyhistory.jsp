<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<title>購入履歴</title>
</head>
<body>
<jsp:include page="/base/header.jsp" />
<div class="container">
		<div class="row center">
			<h4 class=" col s12 light">購入詳細</h4>
		</div>
		<!--  購入 -->
		<div class="row">
			<div class="col s10 offset-s1">
				<div class="card grey lighten-5">
					<div class="card-content">
						<table>
							<thead>
								<tr>
									<th class="center large">購入日時</th>
									<th class="center large">配送方法</th>
									<th class="center large" >合計金額</th>
								</tr>
							</thead>
							<tbody>
						<c:forEach var="buydate" items="${buyList}" >

								<tr>

									<td class="center large"><fmt:formatDate value="${buydate.buyDate}" pattern="yyyy年MM月dd日kk時mm分" /></td>
									<td class="center large">${buydate.deliveryMethodName}</td>
									<td class="center large"><fmt:formatNumber value="${buydate.totalPrice+buydate.deliveryMethodPrice}" pattern="###,###" />円</td>
								</tr>

								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<!-- 詳細 -->
		<div class="row">
			<div class="col s10 offset-s1">
				<div class="card grey lighten-5">
					<div class="card-content">
						<table class="bordered">
							<thead>
								<tr>
									<th class="center large">商品名</th>
									<th class="center large" style="width: 20%">単価</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="itemdate" items="${itemList}" >
								<tr>
									<td class="center large">${itemdate.itemName}</td>
									<td class="center large"><fmt:formatNumber value="${itemdate.price}" pattern="###,###" />円</td>
									</tr>
								</c:forEach>
								<c:forEach var="buydate" items="${buyList}" >
								<tr>

									<td class="center large">${buydate.deliveryMethodName}</td>
									<td class="center large">${buydate.deliveryMethodPrice}円</td>
								</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<br>
		<br>
		<jsp:include page="/base/hooder.jsp" />
	</body>
</html>