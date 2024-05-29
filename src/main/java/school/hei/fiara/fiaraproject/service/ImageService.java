package school.hei.fiara.fiaraproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.hei.fiara.fiaraproject.model.Car;
import school.hei.fiara.fiaraproject.model.Images;
import school.hei.fiara.fiaraproject.repository.CarRepository;
import school.hei.fiara.fiaraproject.repository.ImageRepository;

import java.util.List;
import java.util.Optional;
@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    public Optional<Images> findById(Integer id) {
        return imageRepository.findById(id);
    }

    public List<Images> findAll() {
        return imageRepository.findAll();
    }

    public Images save(Images images) {
        return imageRepository.save(images);
    }

    public Images update(Images images) {
        return imageRepository.save(images);
    }

    public void deleteById(Integer id) {
        imageRepository.deleteById(id);
    }

}
