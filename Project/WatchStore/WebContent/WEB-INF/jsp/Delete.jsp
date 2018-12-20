<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" %>
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
<title>ユーザ情報</title>
</head>
<body>
<jsp:include page="/base/header.jsp" />
 <div class="container">

<h3 class="center">ユーザ削除確認</h3>
<div class="center">
ユーザ名:${userDate.user_name}<br>
を本当に削除してよろしいでしょうか。
</div>
<br>
<br>
<br>
		<div class="row">
		<form action="UserDateDeleteServlet?id=${userDate.id}" method="POST">
			<div class="col s6">
				<button class="btn  waves-effect waves-light  col s6 offset-s4"
					type="submit" name="action">OK</button>
			</div>
			</form>
			<form action="UserdateDetailServlet?id=${userDate.id}" method="POST">
			<div class="col s6">
				<button class="btn  waves-effect waves-light  col s6 offset-s4"
					type="submit" name="action">キャンセル</button>
			</div>
			</form>
	</div>
	</div>
	<br>
		<br>
		<jsp:include page="/base/hooder.jsp" />
		</body>
</html>