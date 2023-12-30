package com.saty.payment.service;

import java.util.Random;
import java.util.UUID;

//import org.apache.logging.log4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
import com.saty.payment.entity.Payment;
import com.saty.payment.repository.PaymentRepository;


@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
    //Logger logger= (Logger) LoggerFactory.getLogger(PaymentService.class);

	
	public Payment doPayment(Payment payment) {
		payment.setPaymentStatus(paymentProcessing());
		payment.setTranactionId(UUID.randomUUID().toString());
		
        //logger.info("Payment-Service Request : {}",new ObjectMapper().writeValueAsString(payment));

		return paymentRepository.save(payment);
		
	}
	
	public String paymentProcessing() {
		// api should be 3rd party payment gateway (payPal, paytm,gpay)
		
		return new Random().nextBoolean()?"success":"false";
	}

	public Payment findPaymentHistoryByOrderId(int orderId) {
		// TODO Auto-generated method stub
		Payment payment=paymentRepository.findByOrderId(orderId);
        //logger.info("paymentService findPaymentHistoryByOrderId : {}",new ObjectMapper().writeValueAsString(payment));
        return payment ;
	}

}
