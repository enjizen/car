package com.cockatoo.wanchalerm.car.repository;

import com.cockatoo.wanchalerm.car.model.CarBrandEntity;
import com.cockatoo.wanchalerm.car.model.CarModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarModelRepository extends JpaRepository<CarModelEntity, Integer> {

    List<CarModelEntity> findByCarBrandId(CarBrandEntity carBrandEntity);
}
