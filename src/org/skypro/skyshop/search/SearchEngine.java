package org.skypro.skyshop.search;

import java.util.*;

public class SearchEngine {
    private HashSet<Searchable> elementsForSearch;

    public SearchEngine(HashSet<Searchable> elementsForSearch) {
        this.elementsForSearch = elementsForSearch;
    }

    public void add(Searchable product) {
        this.elementsForSearch.add(product);
    }

    public TreeSet<Searchable> search(String forSearch) {
        TreeSet<Searchable> result = new TreeSet<>(new SearchComparator());
        for (Searchable search : this.elementsForSearch) {
            if (search != null && search.searchTerm().contains(forSearch)) {
                result.add(search);
            }
        }
        return result;
    }

    private static class SearchComparator implements Comparator<Searchable> {
        @Override
        public int compare(Searchable o1, Searchable o2) {
            int sizeO1 = o1.searchTerm().length();
            int sizeO2 = o2.searchTerm().length();
            int sizeComparisonResult = Integer.compare(sizeO1, sizeO2);
            if (sizeComparisonResult != 0) {
                return sizeComparisonResult;
            } else {
                return o1.searchTerm().compareTo(o2.searchTerm());
            }
        }
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
