<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<jsp:include page="/base/header.jsp" />
 <div class="container">
<h5 class=" col s12 light">ユーザー情報</h5>

		<div class="row">
			<div class="col s12">
				<div class="card grey lighten-5">
					<div class="card-content">
						<form action="UserDateUpdateServlet" method="POST">

								<p class=" center-align">ユーザ情報</p>

							<br> <br>
							<div class="row">
								<div class="input-field col s6 large">
									<input type="text" name="user_name" value="${userDate.user_name}"> <label>名前</label>
									<input type="hidden" name="id" value="${userInfo.id}">
								</div>
								<div class="input-field col s6 large">
									<input type="text" name="birth_date" value="${userDate.birth_date}"> <label>生年月日</label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s12 large">
									<input type="text" name="address" value="${userDate.address}"> <label>住所</label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s6 large">
									<input type="password" name="pass" value=""> <label>パスワード</label>
								</div>
								<div class="input-field col s6 large">
									<input type="password" name="passk" value=""> <label>パスワード(確認)</label>
								</div>
							</div>
							<div class="row">
								<div class="col s12">
									<button class="btn-large  waves-effect waves-light  col s4 offset-s4" type="submit" name="action">更新</button>
								</div>
							</div>
						</form>
						<form action="DeleteConfirmServlet?id=${userDate.id}" method="POST">
						<div class="row">
								<div class="col s12">
									<button class="btn-large  waves-effect waves-light  col s4 offset-s4" type="submit" name="action">削除</button>
								</div>
							</div>
							</form>
					</div>
				</div>
			</div>
		</div>
		</div>
		<div class="row">
			<div class="col s12">
				<div class="card grey lighten-5">
					<div class="card-content">
						<table class="bordered">
							<thead>
								<tr>
									<th style="width: 10%"></th>
									<th class="center large">購入日時</th>
									<th class="center large">配送方法</th>
									<th class="center large">購入金額</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="buydate" items="${List}" >

								<tr>
									<td class="center large"><a href="UserBuyHistoryDetailServlet?id=${buydate.id}" class="btn-floating btn waves-effect waves-light "> <i class="material-icons">details</i></a></td>
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
	</div>
	<br>
		<br>
		<jsp:include page="/base/hooder.jsp" />
</body>
</html>