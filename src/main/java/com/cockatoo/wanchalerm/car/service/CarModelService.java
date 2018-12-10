package com.cockatoo.wanchalerm.car.service;

import com.cockatoo.wanchalerm.car.controller.request.CarModelRequest;
import com.cockatoo.wanchalerm.car.model.CarBrandEntity;
import com.cockatoo.wanchalerm.car.model.CarModelEntity;
import com.cockatoo.wanchalerm.car.repository.CarModelRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class CarModelService {

    @Autowired
    private CarModelRepository carModelRepository;

    public void addCarModel(List<CarModelRequest> carModelRequestList, int brandId){
        log.info("start add");
        List<CarModelEntity> carModelEntityList = new ArrayList<>();
        carModelRequestList.forEach(item->{
            CarModelEntity carModelEntity = new CarModelEntity();
            carModelEntity.setNameEng(item.getLabel());
            carModelEntity.setNameThai(item.getLabel());
            CarBrandEntity carBrandEntity = new CarBrandEntity();
            carBrandEntity.setId(brandId);
            carModelEntity.setCarBrandId(carBrandEntity);
            carModelEntityList.add(carModelEntity);
        });

        carModelRepository.saveAll(carModelEntityList);
        log.info("end add");
    }

    public List<CarModelEntity> getCarModel(Integer brandId){
        log.info("Start get car model");

        CarBrandEntity carBrandEntity = new CarBrandEntity();
        carBrandEntity.setId(brandId);

        List<CarModelEntity> carModelEntityList = carModelRepository.findByCarBrandId(carBrandEntity);

        log.info("End get car model");

        return carModelEntityList;
    }

}
