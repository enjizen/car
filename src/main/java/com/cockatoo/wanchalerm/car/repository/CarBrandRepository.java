package com.cockatoo.wanchalerm.car.repository;

import com.cockatoo.wanchalerm.car.model.CarBrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarBrandRepository extends JpaRepository<CarBrandEntity, Integer> {

    List<CarBrandEntity> findByCarTypeId(Integer carTypeId);
}
