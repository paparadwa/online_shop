package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private LinkedList<Product> products;

    public ProductBasket(LinkedList<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
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
        int specialProductsNum = 0;
        for (Product product : products) {
            if (product != null) {
                System.out.println(product);
                if (product.isSpecial()) {
                    specialProductsNum++;
                }
                notFree++;
            }
        }
        if (notFree == 0) {
            System.out.println("В корзине пусто");
        } else {
            System.out.println("Итого: " + this.totalCost());
            System.out.println("Специальных товаров: " + specialProductsNum);
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
        this.products.clear();
    }

    public List<Product> removeByName(String name) {
        List<Product> removedProducts = new ArrayList<>();
        Iterator<Product> iterator = this.products.iterator();

        while (iterator.hasNext()) {
            Product element = iterator.next();
            if (element.getName().equalsIgnoreCase(name)) {
                removedProducts.add(element);
                iterator.remove();
            }
        }

        return removedProducts;
    }
}
