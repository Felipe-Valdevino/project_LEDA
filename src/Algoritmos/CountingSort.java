package Algoritmos;

public class CountingSort {
    public static void countingSort(String[][] records, String caso) {
        // Defina o máximo esperado no seu caso
        int max = 10000; // Ajuste conforme necessário
        int[] count = new int[max + 1]; // Array de contagem
        String[][] output = new String[records.length][]; // Array de saída

        // Contar a ocorrência de cada valor
        for (int i = 1; i < records.length; i++) { // Começa em 1 para pular o cabeçalho
            int value = Integer.parseInt(records[i][3]); // Coluna com o valor a ser contado
            if (value > 0) { // Ignora valores que foram definidos como "0"
                count[value]++;
            }
        }

        // Modificar o array de contagem para que cada elemento armazenar a soma acumulativa
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Construir o array de saída
        for (int i = records.length - 1; i >= 1; i--) { // Começa em records.length - 1 para preservar a ordem
            int value = Integer.parseInt(records[i][3]);
            if (value > 0) { // Ignora valores que foram definidos como "0"
                output[count[value]] = records[i];
                count[value]--;
            }
        }

        // Copia o array de saída de volta para o array original
        for (int i = 1; i < records.length; i++) { // Começa em 1 para pular o cabeçalho
            records[i] = output[i];
        }
    }
}
