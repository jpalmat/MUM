package com.fekadu.bookreview.controller;

import com.fekadu.bookreview.domain.Category;
import com.fekadu.bookreview.service.CategoryService;
import com.fekadu.bookreview.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping({"/", "/add"})
    public String getCategoryForm(@ModelAttribute("category") Category category, Model model) {
        model.addAttribute("categories", categoryService.getAll());
        return "categoryForm";
    }

    @PostMapping("/add")
    public String saveCategory(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        return "redirect:/category/add";
    }

    @GetMapping("/withajax")
    public String getCategoryFormWithAjax(Model model){
        model.addAttribute("categories", categoryService.getAll());
        return "categoryFormAjax";
    }
}