package com.bridgelabz.workshop2;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Order {
    @Override
	public String toString() {
		return "Order [deliveryAddress=" + deliveryAddress + ", personName=" + personName + ", totalPrice=" + totalPrice
				+ ", orderTime=" + orderTime + ", map=" + map + ", paymentMethod=" + paymentMethod + "]";
	}
	enum PaymentMethod {Debit_Card , CREDIT_CARD, COD,UPI,NET_BANKING,WALLET}
 //  List<FoodItem> foodList = new ArrayList<FoodItem>();
    String deliveryAddress;
    String personName;
  //  int quantity;
    int totalPrice;
    LocalTime orderTime;
    Map<FoodItem , Integer> map = new HashMap<FoodItem , Integer>();
    PaymentMethod paymentMethod;
}

