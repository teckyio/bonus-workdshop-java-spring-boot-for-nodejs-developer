package com.abcrestaurant.ordersysem.repository;

import com.abcrestaurant.ordersysem.entity.FoodEntity;
import org.springframework.data.repository.CrudRepository;

public interface FoodRepository extends CrudRepository<FoodEntity, Long> {
    Iterable<FoodEntity> findAllByCategoryId(Long id);
}
