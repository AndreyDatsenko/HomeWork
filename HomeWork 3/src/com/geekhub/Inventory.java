package com.geekhub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {

    private Map<ProductType, List<Product>> products = new HashMap<>();

    public void addProduct(ProductType type, Product product) {
        List<Product> products = this.products.get(type);

        if (null == products) {
            products = new ArrayList<>();
        }
        products.add(product);
        this.products.put(type, products);
    }

    public double inventoryType(ProductType type) {
        return products.get(type).stream()
                .mapToDouble(p -> p.getPrice() * p.getCount())
                .sum();
    }

    public double inventoryAllTypes() {
        return products.keySet().stream()
                .map(products::get)
                .flatMap(List::stream)
                .mapToDouble(p -> p.getCount() * p.getPrice())
                .sum();
    }

    public Map<ProductType, List<Product>> getProducts() {
        return products;
    }

}
