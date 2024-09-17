package com.example.workintech.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "reviews")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull(message = "User is mandatory")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @NotNull(message = "Product is mandatory")
    private Product product;

    @NotNull(message = "Rating is mandatory")
    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating cannot exceed 5")
    private Integer rating;

    @NotBlank(message = "Comment cannot be blank")
    @Size(max = 500, message = "Comment cannot exceed 500 characters")
    private String comment;
}
