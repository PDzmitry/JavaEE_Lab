package by.protasovitski.util;

import java.io.Serializable;

public interface HashPassword extends Serializable {
    byte[] getHash(String passStr);
}
