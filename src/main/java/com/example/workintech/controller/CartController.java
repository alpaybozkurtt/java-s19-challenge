package com.example.workintech.controller;

import com.example.workintech.entity.Cart;
import com.example.workintech.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
        Cart createdCart = cartService.saveCart(cart);
        return ResponseEntity.ok(createdCart);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable Long id) {
        Cart cart = cartService.getCartById(id);
        return cart != null ? ResponseEntity.ok(cart) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Cart>> getAllCarts() {
        List<Cart> carts = cartService.getAllCarts();
        return ResponseEntity.ok(carts);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable Long id) {
        cartService.deleteCart(id);
        return ResponseEntity.noContent().build();
    }
}
