package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {
    private Product[] products = new Product[5];

    public ProductBasket(Product[] products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        int notFree = 0;
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                break;
            } else {
                notFree++;
            }
        }
        if (notFree == products.length) {
            System.out.println("Невозможно добавить продукт");
        }
    }

    public int totalCost() {
        int amount = 0;
        for (Product product : products) {
            if (product != null) {
                amount += product.getPrice();
            }
        }
        return amount;
    }

    public void printBasket() {
        int notFree = 0;
        for (Product product : products) {
            if (product != null) {
                System.out.println(product.getName() + ": " + product.getPrice());
                notFree++;
            }
        }
        if (notFree == 0) {
            System.out.println("В корзине пусто");
        } else {
            System.out.println("Итого: " + this.totalCost());
        }
    }

    public boolean checkProduct(String name) {
        int notFree = 0;
        boolean flag = false;
        for (Product product : products) {
            if (product != null) {
                if (product.getName().equalsIgnoreCase(name)) {
                    notFree++;
                    flag = true;
                    break;
                } else {
                    notFree++;
                }
            }
        }
        if (notFree == 0) {
            flag = false;
        }
        return flag;
    }

    public void clearBasket() {
        Arrays.fill(products, null);
    }
}
