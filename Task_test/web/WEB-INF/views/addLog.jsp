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
<section>
<div class="container">
    <form class="form-add-task" action="${pageContext.servletContext.contextPath}/controller?command=add_new_log&id=${task.id}" method="post">
        <c:set var="task" value="${task}"></c:set>
        <p>Задача:${task.nameTask}</p>
        <p class="text-danger" id="error">${errorMessage}</p>
        <label for="logDescription" class="sr-only">Комментарий:</label>
        <input size="100" type="text" class="form-text" id="logDescription" placeholder="Введите комментарий" name="logDescription" required autofocus>
        <label for="timeSpent" class="sr-only">Затраченое время:</label>
        <input size="3" type="text" class="form-text" id="timeSpent" placeholder="часы" name="timeSpent" required>
        <input class="btn btn-primary" type="submit" value="Сохранить">
    </form>
</div>
</section>
<jsp:include page="footer.jsp"/>

<script src="webjars/jquery/3.4.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="webjars/popper.js/1.15.0/dist/popper.min.js"></script>
</body>
</html>
