package by.protasovitski.springfirst.exceptions;

import java.security.PrivilegedActionException;

public class DuplicationException extends Exception {

    public DuplicationException(String message) {
        super(message);
    }


    public DuplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicationException(Throwable cause) {
        super(cause);
    }
}
