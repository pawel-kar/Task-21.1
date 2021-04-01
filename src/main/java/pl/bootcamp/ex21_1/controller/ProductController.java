package pl.bootcamp.ex21_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.bootcamp.ex21_1.model.Product;
import pl.bootcamp.ex21_1.model.ProductCategory;
import pl.bootcamp.ex21_1.model.ProductRepository;
import pl.bootcamp.ex21_1.model.ProductsPriceCalculator;

import java.util.List;

@Controller
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    public String goHome() {
        return "front";
    }

    @GetMapping("/list")
    public String searchProductsForGivenCategory(Model model, @RequestParam(required = false, name = "category") ProductCategory productCategories) {
        List<Product> products;
        if (productCategories != null) {
            products = productRepository.findByCategory(productCategories);
        } else {
            products = productRepository.getAll();
        }
        model.addAttribute("products", products);
        var totalPrice = ProductsPriceCalculator.calculateTotalPrice(products);
        model.addAttribute("totalPrice", String.format("%.2f", totalPrice));
        return "list";
    }

    @GetMapping("/add")
    public String goToAddProductForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "addForm";
    }

    @PostMapping("/addProduct")
    public String add(Product product) {
        productRepository.add(product);
        return "front";
    }
}
