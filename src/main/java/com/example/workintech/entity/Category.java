package com.example.workintech.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Category name is mandatory")
    @Size(max = 50, message = "Category name cannot exceed 50 characters")
    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_category_id")
    private Category parentCategory;
}
