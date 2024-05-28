package school.hei.fiara.fiaraproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.hei.fiara.fiaraproject.model.Images;
import school.hei.fiara.fiaraproject.service.ImageService;


import java.util.List;

@RestController
@CrossOrigin
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping("/Image/{id}")
    public Images getImageById(@PathVariable Integer id) {
        return imageService.getImageById(id);
    }

    @GetMapping("/Image")
    public List<Images> getAllImages() {
        return imageService.getAllImages();
    }

    @PostMapping("/Image/Create")
    public Images createImage(@RequestBody Images image) {
        return imageService.createImage(image);
    }

    @PutMapping("/Image/Update{id}")
    public Images updateImage(@PathVariable Integer id, @RequestBody Images image) {
        return imageService.updateImage(id, image);
    }

    @DeleteMapping("/Image/Delete/{id}")
    public void deleteImageById(@PathVariable Integer id) {
        imageService.deleteImageById(id);
    }
}
