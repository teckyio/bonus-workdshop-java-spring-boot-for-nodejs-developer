package com.abcrestaurant.ordersysem.service;

import com.abcrestaurant.ordersysem.dto.food.*;

public interface FoodService {
    PostFoodOrderByIdResponseDTO postFoodOrderById(Long id, PostFoodOrderByIdRequestDTO requestDTO);
}
