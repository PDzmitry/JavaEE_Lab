package by.protasovitski.springfirst.entities.enums;

public enum UserRole {
    OWNER(10),
    COLLABORATOR(5),
    VIEWER(1),
    UNAUTHORIZED(0);

    public Integer level;

    UserRole(Integer level) {
        this.level = level;
    }
}
