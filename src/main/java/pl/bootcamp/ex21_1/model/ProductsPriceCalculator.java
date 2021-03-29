package pl.bootcamp.ex21_1.model;

import java.util.List;

public class ProductsPriceCalculator {

    public static double calculateTotalPrice(List<Product> products ) {
        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }
}
