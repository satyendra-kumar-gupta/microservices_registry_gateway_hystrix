package com.saty.order.controller.service;


//import org.apache.logging.log4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
import com.saty.order.common.Payment;
import com.saty.order.common.TransationRequest;
import com.saty.order.common.TransationResponse;
import com.saty.order.entity.Order;
import com.saty.order.repository.OrderRepository;

@Service
@RefreshScope
public class OrderService {

	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	@Lazy
	private RestTemplate restTemplate;
	
	@Value("${microservice.payment-service.endpoints.endpoint.uri}")
	private String ENDPOINT_PAYMENT_URL;
	
	//Logger logger= (Logger) LoggerFactory.getLogger(OrderService.class);
	
	public TransationResponse doOrder(TransationRequest transationRequest)  {
		String responseMessage ="";
		Order order = transationRequest.getOrder();
		Payment payment = transationRequest.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());

		//logger.info("Order-Service Request : "+new ObjectMapper().writeValueAsString(transationRequest));
		// rest call
		
		Payment paymentResponsePayment = restTemplate.postForObject(ENDPOINT_PAYMENT_URL, payment, Payment.class);
        //logger.info("Order Service getting Response from Payment-Service : "+new ObjectMapper().writeValueAsString(paymentResponsePayment));

		responseMessage = paymentResponsePayment.getPaymentStatus().equals("success") ? "payment processing succesfull and order placed":"thre is failer to payment service , oder be added into cart";
		orderRepository.save(order);
		
		return new TransationResponse(order,paymentResponsePayment.getAmount(),paymentResponsePayment.getTranactionId(),responseMessage);
	}

	
}
