package com.saty.order.common;

import lombok.Data;

@Data
public class Payment {
	private int id;
	private String paymentStatus;
	private String tranactionId;
	private int orderId;
	private double amount;
}
