package com.saty.order.common;

import com.saty.order.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransationResponse {
	private Order order;
	private double amount;
	private String transationId;
	private String message;
}
