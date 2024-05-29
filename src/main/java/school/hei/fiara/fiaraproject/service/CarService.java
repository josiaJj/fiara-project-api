package school.hei.fiara.fiaraproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import school.hei.fiara.fiaraproject.model.Car;
import school.hei.fiara.fiaraproject.repository.CarRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Car getCarById(Integer id) {
        Optional<Car> carOptional = carRepository.findById(id);
        if (carOptional.isPresent()){
            carOptional.get();
        }
        return null;
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    public Car updateCar(Integer id, Car car) {
        Optional<Car> existingCar = carRepository.findById(id);
        if (existingCar.isPresent()) {
            Car carToUpdate = existingCar.get();
            carToUpdate.setName(car.getName());
            carToUpdate.setDescription(car.getDescription());
            carToUpdate.setBrand(car.getBrand());
            carToUpdate.setModel(car.getModel());
            carToUpdate.setPrice(car.getPrice());
            carToUpdate.setColor(car.getColor());
            carToUpdate.setMotorType(car.getMotorType());
            carToUpdate.setPower(car.getPower());
            carToUpdate.setPlaceNumber(car.getPlaceNumber());
            carToUpdate.setStatus(car.getStatus());
            carToUpdate.setType(car.getType());
            return carRepository.save(carToUpdate);
        } else {
            return null;
        }
    }

    public void deleteCarById(Integer id) {
        carRepository.deleteById(id);
    }


    public List<String> getAllCarTypes() {
        return carRepository.findDistinctTypes();
    }

    public List<String> getAllMotorTypes() {
        return carRepository.findDistinctMotorTypes();
    }

    public Double getMinPrice() {
        return carRepository.findMinPrice();
    }

    public Double getMaxPrice() {
        return carRepository.findMaxPrice();
    }

    public List<String> getCarBrands(int limit) {
        return carRepository.findDistinctBrands(PageRequest.of(0, limit));
    }

    public List<Car> getShowCars(int limit) {
        return carRepository.findShowCar(PageRequest.of(0, limit));
    }

    public List<Car> getCarsByBrand(String brand) {
        return carRepository.findByBrand(brand);
    }
    public List<Car> getCarByModel(String model){
        return carRepository.findByModel(model);
    }

}
