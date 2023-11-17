package com.abcrestaurant.ordersysem.dto.category;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetCategoryFoodsByIdResponseDTO {
    @JsonProperty("foods")
    public Iterable<FoodDTO> foods;
    public static class FoodDTO {
    @JsonProperty("id")
        public Long id;
    @JsonProperty("name")
        public String name;
    @JsonProperty("price")
        public Double price;
    }
}
