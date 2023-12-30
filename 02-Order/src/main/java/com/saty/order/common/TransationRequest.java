package com.saty.order.common;

import com.saty.order.entity.Order;

import lombok.Data;


@Data
public class TransationRequest {
	
	private Order order;
	private Payment payment;

}
