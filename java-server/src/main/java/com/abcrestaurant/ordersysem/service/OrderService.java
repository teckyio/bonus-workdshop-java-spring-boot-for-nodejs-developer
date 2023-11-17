package com.abcrestaurant.ordersysem.service;

import com.abcrestaurant.ordersysem.dto.order.*;

public interface OrderService {
    GetOrdersResponseDTO getOrders(GetOrdersRequestDTO requestDTO);

    DeleteOrderByIdResponseDTO deleteOrderById(Long id, DeleteOrderByIdRequestDTO requestDTO);
}
