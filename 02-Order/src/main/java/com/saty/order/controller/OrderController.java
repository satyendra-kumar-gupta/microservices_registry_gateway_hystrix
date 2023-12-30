package com.saty.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.saty.order.common.Payment;
import com.saty.order.common.TransationRequest;
import com.saty.order.common.TransationResponse;
import com.saty.order.controller.service.OrderService;
import com.saty.order.entity.Order;

@RestController
@RequestMapping("/order")
public class OrderController {

	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/doOrder")
	public TransationResponse doOrder(@RequestBody TransationRequest transationRequest) throws JsonProcessingException {
		
		
		return orderService.doOrder(transationRequest);
	}
}
