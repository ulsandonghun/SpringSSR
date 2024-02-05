package com.example.SpringMVC.order;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);
}
