package com.abcrestaurant.ordersysem.service;

import com.abcrestaurant.ordersysem.dto.food.PostFoodOrderByIdRequestDTO;
import com.abcrestaurant.ordersysem.dto.food.PostFoodOrderByIdResponseDTO;
import com.abcrestaurant.ordersysem.entity.OrderEntity;
import com.abcrestaurant.ordersysem.entity.OrderStatus;
import com.abcrestaurant.ordersysem.repository.FoodRepository;
import com.abcrestaurant.ordersysem.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class FoodServiceImpl implements FoodService {
  @Autowired
  FoodRepository foodRepository;


  @Autowired
  OrderRepository orderRepository;

  @Override
  public PostFoodOrderByIdResponseDTO postFoodOrderById(Long id, PostFoodOrderByIdRequestDTO requestDTO) {
    if (requestDTO.quantity<=0) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "quantity should be > 0");
    }
    if (requestDTO.quantity>10) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "quantity should be <= 10");
    }
    if (!foodRepository.existsById(id)) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND,"food not found");
    }

    OrderEntity orderEntity = new OrderEntity();
    orderEntity.setFoodId(id);
    orderEntity.setQuantity((long) requestDTO.quantity);
    orderEntity.setStatus(OrderStatus.pending);
    orderEntity = orderRepository.save(orderEntity);
    PostFoodOrderByIdResponseDTO res = new PostFoodOrderByIdResponseDTO();
    res.orderId = orderEntity.getId();
    return res;
  }
}
