package school.hei.fiara.fiaraproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import school.hei.fiara.fiaraproject.model.Image;


@Repository
public interface ImageRepository extends JpaRepository<Image,Integer> {
    @Query(value = "SELECT DeleteImage(:imageId);", nativeQuery = true)
    void deleteImageById(@Param("imageId") Integer imageId);
}