package com.example.bookstore.service;

import com.example.bookstore.dao.OrderDao;
import com.example.bookstore.model.Book;
import com.example.bookstore.model.Cart;

public class CheckoutService {
    private final OrderDao orderDao = new OrderDao();

    public void init() {
        orderDao.createTablesIfNotExists();
    }

    public long checkout(Long userId, Cart cart) {
        if (cart == null || cart.isEmpty()) {
            throw new IllegalStateException("Cart is empty");
        }
        var orderId = orderDao.createOrder(userId, cart.calculateTotal(), cart.getItems());
        cart.clear();
        return orderId;
    }
}
