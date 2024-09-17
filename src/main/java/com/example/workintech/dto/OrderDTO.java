package com.example.workintech.dto;

import java.util.Date;

public record OrderDTO(Long id, Long userId, Date orderDate, Double totalPrice) {
}
