
package com.cockatoo.wanchalerm.car.controller;


import com.cockatoo.wanchalerm.car.constant.GeneralResponse;
import com.cockatoo.wanchalerm.car.controller.response.DropDownResponse;
import com.cockatoo.wanchalerm.car.factory.ResponseFactory;
import com.cockatoo.wanchalerm.car.model.CarTypeEntity;
import com.cockatoo.wanchalerm.car.service.CarTypeService;
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
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CarTypeEntityControllerTest {

    @InjectMocks
    private CarTypeController carTypeController;

    @Mock
    private CarTypeService carTypeService;

    @Mock
    private ResponseFactory responseFactory;

    @Before
    public void setup() {
        when(responseFactory.success(ArgumentMatchers.any(), ArgumentMatchers.any()))
                .thenCallRealMethod();
    }

    @Test
    public void test_getCarTypeSuccess() {

        CarTypeEntity carTypeEntity = new CarTypeEntity();
        carTypeEntity.setId(1);
        carTypeEntity.setNameThai("ทดสอบ");
        carTypeEntity.setNameEng("test");
        carTypeEntity.setUpdatedDate(new Date());

        List<CarTypeEntity> carTypeEntityList = new ArrayList<>();
        carTypeEntityList.add(carTypeEntity);

        when(carTypeService.getCarTypeAll()).thenReturn(carTypeEntityList);
        ResponseEntity responseEntity = carTypeController.getCarTypeAll();
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        assertNotNull(responseEntity);
        final GeneralResponse<List<DropDownResponse>> result = (GeneralResponse<List<DropDownResponse>>) responseEntity.getBody();
        assertNotNull(result);
        DropDownResponse resultValue = result.getData().get(0);
        assertEquals(resultValue.getId().intValue(), 1);
        assertEquals(resultValue.getLabelThai(), "ทดสอบ");
        assertEquals(resultValue.getLabelEng(), "test");
        verify(carTypeService, times(1)).getCarTypeAll();
    }

}
