package pl.mal.trakmind.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mal.trakmind.model.UserActionTypeEnum;
import pl.mal.trakmind.model.domain.User;
import pl.mal.trakmind.model.domain.UserHistory;
import pl.mal.trakmind.repository.UserHistoryRepository;

@AllArgsConstructor
@Service
public class UserHistoryServiceImpl extends CommonService<UserHistoryServiceImpl> implements UserHistoryService {

    private final UserHistoryRepository userHistoryRepository;

    public void save(User user, String message, UserActionTypeEnum userActionTypeEnum) {
        save(userHistoryRepository.save(createUserHistoryLog(user, null, message, userActionTypeEnum)));
    }

    public void save(String username, String message, UserActionTypeEnum userActionTypeEnum) {
        save(userHistoryRepository.save(createUserHistoryLog(null, username, message, userActionTypeEnum)));
    }

    private UserHistory createUserHistoryLog(User user, String username, String message, UserActionTypeEnum userAction) {
        return  UserHistoryFabric.createUserActionLog(user, username, message, userAction.getActionType());
    }

    private void save(UserHistory userHistory) {
        userHistoryRepository.save(userHistory);
    }
}
