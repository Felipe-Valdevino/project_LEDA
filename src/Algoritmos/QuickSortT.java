package Algoritmos;

public class QuickSortT {

    public static void quickSort(String[][] arr, String caso, int colIndex) {
        quickSort(arr, 0, arr.length - 1, colIndex);
    }

    public static void quickSort(String[][] arr, int low, int high, int colIndex) {
        if (low < high) {
            // Usa a mediana de três para escolher o pivô
            if (high - low > 10) { // Usar QuickSort somente se o array tiver mais de 10 elementos
                int pi = partitionWithMedianOfThree(arr, low, high, colIndex);
                quickSort(arr, low, pi - 1, colIndex);
                quickSort(arr, pi + 1, high, colIndex);
            } else {
                // Usa InsertionSort para arrays pequenos
                insertionSort(arr, low, high, colIndex);
            }
        }
    }

    public static int partitionWithMedianOfThree(String[][] arr, int low, int high, int colIndex) {
        // Mediana de três: low, middle, high
        int middle = low + (high - low) / 2;
        String pivotValue = arr[middle][colIndex];

        // Ordena os três valores para encontrar a mediana
        if (compare(arr[low][colIndex], arr[middle][colIndex]) > 0) {
            swap(arr, low, middle);
        }
        if (compare(arr[low][colIndex], arr[high][colIndex]) > 0) {
            swap(arr, low, high);
        }
        if (compare(arr[middle][colIndex], arr[high][colIndex]) > 0) {
            swap(arr, middle, high);
        }

        // Usa o valor do meio como pivô
        pivotValue = arr[middle][colIndex];
        swap(arr, middle, high - 1); // Coloca o pivô no penúltimo lugar
        int pivot = high - 1;

        int i = low;
        int j = high - 1;

        while (true) {
            while (i < j && compare(arr[++i][colIndex], pivotValue) < 0) ;
            while (i < j && compare(arr[--j][colIndex], pivotValue) > 0) ;
            if (i >= j) break;
            swap(arr, i, j);
        }

        swap(arr, i, high - 1); // Coloca o pivô na posição correta
        return i;
    }

    // Método de comparação com tratamento de exceções para Double
    private static int compare(String a, String b) {
        try {
            double valueA = Double.parseDouble(a);
            double valueB = Double.parseDouble(b);
            return Double.compare(valueA, valueB);
        } catch (NumberFormatException e) {
            return a.compareTo(b); // Comparação lexicográfica caso não sejam números
        }
    }

    // Método auxiliar para trocar dois elementos do array
    private static void swap(String[][] arr, int i, int j) {
        String[] temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Inserção direta para arrays pequenos
    private static void insertionSort(String[][] arr, int low, int high, int colIndex) {
        for (int i = low + 1; i <= high; i++) {
            String[] key = arr[i];
            int j = i - 1;
            while (j >= low && compare(arr[j][colIndex], key[colIndex]) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}

