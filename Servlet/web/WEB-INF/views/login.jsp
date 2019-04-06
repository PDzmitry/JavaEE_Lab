<%--
  Created by IntelliJ IDEA.
  User: Dmitri
  Date: 03.03.2019
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <%--<link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <style type="text/css">
        #error {
            color: red;
        }
    </style>
</head>
<body>
<p id="error">${error}</p>
<div class="container-fluid">
    <form action="LoginServlet" method="post">
        <div class="form-group">
            <label for="name">Имя:</label>
            <input type="text" class="form-text" id="name" placeholder="Введите имя" name="name">
        </div>
        <div class="form-group">
            <label for="password">Пароль:</label>
            <input type="password" class="form-text" id="password" placeholder="Введите пароль" name="password">
        </div>
        <input class="btn btn-primary" type="submit">
        <br><br>
        <a class="btn-link" href="${pageContext.request.contextPath}/RegisterServlet">Регистрация</a>
    </form>
</div>
<%--<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>--%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
