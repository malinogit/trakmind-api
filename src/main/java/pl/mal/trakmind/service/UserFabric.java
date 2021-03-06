package pl.mal.trakmind.service;

import pl.mal.trakmind.model.domain.Role;
import pl.mal.trakmind.model.domain.User;

import java.util.Collections;

class UserFabric {

    static User createUser(String username, Role role) {
        return new User(null, username, "password", "nullMail", true, true,
                true, true, null, Collections.singleton(role));
    }
    static User createBaseUser(User user) {
        user.setPassword("{noop}" + user.getPassword());
        user.setEnabled(true);
        user.setAccountNotExpired(true);
        user.setCredentialsNonExpired(true);
        user.setAccountNonLocked(true);
        return user;
    }
}
