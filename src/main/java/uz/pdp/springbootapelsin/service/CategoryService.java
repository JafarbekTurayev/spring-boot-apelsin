package uz.pdp.springbootapelsin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import uz.pdp.springbootapelsin.entity.Category;
import uz.pdp.springbootapelsin.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

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

    public void edit(Integer id, Model model, Category category) {
        //editni logikasi
//        categoryRepository.getById(); //bu null pointer exception
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            Category editedCategory = optionalCategory.get();
            editedCategory.setName(category.getName());
            categoryRepository.save(editedCategory); // malumot qo'shish
        }
        model.addAttribute("list", categoryRepository.findAll(Sort.by("id")));
    }

    public void delete(Integer id, Model model) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            categoryRepository.deleteById(id);
        }
        model.addAttribute("list", categoryRepository.findAll(Sort.by("id")));
    }
}
