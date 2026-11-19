package model;

public class Product {
    private String id;
    private double price;
    private String description;

    public Product(String id, double price, String description) {
        this.id = id;
        this.price = price;
        this.description = description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
