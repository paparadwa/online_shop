package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

public class App {
    public static void separate(){
        System.out.println("----------------------------------------------------------");
    }
    public static void main(String[] args) {
        DiscountedProduct product1 = new DiscountedProduct("Помидор", 20, 5); //1
        FixPriceProduct product2 = new FixPriceProduct("Огурец");
        SimpleProduct product3 = new SimpleProduct("Перец", 10);
        SimpleProduct product4 = new SimpleProduct("Морковь", 18);
        SimpleProduct product5 = new SimpleProduct("Чеснок", 17);
        SimpleProduct product6 = new SimpleProduct("Лук", 13);
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
        separate();
        Article article1 = new Article("Помидор", "Красный овощ");
        Article article2 = new Article("Огурец", "Зелёный овощ");
        Article article3 = new Article("Перец", "Жёлтый/зелёный/красный овощ");
        Article article4 = new Article("Морковь", "Оранжевый овощ");
        SearchEngine searchEngine = new SearchEngine(new Searchable[]{product1, product2, product3, product4, product5, product6, article1, article2, article3, article4}, 10);
        searchEngine.search("о");
        searchEngine.search("Помидор");
        searchEngine.search("р");
        searchEngine.search("к");
        searchEngine.search("potato");
    }
}