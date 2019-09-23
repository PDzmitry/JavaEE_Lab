<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <style>
        <%@include file="css/login.css"%>
    </style>
</head>
<body class="text-center">
<div class="form-signin">
    <form action="${pageContext.servletContext.contextPath}/controller?command=login" method="post">
        <h1 class="h3 mb-3 font-weight-normal">Введите данные</h1>
        <p class="text-danger" id="error">${errorMessage}</p>
        <label for="name" class="sr-only">Имя:</label>
        <input type="text" class="form-control" id="name" placeholder="Введите логин" name="name" autofocus>
        <label for="password" class="sr-only">Пароль:</label>
        <input type="password" class="form-control" id="password" placeholder="Введите пароль" name="password">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Вход</button>
    </form>
    <form action="${pageContext.servletContext.contextPath}/controller?command=registration_page" method="post">
        <input class="btn btn-link" type="submit" value="Регистрация">
        <p class="mt-5 mb-3 text-muted">&copy 2019</p>
    </form>
</div>

<script src="webjars/jquery/3.4.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="webjars/popper.js/1.15.0/dist/popper.min.js"></script>
</body>
</html>
