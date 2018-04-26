package pl.mal.trakmind.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mal.trakmind.model.RoleNameEnum;
import pl.mal.trakmind.model.domain.User;
import pl.mal.trakmind.repository.UserRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static pl.mal.trakmind.model.UserActionTypeEnum.REGISTER;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl extends CommonService<UserServiceImpl> implements UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final UserHistoryService userHistoryService;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User save(String username, RoleNameEnum roleNameEnum) {
        return save(UserFabric.createUser(username,
                        Optional.of(roleService.findByName(roleNameEnum.getName()).get(0))
                                .orElseThrow(NoSuchElementException::new)));
    }

    @Transactional
    User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public User registerUser(User user) {
        LOGGER.info("REGISTER USER \"" + user.getUsername() + "\" START");
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new IllegalArgumentException("Username is already taken");
        }
        user.setRoles(roleService.findByName(RoleNameEnum.BASIC_USER.getName()));
        user = UserFabric.createBaseUser(user);
        userHistoryService.save(user, null, REGISTER);
        user = save(user);
        LOGGER.info("REGISTER USER \"" + user.getUsername() + "\" COMPLETED");
        return user;
    }
}
