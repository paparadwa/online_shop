package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void separate(){
        System.out.println("----------------------------------------------------------");
    }
    public static void main(String[] args) {
        Product product1 = new Product("Помидор", 20); //1
        Product product2 = new Product("Огурец", 15);
        Product product3 = new Product("Перец", 10);
        Product product4 = new Product("Морковь", 18);
        Product product5 = new Product("Чеснок", 17);
        Product product6 = new Product("Лук", 13);
        ProductBasket productBasket1 = new ProductBasket(new Product[5]);
        productBasket1.addProduct(product1);
        productBasket1.addProduct(product2);
        productBasket1.addProduct(product3);
        productBasket1.addProduct(product4);
        productBasket1.addProduct(product5);
        productBasket1.addProduct(product6); //2
        separate();
        productBasket1.printBasket(); //3
        separate();
        System.out.println(productBasket1.totalCost()); //4
        separate();
        System.out.println(productBasket1.checkProduct("ЧЕСНОК")); //5
        System.out.println(productBasket1.checkProduct("Чебурек")); //6
        separate();
        productBasket1.clearBasket(); //7
        productBasket1.printBasket(); //8
        separate();
        System.out.println(productBasket1.totalCost()); //9
        separate();
        System.out.println(productBasket1.checkProduct("Чебурек")); //10
    }
}