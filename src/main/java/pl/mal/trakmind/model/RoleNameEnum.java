package pl.mal.trakmind.model;

import lombok.Getter;

@Getter
public enum RoleNameEnum {
    ANONYMOUS("ANONYMOUS"), BASIC_USER("BASIC_USER"), GLOBAL_ADMIN("GLOBAL_ADMIN");
    private final String name;

    RoleNameEnum(String name) {
        this.name = name;
    }
}
