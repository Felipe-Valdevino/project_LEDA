package Algoritmos;

public class SelectionSort {

    public static void selectionSort(String[][] records, String caso) {
        int n = records.length;

        for (int i = 0; i < n - 1; i++) {
            int minOrMaxIdx = i;

            // Encontra o menor ou maior valor com base no caso
            for (int j = i + 1; j < n; j++) {
                if (caso.equals("piorCaso")) {
                    if (records[j][2].compareTo(records[minOrMaxIdx][2]) > 0) {
                        minOrMaxIdx = j;
                    }
                } else if (caso.equals("melhorCaso")) {
                    if (records[j][2].compareTo(records[minOrMaxIdx][2]) < 0) {
                        minOrMaxIdx = j;
                    }
                } else {
                    if (records[j][2].compareTo(records[minOrMaxIdx][2]) > 0) {
                        minOrMaxIdx = j;
                    }
                }
            }

            // Troca os elementos
            String[] temp = records[minOrMaxIdx];
            records[minOrMaxIdx] = records[i];
            records[i] = temp;
        }
    }
}
