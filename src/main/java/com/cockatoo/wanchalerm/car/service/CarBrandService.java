package com.cockatoo.wanchalerm.car.service;

import com.cockatoo.wanchalerm.car.model.CarBrand;
import com.cockatoo.wanchalerm.car.repository.CarBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarBrandService {
    @Autowired
    private CarBrandRepository carBrandRepository;

    public List<CarBrand> getCarBrandList( Integer carTypeId){
        return carBrandRepository.findByCarTypeId(carTypeId);
    }
}
