package Road_Accidents;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Algoritmos.InsertionSort;
import Algoritmos.SelectionSort;
import Algoritmos.MergeSort;
import Algoritmos.QuickSort;
import Algoritmos.QuickSort_Mediana3;
import Algoritmos.CountingSort;
import Algoritmos.HeapSort;

public class AccidentProcessorData {

    public static String[][] readCsv(String filePath) {
        String[][] records = new String[1000][]; // Inicia com um array grande
        int index = 0; // Contador de registros lidos

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Ler os cabeçalhos
            line = br.readLine();
            records[index++] = line.split(",");

            // Ler cada linha do arquivo
            while ((line = br.readLine()) != null) {
                if (index >= records.length) {
                    // Aumenta o tamanho do array se necessário
                    String[][] newRecords = new String[records.length * 2][];
                    System.arraycopy(records, 0, newRecords, 0, records.length);
                    records = newRecords;
                }
                records[index++] = line.split(",");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Copia os registros para um novo array do tamanho exato
        String[][] finalRecords = new String[index][];
        System.arraycopy(records, 0, finalRecords, 0, index);
        return finalRecords;
    }

    public static void sortAndSave(String[][] records, String algorithm, String caso) {
        // Copia os registros para um novo array para ordenar
        String[][] recordsToSort = new String[records.length][];
        for (int i = 0; i < records.length; i++) {
            recordsToSort[i] = records[i]; // Copia cada linha
        }

        // Verifica se a coluna 3 (presumivelmente a que será usada pelo CountingSort) tem valores válidos
        if (algorithm.equals("countingSort")) {
            for (int i = 1; i < recordsToSort.length; i++) { // Começa em 1 para pular o cabeçalho
                if (recordsToSort[i][3] == null || recordsToSort[i][3].trim().isEmpty()) {
                    System.out.println("Valor inválido na linha " + i + ": " + recordsToSort[i][3]);
                    recordsToSort[i][3] = "0"; // Substitui valores inválidos por "0"
                } else {
                    try {
                        // Tenta converter a coluna 3 para um valor inteiro
                        Integer.parseInt(recordsToSort[i][3]);
                    } catch (NumberFormatException e) {
                        System.out.println("Valor inválido na linha " + i + ": " + recordsToSort[i][3]);
                        recordsToSort[i][3] = "0"; // Substitui valores inválidos por "0"
                    }
                }
            }
        }

        long startTime = System.currentTimeMillis();

        // Seleciona e executa o algoritmo de ordenação
        switch (algorithm) {
            case "insertionSort":
                InsertionSort.insertionSort(recordsToSort, caso);
                break;
            case "selectionSort":
                SelectionSort.selectionSort(recordsToSort, caso);
                break;
            case "mergeSort":
                MergeSort.mergeSort(recordsToSort, caso);
                break;
            case "quickSort":
                QuickSort.quickSort(recordsToSort, caso);
                break;
            case "quickSortMedianaDeTres":
                QuickSort_Mediana3.quickSortMedianaDeTres(recordsToSort, caso);
                break;
            case "countingSort":
                CountingSort.countingSort(recordsToSort, caso);
                break;
            case "heapSort":
                HeapSort.heapSort(recordsToSort, caso);
                break;
            default:
                throw new IllegalArgumentException("Algoritmo desconhecido: " + algorithm);
        }

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        // Grava o resultado em um arquivo CSV
        String outputFilePath = "./util/accidents_NCBMV_date_" + algorithm + "_" + caso + ".csv";
        writeCsv(recordsToSort, outputFilePath);

        // Adiciona o tempo de execução a um arquivo separado
        appendExecutionTime(algorithm, caso, executionTime);
    }

    public static void writeCsv(String[][] records, String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String[] record : records) {
                if (record != null) { // Verifica se o registro não é nulo
                    bw.write(String.join(",", record));
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void appendExecutionTime(String algorithm, String caso, long time) {
        String outputFilePath = "./util/execution_timesData.csv";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath, true))) {
            bw.write(algorithm + "," + caso + "," + time + "ms");
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
