package com.example.workintech.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Product name is mandatory")
    @Size(max = 100, message = "Product name cannot exceed 100 characters")
    private String name;

    @NotBlank(message = "Description is mandatory")
    @Size(max = 500, message = "Description cannot exceed 500 characters")
    private String description;

    @NotNull(message = "Price is mandatory")
    @Min(value = 0, message = "Price cannot be negative")
    private Double price;

    @NotNull(message = "Stock is mandatory")
    @Min(value = 0, message = "Stock cannot be negative")
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @NotNull(message = "isOnSale flag is mandatory")
    private Boolean isOnSale;

    @Min(value = 0, message = "Total sales cannot be negative")
    private Integer totalSales;

    @Min(value = 0, message = "Likes cannot be negative")
    private Integer likes;
}
