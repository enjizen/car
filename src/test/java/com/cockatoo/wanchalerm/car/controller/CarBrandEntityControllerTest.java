package com.cockatoo.wanchalerm.car.controller;

import com.cockatoo.wanchalerm.car.constant.GeneralResponse;
import com.cockatoo.wanchalerm.car.controller.response.DropDownResponse;
import com.cockatoo.wanchalerm.car.factory.ResponseFactory;
import com.cockatoo.wanchalerm.car.model.CarBrandEntity;
import com.cockatoo.wanchalerm.car.service.CarBrandService;
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

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CarBrandEntityControllerTest {

    @InjectMocks
    private CarBrandController carBrandController;

    @Mock
    private CarBrandService carBrandService;

    @Mock
    private ResponseFactory responseFactory;

    @Before
    public void setup() {
        when(responseFactory.success(ArgumentMatchers.any(), ArgumentMatchers.any()))
                .thenCallRealMethod();
    }

    @Test
    public void getCarBrandById() {
        CarBrandEntity carBrandEntity = new CarBrandEntity();
        carBrandEntity.setId(1);
        carBrandEntity.setNameThai("ทดสอบ");
        carBrandEntity.setNameEng("test");
        carBrandEntity.setCarTypeId(1);

        List<CarBrandEntity> carBrandEntityList = new ArrayList<>();
        carBrandEntityList.add(carBrandEntity);
        when(carBrandService.getCarBrandList(1)).thenReturn(carBrandEntityList);

        ResponseEntity responseEntity = carBrandController.getCarBrandById(1);
        final GeneralResponse<List<DropDownResponse>> result = (GeneralResponse<List<DropDownResponse>>) responseEntity.getBody();
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        assertNotNull(result);
        DropDownResponse response = result.getData().get(0);
        assertEquals(response.getId().intValue(), 1);
        assertEquals(response.getLabelThai(), "ทดสอบ");
        assertEquals(response.getLabelEng(), "test");

        verify(carBrandService, times(1)).getCarBrandList(anyInt());

    }
}