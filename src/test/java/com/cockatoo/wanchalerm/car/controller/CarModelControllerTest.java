package com.cockatoo.wanchalerm.car.controller;

import com.cockatoo.wanchalerm.car.constant.GeneralResponse;
import com.cockatoo.wanchalerm.car.controller.response.DropDownResponse;
import com.cockatoo.wanchalerm.car.factory.ResponseFactory;
import com.cockatoo.wanchalerm.car.model.CarBrandEntity;
import com.cockatoo.wanchalerm.car.model.CarModelEntity;
import com.cockatoo.wanchalerm.car.service.CarModelService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CarModelControllerTest {

    @InjectMocks
    private CarModelController carModelController;

    @Mock
    private CarModelService carModelService;

    @Mock
    private ResponseFactory responseFactory;

    @Before
    public void setup() {
        when(responseFactory.success(ArgumentMatchers.any(), ArgumentMatchers.any()))
                .thenCallRealMethod();
    }

    @Test
    public void test_getCar_model(){
        CarModelEntity carModelEntity = new CarModelEntity();
        carModelEntity.setId(1);
        carModelEntity.setNameEng("test");
        carModelEntity.setNameThai("ทดสอบ");
        CarBrandEntity carBrandEntity = new CarBrandEntity();
        carBrandEntity.setId(1);
        carModelEntity.setCarBrandId(carBrandEntity);

        List<CarModelEntity> carModelEntityList = new ArrayList<>();
        carModelEntityList.add(carModelEntity);

        when(carModelService.getCarModel(anyInt())).thenReturn(carModelEntityList);

        ResponseEntity responseEntity = carModelController.getCarModelAll(1);

        final GeneralResponse<List<DropDownResponse>> result = (GeneralResponse<List<DropDownResponse>>) responseEntity.getBody();
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        assertNotNull(result);
        DropDownResponse response = result.getData().get(0);
        assertEquals(response.getId().intValue(), 1);
        assertEquals(response.getLabelThai(), "ทดสอบ");
        assertEquals(response.getLabelEng(), "test");
        verify(carModelService, times(1)).getCarModel(1);
    }

}