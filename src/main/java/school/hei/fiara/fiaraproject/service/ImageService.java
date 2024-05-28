package school.hei.fiara.fiaraproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.hei.fiara.fiaraproject.model.Images;
import school.hei.fiara.fiaraproject.repository.ImageRepository;


import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public Images getImageById(Integer id) {
        Optional<Images> imageOptional = imageRepository.findById(id);
       if (imageOptional.isPresent()){
         imageOptional.get();
       }
       return null;
    }

    public List<Images> getAllImages() {
        return imageRepository.findAll();
    }

    public Images createImage(Images image) {
        return imageRepository.save(image);
    }

    public Images updateImage(Integer id, Images image) {
        Optional<Images> existingImage = imageRepository.findById(id);
        if (existingImage.isPresent()) {
            Images imageToUpdate = existingImage.get();
            imageToUpdate.setProductId(image.getProductId());
            imageToUpdate.setUrl(image.getUrl());
            return imageRepository.save(imageToUpdate);
        } else {
            return null;
        }
    }

    public void deleteImageById(Integer id) {
        imageRepository.deleteById(id);
    }
}
