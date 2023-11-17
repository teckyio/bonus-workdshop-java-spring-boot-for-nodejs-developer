package com.abcrestaurant.ordersysem.service;

import com.abcrestaurant.ordersysem.dto.category.GetCategoriesRequestDTO;
import com.abcrestaurant.ordersysem.dto.category.GetCategoriesResponseDTO;
import com.abcrestaurant.ordersysem.dto.category.GetCategoryFoodsByIdRequestDTO;
import com.abcrestaurant.ordersysem.dto.category.GetCategoryFoodsByIdResponseDTO;
import com.abcrestaurant.ordersysem.entity.CategoryEntity;
import com.abcrestaurant.ordersysem.entity.FoodEntity;
import com.abcrestaurant.ordersysem.repository.CategoryRepository;
import com.abcrestaurant.ordersysem.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

import static com.abcrestaurant.ordersysem.mapper.MapperUtils.copy;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public GetCategoriesResponseDTO getCategories(GetCategoriesRequestDTO requestDTO) {
        GetCategoriesResponseDTO res = new GetCategoriesResponseDTO();
        List<GetCategoriesResponseDTO.CategoryDTO> categoryDTOList = new ArrayList<>();
        res.categories = categoryDTOList;
        for (CategoryEntity categoryEntity : categoryRepository.findAll()) {
            GetCategoriesResponseDTO.CategoryDTO categoryDTO = new GetCategoriesResponseDTO.CategoryDTO();
//            dto.id = categoryEntity.getId();
//            dto.name = categoryEntity.getName();
            copy(categoryEntity, categoryDTO);
            categoryDTOList.add(categoryDTO);
        }
        return res;
    }

    @Override
    public GetCategoryFoodsByIdResponseDTO getCategoryFoodsById(Long id, GetCategoryFoodsByIdRequestDTO requestDTO) {

        if (categoryRepository.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"category not found");
        }

        GetCategoryFoodsByIdResponseDTO res = new GetCategoryFoodsByIdResponseDTO();
        List<GetCategoryFoodsByIdResponseDTO.FoodDTO> foodDTOList = new ArrayList<>();
        res.foods = foodDTOList;

        for (FoodEntity foodEntity : foodRepository.findAllByCategoryId(id)) {
            GetCategoryFoodsByIdResponseDTO.FoodDTO foodDTO = new GetCategoryFoodsByIdResponseDTO.FoodDTO();
//            foodDTO.name = foodEntity.getName();
//            foodDTO.price = foodEntity.getPrice();
            copy(foodEntity, foodDTO);
            foodDTOList.add(foodDTO);
        }

        return res;
    }
}
