package by.protasovitski.command.factory;

public enum CommandType {
    LOGIN("login"),
    LOGIN_PAGE("login_page"),
    SIGN_OUT("sign_out"),

    REGISTER_NEW_USER("register_new_user"),
    REGISTRATION_PAGE("registration_page"),
    EDIT_USER("edit_user"),
    EDIT_USER_PAGE("edit_user_page"),
    LIST_USERS("list_users"),
    PERFORM_TASK("perform_task"),

    WELCOME("welcome"),
    ADD_NEW_TASK("add_new_task"),

    ADD_LOG_PAGE("add_log_page"),
    ADD_NEW_LOG("add_new_log"),
    VIEW_LOG("view_log"),
    LIST_USERS_WITH_TASK_COMPLETION("list_users_with_task_completion"),
    NUMBER_OF_USER_TASKS("number_of_user_tasks");



    private String command;

    CommandType(String command){
        this.command=command;
    }
}
