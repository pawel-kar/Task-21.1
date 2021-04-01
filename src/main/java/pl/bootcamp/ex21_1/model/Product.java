package pl.bootcamp.ex21_1.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {
    private String name;
    private double price;
    private ProductCategory productCategory;

    public Product() {
    }

    public Product(String name, double price, ProductCategory productCategory) {
        this.name = name;
        this.price = price;
        this.productCategory = productCategory;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        BigDecimal bd = new BigDecimal(price).setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }
}
