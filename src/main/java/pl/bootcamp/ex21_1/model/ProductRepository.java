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
        productRepository.add(new Product("Masło", 5, ProductCategory.GROCERY));
        productRepository.add(new Product("Chleb", 10, ProductCategory.GROCERY));
        productRepository.add(new Product("Mango", 15, ProductCategory.GROCERY));
        productRepository.add(new Product("Odkurzacz", 150, ProductCategory.HOUSEHOLD));
        productRepository.add(new Product("KREDKI", 15, ProductCategory.OTHER));
    }

    public List<Product> getAll() {
        return productRepository;
    }

    public void add(Product product) {
        productRepository.add(product);
    }

    public List<Product> findByCategory(ProductCategory productCategory) {
        return productRepository.stream()
                .filter(product -> product.getProductCategory().equals(productCategory))
                .collect(Collectors.toList());
    }
}
