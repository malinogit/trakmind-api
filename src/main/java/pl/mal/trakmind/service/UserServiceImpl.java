package pl.mal.trakmind.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mal.trakmind.model.RoleNameEnum;
import pl.mal.trakmind.model.domain.User;
import pl.mal.trakmind.repository.UserRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(String username, RoleNameEnum roleNameEnum) {
        return userRepository.save(
                UserFabric.createUser(username,
                        Optional.of(roleService.findByName(roleNameEnum.getName()).get(0))
                                .orElseThrow(NoSuchElementException::new)));
    }

    @Override
    public List<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
