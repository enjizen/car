package com.cockatoo.wanchalerm.car.service;

import com.cockatoo.wanchalerm.car.repository.CarModelRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CarModelServiceTest {

    @InjectMocks
    private CarModelService carModelService;

    @Mock
    private CarModelRepository carModelRepository;

    @Test
    public void getCarModel() {
        when(carModelRepository.findByCarBrandId(any())).thenReturn(anyList());
        carModelService.getCarModel(1);
        verify(carModelRepository, times(1)).findByCarBrandId(any());
    }
}