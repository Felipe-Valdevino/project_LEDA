package Algoritmos;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(String[][] records, String caso) {
        if (records.length < 2) return;
        int mid = records.length / 2;
        String[][] left = Arrays.copyOfRange(records, 0, mid);
        String[][] right = Arrays.copyOfRange(records, mid, records.length);

        mergeSort(left, caso);
        mergeSort(right, caso);
        merge(records, left, right, caso);
    }

    private static void merge(String[][] records, String[][] left, String[][] right, String caso) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (caso.equals("piorCaso") ? left[i][2].compareTo(right[j][2]) > 0 :
                caso.equals("melhorCaso") ? left[i][2].compareTo(right[j][2]) < 0 :
                left[i][2].compareTo(right[j][2]) > 0) {
                records[k++] = left[i++];
            } else {
                records[k++] = right[j++];
            }
        }

        while (i < left.length) {
            records[k++] = left[i++];
        }

        while (j < right.length) {
            records[k++] = right[j++];
        }
    }
}
