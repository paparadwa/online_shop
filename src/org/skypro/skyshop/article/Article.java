package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

public class Article implements Searchable {
    private final String title;
    private final String content;

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return title + '\'' + content;
    }

    @Override
    public String searchTerm() {
        return this.toString();
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public void getStringRepresentation() {
        Searchable.super.getStringRepresentation();
    }
}
