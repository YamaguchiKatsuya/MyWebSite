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
<title>トップページ</title>

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
        <li><a href="CartServlet"><i class="material-icons">shopping_cart</i></a></li>
        <li><a href="NewConfirmServlet"><i class="material-icons">add</i></a></li>
        <c:if test="${userInfo!= null}" >
        <li>${userInfo.user_name} さん </li>
        </c:if>
     </ul>
    </div>
  </nav>
  <li class="right"><a href="LogoutServlet">ログアウト</a></li>
 <div class="container">
<h3 class="center">勝時計店</h3>
<br>
<div class="center large">勝時計店は、世界各国の時計を取り扱っている小売店です。</div>
<br>
<div class="center large">取り扱いブランドは変更することがございます。</div>
<br>
<div class="center large">是非、ご自身に合う最高の一本を探してみてください。</div>
<br>
<br>
<div class="cp_cssslider center">
	<div class="cp_slidewrapper">
		<div class="cp_slide_item"><img src="img/gucci.jpg" class="slideheight"></div>
		<div class="cp_slide_item"><img src="img/iwc.jpg"class="slideheight"></div>
		<div class="cp_slide_item"><img src="img/paulsmith.jpg"class="slideheight"></div>
		<div class="cp_slide_item"><img src="img/tag.jpg"class="slideheight"></div>
		<div class="cp_slide_item"><img src="img/timex.jpg"class="slideheight"></div>
	</div>
</div>
<div class="center font-size">取り扱いブランド</div>
<div class="row">
<div class="col s4">
		<div class="card">
		<div class="card-image">
		<img class="width height" src="http://watch-monster.com/system/articles/images/000/001/231/medium/7ee29225-9eaf-4f0e-b41c-56ac7f2770a2.gif?1466912345" alt="">
		</div>
		</div>
		</div>
		<div class="col s4">
		<div class="card">
		<div class="card-image">
		<img class="width height" src="http://watch-monster.com/system/articles/images/000/001/231/medium/7ee29225-9eaf-4f0e-b41c-56ac7f2770a2.gif?1466912345" alt="">
		</div>
		</div>
		</div>
		<div class="col s4">
		<div class="card">
		<div class="card-image">
		<img class="width height" src="http://watch-monster.com/system/articles/images/000/001/231/medium/7ee29225-9eaf-4f0e-b41c-56ac7f2770a2.gif?1466912345" alt="">
		</div>
		</div>
		</div>
		</div>
		<div class="row">
		<div class="col s4">
		<div class="card">
		<div class="card-image">
		<img class="width height" src="http://watch-monster.com/system/articles/images/000/001/231/medium/7ee29225-9eaf-4f0e-b41c-56ac7f2770a2.gif?1466912345" alt="">
		</div>
		</div>
		</div>
		<div class="col s4">
		<div class="card">
		<div class="card-image">
		<img class="width height" src="http://watch-monster.com/system/articles/images/000/001/231/medium/7ee29225-9eaf-4f0e-b41c-56ac7f2770a2.gif?1466912345" alt="">
		</div>
		</div>
		</div>
		<div class="col s4">
		<div class="card">
		<div class="card-image">
		<img class="width height" src="http://watch-monster.com/system/articles/images/000/001/231/medium/7ee29225-9eaf-4f0e-b41c-56ac7f2770a2.gif?1466912345" alt="">
		</div>
		</div>
		</div>
		<div class="col s4">
		<div class="card">
		<div class="card-image">
		<img class="width height" src="http://watch-monster.com/system/articles/images/000/001/231/medium/7ee29225-9eaf-4f0e-b41c-56ac7f2770a2.gif?1466912345" alt="">
		</div>
		</div>
		</div>
		<div class="col s4">
		<div class="card">
		<div class="card-image">
		<img class="width height" src="http://watch-monster.com/system/articles/images/000/001/231/medium/7ee29225-9eaf-4f0e-b41c-56ac7f2770a2.gif?1466912345" alt="">
		</div>
		</div>
		</div>
		<div class="col s4">
		<div class="card">
		<div class="card-image">
		<img class="width height" src="http://watch-monster.com/system/articles/images/000/001/231/medium/7ee29225-9eaf-4f0e-b41c-56ac7f2770a2.gif?1466912345" alt="">
		</div>
		</div>
		</div>
		</div>
		</div>
</body>
</html>