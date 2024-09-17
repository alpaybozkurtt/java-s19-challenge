package com.example.workintech.service;

import com.example.workintech.entity.Cart;
import com.example.workintech.repository.CartRepository;
import com.example.workintech.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart getCartById(Long id) {
        Optional<Cart> cart = cartRepository.findById(id);
        return cart.orElse(null);
    }

    @Override
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    @Override
    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }
}
