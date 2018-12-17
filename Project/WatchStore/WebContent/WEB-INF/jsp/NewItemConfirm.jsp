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
<title>入力内容確認</title>
</head>
<body>
<jsp:include page="/base/header.jsp" />
<div class="container">
<h4>入力内容確認</h4>
<br>
<br>
<form name=MyForm action="NewItemConfirmServlet" method="POST">
<div class="row">
        <div class="input-field col s12">
          <input value="${i.itemName}" name="item_name" type="text" class="validate" readonly>
          <label for="disabled">商品名</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <input readonly value="${i.detail}" name="detail" type="text" class="validate">
          <label for="disabled">詳細</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <input readonly value="${i.price}" name="price" type="text" class="validate">
          <label for="disabled">値段</label>
        </div>
      </div>
       <div class="row">
        <div class="input-field col s12">
          <input readonly value="${i.fileName}" name="file_name" type="text" class="validate">
          <label for="disabled">ファイル名</label>
        </div>
      </div>
    <div class="row">
		<div class="card">
		<div class="card-image">
		<img src="img/${i.fileName}" class="slideheight">
		</div>
		</div>
		</div>
      <div class="center font-size">
      上記内容で登録してよろしいでしょうか?
</div>
<div class="row">
<div class="center col s6">
<button  class="btn waves-effect waves-light"type=submit name=action onClick="func('action');">登録</button>
</div>
<div class="center col s6">
<button class="btn waves-effect waves-light" type=submit name=return onClick="func('return');">修正</button>
</div>
</div>
<input type=hidden name=MySubmit>
</form>
<script language="JavaScript">
function func(MyCommand){
document.MyForm.MySubmit.value=MyCommand;
document.MyForm.submit();
}
</script>
</div>

</body>
</html>