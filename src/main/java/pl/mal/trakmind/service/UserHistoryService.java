package pl.mal.trakmind.service;

import pl.mal.trakmind.model.UserActionTypeEnum;
import pl.mal.trakmind.model.domain.User;

public interface UserHistoryService {

    void save(User user, String message, UserActionTypeEnum userActionTypeEnum);
    void save(String username, String message, UserActionTypeEnum userActionTypeEnum);
}
