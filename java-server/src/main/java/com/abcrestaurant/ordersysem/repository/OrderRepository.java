package com.abcrestaurant.ordersysem.repository;

import com.abcrestaurant.ordersysem.entity.OrderEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends CrudRepository<OrderEntity, Long> {
    @Query(value = """
    select *
    from "order"
    where status = :status
    order by id desc
    limit :count
    """, nativeQuery = true)
    Iterable<OrderEntity> getRecentPendingOrders(
            @Param("status") String status,
            @Param("count") int count
    );
}
