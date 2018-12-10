package com.cockatoo.wanchalerm.car.service;

import com.cockatoo.wanchalerm.car.model.CarBrandEntity;
import com.cockatoo.wanchalerm.car.repository.CarBrandRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class CarBrandService {
    @Autowired
    private CarBrandRepository carBrandRepository;

    public List<CarBrandEntity> getCarBrandList(Integer carTypeId){
        log.info("Start get car brand");
        List<CarBrandEntity> carBrandList = carBrandRepository.findByCarTypeId(carTypeId);
        log.info("End get car brand");
        return carBrandList;
    }
}
