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
            <c:set var="user" value="${user}"></c:set>
            <h1 class="h4 col-lg-12 font-weight-normal">Добро пожаловать, ${user.name}</h1>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div>
                    <form  action="${pageContext.servletContext.contextPath}/controller?command=add_new_task" method="post">
                     <div class="row">
                         <div class="col-lg-2">
                             <input class="btn btn-success btn-sm" type="submit" value="+Добавить">
                         </div>
                         <div class="col-lg-10">
                             <input size="100" type="text" class="form-text" id="nNameTask" placeholder="Введите название задачи" name="nNameTask" required autofocus>
                         </div>
                     </div>
                    </form>
                </div>
                <table class="table table-striped">
                    <caption style="caption-side: top" class="text-uppercase" size="14">Список ваших задач</caption>
                    <tr>
                        <th>Задача</th>
                        <th>Состояние</th>
                        <th colspan="3" class="text-center">Опции</th>
                    </tr>
                    <c:forEach items="${group}" var="task">

                        <tr>
                            <td>${task.nameTask}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${task.status==false}">
                                        не выполнена
                                    </c:when>
                                    <c:otherwise>
                                        выполнена
                                    </c:otherwise>
                                </c:choose>
                            </td>

                            <td>
                                <div>
                                    <form action="${pageContext.servletContext.contextPath}/controller?command=perform_task&id=${task.id}" method="post">
                                        <input
                                                <c:choose>
                                                    <c:when test="${task.status==true}">
                                                        disabled="disabled"
                                                    </c:when>
                                                </c:choose>
                                                class="btn btn-danger btn-sm" type="submit" value="Выполнить"/>
                                    </form>
                                </div>
                            </td>
                            <td>
                                <div>
                                    <form action="${pageContext.servletContext.contextPath}/controller?command=view_log&id=${task.id}" method="post">
                                        <input class="btn btn-primary btn-sm" type="submit" value="Посмотреть лог"/>
                                    </form>
                                </div>
                            </td>
                            <td>
                                <div>
                                    <form action="${pageContext.servletContext.contextPath}/controller?command=add_log_page&id=${task.id}" method="post">
                                        <input  <c:choose>
                                            <c:when test="${task.status==true}">
                                                disabled="disabled"
                                            </c:when>
                                        </c:choose>
                                                class="btn btn-success btn-sm" type="submit" value="Добавить в лог"/>
                                    </form>
                                </div>
                            </td>
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
<%--<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>--%>
</body>
</html>
