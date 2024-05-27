package school.hei.fiara.fiaraproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.hei.fiara.fiaraproject.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {
}
