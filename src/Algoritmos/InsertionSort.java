package Algoritmos;

import java.util.Date;

public class InsertionSort{
    
	public static void insertionSort(String[][] records, String caso) {
        // A implementação do Insertion Sort deve considerar o caso especificado.
        int n = records.length;

        // Adapte o caso de ordenação para os diferentes cenários
        for (int i = 1; i < n; i++) {
            String[] key = records[i];
            int j = i - 1;

            // Ordena em ordem decrescente pela data (campo 2)
            while (j >= 0 && (caso.equals("piorCaso") ? key[2].compareTo(records[j][2]) > 0 :
                    caso.equals("melhorCaso") ? key[2].compareTo(records[j][2]) < 0 :
                    key[2].compareTo(records[j][2]) > 0)) {
                records[j + 1] = records[j];
                j = j - 1;
            }
            records[j + 1] = key;
        }
    }
}