package ca.badalsarkar.carddatabase.controllers;

import ca.badalsarkar.carddatabase.model.Car;
import ca.badalsarkar.carddatabase.repositories.CarRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    @Autowired
    private CarRepositories carRepository;

    @GetMapping("/cars")
    public Iterable<Car> getCars(){
        return carRepository.findAll();
    }
}
