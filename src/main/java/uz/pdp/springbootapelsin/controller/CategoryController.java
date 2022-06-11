package uz.pdp.springbootapelsin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootapelsin.entity.Category;
import uz.pdp.springbootapelsin.repository.CategoryRepository;
import uz.pdp.springbootapelsin.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    CategoryRepository categoryRepository;

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

    @GetMapping("/edit/{id}")
    public String getEditPage(@PathVariable Integer id, Model model) {
//        Category category = categoryRepository.getById(id); //1-variant
        Category category = categoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id not found!" + id));
        model.addAttribute("category", category);
        return "category/edit";
    }

    @PostMapping("/edit/{id}")
    public String saveEditPage(@PathVariable Integer id, @ModelAttribute Category category, Model model) {
        categoryService.edit(id, model, category);
        return "category/list";
    }

    @GetMapping("/delete/{id}")
    public String deletePage(@PathVariable Integer id, Model model) {
        categoryService.delete(id, model);
        return "category/list";
    }
}
