<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="container">
    <nav class="navbar navbar-expand-lg navbar-light bg-light ">
        <button class="navbar-toggler ml-auto mr-auto" type="button" data-toggle="collapse" data-target="#navbar-main"
                aria-controls="navbar-main" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbar-main">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <form action="${pageContext.servletContext.contextPath}/controller?command=welcome" method="post">
                        <input class="btn btn-link" type="submit" value="Home">
                    </form>
                </li>
            </ul>
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <form action="${pageContext.servletContext.contextPath}/controller?command=list_users" method="post">
                    <input class="btn btn-link" type="submit" value="Список пользователей">
                </form>
                </li>
<%--                <li class="nav-item"><a href="#">Справочник задач</a></li>--%>
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
