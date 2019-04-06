<%--
  Created by IntelliJ IDEA.
  User: Dmitri
  Date: 03.04.2019
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--<link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="container-fluid">
    <p id="error" style="color: red">${error}</p>
    <form method="post" action="GroupServlet">
        <p> Редактировать:</p>
        <div class="form-group">
            <input hidden="hidden" type="text" class="form-text" id="id" placeholder="Введите имя" name="id"
                   value="${person.id}">
            <label for="nname">Имя:</label>
            <input type="text" class="form-text" id="nname" placeholder="Введите имя" name="nname"
                   value="${person.name}">
        </div>
        <div class="form-group">
            <label for="nphone">Телефон:</label>
            <input type="text" class="form-text" id="nphone" placeholder="Введите телефон" name="nphone"
                   value="${person.phone}">
        </div>
        <div class="form-group">
            <label for="nemail">Email:</label>
            <input type="text" class="form-text" id="nemail" placeholder="Введите email" name="nemail"
                   value="${person.email}">
        </div>
        <input class="btn btn-primary" name="add" type="submit" value="Сохранить">
    </form>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
