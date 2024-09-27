package Road_Accidents;

public class Main {

    public static void main(String[] args) {
        // EXECULTA A TRANSFORMAÇÃO
        String arquivoEntrada = "./util/road_accidents_czechia_2016_2022.csv";
        String arquivoEntrada2 = "./util/pedestrian.csv";

        // Filtrar acidentes com álcool
        String arquivoSaidaAlcool = "./util/alcohol_accidents.csv";
        AccidentFilter.filtrarAcidentesPorAlcool(arquivoEntrada, arquivoSaidaAlcool);

        // Filtrar acidentes sem colisão de veículos em movimento
        String arquivoSaidaNCBMV = "./util/accidents_NCBMV.csv";
        AccidentFilter.filtrarAcidentesSemColisaoDeVeiculos(arquivoEntrada, arquivoSaidaNCBMV);

        // Filtrar acidentes causados por animais da floresta
        String arquivoSaidaCWFA = "./util/accidents_CWFA.csv";
        AccidentFilter.filtrarAcidentesPorAnimaisDaFloresta(arquivoSaidaNCBMV, arquivoSaidaCWFA);

        // Filtrar pedestres que estavam sob a influência de álcool
        String arquivoSaidaDrunk = "./util/drunk_pedestrians.csv";
        AccidentFilter.filtrarPedestresSobAlcool(arquivoEntrada2, arquivoSaidaDrunk);

        // Caminho para o arquivo CSV
        String csvFilePath = "./util/accidents_NCBMV.csv"; // Arquivo de entrada para processamento

        // Leia o arquivo CSV
        String[][] records1 = AccidentProcessorData.readCsv(csvFilePath);

        if (records1 == null || records1.length == 0) {
            System.out.println("Arquivo CSV vazio ou inválido.");
            return;
        }

        // Executar algoritmos de ordenação com diferentes casos
        String[] algorithms = {"insertionSort", "selectionSort", "mergeSort", "quickSort", "quickSortMedianaDeTres", "countingSort", "heapSort"};
        String[] casos = {"melhorCaso", "piorCaso"};

        // Para cada algoritmo e caso, execute a ordenação e salve os resultados
        for (String algorithm : algorithms) {
            for (String caso : casos) {
                System.out.println("Executando " + algorithm + " no " + caso + "para Data");
                AccidentProcessorData.sortAndSave(records1, algorithm, caso);
            }
        }

        // Agora, processe e ordene os dados pelo tempo
        String[][] records2 = AccidentProcessorTime.readCsv(csvFilePath);

        if (records2 == null || records2.length == 0) {
            System.out.println("Arquivo CSV vazio ou inválido.");
            return;
        }

        for (String algorithm : algorithms) {
            for (String caso : casos) {
                System.out.println("Executando " + algorithm + " no " + caso + " para tempo");
                AccidentProcessorTime.sortAndSave(records2, algorithm, caso);
            }
        }

        System.out.println("Processamento e ordenação por data e tempo concluídos.");
    }
}
