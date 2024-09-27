package Algoritmos;

public class InsertionSortT {
    public static void insertionSort(String[][] array, String caso, int index) {
        for (int i = 1; i < array.length; i++) {
            String[] key = array[i];
            int j = i - 1;
            while (j >= 0 && Double.parseDouble(array[j][index]) > Double.parseDouble(key[index])) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
}
