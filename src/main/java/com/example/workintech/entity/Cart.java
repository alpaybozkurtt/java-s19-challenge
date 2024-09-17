package com.example.workintech.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "carts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    @NotNull(message = "User is mandatory")
    private User user;

    @NotNull(message = "Total price is mandatory")
    @Min(value = 0, message = "Total price cannot be negative")
    private Double totalPrice;
}
