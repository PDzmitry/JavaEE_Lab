package by.protasovitski.util.pages;

public enum Page {
    LOGIN_PAGE("/WEB-INF/views/login.jsp"),
    REGISTER_PAGE("/WEB-INF/views/register.jsp"),
    WELCOME_PAGE("/WEB-INF/views/listTask.jsp"),
    ERROR_PAGE("/WEB-INF/views/errorPage.jsp"),
    NEW_TASK_PAGE("/WEB-INF/views/addTask.jsp"),
    LIST_USERS_PAGE("/WEB-INF/views/users.jsp"),
    EDIT_USER_PAGE("/WEB-INF/views/editUser.jsp"),
    VIEW_LOG_PAGE("/WEB-INF/views/viewlog.jsp"),
    ADD_LOG_PAGE("/WEB-INF/views/addLog.jsp"),
    LIST_USERS_WITH_TASK_COMPLETION("/WEB-INF/views/usersWithTaskCompletion.jsp"),
    NUMBER_OF_USER_TASKS("/WEB-INF/views/numberOfUserTasks.jsp");


    private final String value;

    Page(String value){
        this.value=value;
    }

    public String getValue() {
        return value;
    }
}
