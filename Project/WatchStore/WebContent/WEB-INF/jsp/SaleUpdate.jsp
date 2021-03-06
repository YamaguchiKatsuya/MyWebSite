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
  <title>割引修正</title>
</head>
<body>
<jsp:include page="/base/header.jsp" />
<div class="container">
<h4>割引修正</h4>
<c:if test="${errMsg != null}" >
	    <div class="alert alert-danger center color-red" role="alert">
		  ${errMsg}
		</div>
	</c:if>
<form action="UpdateSaleServlet" method="post">
<div class="row">
    <div class="col s12">
    <div class="row">
      <div class="input-field col s6 ">
      <i class="material-icons prefix">edit</i>
								<select name="brand_name">
									<c:forEach var="brand" items="${brandList}">
										<option value="${brand.brandName}">${brand.brandName}</option>
									</c:forEach>
								</select> <label for="autocomplete-input">ブランド名</label>
							</div>
							</div>
							</div>
	<div class="row">
    <div class="col s6">
    <div class="row">
        <div class="input-field col s12">
          <i class="material-icons prefix">edit</i>
          <input type="text" name="sale" class="autocomplete" value="${saledate.sale }">
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
          <input type="date" name="start_date" class="autocomplete" value="${saledate.startDate}">
          <label for="autocomplete-input">開始日</label>
        </div>
        <div class="col s2">
        <i>～</i>
        </div>
         <div class="input-field col s5">
          <input type="date" name="finish_date" class="autocomplete" value="${saledate.finishDate }">
          <label for="autocomplete-input">終了日</label>
        </div>
      </div>
    </div>
  </div>
  <input type="hidden" name="id" class="autocomplete" value="${saledate.id }">
<div class="center">
<button class="btn waves-effect waves-light" type="submit" name="action">修正
    <i class="material-icons right">send</i>
  </button>
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
		</script>
</body>
</html>