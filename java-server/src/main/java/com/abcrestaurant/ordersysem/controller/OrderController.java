package com.abcrestaurant.ordersysem.controller;

import com.abcrestaurant.ordersysem.dto.order.DeleteOrderByIdRequestDTO;
import com.abcrestaurant.ordersysem.dto.order.DeleteOrderByIdResponseDTO;
import com.abcrestaurant.ordersysem.dto.order.GetOrdersRequestDTO;
import com.abcrestaurant.ordersysem.dto.order.GetOrdersResponseDTO;
import com.abcrestaurant.ordersysem.entity.OrderStatus;
import com.abcrestaurant.ordersysem.service.OrderService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.abcrestaurant.ordersysem.validator.ValidatorUtils.assertNoNull;

@RestController
@RequestMapping("orders")
public class OrderController {
  @Autowired
  OrderService orderService;

    // GET /orders
    @GetMapping
    public GetOrdersResponseDTO getOrders(GetOrdersRequestDTO requestDTO, @PathParam("status") OrderStatus status) {
        // to add validation logic
        if (status == null) {
            status = OrderStatus.pending;
        }
        requestDTO.status = status;
        assertNoNull(requestDTO, "req.query");
        return orderService.getOrders(requestDTO);
    }

    // DELETE /orders/:id
    @DeleteMapping("{id}")
    public DeleteOrderByIdResponseDTO deleteOrderById(@PathVariable Long id, DeleteOrderByIdRequestDTO requestDTO) {
        // to add validation logic
        assertNoNull(requestDTO, "req.body");
        return orderService.deleteOrderById(id, requestDTO);
    }
}
