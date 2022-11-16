package com.example.v3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
public class controller {
    @Autowired
    private carRepo carRepo;

    @ExceptionHandler(NoSuchElementException.class)
    public String handleNoSuchElement(NoSuchElementException e){
        return "No such element" + e.getMessage();
    }

    @GetMapping("/car")
    public Iterable<car> getCars(){
        return carRepo.findAll();
    }

    @PostMapping("/save")
    public String saveCars(@RequestBody car Car){
        carRepo.save(Car);
        return "SUCCESS";
    }

    @PutMapping("/update/{id}")
    public String updateCars(@PathVariable long id,@RequestBody car Car){
        car updateCar = carRepo.findById(id).get();
        updateCar.setCarType(Car.getCarType());
        updateCar.setLicensePlate(Car.getLicensePlate());
        updateCar.setVehicleIdentificationNumber(Car.getVehicleIdentificationNumber());
        carRepo.save(updateCar);
        return "SUCCESS";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCar(@PathVariable long id){
        car delete = carRepo.findById(id).get();
        carRepo.delete(delete);
        return "SUCCESS";
    }
}
