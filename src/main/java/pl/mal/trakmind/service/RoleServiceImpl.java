package pl.mal.trakmind.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mal.trakmind.model.domain.Role;
import pl.mal.trakmind.repository.RoleRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public List<Role> findByName(String username) {
        return roleRepository.findByName(username);
    }
}
