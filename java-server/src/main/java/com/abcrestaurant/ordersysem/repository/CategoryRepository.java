package com.abcrestaurant.ordersysem.repository;

import com.abcrestaurant.ordersysem.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {
}
