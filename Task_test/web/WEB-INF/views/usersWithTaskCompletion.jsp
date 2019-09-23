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
        <div class="row">
            <div class="col-lg-12">
                <table class="table table-striped">
                    <caption style="caption-side: top" class="text-uppercase" size="14">Список пользователей
                       время выполнения зачачи больше 100 часов</caption>
                    <tr>
                        <th>Логин</th>
                        <th>ФИО</th>
                    </tr>
                    <c:forEach items="${group}" var="user">
                        <tr>
                            <td>${user.login}</td>
                            <td>${user.name}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

        </div>
    </div>
</section>
<jsp:include page="footer.jsp"/>

<script src="webjars/jquery/3.4.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="webjars/popper.js/1.15.0/dist/popper.min.js"></script>
</body>
</html>
