package pl.mal.trakmind.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mal.trakmind.model.domain.UserHistory;

public interface UserHistoryRepository extends JpaRepository<UserHistory, Long> {
}
