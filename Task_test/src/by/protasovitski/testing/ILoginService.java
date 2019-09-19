package by.protasovitski.testing;

import java.io.Serializable;

public interface ILoginService extends Serializable {
    boolean login(String name, String password);
}
