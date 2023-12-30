package com.saty.payment.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name ="PAYMENT_TB")
public class Payment {
	
	@jakarta.persistence.Id
	@GeneratedValue
	private int id;
	private String paymentStatus;
	private String tranactionId;
	private int orderId;
	private double amount;
}
