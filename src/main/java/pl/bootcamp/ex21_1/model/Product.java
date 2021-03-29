package pl.bootcamp.ex21_1.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {
    private String name;
    private double price;
    private ProductCategories productCategory;

    public Product() {
    }

    public Product(String name, double price, ProductCategories productCategory) {
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

    public ProductCategories getProductCategory() {
        return productCategory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setProductCategory(ProductCategories productCategory) {
        this.productCategory = productCategory;
    }
}
