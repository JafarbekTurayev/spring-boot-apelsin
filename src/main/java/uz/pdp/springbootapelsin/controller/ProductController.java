package uz.pdp.springbootapelsin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootapelsin.dto.ProductDTO;
import uz.pdp.springbootapelsin.entity.Product;
import uz.pdp.springbootapelsin.repository.CategoryRepository;
import uz.pdp.springbootapelsin.repository.ProductRepository;
import uz.pdp.springbootapelsin.service.ProductService;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;
    private final ProductService productService;
    private final CategoryRepository categoryRepository;

    @GetMapping
    public String getAll(Model model) {
        productService.getAll(model);
        return "product/list";// page nomi list.html templates ni ichida
    }

    @GetMapping("/add")
    public String getAddPage(Model model) {
        model.addAttribute("categoryList", categoryRepository.findAll());
        return "product/add"; //page nomi -> list.html templates
    }

    @PostMapping("/add")
    public String getSavePage(@ModelAttribute ProductDTO productDto, Model model) {
        productService.add(model, productDto);
        return "product/list";
    }

//    @GetMapping("/update/{id}")
//    public String updateForm(@PathVariable(value = "id") int id, Model model) {
//        Product product = productService.getById(id);
//        model.addAttribute("product", product);
//        return "product/update";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String deleteThroughId(@PathVariable(value = "id") int id, Model model) {
//        productService.deleteById(id);
//        productService.getAll(model);
//        return "product/list";
//    }
}
