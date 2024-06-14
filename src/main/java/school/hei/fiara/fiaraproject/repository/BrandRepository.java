package school.hei.fiara.fiaraproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.hei.fiara.fiaraproject.model.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Integer> {
}