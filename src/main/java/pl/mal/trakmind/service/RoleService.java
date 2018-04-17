package pl.mal.trakmind.service;

import pl.mal.trakmind.model.domain.Role;

import java.util.List;

public interface RoleService {

    List<Role> findByName(String username);
}
