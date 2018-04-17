package pl.mal.trakmind.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mal.trakmind.model.domain.Role;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {

    List<Role> findByName(String name);
}
