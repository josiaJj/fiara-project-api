package school.hei.fiara.fiaraproject.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.hei.fiara.fiaraproject.model.Image;
import school.hei.fiara.fiaraproject.repository.ImageRepository;


import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    public Optional<Image> findById(Integer id){
        return  imageRepository.findById(id);
    }
    public List<Image> finAll(){
        return imageRepository.findAll();
    }
    public Image register(Image image){
        return  imageRepository.save(image);
    }
    public void delete(Integer id ){
        imageRepository.deleteImageById(id);
    }
    public Image updateImage(Integer id, Image newImageDetails) {
        Optional<Image> optionalImage = imageRepository.findById(id);

        if (optionalImage.isPresent()) {
            Image existingImage = optionalImage.get();
            existingImage.setName(newImageDetails.getName());
            existingImage.setUrl(newImageDetails.getUrl());
            return imageRepository.save(existingImage);
        } else {
            throw new RuntimeException("User not found with id  : " + id);
        }
    }
}