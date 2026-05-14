package com.ram.Strategy.example;

interface SortingStrategy{
    void sort(int[] arr);
}

class BubbleSortStrategy implements SortingStrategy{
    @Override
    public void sort(int[] arr) {
        System.out.println("Sorting using Bubble Sort ..........");
    }
}

class MergeSortStrategy implements SortingStrategy{
    @Override
    public void sort(int[] arr) {
        System.out.println("Sorting using Merge Sort ...........");
    }
}

class QuickSortStrategy implements SortingStrategy{

    @Override
    public void sort(int[] arr) {
        System.out.println("Sorting using Quick Sort ...........");;
    }
}


class SortingContext{
    private SortingStrategy sortingStrategy;

    public SortingContext(SortingStrategy sortingStrategy){
        this.sortingStrategy = sortingStrategy;
    }

    public void setSortingStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void performSort(int[] arr){
        sortingStrategy.sort(arr);
    }
}

public class Main {
    public static void main(String[] args) {
        SortingContext sortingContext = new SortingContext(new BubbleSortStrategy());
        int[] array1 = {5, 2, 9, 1, 5};
        sortingContext.performSort(array1); // Output: Sorting using Bubble Sort

        // Change strategy to MergeSortStrategy
        sortingContext.setSortingStrategy(new MergeSortStrategy());
        int[] array2 = {8, 3, 7, 4, 2};
        sortingContext.performSort(array2); // Output: Sorting using Merge Sort

        // Change strategy to QuickSortStrategy
        sortingContext.setSortingStrategy(new QuickSortStrategy());
        int[] array3 = {6, 1, 3, 9, 5};
        sortingContext.performSort(array3); // Output: Sorting using Quick Sort
    }
}
