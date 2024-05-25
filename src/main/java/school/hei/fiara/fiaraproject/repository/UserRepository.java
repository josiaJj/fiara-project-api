package school.hei.fiara.fiaraproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.hei.fiara.fiaraproject.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
