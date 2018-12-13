<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<title>購入手続き</title>
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
<h3 class="center">購入手続き</h3>

			<table class="highlight">
        <thead>
          <tr>
              <th>商品名</th>
              <th>単価</th>
              <th>小計</th>
          </tr>
        </thead>

        <tbody>
         <c:forEach var="item" items="${cart}"  varStatus="status" >
          <tr>
            <td>${item.itemName}</td>
            <td>${item.price}</td>
            <td>${item.price}</td>
          </tr>
          </c:forEach>
          <tr>
            <td></td>
            <td></td>
            <td>
           <div class="input-field col s12">
    <select>
      <option value="" disabled selected></option>
      <option value="1">通常配送</option>
      <option value="2">時間指定配送</option>
      <option value="3">特急配送</option>
    </select>
    <label>配送方法</label>
  </div>
  </td>
  </tr>
        </tbody>
      </table>
</body>
</html>