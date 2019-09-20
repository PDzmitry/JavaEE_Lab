<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Regisrty</title>
    <link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <style>
        <%@include file="css/default.css"%>
        <%@include file="css/default-body-color.css"%>
    </style>
</head>
<body>
<div class="container-fluid">
    <form class="form-registry-user" action="${pageContext.servletContext.contextPath}/controller?command=register_new_user" method="post">
        <p>Новый пользователь</p>
        <p class="text-danger" id="error">${errorMessage}</p>
        <label for="newName" class="sr-only">Имя:</label>
        <input type="text" class="form-text" id="newName" placeholder="Введите имя" name="newName" required autofocus>
        <label for="newLogin" class="sr-only">Логин:</label>
        <input type="text" class="form-text" id="newLogin" placeholder="Введите логин" name="newLogin" required>
        <label for="newPassword" class="sr-only">Пароль:</label>
        <input type="password" class="form-text" id="newPassword" placeholder="Введите пароль" name="newPassword" required>
        <input class="btn btn-primary" type="submit" value="Зарегистрировать">
    </form>
</div>
<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
</body>
</html>
