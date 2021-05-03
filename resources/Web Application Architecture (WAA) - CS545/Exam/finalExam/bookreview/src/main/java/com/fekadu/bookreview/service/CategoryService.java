package com.fekadu.bookreview.service;
import com.fekadu.bookreview.domain.Category;
import java.util.List;
public interface CategoryService {
    Category save(Category category);
    List<Category> getAll();
    Category findById(Long id);
}
