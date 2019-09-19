<%--
  Created by IntelliJ IDEA.
  User: Dmitri
  Date: 03.03.2019
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
        <%@include file="../css/default.css"%>
    </style>
</head>
<body>
<header class="container">
    <nav class="navbar navbar-expand-lg navbar-light bg-light ">
        <button class="navbar-toggler ml-auto mr-auto" type="button" data-toggle="collapse" data-target="#navbar-main"
                aria-controls="navbar-main" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbar-main">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item"><a href="#">Home</a></li>
            </ul>
            <ul class="navbar-nav ml-auto">
                <li class="nav-item ">
                    <form action="${pageContext.servletContext.contextPath}/controller?command=login_page" method="post">
                        <input hidden="hidden" name="action" value="login">
                        <input class="btn btn-link" type="submit" value="Login">
                    </form>
                </li>
                <li class="nav-item ">
                    <form action="${pageContext.servletContext.contextPath}/controller?command=sign_out" method="post">
                        <input hidden="hidden" name="action" value="logout">
                        <input class="btn btn-link" type="submit" value="Logout">
                    </form>
                </li>
            </ul>
        </div>
    </nav>
</header>
<section>
    <div class="container">
        <div class="row">
            <h1 class="h3 mb-3 font-weight-normal">Добро пожаловать, ${name} последнее время входа ${time}</h1>
        </div>
        <div class="row">
            <div class="col-lg-8">
                <table class="table table-striped">
                    <caption style="caption-side: top">Список вашей группы</caption>
                    <tr>
                        <th>Имя</th>
                        <th>Логин</th>
                        <th colspan="2" class="text-center">Опции</th>
                    </tr>
                    <c:forEach items="${group}" var="user">
                        <tr>
                            <td>${user.name}</td>
                            <td>${user.login}</td>
                            <td>
                                <div>
                                    <form action="${pageContext.servletContext.contextPath}/controller?command=edit_person" method="post">
                                        <input hidden="hidden" name="id" value="${user.id}">
                                        <input class="btn btn-primary btn-sm" type="submit" value="Редактировать">
                                    </form>
                                </div>
                            </td>
                            <td>
                                <div>
                                    <form action="${pageContext.servletContext.contextPath}/controller?command=del_person" method="post">
                                        <input hidden="hidden" name="id" value="${user.id}">
                                        <input class="btn btn-primary btn-sm" type="submit" value="Удалить">
                                    </form>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="offset-1 col-lg-3">
                <form class="form-add-person" method="post" action="${pageContext.servletContext.contextPath}/controller?command=add_new_person">
                    <p>Новый:</p>
                    <label for="nname" class="sr-only">Имя:</label>
                    <input type="text" class="form-text" id="nname" placeholder="Введите имя" name="nname" required
                           autofocus>
                    <label for="nphone" class="sr-only">Телефон:</label>
                    <input type="text" class="form-text" id="nphone" placeholder="Введите телефон" name="nphone"
                           required>
                    <label for="nemail" class="sr-only">Email:</label>
                    <input type="text" class="form-text" id="nemail" placeholder="Введите email" name="nemail" required>
                    <input class="btn btn-primary btn-sm" name="add" type="submit" value="Добавить">
                </form>
            </div>
        </div>
    </div>
</section>

<footer class="footer container">
    <p align="center">2019 Все права защищены</p>
</footer>

<script src="webjars/jquery/3.3.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</body>
</html>
