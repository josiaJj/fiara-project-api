package school.hei.fiara.fiaraproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.hei.fiara.fiaraproject.model.Car;
import school.hei.fiara.fiaraproject.model.User;
import school.hei.fiara.fiaraproject.service.CarService;

import java.util.List;
import java.util.Optional;

@RequestMapping("/cars")
@RestController
public class CarController {
    @Autowired
    private CarService carService;



    @GetMapping("/{id}")
    public Optional<Car> getCarById(@PathVariable Integer id) {
        return carService.findById(id);
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carService.findAll();
    }

    @PostMapping
    public Car createCar(@RequestBody Car car) {
        return carService.save(car);
    }

    @PutMapping
    public Car updateCar(@RequestBody Car car){
        return carService.update(car);
    }

    @DeleteMapping("/{id}")
    public void deleteCarById(@PathVariable Integer id) {
        carService.deleteById(id);
    }

}
