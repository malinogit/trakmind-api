package pl.mal.trakmind.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mal.trakmind.model.domain.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByUsername(String username);
}
