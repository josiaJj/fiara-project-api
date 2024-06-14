package school.hei.fiara.fiaraproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.hei.fiara.fiaraproject.model.Car;
import school.hei.fiara.fiaraproject.service.CarService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/car")
@CrossOrigin(origins = {"http://localhost:3000"})

public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/all")
    public List<Car> findAll(){
        return  carService.findAllCar();
    }
    @GetMapping("/{id}")
    public Optional<Car> findById(@PathVariable Integer id){
        return  carService.findCarById(id);
    }

    @PostMapping("/register")
    public  Car register(@RequestBody  Car car){
        return carService.saveCar(car);
    }
    @DeleteMapping("/{id}")
    public  void deleteCar(@PathVariable Integer id ){
        carService.delete(id);
    }
    @GetMapping("/brand")
    public List<Car> getCarsByBrand(@RequestParam String brand) {
        return carService.findAllCarByBrand(brand);
    }
    @GetMapping("/brand-name")
    public List<Car> findCarsByBrandModelContaining(@RequestParam String brand) {
        return carService.findCarsByBrandModelContaining(brand);
    }
    @PutMapping("/{id}")
    public Car UpdateCar(@PathVariable Integer id , @RequestBody Car car){
        return  carService.updateCar(id,car);
    }
}