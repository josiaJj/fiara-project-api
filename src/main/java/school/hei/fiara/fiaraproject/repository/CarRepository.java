package school.hei.fiara.fiaraproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import school.hei.fiara.fiaraproject.model.Car;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {
    @Query("SELECT DISTINCT c.type FROM Car c")
    List<String> findDistinctTypes();

    @Query("SELECT DISTINCT c.motor_type FROM Car c")
    List<String> findDistinctMotorTypes();

    @Query("SELECT MIN(c.price) FROM Car c")
    Double findMinPrice();

    @Query("SELECT MAX(c.price) FROM Car c")
    Double findMaxPrice();

    @Query("SELECT DISTINCT c.brand FROM Car c LIMIT ?")
    List<String> findDistinctBrands(int limit);

    @Query("SELECT c FROM Car c ORDER BY c.id DESC LIMIT 6")
    List<Car> findShowCar();


    @Query("SELECT c FROM Car c WHERE c.brand = ?")
    List<Car> findByBrand(String brand);


    @Query("SELECT c FROM Car c WHERE c.model = ?")
    List<Car> findByModel(String model);
}
