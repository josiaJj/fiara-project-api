package school.hei.fiara.fiaraproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import school.hei.fiara.fiaraproject.model.Car;
import school.hei.fiara.fiaraproject.service.CarService;

import java.util.List;

@RestController
@CrossOrigin
public class LandingPageController {
    @Autowired
    private CarService carService;

    @GetMapping("/Car/CarBrand")
    public List<String> getCarBrands() {
        return carService.getCarBrands(6);
    }

    @GetMapping("/Car/ShowCar")
    public List<Car> getShowCars() {
        return carService.getShowCars();
    }
}
