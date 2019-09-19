package by.protasovitski.command.factory;


import by.protasovitski.command.Command;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class CommandFactory implements Serializable {

    @Inject
    @Type(CommandType.LOGIN)
    private Command loginCommand;

    @Inject
    @Type(CommandType.WELCOME)
    private Command welcomeCommand;

    @Inject
    @Type(CommandType.REGISTER_NEW_USER)
    private Command registerNewUserCommand;

    @Inject
    @Type(CommandType.SIGN_OUT)
    private Command singOutCommand;

    @Inject
    @Type(CommandType.LOGIN_PAGE)
    private Command loginPageCommand;

    @Inject
    @Type(CommandType.REGISTRATION_PAGE)
    private Command registerPageCommand;

    @Inject
    @Type(CommandType.ADD_NEW_TASK)
    private Command addNewTaskCommand;

    @Inject
    @Type(CommandType.PERFORM_TASK)
    private Command performTaskCommand;

    @Inject
    @Type(CommandType.EDIT_USER_PAGE)
    private Command editUserPageCommand;

    @Inject
    @Type(CommandType.EDIT_USER)
    private Command editUserCommand;

    @Inject
    @Type(CommandType.LIST_USERS)
    private Command listUsersCommand;


    public Command create(String command) {
        command = command.toUpperCase();
        CommandType commandEnum = CommandType.valueOf(command);


        Command resultCommand;

        switch (commandEnum) {
            case LOGIN: {
                resultCommand = loginCommand;
                break;
            }
            case REGISTER_NEW_USER: {
                resultCommand = registerNewUserCommand;
                break;
            }
            case SIGN_OUT: {
                resultCommand = singOutCommand;
                break;
            }
            case LOGIN_PAGE: {
                resultCommand = loginPageCommand;
                break;
            }
            case WELCOME: {
                resultCommand = welcomeCommand;
                break;
            }

            case REGISTRATION_PAGE: {
                resultCommand = registerPageCommand;
                break;
            }
            case ADD_NEW_TASK: {
                resultCommand = addNewTaskCommand;
                break;
            }
            case PERFORM_TASK: {
                resultCommand = performTaskCommand;
                break;
            }
            case EDIT_USER_PAGE: {
                resultCommand = editUserPageCommand;
                break;
            }
            case EDIT_USER: {
                resultCommand = editUserCommand;
                break;
            }
            case LIST_USERS: {
                resultCommand = listUsersCommand;
                break;
            }
            default: {
                resultCommand = loginCommand;
            }
        }
        return resultCommand;
    }

}
