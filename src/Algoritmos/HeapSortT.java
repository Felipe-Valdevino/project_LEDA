package Algoritmos;

public class HeapSortT {
    public static void heapSort(String[][] array, String caso, int index) {
        int n = array.length;

        // Constrói o heap máximo
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i, index);
        }

        // Extrai os elementos do heap um por um
        for (int i = n - 1; i > 0; i--) {
            // Move o maior elemento atual para o final do array
            String[] temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Chama o heapify no heap reduzido
            heapify(array, i, 0, index);
        }
    }

    private static void heapify(String[][] array, int n, int i, int index) {
        int largest = i; // Inicializa o maior como raiz
        int left = 2 * i + 1; // Filho à esquerda
        int right = 2 * i + 2; // Filho à direita

        // Converte as datas para inteiros para comparação
        int largestValue = Integer.parseInt(array[largest][index]);
        if (left < n) {
            int leftValue = Integer.parseInt(array[left][index]);
            // Verifica se o filho à esquerda é maior que a raiz para ordenação decrescente
            if (leftValue > largestValue) {
                largest = left;
                largestValue = leftValue;
            }
        }

        if (right < n) {
            int rightValue = Integer.parseInt(array[right][index]);
            // Verifica se o filho à direita é maior que o maior até agora para ordenação decrescente
            if (rightValue > largestValue) {
                largest = right;
            }
        }

        // Se o maior não for a raiz, troca os valores e continua o processo de heapificação
        if (largest != i) {
            String[] temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;

            // Recursivamente faz heapify na subárvore afetada
            heapify(array, n, largest, index);
        }
    }
}
