package Algoritmos;

public class CountingSortT {
    public static void countingSort(String[][] array, String caso, int index) {
        // Determina o tamanho do array de contagem
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // Encontrar o valor máximo e mínimo
        for (String[] record : array) {
            if (record != null && record[index] != null) {
                try {
                    int value = Integer.parseInt(record[index]);
                    if (value > max) {
                        max = value;
                    }
                    if (value < min) {
                        min = value;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Valor inválido: " + record[index]);
                }
            }
        }

        // Debugging: Imprimir valores máximo e mínimo
        System.out.println("Valor máximo: " + max);
        System.out.println("Valor mínimo: " + min);

        // Verificar se min e max são válidos
        if (max < 0 || min < 0) {
            throw new IllegalArgumentException("Valores inválidos encontrados, não devem ser negativos.");
        }

        int range = max - min + 1; // Determine o tamanho do array de contagem
        if (range <= 0) {
            throw new IllegalArgumentException("O range deve ser positivo, encontrado: " + range);
        }

        // Cria o array de contagem
        int[] count = new int[range]; // Aqui pode ocorrer o erro
    }
}

