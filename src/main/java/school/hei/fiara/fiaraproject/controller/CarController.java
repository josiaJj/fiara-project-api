package school.hei.fiara.fiaraproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.hei.fiara.fiaraproject.model.Car;
import school.hei.fiara.fiaraproject.service.CarService;

import java.util.List;

@RestController
@CrossOrigin
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/Car/{id}")
    public Car getCarById(@PathVariable Integer id) {
        return carService.getCarById(id);
    }

    @GetMapping("/Car")
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @PostMapping("/Car/Create")
    public Car createCar(@RequestBody Car car) {
        return carService.createCar(car);
    }

    @PutMapping("/Car/Update/{id}")
    public Car updateCar(@PathVariable Integer id, @RequestBody Car car) {
        return carService.updateCar(id, car);
    }

    @DeleteMapping("/Car/Delete/{id}")
    public void deleteCarById(@PathVariable Integer id) {
        carService.deleteCarById(id);
    }



}
