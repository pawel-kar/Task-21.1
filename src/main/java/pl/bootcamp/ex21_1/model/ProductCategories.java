package pl.bootcamp.ex21_1.model;

public enum ProductCategories {
    GROCERY("spożywcze"), HOUSEHOLD("domowe"), OTHER("inne");

    private final String polishName;

    ProductCategories(String polishName) {
        this.polishName = polishName;
    }

    public String getPolishName() {
        return polishName;
    }
}
