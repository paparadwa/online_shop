package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.HashMap;
import java.util.HashSet;


public class App {
    public static void separate() {
        System.out.println("----------------------------------------------------------");
    }

    public static void main(String[] args) {
        DiscountedProduct product1 = new DiscountedProduct("Помидор", 20, 5); //1
        FixPriceProduct product2 = new FixPriceProduct("Огурец");
        SimpleProduct product3 = new SimpleProduct("Перец", 10);
        SimpleProduct product4 = new SimpleProduct("Морковь", 18);
        SimpleProduct product5 = new SimpleProduct("Чеснок", 17);
        SimpleProduct product6 = new SimpleProduct("Лук", 13);
        ProductBasket productBasket1 = new ProductBasket(new HashMap<>());
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
        //productBasket1.clearBasket(); //7
        productBasket1.printBasket(); //8
        separate();
        System.out.println(productBasket1.totalCost()); //9
        separate();
        System.out.println(productBasket1.checkProduct("Чебурек")); //10
        separate();
        Article article1 = new Article("Помидор", "Красный овощ");
        Article article2 = new Article("Огурец", "Зелёный овощ");
        Article article3 = new Article("Перец", "Жёлтый/зелёный/красный овощ");
        Article article4 = new Article("Морковь", "Оранжевый овощ");
        System.out.println(article1);
        separate();
        SearchEngine searchEngine = new SearchEngine(new HashSet<>());
        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(product4);
        searchEngine.add(product5);
        searchEngine.add(product6);
        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);
        searchEngine.add(article4);
        searchEngine.add(product1);
        System.out.println("searchEngine.search(\"о\") = " + searchEngine.search("о"));
        System.out.println("searchEngine.search(\"h\") = " + searchEngine.search("h"));
        System.out.println("searchEngine.search(\"Помидор\") = " + searchEngine.search("Помидор"));
        System.out.println("searchEngine.search(\"р\") = " + searchEngine.search("р"));
        System.out.println("searchEngine.search(\"к\") = " + searchEngine.search("к"));
        System.out.println("searchEngine.search(\"potato\") = " + searchEngine.search("potato"));
        separate();
        try {
            SimpleProduct excProduct1 = new SimpleProduct(null, 10);
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
        }
        try {
            SimpleProduct excProduct1 = new SimpleProduct("Чебурек", 0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
        }
        try {
            DiscountedProduct excProduct1 = new DiscountedProduct(null, 10, 1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
        }
        try {
            DiscountedProduct excProduct1 = new DiscountedProduct("Чебурек", 0, 1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
        }
        try {
            DiscountedProduct excProduct1 = new DiscountedProduct("Чебурек", 10, 101);
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
        }
        separate();
        try {
            System.out.println(searchEngine.searchTheMostSimilar("помидор"));
        } catch (BestResultNotFound e) {
            System.out.println(e.toString());
        }
        try {
            System.out.println(searchEngine.searchTheMostSimilar("о"));
        } catch (BestResultNotFound e) {
            System.out.println(e.toString());
        }
        try {
            System.out.println(searchEngine.searchTheMostSimilar(null));
        } catch (BestResultNotFound e) {
            System.out.println(e.toString());
        }
        try {
            System.out.println(searchEngine.searchTheMostSimilar(""));
        } catch (BestResultNotFound e) {
            System.out.println(e.toString());
        }
        try {
            System.out.println(searchEngine.searchTheMostSimilar("hello"));
        } catch (BestResultNotFound e) {
            System.out.println(e.toString());
        }
        try {
            System.out.println(searchEngine.searchTheMostSimilar("h"));
        } catch (BestResultNotFound e) {
            System.out.println(e.toString());
        }
        separate();
        //дз. Java Collections Framework: List
        System.out.println(productBasket1.removeByName("Помидор"));
        separate();
        productBasket1.printBasket();
        separate();
        if (productBasket1.removeByName("Эклер").isEmpty()) {
            System.out.println("Список пуст");
        } else {
            System.out.println(productBasket1.removeByName("Эклер"));
        }
        separate();
        productBasket1.printBasket();
        separate();
        productBasket1.clearBasket();
        productBasket1.printBasket();
    }
}