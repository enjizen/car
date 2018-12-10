package com.cockatoo.wanchalerm.car.controller;

import com.cockatoo.wanchalerm.car.controller.response.DropDownResponse;
import com.cockatoo.wanchalerm.car.factory.ResponseFactory;
import com.cockatoo.wanchalerm.car.model.CarTypeEntity;
import com.cockatoo.wanchalerm.car.service.CarTypeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@Log4j2
public class CarTypeController {

    @Autowired
    private CarTypeService carTypeService;

    @Autowired
    private ResponseFactory responseFactory;

    @GetMapping(value =  "/car-type/")
    public ResponseEntity getCarTypeAll(){
        log.info("========= Start Get Car type All =======");
        final List<CarTypeEntity> carTypeEntityList = carTypeService.getCarTypeAll();
        final List<DropDownResponse> carTypeResponseList = new ArrayList<>();
        carTypeEntityList.forEach(carTypeEntity -> carTypeResponseList.add(new DropDownResponse(carTypeEntity.getId(), carTypeEntity.getNameThai(), carTypeEntity.getNameEng())));
        ResponseEntity responseEntity = responseFactory.success(carTypeResponseList, List.class);
        log.info("========= End Get Car type All =========");
        return responseEntity;
    }



}
