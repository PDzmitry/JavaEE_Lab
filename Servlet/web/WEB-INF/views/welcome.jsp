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
<html>
<head>
    <title>Home</title>
    <%--<link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <style type="text/css">
        html {
            height: 100%
        }

        body {
            min-height: 100%;
            position: relative;
            padding-bottom: 70px;
        }

        .footer {
            position: absolute;
            left: 0;
            right: 0;
            bottom: 0;
            height: 50px;
        }
    </style>
</head>
<body>
<header>
    <div class="container">
        <div class="row">
            <nav role="navigation" class="navbar navbar-default">
                <div class="">
                    <img src="https://www.kv.by/sites/default/files/user7743/logo_iba_group.jpg" width="50" height="50">
                </div>
                <div class="navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">Home</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="LoginServlet">Login</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="LogoutServlet">Logout</a></li>
                    </ul>
                </div>
            </nav>
        </div>
    </div>
</header>
<section>
    <div class="container">
        <div class="row">
            <h3>Добро пожаловать, ${name} последнее время входа ${time}</h3>
        </div>
        <div class="row">
            <div class="col-lg-8">
                <table class="table table-responsive">
                    <caption>Список вашей группы</caption>
                    <tr>
                        <th>Имя</th>
                        <th>Телефон</th>
                        <th>email</th>
                        <th colspan="2" class="text-center">Опции</th>
                    </tr>
                    <c:forEach items="${group}" var="person">
                        <tr>
                            <td>${person.name}</td>
                            <td>${person.phone}</td>
                            <td>${person.email}</td>
                            <td><a href="${pageContext.request.contextPath}/GroupServlet?action=edit&id=${person.id}">Редактировать</a>
                            </td>
                            <td>
                                <a href="${pageContext.request.contextPath}/GroupServlet?action=delete&id=${person.id}">Удалить</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="col-lg-1"></div>
            <div class="col-lg-3">
                <p id="error" style="color: red">${error}</p>
                <form method="post" action="GroupServlet">
                    <p> Новый:</p>
                    <div class="form-group">
                        <label for="nname">Имя:</label>
                        <input type="text" class="form-text" id="nname" placeholder="Введите имя" name="nname">
                    </div>
                    <div class="form-group">
                        <label for="nphone">Телефон:</label>
                        <input type="text" class="form-text" id="nphone" placeholder="Введите телефон" name="nphone">
                    </div>
                    <div class="form-group">
                        <label for="nemail">Email:</label>
                        <input type="text" class="form-text" id="nemail" placeholder="Введите email" name="nemail">
                    </div>
                    <input class="btn btn-primary" name="add" type="submit" value="Добавить">
                </form>
            </div>
        </div>
    </div>
</section>

<footer class="footer">
    <div class="container" style="background-color: whitesmoke">
        <p align="center">2019 Все права защищены</p>
    </div>
</footer>

<script src="webjars/jquery/3.3.1/jquery.min.js"></script>
<%--<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>--%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
