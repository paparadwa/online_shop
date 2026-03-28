package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    protected final String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public String searchTerm() {
        return this.getName();
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public void getStringRepresentation() {
        Searchable.super.getStringRepresentation();
    }
}
