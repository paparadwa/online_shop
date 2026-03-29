package org.skypro.skyshop.search;

public interface Searchable {
    String searchTerm();
    String getContentType();
    default String getStringRepresentation(){
        return "Имя " + searchTerm() + " — тип " + getContentType();
    }
}
