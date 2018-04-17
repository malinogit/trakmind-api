package pl.mal.trakmind.service;

import pl.mal.trakmind.model.domain.Role;
import pl.mal.trakmind.model.domain.User;

import java.util.Collections;

class UserFabric {

    static User createUser(String username, Role role) {
        return new User(null, username, "password", true, true,
                true, true, Collections.singleton(role));
    }
}
