package com.cockatoo.wanchalerm.car.controller;

import com.cockatoo.wanchalerm.car.controller.request.CarModelRequest;
import com.cockatoo.wanchalerm.car.controller.response.DropDownResponse;
import com.cockatoo.wanchalerm.car.factory.ResponseFactory;
import com.cockatoo.wanchalerm.car.model.CarModelEntity;
import com.cockatoo.wanchalerm.car.service.CarModelService;
import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Log4j2
public class CarModelController {

    @Autowired
    private CarModelService carModelService;

    @Autowired
    private ResponseFactory responseFactory;

    @PostMapping(value = "/car-model/{brandId}")
    public ResponseEntity addCarModel(@PathVariable("brandId") Integer brandId, @RequestBody List<CarModelRequest> carModelRequests){

        log.info("brand id {} ", brandId);

        log.info("model {} " ,new Gson().toJson(carModelRequests));

        carModelService.addCarModel(carModelRequests, brandId);
        return null;
    }

    @GetMapping(value = "/car-model/{brandId}")
    public ResponseEntity getCarModelAll(@PathVariable("brandId") Integer brandId){
        log.info("========= Start Get Car Model by brand id [{}] =======", brandId);
        List<CarModelEntity> carModelEntityList = carModelService.getCarModel(brandId);
        final List<DropDownResponse> carModelResponseList = new ArrayList<>();
        carModelEntityList.forEach(carModel -> carModelResponseList.add(new DropDownResponse(carModel.getId(), carModel.getNameThai(), carModel.getNameEng()) ));
        log.info("========= End Get Car Model by brand id [{}] =======", brandId);
        return  responseFactory.success(carModelResponseList, List.class);
    }

}
