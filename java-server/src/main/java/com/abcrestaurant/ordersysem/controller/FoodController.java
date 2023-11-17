package com.abcrestaurant.ordersysem.controller;

import com.abcrestaurant.ordersysem.dto.food.*;

import com.abcrestaurant.ordersysem.dto.food.PostFoodOrderByIdRequestDTO;
import com.abcrestaurant.ordersysem.dto.food.PostFoodOrderByIdResponseDTO;
import com.abcrestaurant.ordersysem.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.abcrestaurant.ordersysem.validator.ValidatorUtils.assertNoNull;

@RestController
@RequestMapping("foods")
public class FoodController {
  @Autowired
  FoodService foodService;

    // POST /foods/:id/order
    @PostMapping("{id}/order")
    public PostFoodOrderByIdResponseDTO postFoodOrderById(@PathVariable Long id, @RequestBody PostFoodOrderByIdRequestDTO requestDTO) {
        // to add validation logic
        assertNoNull(requestDTO, "req.body");

        return foodService.postFoodOrderById(id, requestDTO);
    }
}
