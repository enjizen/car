package com.cockatoo.wanchalerm.car.service;

import com.cockatoo.wanchalerm.car.model.CarTypeEntity;
import com.cockatoo.wanchalerm.car.repository.CarTypeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class CarTypeService {

    @Autowired
    private CarTypeRepository carTypeRepository;

    public List<CarTypeEntity> getCarTypeAll(){
        log.info("Start get car type all");
        List<CarTypeEntity> carTypeEntityList = carTypeRepository.findAll();
        log.info("End get car type all");
        return carTypeEntityList;
    }
}
