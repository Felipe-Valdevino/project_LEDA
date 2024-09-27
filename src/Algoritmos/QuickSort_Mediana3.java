package Algoritmos;

import Algoritmos.QuickSort;

public class QuickSort_Mediana3 {

    public static void quickSortMedianaDeTres(String[][] records, String caso) {
        quickSort(records, 0, records.length - 1, caso);
    }

    private static void quickSort(String[][] records, int low, int high, String caso) {
        if (low < high) {
            int median = medianOfThree(records, low, high, caso);
            String[] temp = records[median];
            records[median] = records[high];
            records[high] = temp;

            int pi = QuickSort.partition(records, low, high, caso);
            quickSort(records, low, pi - 1, caso);
            quickSort(records, pi + 1, high, caso);
        }
    }

    private static int medianOfThree(String[][] records, int low, int high, String caso) {
        int mid = (low + high) / 2;
        if (records[low][2].compareTo(records[mid][2]) > 0)
            swap(records, low, mid);
        if (records[low][2].compareTo(records[high][2]) > 0)
            swap(records, low, high);
        if (records[mid][2].compareTo(records[high][2]) > 0)
            swap(records, mid, high);
        return mid;
    }

    private static void swap(String[][] records, int i, int j) {
        String[] temp = records[i];
        records[i] = records[j];
        records[j] = temp;
    }
}