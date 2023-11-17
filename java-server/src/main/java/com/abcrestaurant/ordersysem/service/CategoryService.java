package com.abcrestaurant.ordersysem.service;

import com.abcrestaurant.ordersysem.dto.category.*;

public interface CategoryService {
    GetCategoriesResponseDTO getCategories(GetCategoriesRequestDTO requestDTO);

    GetCategoryFoodsByIdResponseDTO getCategoryFoodsById(Long id, GetCategoryFoodsByIdRequestDTO requestDTO);
}
