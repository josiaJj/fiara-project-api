package school.hei.fiara.fiaraproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.hei.fiara.fiaraproject.model.Car;
import school.hei.fiara.fiaraproject.model.Images;
import school.hei.fiara.fiaraproject.service.ImageService;

import java.util.List;
import java.util.Optional;

@RequestMapping("/images")
@RestController
public class ImageController {
    @Autowired
    private ImageService  imageService;


    @GetMapping("/{id}")
    public Optional<Images> getImageById(@PathVariable Integer id) {
        return imageService.findById(id);
    }

    @GetMapping
    public List<Images> getAllImages() {
        return imageService.findAll();
    }

    @PostMapping
    public Images createImage(@RequestBody Images images) {
        return imageService.save(images);
    }

    @PutMapping
    public Images updateImages(@RequestBody Images images){
        return imageService.update(images);
    }

    @DeleteMapping("/{id}")
    public void deleteImageById(@PathVariable Integer id) {
        imageService.deleteById(id);
    }

}
