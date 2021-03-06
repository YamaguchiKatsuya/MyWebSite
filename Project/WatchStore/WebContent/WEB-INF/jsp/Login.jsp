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

<title>ログイン</title>
</head>
<body>
<jsp:include page="/base/header.jsp" />
  <div class="container">
<h4>ログイン</h4>
<c:if test="${errMsg != null}" >
	    <div class="alert alert-danger center color-red" role="alert">
		  ${errMsg}
		</div>
	</c:if>
<form action="LoginServlet" method="post">
<div class="row">
    <div class="col s12">
      <div class="row">
        <div class="input-field col s12">
          <i class="material-icons prefix">edit</i>
          <input type="text" name="userName" class="autocomplete">
          <label for="autocomplete-input">ユーザ名</label>
        </div>
      </div>
    </div>
  </div>
   <div class="row">
    <div class="col s12">
      <div class="row">
        <div class="input-field col s12">
          <i class="material-icons prefix">lock</i>
          <input type="password" name="password" class="autocomplete">
          <label for="autocomplete-input">パスワード</label>
        </div>
      </div>
    </div>
  </div>
  <div class="center">
<button class="btn waves-effect waves-light" type="submit" name="action">ログイン
    <i class="material-icons right">send</i>
  </button>
  </div>
  </form>
  <div class="right">
   <a href="NewConfirmServlet">新規登録</a>
  </div>
  </div>
	<br>
	<br>
	<jsp:include page="/base/hooder.jsp" />
</body>
</html>