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
    ADD_NEW_TASK("add_new_task");
    /* ADD_NEW_PERSON("add_new_person"),
   DEL_PERSON("del_person"),*/


//    NEW_TASK_PAGE("new_task_page"),


    private String command;

    CommandType(String command){
        this.command=command;
    }
}
