package com.abcrestaurant.ordersysem.service;

import com.abcrestaurant.ordersysem.dto.order.DeleteOrderByIdRequestDTO;
import com.abcrestaurant.ordersysem.dto.order.DeleteOrderByIdResponseDTO;
import com.abcrestaurant.ordersysem.dto.order.GetOrdersRequestDTO;
import com.abcrestaurant.ordersysem.dto.order.GetOrdersResponseDTO;
import com.abcrestaurant.ordersysem.entity.FoodEntity;
import com.abcrestaurant.ordersysem.entity.OrderEntity;
import com.abcrestaurant.ordersysem.entity.OrderStatus;
import com.abcrestaurant.ordersysem.repository.FoodRepository;
import com.abcrestaurant.ordersysem.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
  @Autowired
  OrderRepository orderRepository;

  @Autowired
  FoodRepository foodRepository;


  @Override
  public GetOrdersResponseDTO getOrders(GetOrdersRequestDTO requestDTO) {
    GetOrdersResponseDTO res = new GetOrdersResponseDTO();
    List<GetOrdersResponseDTO.OrderDTO> orderDTOList = new ArrayList<>();
    res.orders = orderDTOList;

    String status = requestDTO.status.name();
    System.out.println("filter by status: " + status);
    Iterable<OrderEntity> orderEntities = orderRepository.getRecentPendingOrders(status,10);

    for (OrderEntity orderEntity : orderEntities) {
      GetOrdersResponseDTO.OrderDTO orderDTO = new GetOrdersResponseDTO.OrderDTO();
      orderDTO.orderId = orderEntity.getId();
      orderDTO.foodId = orderEntity.getFoodId();
      FoodEntity foodEntity = foodRepository.findById(orderEntity.getFoodId()).orElseThrow();
      orderDTO.foodName = foodEntity.getName();
      orderDTO.quantity = orderEntity.getQuantity();
      orderDTOList.add(orderDTO);
    }
    return res;
  }

  @Override
  public DeleteOrderByIdResponseDTO deleteOrderById(Long id, DeleteOrderByIdRequestDTO requestDTO) {
    Optional<OrderEntity> orderEntityOptional = orderRepository.findById(id);
    if (orderEntityOptional.isEmpty()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND,"order not found");
    }
    OrderEntity orderEntity = orderEntityOptional.get();
    orderEntity.setStatus(OrderStatus.cancelled);
    orderRepository.save(orderEntity);
    DeleteOrderByIdResponseDTO res = new DeleteOrderByIdResponseDTO();
    return res;
//    return null;
  }
}
