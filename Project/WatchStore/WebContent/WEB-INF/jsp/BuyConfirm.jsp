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
<title>カートアイテム</title>
</head>
<body>
<jsp:include page="/base/header.jsp" />
 <div class="container">
<h3 class="center">カートアイテム</h3>
<form action="ConfirmServlet" method="post">

			<table class="bordered">
				<thead>
					<tr>
						<th class="center large" style="width: 20%">商品名</th>
						<th class="center large">単価</th>
						<th class="center large" style="width: 20%">小計</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${cart}">
						<tr>
							<td class="center large">${item.itemName}</td>
							<td class="center large">
							<c:if test="${item.sale!=null}">
									<fmt:formatNumber value="${item.saleprice}" pattern="###,###" />円
							</c:if>
			 				<c:if test="${item.sale==null}">
									<fmt:formatNumber value="${item.price}" pattern="###,###" />円
							</c:if>
							</td>
							<td class="center large">
							<c:if test="${item.sale!=null}">
									<fmt:formatNumber value="${item.saleprice}" pattern="###,###" />円
							</c:if>
			 				<c:if test="${item.sale==null}">
									<fmt:formatNumber value="${item.price}" pattern="###,###" />円
							</c:if>
							</td>
						</tr>
					</c:forEach>
					<tr>
						<td class="center"></td>
						<td class="center"></td>
						<td class="center large">
							<div class="input-field col s8 offset-s2 ">
								<select name="delivery_method_id">
									<c:forEach var="dmdb" items="${dmdbList}">
										<option value="${dmdb.id}">${dmdb.method}</option>
									</c:forEach>
								</select> <label>配送方法</label>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
			<br>
			<div class="row">
								<div class="col s12">
									<button class="btn-large  waves-effect waves-light  col s4 offset-s4" type="submit" name="action">購入確認</button>
								</div>
							</div>
							</form>
		</div>
		<br>
		<br>
		<jsp:include page="/base/hooder.jsp" />
		<script type="text/javascript">
			document.addEventListener('DOMContentLoaded', function() {
		    var elems = document.querySelectorAll('select');
		    var instances = M.FormSelect.init(elems);
		  });
		</script>
		</body>
</html>