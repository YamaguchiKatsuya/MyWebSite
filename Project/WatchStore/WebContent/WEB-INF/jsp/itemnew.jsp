<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
  <title>商品登録</title>
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
<h4>商品登録</h4>

<form action="NewitemServlet" method="post">
<div class="row">
    <div class="col s12">
      <div class="row">
        <div class="input-field col s12">
          <i class="material-icons prefix">edit</i>
          <c:if test="${d==null}" >
          <input type="text" name="item_name" class="autocomplete">
          </c:if>
          <c:if test="${d!=null}" >
          <input type="text" name="item_name" class="autocomplete" value="${d.itemName }">
          </c:if>
          <label for="autocomplete-input">商品名</label>
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
          <input type="text" name="detail" class="autocomplete">
          </c:if>
          <c:if test="${d!=null}" >
          <input type="text" name="detail" class="autocomplete" value="${d.detail }">
          </c:if>
                    <label for="autocomplete-input">詳細</label>
        </div>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col s12">
      <div class="row">
        <div class="input-field col s12">
          <i class="material-icons prefix">attach_money</i>
          <c:if test="${d==null}" >
          <input type="text" name="price" class="autocomplete">
          </c:if>
          <c:if test="${d!=null}" >
          <input type="text" name="price" class="autocomplete" value="${d.price }">
          </c:if>
          <label for="autocomplete-input">値段</label>
        </div>
      </div>
    </div>
  </div>
    <div class="file-field input-field">
      <div class="btn">
        <span>画像</span>
        <c:if test="${d==null}" >
          <input type="file" name="file_name" class="autocomplete">
          </c:if>
          <c:if test="${d!=null}" >
          <input type="file" name="file_name" class="autocomplete" value="${d.fileName }">
          </c:if>
      </div>
      <div class="file-path-wrapper">
        <input class="file-path validate" type="text">
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