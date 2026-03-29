package org.skypro.skyshop.search;

import java.util.Arrays;

public class SearchEngine {
    private Searchable[] elementsForSearch;

    public SearchEngine(Searchable[] elementsForSearch, int size) {
        this.elementsForSearch = Arrays.copyOf(elementsForSearch, size);
    }

    public void add(Searchable product) {
        int notFree = 0;
        for (int i = 0; i < this.elementsForSearch.length; i++) {
            if (this.elementsForSearch[i] == null) {
                this.elementsForSearch[i] = product;
                break;
            } else {
                notFree++;
            }
        }
        if (notFree == this.elementsForSearch.length) {
            System.out.println("Невозможно добавить продукт");
        }
    }

    public void search(String forSearch) {
        int max = 5;
        int j = 0;
        Searchable[] resultArray = new Searchable[max];
        for (Searchable search : this.elementsForSearch) {
            if (max > 0) {
                if (search != null && search.searchTerm().contains(forSearch)) {
                    resultArray[j] = search;
                    max--;
                    j++;
                }
            } else {
                break;
            }
        }
        System.out.println(Arrays.toString(resultArray));
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
