<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>トップページ</title>

</head>
<body>
<jsp:include page="/base/header.jsp" />
 <div class="container">
<h3 class="center">勝時計店</h3>
<br>
<div class="center font-size">勝時計店は、世界各国の時計を取り扱っている小売店です。</div>
<br>
<div class="center font-size">取り扱いブランドは変更することがございます。</div>
<br>
<div class="center font-size">是非、ご自身に合う最高の一本を探してみてください。</div>
<br>
<br>

<br>
<br>
<h4 class="center">おすすめ商品</h4>
<br>
<div class="row">
<div class="col s4">
		<div class="card">
		<div class="card-image he">
		<a href="ItemDetailServlet?id=5">
		<img class="width height" src="img/1545293672750timex1.jpg" alt=""></a>
		</div>
		</div>
		</div>
<div class="col s4">
		<div class="card">
		<div class="card-image he">
		<a href="ItemDetailServlet?id=1">
		<img class="width height" src="img/1545293714291gucci.jpg" alt=""></a>
		</div>
		</div>
		</div>
<div class="col s4">
		<div class="card">
		<div class="card-image he">
		<a href="ItemDetailServlet?id=4">
		<img class="width height" src="img/1545293681217GW.jpg" alt=""></a>
		</div>
		</div>
		</div>
		</div>
<br>
<br>
<br>
<h4 class="center">取り扱いブランド</h4>
<br>
<div class="row">
 <c:forEach var="brand" items="${brandList}" >
 		<div class="col s4">
		<div class="card">
		<div class="card-image he2">
		<a href="BrandServlet?id=${brand.id}">
		<img class="width height" src="img/${brand.fileName}" alt="${brand.brandName}">
		</div>
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