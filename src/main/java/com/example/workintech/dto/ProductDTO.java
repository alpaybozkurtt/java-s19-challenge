package com.example.workintech.dto;

public record ProductDTO(Long id, String name, String description, Double price, Integer stock, Boolean isOnSale) {
}
