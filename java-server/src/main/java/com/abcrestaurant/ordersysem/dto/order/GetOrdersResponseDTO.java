package com.abcrestaurant.ordersysem.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetOrdersResponseDTO {
    @JsonProperty("orders")
    public Iterable<OrderDTO> orders;
    public static class OrderDTO {
    @JsonProperty("order_id")
        public Long orderId;
    @JsonProperty("food_id")
        public Long foodId;
    @JsonProperty("food_name")
        public String foodName;
    @JsonProperty("quantity")
        public Long quantity;
    }
}
