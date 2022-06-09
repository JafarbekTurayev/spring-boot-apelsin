package uz.pdp.springbootapelsin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootapelsin.entity.Category;
import uz.pdp.springbootapelsin.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public String getAll(Model model) {
        categoryService.getAll(model);
        return "category/list"; //page nomi -> list.html templates
    }

    @GetMapping("/add")
    public String getAddPage() {
//        model.addAttribute("category", null);
        return "category/add"; //page nomi -> list.html templates
    }

    @PostMapping("/add")
    public String getSavePage(@ModelAttribute Category category, Model model) {
        categoryService.add(model, category);
        return "category/list";
    }


}
