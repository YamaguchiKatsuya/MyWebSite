<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>購入完了</title>
</head>
<body>
<jsp:include page="/base/header.jsp" />
 <div class="container">
<h4 class="center">購入が完了しました</h4>
<br>
<div class="col s4 left">
				<a href="SearchServlet" class="waves-effect waves-light btn-large">買い物を続ける</a>
			</div>
				<div class="col s4 right">
				<a href="UserdateDetailServlet?id=${userInfo.id}" class="waves-effect waves-light btn-large">ユーザ情報へ</a>
			</div>
			<br>
<h4 class="center">購入詳細</h4>

			<table class="bordered">
				<thead>
					<tr>
						<th class="center large">購入日時</th>
						<th class="center large">配送方法</th>
						<th class="center large">合計金額</th>
					</tr>
				</thead>
				<tbody>
						<tr>
							<td class="center large">${resultBDB.buyDate}</td>
							<td class="center large">${userSelectDMB.method}</td>
							<td class="center large"><fmt:formatNumber value="${totalPrice+userSelectDMB.price}" pattern="###,###" />円</td>
						</tr>
						</tbody>
			</table>
<br>
<br>
						<div class="row">
			<table class="bordered">
				<thead>
					<tr>
						<th class="center large">商品名</th>
						<th class="center large">単価</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${cart}">
						<tr>
							<td class="center large">${item.itemName}</td>
							<td class="center large"><fmt:formatNumber value="${item.price}" pattern="###,###" /></td>
						</tr>
					</c:forEach>
					<tr>
							<td class="center large">${userSelectDMB.method}</td>
							<td class="center large">${userSelectDMB.price}円</td>
						</tr>
						</tbody>
			</table>
			</div>
			</div>
<br>
		<br>
		<jsp:include page="/base/hooder.jsp" />
</body>
</html>