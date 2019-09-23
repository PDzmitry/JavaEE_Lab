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
                    <c:set var="task" value="${task}"></c:set>
                    <caption style="caption-side: top" class="text-uppercase" size="14">Протокол задачи:${task.nameTask}</caption>
                    <tr>
                        <th>Комментарий</th>
                        <th>Затраченое время</th>
                    </tr>
                    <c:forEach items="${group}" var="log">
                        <tr>
                            <td>${log.description}</td>
                            <td>${log.timeSpent}</td>
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
