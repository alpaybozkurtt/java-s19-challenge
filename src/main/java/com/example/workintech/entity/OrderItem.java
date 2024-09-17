package com.example.workintech.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "order_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @NotNull(message = "Order is mandatory")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @NotNull(message = "Product is mandatory")
    private Product product;

    @NotNull(message = "Quantity is mandatory")
    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity;

    @NotNull(message = "Price is mandatory")
    @Min(value = 0, message = "Price cannot be negative")
    private Double price;
}
