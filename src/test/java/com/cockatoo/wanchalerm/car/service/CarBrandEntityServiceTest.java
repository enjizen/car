package com.cockatoo.wanchalerm.car.service;

import com.cockatoo.wanchalerm.car.repository.CarBrandRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static reactor.core.publisher.Mono.when;

@RunWith(MockitoJUnitRunner.class)
public class CarBrandEntityServiceTest {

    @InjectMocks
    private CarBrandService carBrandService;

    @Mock
    private CarBrandRepository carBrandRepository;

    @Test
    public void getCarBrandList() {
        carBrandService.getCarBrandList(anyInt());
        verify(carBrandRepository, times(1)).findByCarTypeId(anyInt());
    }
}