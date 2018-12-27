<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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


<title>セール一覧</title>
<jsp:include page="/base/header.jsp" />
<div class="container">
<h4>セール一覧</h4>
<br>

 <table class="highlight">
        <thead>
          <tr>
              <th class="center large">対象ブランド</th>
              <th class="center large">日時</th>
              <th class="center large">割引率</th>
              <th class="center large" style="width:600px"></th>
          </tr>
        </thead>

        <tbody>
          <c:forEach var="saledate" items="${saleList}" >
          <tr>
            <td class="center large">${saledate.brandName}</td>
            <td class="center large">${saledate.startDate}～${saledate.finishDate}</td>
            <td class="center large">${saledate.sale}%</td>
            <td class="center large">

            <div class="row">
			<div class="col s6">
				<a href="UpdateSaleServlet?id=${saledate.id}"><button class="btn-large  waves-effect waves-light  col s6 offset-s4"
					type="submit" name="action">修正</button></a>
			</div>

			<form action="DeleteSaleServlet?id=${saledate.id}" method="POST">
			<div class="col s6">
				<button class="btn-large  waves-effect waves-light  col s6 offset-s4"
					type="submit" name="action">削除</button>
			</div>
			</form>
			</div>
            </td>
          </tr>
          </c:forEach>
        </tbody>
      </table>
      </div>
      <br>
		<br>
		<jsp:include page="/base/hooder.jsp" />

</body>
</html>