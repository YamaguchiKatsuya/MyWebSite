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
<form name=MyForm action="NewuserServlet" method="POST">
<div class="row">
        <div class="input-field col s12">
          <input value="${u.user_name}" name="userName" type="text" class="validate" readonly>
          <label for="disabled">ユーザ名</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <input readonly value="${u.address}" name="address" type="text" class="validate">
          <label for="disabled">住所</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <input readonly value="${u.birth_date}" name="birthDate" type="text" class="validate">
          <label for="disabled">生年月日</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <input readonly value="${u.password}" name="pass" type="text" class="validate">
          <label for="disabled">パスワード</label>
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
<br>
		<br>
		<jsp:include page="/base/hooder.jsp" />
<script language="JavaScript">
function func(MyCommand){
document.MyForm.MySubmit.value=MyCommand;
document.MyForm.submit();
}
</script>
</div>

</body>
</html>