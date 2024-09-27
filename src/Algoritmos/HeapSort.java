package Algoritmos;

public class HeapSort {

    public static void heapSort(String[][] records, String caso) {
        int n = records.length;

        // Constrói o heap (rearranja o array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(records, n, i, caso);
        }

        // Extrai os elementos um a um do heap
        for (int i = n - 1; i > 0; i--) {
            String[] temp = records[0];
            records[0] = records[i];
            records[i] = temp;

            // Chama heapify na sub-árvore reduzida
            heapify(records, i, 0, caso);
        }
    }

    private static void heapify(String[][] records, int n, int i, String caso) {
        int largestOrSmallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (caso.equals("piorCaso")) {
            if (left < n && records[left][2].compareTo(records[largestOrSmallest][2]) > 0) {
                largestOrSmallest = left;
            }
            if (right < n && records[right][2].compareTo(records[largestOrSmallest][2]) > 0) {
                largestOrSmallest = right;
            }
        } else {
            if (left < n && records[left][2].compareTo(records[largestOrSmallest][2]) < 0) {
                largestOrSmallest = left;
            }
            if (right < n && records[right][2].compareTo(records[largestOrSmallest][2]) < 0) {
                largestOrSmallest = right;
            }
        }

        if (largestOrSmallest != i) {
            String[] temp = records[i];
            records[i] = records[largestOrSmallest];
            records[largestOrSmallest] = temp;

            heapify(records, n, largestOrSmallest, caso);
        }
    }
}