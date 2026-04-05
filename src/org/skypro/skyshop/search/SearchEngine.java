package org.skypro.skyshop.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SearchEngine {
    private LinkedList<Searchable> elementsForSearch;

    public SearchEngine(LinkedList<Searchable> elementsForSearch) {
        this.elementsForSearch = elementsForSearch;
    }

    public void add(Searchable product) {
        this.elementsForSearch.add(product);
    }

    public void search(String forSearch) {
        List<Searchable> resultArray = new ArrayList<>();
        for (Searchable search : this.elementsForSearch) {
            if (search != null && search.searchTerm().contains(forSearch)) {
                resultArray.add(search);
            }
        }
        System.out.println(resultArray);
    }

    private int calculateOccurrencesOfSubstring(Searchable product, String substring) {
        String str = product.searchTerm().toLowerCase();
        substring = substring.toLowerCase();
        int quantity = 0;
        int index = 0;
        int substringIndex = str.indexOf(substring, index);

        while (substringIndex != -1) {
            quantity++;
            index = substringIndex + substring.length();
            substringIndex = str.indexOf(substring, index);
        }

        return quantity;
    }

    public Searchable searchTheMostSimilar(String search) throws BestResultNotFound {
        if (search == null || search.isBlank()) {
            throw new BestResultNotFound(search);
        }
        Searchable mostSimilar = null;
        int max = -1;
        for (Searchable forSearch : this.elementsForSearch) {
            if (forSearch != null) {
                int cnt = calculateOccurrencesOfSubstring(forSearch, search);
                if (cnt > max && cnt > 0) {
                    mostSimilar = forSearch;
                    max = cnt;
                }
            }
        }
        if (mostSimilar == null) {
            throw new BestResultNotFound(search);
        }
        return mostSimilar;
    }
}
