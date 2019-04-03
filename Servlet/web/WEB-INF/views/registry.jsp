<%--
  Created by IntelliJ IDEA.
  User: Dmitri
  Date: 24.03.2019
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
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
    <form action="RegisterServlet" method="post">
        <h3>Новый пользователь</h3>
        <div class="form-group">
            <label for="name">Имя:</label>
            <input type="text" class="form-text" id="name" placeholder="Введите имя" name="name">
        </div>
        <div class="form-group">
            <label for="password">Пароль:</label>
            <input type="password" class="form-text" id="password" placeholder="Введите пароль" name="password">
        </div>
        <input class="btn btn-primary" type="submit" value="Добавить">
    </form>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>