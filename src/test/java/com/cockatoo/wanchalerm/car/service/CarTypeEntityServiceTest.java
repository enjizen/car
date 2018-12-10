package com.cockatoo.wanchalerm.car.service;

import com.cockatoo.wanchalerm.car.repository.CarTypeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CarTypeEntityServiceTest {

    @InjectMocks
    private CarTypeService carTypeService;

    @Mock
    private CarTypeRepository carTypeRepository;


    @Test
    public void getCarTypeAll(){
        carTypeService.getCarTypeAll();
        verify(carTypeRepository, times(1)).findAll();
    }

}