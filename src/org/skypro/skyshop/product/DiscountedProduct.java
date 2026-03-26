package org.skypro.skyshop.product;

public class DiscountedProduct extends Product{
    private int basePrice;
    private int discountPercent;

    public DiscountedProduct(String name, int basePrice, int discountPercent) {
        super(name);
        this.basePrice = basePrice;
        this.discountPercent = discountPercent;
    }

    @Override
    public int getPrice(){
        return (int)(basePrice * (1f - (discountPercent/100f)));
    }

    @Override
    public boolean isSpecial(){
        return true;
    }
    @Override
    public String toString(){
        return name + ": " + getPrice() + " (скидка " + discountPercent + "%)";
    }
}
