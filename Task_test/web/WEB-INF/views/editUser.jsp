<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
        <%@include file="css/default.css"%>
    </style>
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="container">
    <form class="form-edit-user" action="${pageContext.servletContext.contextPath}/controller?command=edit_user" method="post">
        <input hidden="hidden" name="action" value="edit-user-success">
        <p> Редактировать пользователя:</p>
        <p id="error" style="color: red">${error}</p>
            <input hidden="hidden" type="text" class="form-text" id="user_id"  name="user_id"
                   value="${user.id}">
        <label for="newName" class="sr-only">ФИО:</label>
        <input type="text" class="form-text" id="newName" placeholder="Введите имя" name="newName" value="${user.name}" required autofocus>
        <label for="newLogin" class="sr-only">Логин:</label>
        <input type="text" class="form-text" id="newLogin" placeholder="Введите логин" name="newLogin" value="${user.login}" required>
        <label for="newPassword" class="sr-only">Пароль:</label>
        <input type="password" class="form-text" id="newPassword" placeholder="Введите пароль" name="newPassword" value="${user.password}" required>
        <input class="btn btn-primary" type="submit" value="Сохранить">
    </form>
</div>
<jsp:include page="footer.jsp"/>

<script src="webjars/jquery/3.3.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</body>
</html>

