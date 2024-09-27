package Algoritmos;

public class SelectionSortT {
    public static void selectionSort(String[][] array, String caso, int index) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (Double.parseDouble(array[j][index]) < Double.parseDouble(array[minIndex][index])) {
                    minIndex = j;
                }
            }
            // Troca os elementos
            String[] temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}

