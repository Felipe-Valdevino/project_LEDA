package Road_Accidents;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import Algoritmos.CountingSortT;
import Algoritmos.HeapSortT;
import Algoritmos.InsertionSortT;
import Algoritmos.MergeSortT;
import Algoritmos.QuickSortT;
import Algoritmos.QuickSort_Mediana3T;
import Algoritmos.SelectionSortT;

public class AccidentProcessorTime {

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
                    String[][] newRecords = new String[records.length * 2][]; // Aumenta a capacidade
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
        // Copia os registros para um novo array para ordenar (incluindo o cabeçalho)
        String[][] recordsToSort = new String[records.length - 1][];
        for (int i = 1; i < records.length; i++) { // Começa em 1 para ignorar o cabeçalho
            recordsToSort[i - 1] = records[i]; // Copia cada linha (exceto o cabeçalho)
        }

        // Verifica e converte a coluna "time" (coluna 3) para valores numéricos ou data
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        double minValue = Double.MAX_VALUE;
        double maxValue = Double.MIN_VALUE;

        for (int i = 0; i < recordsToSort.length; i++) {
            String timeValue = recordsToSort[i][3];
            try {
                if (timeValue != null && !timeValue.isEmpty()) {
                    if (timeValue.contains("-")) {
                        // Tenta converter valores no formato "yyyy-MM-dd" para um número
                        long timeInMillis = dateFormat.parse(timeValue).getTime(); // Converte para milissegundos desde 1970
                        recordsToSort[i][3] = Double.toString(timeInMillis); // Converte para string numérica
                    } else if (timeValue.matches("\\d+\\.\\d+") || timeValue.matches("\\d+")) {
                        // Se o valor for numérico (decimal ou inteiro), trate-o como hora decimal
                    } else if (timeValue.contains(":")) {
                        // Trata valores no formato "hh:mm"
                        String[] timeParts = timeValue.split(":");
                        double hours = Double.parseDouble(timeParts[0]);
                        double minutes = Double.parseDouble(timeParts[1]) / 60.0;
                        recordsToSort[i][3] = Double.toString(hours + minutes); // Converte para horas decimais
                    } else {
                        // Tenta converter diretamente para Double
                        Double.parseDouble(timeValue); // Valida o valor
                    }
                } else {
                    recordsToSort[i][3] = "0.0"; // Substitui valores vazios por "0.0"
                }
            } catch (NumberFormatException | ParseException e) {
                System.out.println("Valor inválido na linha " + (i + 2) + ": " + timeValue);
                recordsToSort[i][3] = "0.0"; // Substitui valores inválidos por "0.0"
            }

            // Conversão para encontrar min e max valores
            try {
                double currentValue = Double.parseDouble(recordsToSort[i][3]);
                minValue = Math.min(minValue, currentValue);
                maxValue = Math.max(maxValue, currentValue);
            } catch (NumberFormatException e) {
                System.out.println("Erro na conversão para encontrar min/max na linha " + (i + 2) + ": " + recordsToSort[i][3]);
            }
        }

        // Conversão para inteiros antes de usar o CountingSort
        for (int i = 0; i < recordsToSort.length; i++) {
            try {
                double value = Double.parseDouble(recordsToSort[i][3]);
                if (value < 0) {
                    System.out.println("Valor negativo encontrado na linha " + (i + 2) + ": " + value);
                    recordsToSort[i][3] = "0"; // Define para 0 se o valor for negativo
                } else {
                    recordsToSort[i][3] = Integer.toString((int) value); // Converte para inteiro
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro na conversão para inteiro na linha " + (i + 2) + ": " + recordsToSort[i][3]);
                recordsToSort[i][3] = "0"; // Valores inválidos convertidos para 0
            }
        }

        // Verifica se os valores min e max são válidos
        if (minValue < 0 || maxValue < 0) {
            System.out.println("Valores inválidos encontrados: min = " + minValue + ", max = " + maxValue);
            return; // Evita chamar o Counting Sort se os valores não forem válidos
        }

        long startTime = System.currentTimeMillis();

        // Seleciona e executa o algoritmo de ordenação
        switch (algorithm) {
            case "insertionSort":
                InsertionSortT.insertionSort(recordsToSort, caso, 3); // Ordena pela coluna "time"
                break;
            case "selectionSort":
                SelectionSortT.selectionSort(recordsToSort, caso, 3);
                break;
            case "mergeSort":
                MergeSortT.mergeSort(recordsToSort, caso, 3);
                break;
            case "quickSort":
                QuickSortT.quickSort(recordsToSort, caso, 3);
                break;
            case "quickSortMedianaDeTres":
                QuickSort_Mediana3T.quickSortMedianaDeTres(recordsToSort, caso, 3);
                break;
            case "countingSort":
                // Verifica o range antes de chamar o CountingSort
                if (maxValue >= 0 && maxValue < Integer.MAX_VALUE) {
                    CountingSortT.countingSort(recordsToSort, caso, 3);
                } else {
                    System.out.println("Erro: Range inválido para Counting Sort.");
                }
                break;
            case "heapSort":
                HeapSortT.heapSort(recordsToSort, caso, 3);
                break;
            default:
                throw new IllegalArgumentException("Algoritmo desconhecido: " + algorithm);
        }

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        // Grava o resultado em um arquivo CSV
        String outputFilePath = "./util/accidents_NCBMV_time_" + algorithm + "_" + caso + ".csv";
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
        String outputFilePath = "./util/execution_times_time.csv";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath, true))) {
            bw.write(algorithm + "," + caso + "," + time + "ms");
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
