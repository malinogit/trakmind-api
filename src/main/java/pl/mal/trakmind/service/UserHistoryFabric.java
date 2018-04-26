package pl.mal.trakmind.service;

import pl.mal.trakmind.model.domain.User;
import pl.mal.trakmind.model.domain.UserHistory;

class UserHistoryFabric {

    static UserHistory createUserActionLog(User user, String username, String message, String userAction) {
        UserHistory userHistory = new UserHistory();
        userHistory.setUser(user);
        userHistory.setUsername(username);
        userHistory.setActionType(userAction);
        userHistory.setMessage(message);
        return userHistory;
    }
}
