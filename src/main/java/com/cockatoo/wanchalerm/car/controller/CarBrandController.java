package com.cockatoo.wanchalerm.car.controller;

import com.cockatoo.wanchalerm.car.controller.response.DropDownResponse;
import com.cockatoo.wanchalerm.car.factory.ResponseFactory;
import com.cockatoo.wanchalerm.car.model.CarBrandEntity;
import com.cockatoo.wanchalerm.car.service.CarBrandService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Log4j2
public class CarBrandController {

    @Autowired
    private CarBrandService carBrandService;

    @Autowired
    private ResponseFactory responseFactory;

    @GetMapping("/car-brand/{car_type_id}")
    public ResponseEntity getCarBrandById(@PathVariable("car_type_id") Integer carTypeId){
        log.info("========= Start Get Car Brand by  type [{}] =======", carTypeId);
        final List<CarBrandEntity> carBrandEntityList = carBrandService.getCarBrandList(carTypeId);
        final List<DropDownResponse> carBrandResponseList = new ArrayList<>();
        carBrandEntityList.forEach(carBrand -> carBrandResponseList.add(new DropDownResponse(carBrand.getId(), carBrand.getNameThai(), carBrand.getNameEng()) ));
        log.info("========= End Get Car Brand by  type [{}] =========", carTypeId);
        return responseFactory.success(carBrandResponseList, List.class);
    }
}
