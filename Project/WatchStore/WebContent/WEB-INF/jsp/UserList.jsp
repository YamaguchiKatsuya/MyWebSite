<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>ユーザ一覧</title>
</head>
<body>
<jsp:include page="/base/header.jsp" />
<div class="container">
<h4>ユーザ一覧</h4>
<br>
<form action="ListServlet" method="post">
<div class="row">
    <div class="col s12">
      <div class="row">
        <div class="input-field col s12">
          <i class="material-icons prefix">edit</i>
          <input type="text" name="user_name" class="autocomplete">
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
          <input type="text" name="address" class="autocomplete">
          <label for="autocomplete-input">住所</label>
        </div>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col s12">
      <div class="row">
        <div class="input-field col s5">
          <i class="material-icons prefix">edit</i>
          <input type="date" name="date1" class="autocomplete">
          <label for="autocomplete-input">生年月日</label>
        </div>
        <div class="col s2">
        <i>～</i>
        </div>
         <div class="input-field col s5">
          <input type="date" name="date2" class="autocomplete">
          <label for="autocomplete-input">生年月日</label>
        </div>
      </div>
    </div>
  </div>
  <div class="col s4 right">
				<button class="btn-large  waves-effect waves-light  col s6 offset-s4"
					type="submit" name="action">検索</button>
			</div>
			</form>
 <table class="highlight">
        <thead>
          <tr>
              <th class="center">ユーザ名</th>
              <th class="center">生年月日</th>
              <th class="center">最終更新日時</th>
              <th class="center"  style="width:600px"></th>
          </tr>
        </thead>

        <tbody>
         <c:forEach var="user" items="${userList}" >
          <tr>
            <td class="center">${user.user_name}</td>
            <td class="center">${user.birth_date}</td>
            <td class="center"><fmt:formatDate value="${user.update_date}" pattern="yyyy年MM月dd日kk時mm分" /></td>
            <td class="center">
            <div class="row">
		<form action="UserdateDetailServlet?id=${user.id}" method="POST">
			<div class="col s6">
				<button class="btn  waves-effect waves-light  col s6 offset-s4"
					type="submit" name="action">詳細</button>
			</div>
			</form>

			<form action="DeleteConfirmServlet?id=${user.id}" method="POST">
			<div class="col s6">
				<button class="btn  waves-effect waves-light  col s6 offset-s4"
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