package pl.mal.trakmind.service;

import pl.mal.trakmind.model.RoleNameEnum;
import pl.mal.trakmind.model.domain.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User save(String username, RoleNameEnum roleNameEnum);
    List<User> findByUsername(String name);
    User registerUser(User user);
}
