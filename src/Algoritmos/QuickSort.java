package Algoritmos;

public class QuickSort {

    public static void quickSort(String[][] records, String caso) {
        quickSort(records, 0, records.length - 1, caso);
    }

    private static void quickSort(String[][] records, int low, int high, String caso) {
        if (low < high) {
            int pi = partition(records, low, high, caso);
            quickSort(records, low, pi - 1, caso);
            quickSort(records, pi + 1, high, caso);
        }
    }

    static int partition(String[][] records, int low, int high, String caso) {
        String[] pivot = records[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (caso.equals("piorCaso") ? records[j][2].compareTo(pivot[2]) > 0 :
                caso.equals("melhorCaso") ? records[j][2].compareTo(pivot[2]) < 0 :
                records[j][2].compareTo(pivot[2]) > 0) {
                i++;

                String[] temp = records[i];
                records[i] = records[j];
                records[j] = temp;
            }
        }

        String[] temp = records[i + 1];
        records[i + 1] = records[high];
        records[high] = temp;

        return i + 1;
    }
}
