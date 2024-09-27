package Algoritmos;

public class QuickSort_Mediana3T {
    public static void quickSortMedianaDeTres(String[][] array, String caso, int index) {
        quickSort(array, 0, array.length - 1, index);
    }

    private static void quickSort(String[][] array, int low, int high, int index) {
        if (low < high) {
            int pi = partitionMedianaDeTres(array, low, high, index);
            quickSort(array, low, pi - 1, index);
            quickSort(array, pi + 1, high, index);
        }
    }

    private static int partitionMedianaDeTres(String[][] array, int low, int high, int index) {
        int mid = low + (high - low) / 2;

        // Coloca a mediana entre low, mid e high na posição high
        if (Double.parseDouble(array[mid][index]) < Double.parseDouble(array[low][index])) {
            swap(array, low, mid);
        }
        if (Double.parseDouble(array[high][index]) < Double.parseDouble(array[low][index])) {
            swap(array, low, high);
        }
        if (Double.parseDouble(array[high][index]) < Double.parseDouble(array[mid][index])) {
            swap(array, mid, high);
        }

        // Agora a mediana está na posição high, vamos usá-la como pivô
        swap(array, mid, high);
        double pivotValue = Double.parseDouble(array[high][index]);
        int i = low - 1;

        // Particiona o array
        for (int j = low; j < high; j++) {
            if (Double.parseDouble(array[j][index]) <= pivotValue) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high); // Coloca o pivô na posição correta
        return i + 1; // Retorna o índice do pivô
    }

    private static void swap(String[][] array, int i, int j) {
        String[] temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
