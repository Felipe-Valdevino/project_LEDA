package Algoritmos;

public class MergeSortT {
    public static void mergeSort(String[][] array, String caso, int index) {
        if (array.length > 1) {
            int mid = array.length / 2;

            String[][] left = new String[mid][];
            String[][] right = new String[array.length - mid][];

            System.arraycopy(array, 0, left, 0, mid);
            System.arraycopy(array, mid, right, 0, array.length - mid);

            mergeSort(left, caso, index);
            mergeSort(right, caso, index);

            merge(array, left, right, index);
        }
    }

    private static void merge(String[][] array, String[][] left, String[][] right, int index) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (Double.parseDouble(left[i][index]) <= Double.parseDouble(right[j][index])) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }
        while (i < left.length) {
            array[k++] = left[i++];
        }
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }
}

