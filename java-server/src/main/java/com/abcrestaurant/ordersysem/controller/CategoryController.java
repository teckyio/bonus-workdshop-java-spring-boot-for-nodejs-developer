package com.abcrestaurant.ordersysem.controller;

import com.abcrestaurant.ordersysem.dto.category.*;
import com.abcrestaurant.ordersysem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.abcrestaurant.ordersysem.validator.ValidatorUtils.assertNoNull;

@RestController
@RequestMapping("categories")
public class CategoryController {
  @Autowired
  CategoryService categoryService;

    // GET /categories
    @GetMapping
    public GetCategoriesResponseDTO getCategories(GetCategoriesRequestDTO requestDTO) {
        // to add validation logic
        assertNoNull(requestDTO, "req.body");
        return categoryService.getCategories(requestDTO);
    }

    // GET /categories/:id/foods
    @GetMapping("{id}/foods")
    public GetCategoryFoodsByIdResponseDTO getCategoryFoodsById(@PathVariable Long id, GetCategoryFoodsByIdRequestDTO requestDTO) {
        // to add validation logic
        assertNoNull(requestDTO, "req.body");
        return categoryService.getCategoryFoodsById(id, requestDTO);
    }
}
