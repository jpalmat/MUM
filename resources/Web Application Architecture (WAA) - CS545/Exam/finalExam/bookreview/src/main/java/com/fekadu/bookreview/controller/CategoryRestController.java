package com.fekadu.bookreview.controller;

import com.fekadu.bookreview.domain.Category;
import com.fekadu.bookreview.service.CategoryService;
import com.fekadu.bookreview.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categoryrest")
public class CategoryRestController {
    @Autowired
    private  CategoryService categoryService;
   /* @GetMapping("/withajax")
    public String getCategoryFormWithAjax (Model model){
        model.addAttribute("categories", categoryService.getAll());
        return "categoryFormAjax";
    }*/
    @PostMapping("/add")
    public  List<Category> createCategory(@Valid @RequestBody Category category) {
         categoryService.save(category);
         return categoryService.getAll();
    }
}