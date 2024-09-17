package com.example.workintech.service;

import com.example.workintech.entity.Cart;
import java.util.List;

public interface CartService {
    Cart saveCart(Cart cart);
    Cart getCartById(Long id);
    List<Cart> getAllCarts();
    void deleteCart(Long id);
}
