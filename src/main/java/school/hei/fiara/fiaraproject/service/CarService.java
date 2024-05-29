package school.hei.fiara.fiaraproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.hei.fiara.fiaraproject.model.Car;

import school.hei.fiara.fiaraproject.repository.CarRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public Optional<Car> findById(Integer id) {
        return carRepository.findById(id);
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Car save(Car car) {
        return carRepository.save(car);
    }

    public Car update(Car car) {
        return carRepository.save(car);
    }

    public void deleteById(Integer id) {
        carRepository.deleteById(id);
    }

}
