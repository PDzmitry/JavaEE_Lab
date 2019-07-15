package by.protasovitski.springfirst.exceptions;

import java.security.PrivilegedActionException;

public class RegistrationException extends Exception {

    public RegistrationException(String message) {
        super(message);
    }

    public RegistrationException(String message, Throwable cause) {
        super(message, cause);
    }

    public RegistrationException(Throwable cause) {
        super(cause);
    }
}
