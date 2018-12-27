<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" %>
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
<title>検索画面</title>
</head>
<body>
<jsp:include page="/base/header.jsp" />
 <div class="container">
<h2 class="center">${date.brandName}</h2>
<br>
  <div class="row">
  <c:forEach var="item" items="${brand}" >
		<div class="col s3">
		<div class="card">
		<div class="card-image he">
		<a href="ItemDetailServlet?id=${item.id}"><img src="img/${item.fileName2}"class="photo slideheight"></a>
		</div>
		</div>
			<div class="center font-size">${item.itemName}</div>
			<div class="center font-size">
			<fmt:formatNumber value="${item.price}" pattern="###,###" />円<br>
			<c:if test="${item.sale!=null}" >
			→<fmt:formatNumber value="${item.saleprice}" pattern="###,###" />円
			</c:if>
			</div>
		</div>
				</c:forEach>
				</div>
</div>
<br>
		<br>
		<jsp:include page="/base/hooder.jsp" />


</body>
</html>