package com.example.util;

import com.example.model.Product;

import java.util.ArrayList;
import java.util.List;

public class DataStore {
    private static List<Product> products = new ArrayList<>();

    static {
        // Sample products
        products.add(new Product(1, "Laptop", 999.99, "High-performance laptop"));
        products.add(new Product(2, "Smartphone", 499.99, "Latest model smartphone"));
        products.add(new Product(3, "Headphones", 99.99, "Noise-cancelling headphones"));
    }

    public static List<Product> getProducts() {
        return products;
    }

    public static Product getProductById(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }
}
