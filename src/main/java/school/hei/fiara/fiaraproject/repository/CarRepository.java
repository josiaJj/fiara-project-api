package school.hei.fiara.fiaraproject.repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import school.hei.fiara.fiaraproject.model.Car;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    @Query("SELECT DISTINCT c.type FROM Car c")
    List<String> findDistinctTypes();

    @Query("SELECT DISTINCT c.motorType FROM Car c")
    List<String> findDistinctMotorTypes();

    @Query("SELECT MIN(c.price) FROM Car c")
    Double findMinPrice();

    @Query("SELECT MAX(c.price) FROM Car c")
    Double findMaxPrice();

    @Query("SELECT DISTINCT c.brand FROM Car c")
    List<String> findDistinctBrands(Pageable pageable);

    @Query("SELECT c FROM Car c ORDER BY c.id DESC")
    List<Car> findShowCar(Pageable pageable);

    @Query("SELECT c FROM Car c WHERE c.brand = :brand")
    List<Car> findByBrand(@Param("brand") String brand);

    @Query("SELECT c FROM Car c WHERE c.model = :model")
    List<Car> findByModel(@Param("model") String model);
}
