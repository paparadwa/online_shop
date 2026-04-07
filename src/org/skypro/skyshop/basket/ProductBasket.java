package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private HashMap<String, List<Product>> products;

    public ProductBasket(HashMap<String, List<Product>> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        products.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }

    public int totalCost() {
        return products.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    public void printBasket() {
        if (this.products.isEmpty()) {
            System.out.println("В корзине пусто");
        } else {
            products.values().stream()
                    .flatMap(Collection::stream)
                    .forEach(System.out::println);
        }
        System.out.println("Итого: " + this.totalCost());
        System.out.println("Специальных товаров: " + this.getSpecialCount());
    }


    private long getSpecialCount() {
        return products.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }

    public boolean checkProduct(String name) {
        boolean flag = false;
        for (List<Product> productsList : products.values()) {
            for (Product product : productsList) {
                if (product.getName().equalsIgnoreCase(name)) {
                    flag = true;
                    break;
                }
            }
        }
        if (this.products.isEmpty()) {
            flag = false;
        }
        return flag;
    }

    public void clearBasket() {
        this.products.clear();
    }

    public List<Product> removeByName(String name) {
        List<Product> removedProducts = new ArrayList<>();
        if (products.containsKey(name)) {
            removedProducts.addAll(products.get(name));
            products.remove(name);
        }
        return removedProducts;
    }
}
