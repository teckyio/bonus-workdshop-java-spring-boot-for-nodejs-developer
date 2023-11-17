package com.abcrestaurant.ordersysem.dto.food;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostFoodOrderByIdRequestDTO {
    @JsonProperty("quantity")
    public Integer quantity;
}
