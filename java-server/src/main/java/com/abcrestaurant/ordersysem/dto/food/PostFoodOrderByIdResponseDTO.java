package com.abcrestaurant.ordersysem.dto.food;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostFoodOrderByIdResponseDTO {
    @JsonProperty("order_id")
    public Long orderId;
}
