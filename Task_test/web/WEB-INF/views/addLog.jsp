<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Добавление задачи в лог</title>
    <link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <style>
        <%@include file="css/default.css"%>
        <%@include file="css/default-body-color.css"%>
    </style>
</head>
<body>
<div class="container-fluid">
    <form class="form-add-task" action="${pageContext.servletContext.contextPath}/controller?command=add_new_task" method="post">
        <p>задача</p>
        <p id="error" style="color: red">${error}</p>
        <label for="nNameTask" class="sr-only">Название задачи:</label>
        <input size="100" type="text" class="form-text" id="nNameTask" placeholder="Введите название задачи" name="nNameTask" required autofocus>
        <input class="btn btn-primary" type="submit" value="Сохранить">
    </form>
</div>
<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
</body>
</html>
