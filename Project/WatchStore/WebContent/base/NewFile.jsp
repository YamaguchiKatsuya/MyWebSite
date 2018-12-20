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

</head>
<body>
    <input type="checkbox" class="check" id="checked">
    <label class="menu-btn" for="checked">
        <span class="bar top"></span>
        <span class="bar middle"></span>
        <span class="bar bottom"></span>
        <span class="menu-btn__text">MENU</span>
    </label>
    <label class="close-menu" for="checked"></label>
    <nav class="drawer-menu">
        <ul>
            <li><a href="#">Side Menu Name</a></li>
            <li><a href="#">Side Menu Name</a></li>
            <li><a href="#">Side Menu Name</a></li>
            <li><a href="#">Side Menu Name</a></li>
            <li><a href="#">Side Menu Name</a></li>
        </ul>
    </nav>
    <div class="contents">
        <div class="contents__inner">
            <h3>勝時計店</h3>
        </div>
    </div>
</body>
</html>