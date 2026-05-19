package com.example.lld.designpatterns.behavioral;

import java.sql.Array;
import java.util.List;

interface BaseSortingStrategy {
    public void sort(String[] arr, int size);
}

class SortingContext {
    private BaseSortingStrategy sortingStrategy;

    public SortingContext(BaseSortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void setSortingStrategy(BaseSortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;

    }

    public void performSort(String[] args, int size) {
        if (sortingStrategy != null) {
            sortingStrategy.sort(args, size);
        }
    }
}

class AlphabeticalSort implements BaseSortingStrategy {
    @Override
    public void sort(String[] args, int size) {
        System.out.println("Sorting by alphabetical order");
    }
}


public class StrategyDesignPattern {
    public static void main(String[] args) {
        String[] array = {"hello", "by"};
        AlphabeticalSort alphabeticalSort = new AlphabeticalSort();
        SortingContext sortingContext = new SortingContext(alphabeticalSort);
        sortingContext.performSort(array, 2);

    }
}
