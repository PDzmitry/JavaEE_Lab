<%--
  Created by IntelliJ IDEA.
  User: Dmitri
  Date: 03.04.2019
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>EditPerson</title>
    <link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <style>
        <%@include file="../css/default.css"%>
        <%@include file="../css/default-body-color.css"%>
    </style>
</head>
<body>
<div class="container-fluid">
    <form class="form-edit-person" method="post" action="ControllerServlet">
        <input hidden="hidden" name="action" value="edit-person-success">
        <p> Редактировать:</p>
            <input hidden="hidden" type="text" class="form-text" id="id" placeholder="Введите имя" name="id"
                   value="${person.id}">
            <label for="nname" class="sr-only">Имя:</label>
            <input type="text" class="form-text" id="nname" placeholder="Введите имя" name="nname"
                   value="${person.name}" required autofocus>
            <label for="nphone" class="sr-only">Телефон:</label>
            <input type="text" class="form-text" id="nphone" placeholder="Введите телефон" name="nphone"
                   value="${person.phone}" required>
            <label for="nemail" class="sr-only">Email:</label>
            <input type="text" class="form-text" id="nemail" placeholder="Введите email" name="nemail"
                   value="${person.email}" required>
        <input class="btn btn-primary btn-sm" name="add" type="submit" value="Сохранить">
    </form>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
