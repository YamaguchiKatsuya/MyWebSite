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
  <title>新規登録</title>
</head>
<body>
<nav class="#2e7d32 green darken-3">
    <div class="nav-wrapper">
      <a href="TopLoginServlet?id=${userInfo.id}" class="brand-logo"><i class="large material-icons">store</i>勝時計店</a>
      <ul class="right hide-on-med-and-down">
        <li><a href="SearchServlet"><i class="material-icons">watch</i></a></li>
        <c:if test="${userInfo==null}" >
        <li><a href="LoginServlet"><i class="material-icons">vpn_key</i></a></li>
        </c:if>
        <c:if test="${userInfo!= null}" >
        <li><a href="UserdateDetailServlet?id=${userInfo.id}"><i class="material-icons">account_circle</i></a></li>
        </c:if>
        <li><a href="collapsible.html"><i class="material-icons">shopping_cart</i></a></li>
        <li><a href="NewuserServlet"><i class="material-icons">add</i></a></li>
        <c:if test="${userInfo!= null}" >
        <li>${userInfo.user_name} さん </li>
        </c:if>
     </ul>
    </div>
  </nav>
  <li class="right"><a href="LogoutServlet">ログアウト</a></li>
<div class="container">
<h4>新規登録</h4>
<c:if test="${errMsg != null}" >
	    <div class="alert alert-danger center color-red" role="alert">
		  ${errMsg}
		  </div>
		  </c:if>
<form action="NewConfirmServlet" method="post">
<div class="row">
    <div class="col s12">
      <div class="row">
        <div class="input-field col s12">
          <i class="material-icons prefix">edit</i>
          <c:if test="${d==null}" >
          <input type="text" name="userName" class="autocomplete">
          </c:if>
          <c:if test="${d!=null}" >
          <input type="text" name="userName" class="autocomplete" value="${d.user_name }">
          </c:if>
          <label for="autocomplete-input">ユーザ名</label>
        </div>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col s12">
      <div class="row">
        <div class="input-field col s12">
          <i class="material-icons prefix">edit</i>
          <c:if test="${d==null}" >
          <input type="text" name="address" class="autocomplete">
          </c:if>
          <c:if test="${d!=null}" >
          <input type="text" name="address" class="autocomplete" value="${d.address }">
          </c:if>
          <label for="autocomplete-input">住所</label>
        </div>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col s12">
      <div class="row">
        <div class="input-field col s12">
          <i class="material-icons prefix">date_range</i>
          <c:if test="${d==null}" >
          <input type="date" name="birthDate" class="autocomplete">
          </c:if>
          <c:if test="${d!=null}" >
          <input type="date" name="birthDate" class="autocomplete" value="${d.birth_date }">
          </c:if>
          <label for="autocomplete-input">生年月日</label>
        </div>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col s12">
      <div class="row">
        <div class="input-field col s12">
          <i class="material-icons prefix">lock</i>
          <input type="password" name="pass" class="autocomplete">
          <label for="autocomplete-input">パスワード</label>
        </div>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col s12">
      <div class="row">
        <div class="input-field col s12">
          <i class="material-icons prefix">lock</i>
          <input type="password" name="passk" class="autocomplete">
          <label for="autocomplete-input">パスワード(確認)</label>
        </div>
      </div>
    </div>
  </div>

<div class="center">
<button class="btn waves-effect waves-light" type="submit" name="action">確認
    <i class="material-icons right">send</i>
  </button>
  </div>
  </div>
  </form>
</body>
</html>