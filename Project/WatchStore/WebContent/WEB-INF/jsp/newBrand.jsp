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
  <title>ブランド登録</title>
</head>
<body>
<jsp:include page="/base/header.jsp" />
<div class="container">
<h4>ブランド登録</h4>
<c:if test="${errMsg != null}" >
	    <div class="alert alert-danger center color-red" role="alert">
		  ${errMsg}
		</div>
	</c:if>
<form action="NewBrandServlet" method="post" enctype=multipart/form-data>
<div class="row">
    <div class="col s12">
      <div class="row">
        <div class="input-field col s12">
          <i class="material-icons prefix">edit</i>
          <c:if test="${d==null}" >
          <input type="text" name="brand_name" class="autocomplete">
          </c:if>
          <c:if test="${d!=null}" >
          <input type="text" name="brand_name" class="autocomplete" value="${d.brandName }">
          </c:if>
          <label for="autocomplete-input">ブランド名</label>
        </div>
      </div>
    </div>
  </div>
  		<div class="file-field input-field">
      	<div class="btn">
        <span>画像</span>
          <input type="file" name="file_name" class="autocomplete">
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
  <br>
		<br>
		<jsp:include page="/base/hooder.jsp" />
</body>
</html>