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
  <title>商品更新</title>
</head>
<body>
<jsp:include page="/base/header.jsp" />
<div class="container">
<h4>商品更新</h4>
<form action="ItemUpdateServlet" method="POST" enctype=multipart/form-data>
<div class="row">
    <div class="col s12">
      <div class="row">
        <div class="input-field col s12">
          <i class="material-icons prefix">edit</i>
          <input type="text" name="item_name" class="autocomplete" value="${itemDate.itemName}">
          <input type="hidden" name="id" value="${itemDate.id}">
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
          <input type="text" name="detail" class="autocomplete" value="${itemDate.detail}">
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
          <input type="text" name="price" class="autocomplete" value="${itemDate.price}">
          <label for="autocomplete-input">値段</label>
        </div>
      </div>
    </div>
  </div>

    <div class="file-field input-field">
      <div class="btn">
        <span>画像</span>
        <input type="file" name="file_name">
      </div>
      <div class="file-path-wrapper">
        <input class="file-path validate" type="text">
      </div>
    </div>
    <div class="row">
		<div class="card">
		<div class="card-image">
		<img src="img/${itemDate.fileName}" class="width height">
		</div>
		</div>
		</div>

<div class="center">
<button class="btn waves-effect waves-light" type="submit" name="action">更新
    <i class="material-icons right">send</i>
  </button>
  </div>
  </form>
  </div>

</body>
</html>