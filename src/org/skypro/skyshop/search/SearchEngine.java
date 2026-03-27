package org.skypro.skyshop.search;

import java.util.Arrays;

public class SearchEngine{
    private Searchable[] elementsForSearch;

    public SearchEngine(Searchable[] elementsForSearch, int size) {
        this.elementsForSearch = Arrays.copyOf(elementsForSearch, size);
    }

    public void search(String forSearch){
        int max = 5;
        Searchable[] resultArray = new Searchable[max];
        for (int i = 0; i < this.elementsForSearch.length; i++) {
            if (resultArray.length >= i + 1){
                if (elementsForSearch[i].searchTerm().contains(forSearch)) {
                    resultArray[i] = elementsForSearch[i];
                }
            } else {
                break;
            }
        }
        System.out.println(Arrays.toString(resultArray));
    }
}
