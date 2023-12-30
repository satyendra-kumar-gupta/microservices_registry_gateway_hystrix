package com.saty.order.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name ="ORDER_TB")
public class Order {
	
   @jakarta.persistence.Id 
   private int id;
   private String name;
   private int qty;
   private double price;
   
}
