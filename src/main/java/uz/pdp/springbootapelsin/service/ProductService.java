package uz.pdp.springbootapelsin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import uz.pdp.springbootapelsin.dto.ProductDTO;
import uz.pdp.springbootapelsin.entity.Category;
import uz.pdp.springbootapelsin.entity.Product;
import uz.pdp.springbootapelsin.repository.CategoryRepository;
import uz.pdp.springbootapelsin.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public void getAll(Model model) {
        List<Product> productList = productRepository.findAll();
        model.addAttribute("list", productList);
    }

    public void add(Model model, ProductDTO productDto) {
        Product product = new Product();
        product.setDescription(productDto.getDescription());
        product.setName(productDto.getName());
        product.setPrice(BigDecimal.valueOf(productDto.getPrice()));
        //1-variant
//        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCatId());
//        if (optionalCategory.isPresent()) {
//            Category category = optionalCategory.get();
//            product.setCategory(category);
//        }
        //yogini tanlay olmagani un mumkin
        product.setCategory(categoryRepository.getById(productDto.getCatId()));

        productRepository.save(product);

        model.addAttribute("list", productRepository.findAll());
    }

    public Product getById(int id) {
        return productRepository.findById(id).orElseThrow();
    }

    public void deleteById(int id) {
        productRepository.deleteById(id);
    }


}
