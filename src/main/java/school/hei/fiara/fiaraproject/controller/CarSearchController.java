package school.hei.fiara.fiaraproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import school.hei.fiara.fiaraproject.model.Car;
import school.hei.fiara.fiaraproject.service.CarService;

import java.util.List;
@RestController
@CrossOrigin
public class CarSearchController {
    @Autowired
   private CarService carService;

    @GetMapping("/Car/Types")
    public List<String> getAllCarTypes() {
        return carService.getAllCarTypes();
    }

    @GetMapping("/Car/MotorTypes")
    public List<String> getAllMotorTypes() {
        return carService.getAllMotorTypes();
    }



    @GetMapping("/Car/MinPrice")
    public Double getMinPrice(){
        return carService.getMinPrice();
    }
    @GetMapping("/Car/MaxPrice")
    public Double getMaxPrice(){
        return carService.getMaxPrice();
    }


    @GetMapping("/Car/ByBrand")
    public List<Car> getCarsByBrand(@RequestParam String brand) {
        return carService.getCarByBrand(brand);
    }

    @GetMapping("/Car/ByModel")
    public  List<Car> getCarByModel(@RequestParam String model){
        return carService.getCarByModel(model);
    }

}
