package org.skypro.skyshop.search;
import java.util.Arrays;

public class SearchEngine{
    private Searchable[] elementsForSearch;

    public SearchEngine(Searchable[] elementsForSearch, int size) {
        this.elementsForSearch = Arrays.copyOf(elementsForSearch, size);
    }

    public void add(Searchable product){
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

    public void search(String forSearch){
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
}
