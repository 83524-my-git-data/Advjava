package com.sunbeam.controller;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;
import com.sunbeam.service.CategoryService;
import com.sunbeam.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    public ProductController() {
        System.out.println("in ctor " + getClass());
    }

    @GetMapping("/view")
    public String getProductByPriceAndCategory(@RequestParam double min, @RequestParam double max, @RequestParam long categoryId, Model model) {
        Category productCategory = categoryService.findById(categoryId);
        List<Product> products = productService.getProductByPriceAndCategory(min, max, productCategory);
        
        model.addAttribute("products", products);
        
        return "/products/view";
    }
}
