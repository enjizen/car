package com.cockatoo.wanchalerm.car.controller;

import com.cockatoo.wanchalerm.car.constant.GeneralResponse;
import com.cockatoo.wanchalerm.car.controller.response.CarBrandResponse;
import com.cockatoo.wanchalerm.car.factory.ResponseFactory;
import com.cockatoo.wanchalerm.car.model.CarBrand;
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
public class CarBrandControllerTest {

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
        CarBrand carBrand = new CarBrand();
        carBrand.setId(1);
        carBrand.setNameThai("ทดสอบ");
        carBrand.setNameEng("test");
        carBrand.setCarTypeId(1);

        List<CarBrand> carBrandList = new ArrayList<>();
        carBrandList.add(carBrand);
        when(carBrandService.getCarBrandList(1)).thenReturn(carBrandList);

        ResponseEntity responseEntity = carBrandController.getCarBrandById(1);
        final GeneralResponse<List<CarBrandResponse>> result = (GeneralResponse<List<CarBrandResponse>>) responseEntity.getBody();
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        assertNotNull(result);
        CarBrandResponse response = result.getData().get(0);
        assertEquals(response.getId().intValue(), 1);
        assertEquals(response.getBrandNameThai(), "ทดสอบ");
        assertEquals(response.getBrandNameEng(), "test");

        verify(carBrandService, times(1)).getCarBrandList(anyInt());

    }
}