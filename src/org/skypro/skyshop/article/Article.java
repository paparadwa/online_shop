package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public class Article implements Searchable {
    private final String title;
    private final String content;

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return title + "\n" + content;
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
    public String getStringRepresentation() {
        return Searchable.super.getStringRepresentation();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        Article article = (Article) obj;
        return Objects.equals(this.title, article.title);
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }
}
