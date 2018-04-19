package pl.mal.trakmind.model;

import lombok.Getter;

@Getter
public enum PrivilegeNameEnum {
    KIRA("KIRA");
    private final String name;

    PrivilegeNameEnum(String name) {
        this.name = name;
    }
}
