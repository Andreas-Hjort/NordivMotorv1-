package com.motorhome.demo.Service;

import com.motorhome.demo.Model.Cars;
import com.motorhome.demo.Repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    CarRepo carRepo;

    public List<Cars> fetchALL() {
        return carRepo.fetchALL();
    }

    public Cars addCar(Cars c) {
        return carRepo.addCars(c);
    }

    public Boolean deleteCar(int id) {
        return carRepo.deleteCar(id);
    }
}