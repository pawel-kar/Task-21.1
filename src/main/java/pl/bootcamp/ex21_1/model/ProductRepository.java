package pl.bootcamp.ex21_1.model;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {

    private final List<Product> productRepository;

    public ProductRepository() {
        this.productRepository = new ArrayList<>();
        productRepository.add(new Product("Masło", 5, ProductCategories.GROCERY));
        productRepository.add(new Product("Chleb", 10, ProductCategories.GROCERY));
        productRepository.add(new Product("Mango", 15, ProductCategories.GROCERY));
        productRepository.add(new Product("Odkurzacz", 150, ProductCategories.HOUSEHOLD));
        productRepository.add(new Product("KREDKI", 15, ProductCategories.OTHER));
    }

    public List<Product> getAll() {
        return productRepository;
    }

    public void add(Product product) {
        productRepository.add(product);
    }

    public List<Product> findByCategory(String polishCategory) {
        return productRepository.stream()
                .filter(product -> product.getProductCategory().getPolishName().equals(polishCategory))
                .collect(Collectors.toList());
    }

    public double getTotalPrice(List<Product> products) {
        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }
}
