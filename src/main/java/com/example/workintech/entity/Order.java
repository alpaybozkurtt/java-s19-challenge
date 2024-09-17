package com.example.workintech.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull(message = "User is mandatory")
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull(message = "Order date is mandatory")
    private Date orderDate;

    @NotNull(message = "Total price is mandatory")
    @Min(value = 0, message = "Total price cannot be negative")
    private Double totalPrice;
}
