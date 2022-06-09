package uz.pdp.springbootapelsin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import uz.pdp.springbootapelsin.entity.Category;
import uz.pdp.springbootapelsin.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public void getAll(Model model) {
        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("list", categoryList);
    }

    public void add(Model model, Category category) {
        categoryRepository.save(category);
        model.addAttribute("list", categoryRepository.findAll());
    }
}
