package com.abcrestaurant.ordersysem.dto.category;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetCategoriesResponseDTO {
    @JsonProperty("categories")
    public Iterable<CategoryDTO> categories;

    public static class CategoryDTO {
    @JsonProperty("id")
        public Long id;
    @JsonProperty("name")
        public String name;
    }
}
