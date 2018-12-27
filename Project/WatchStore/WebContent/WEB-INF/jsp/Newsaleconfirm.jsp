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
  <title>割引登録確認</title>
</head>
<body>
<jsp:include page="/base/header.jsp" />
<div class="container">
<h4>割引登録確認</h4>
<c:if test="${errMsg != null}" >
	    <div class="alert alert-danger center color-red" role="alert">
		  ${errMsg}
		</div>
	</c:if>
<form  name=MyForm action="NewSaleConfirmServlet" method="post">
<div class="row">
    <div class="col s12">
     <div class="row">
    <div class="col s6">
    <div class="row">
        <div class="input-field col s12">
          <i class="material-icons prefix">edit</i>
          <input value="${s.brandName}" type="text" name="brand_name" class="autocomplete">
          <label for="autocomplete-input">ブランド名</label>
        </div>
      </div>
    </div>
  </div>
	<div class="row">
    <div class="col s6">
    <div class="row">
        <div class="input-field col s12">
          <i class="material-icons prefix">edit</i>
          <input value="${s.sale}" type="text" name="sale" class="autocomplete">
          <label for="autocomplete-input">割引率</label>
        </div>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col s12">
      <div class="row">
        <div class="input-field col s5">
          <i class="material-icons prefix">edit</i>
          <input  value="${s.startDate}" type="text" name="start_date" class="autocomplete">
          <label for="autocomplete-input">開始日</label>
        </div>
        <div class="col s2">
        <i>～</i>
        </div>
         <div class="input-field col s5">
          <input value="${s.finishDate}" type="text" name="finish_date" class="autocomplete">
          <label for="autocomplete-input">終了日</label>
        </div>
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
</div>
</div>
</form>
</div>
  <br>
		<br>
		<jsp:include page="/base/hooder.jsp" />
  <script type="text/javascript">
			document.addEventListener('DOMContentLoaded', function() {
		    var elems = document.querySelectorAll('select');
		    var instances = M.FormSelect.init(elems);
		  });
		function func(MyCommand) {
			document.MyForm.MySubmit.value = MyCommand;
			document.MyForm.submit();
		}
	</script>
</body>
</html>