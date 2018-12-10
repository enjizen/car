package com.cockatoo.wanchalerm.car.repository;

import com.cockatoo.wanchalerm.car.model.CarTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarTypeRepository extends JpaRepository<CarTypeEntity, Integer> {
}
