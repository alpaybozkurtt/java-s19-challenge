package com.example.workintech.service;

import com.example.workintech.entity.Category;
import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category createCategory(Category category);
}
