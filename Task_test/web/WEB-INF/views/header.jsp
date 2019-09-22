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
                <li class="nav-item active">
                    <form action="${pageContext.servletContext.contextPath}/controller?command=welcome" method="post">
                        <input class="btn btn-link" type="submit" value="Главная">
                    </form>
                </li>
            </ul>
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <form action="${pageContext.servletContext.contextPath}/controller?command=list_users" method="post">
                        <input class="btn btn-link" type="submit" value="Пользователи">
                    </form>
                </li>
                <li class="nav-item">
                    <form action="${pageContext.servletContext.contextPath}/controller?command=number_of_user_tasks" method="post">
                        <input class="btn btn-link" type="submit" value="Пользователи с количеством задач">
                    </form>
                </li>
                <li class="nav-item">
                    <form action="${pageContext.servletContext.contextPath}/controller?command=list_users_with_task_completion&total=100" method="post">
                    <input class="btn btn-link" type="submit" value="Пользователи время зачач > 100 ">
                </form>
                </li>
            </ul>
            <ul class="navbar-nav ml-auto">
                <li class="nav-item ">
                    <form action="${pageContext.servletContext.contextPath}/controller?command=login_page" method="post">
                        <input hidden="hidden" name="action" value="login">
                        <input class="btn btn-link" type="submit" value="Вход">
                    </form>
                </li>
                <li class="nav-item ">
                    <form action="${pageContext.servletContext.contextPath}/controller?command=sign_out" method="post">
                        <input hidden="hidden" name="action" value="logout">
                        <input class="btn btn-link" type="submit" value="Выход">
                    </form>
                </li>
            </ul>
        </div>
    </nav>
</header>
