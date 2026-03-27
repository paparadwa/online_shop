package org.skypro.skyshop.search;

public interface Searchable {
    String searchTerm();
    String getContentType();
    default void getStringRepresentation(){
        System.out.println("Имя" + searchTerm() + " — тип " + getContentType());
    }
}
