package com.saty.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saty.order.entity.Order;

@Repository 
public interface OrderRepository extends JpaRepository<Order, Integer> {
 
}
