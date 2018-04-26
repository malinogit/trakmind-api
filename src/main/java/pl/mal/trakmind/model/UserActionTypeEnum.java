package pl.mal.trakmind.model;

import lombok.Getter;

@Getter
public enum UserActionTypeEnum {
    REGISTER("REGISTER");
    private final String actionType;
    UserActionTypeEnum(String actionType) {
        this.actionType = actionType;
    }
}
