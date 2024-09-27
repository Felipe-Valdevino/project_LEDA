package Road_Accidents;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AccidentFilter {
	// Método para filtrar acidentes com álcool
    public static void filtrarAcidentesPorAlcool(String arquivoEntrada, String arquivoSaida) {
        String linha;
        String separador = ","; // Separador usado no CSV

        try (BufferedReader br = new BufferedReader(new FileReader(arquivoEntrada));
             BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoSaida))) {

            // Lê a primeira linha que contém o cabeçalho
            String cabecalho = br.readLine();
            if (cabecalho != null) {
                bw.write(cabecalho);
                bw.newLine();
            }

            // Lê e processa cada linha do arquivo
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(separador);

                // Verifica se a coluna 'alcohol' (índice 9) tem o valor "ne"
                if (dados.length > 9 && "ne".equals(dados[9])) {
                    bw.write(linha);
                    bw.newLine();
                }
            }

            System.out.println("Arquivo com acidentes com álcool gerado com sucesso: " + arquivoSaida);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para filtrar acidentes sem colisão de veículos em movimento
    public static void filtrarAcidentesSemColisaoDeVeiculos(String arquivoEntrada, String arquivoSaida) {
        String linha;
        String separador = ","; // Separador usado no CSV

        try (BufferedReader br = new BufferedReader(new FileReader(arquivoEntrada));
             BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoSaida))) {

            // Lê a primeira linha que contém o cabeçalho
            String cabecalho = br.readLine();
            if (cabecalho != null) {
                bw.write(cabecalho);
                bw.newLine();
            }

            // Lê e processa cada linha do arquivo
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(separador);

                // Verifica se a coluna 'crash_kind' (índice 6) tem o valor esperado
                if (dados.length > 6 && "not an option It is not a collision between moving vehicles".equals(dados[6])) {
                    bw.write(linha);
                    bw.newLine();
                }
            }

            System.out.println("Arquivo com acidentes sem colisão de veículos gerado com sucesso: " + arquivoSaida);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
 // Método para filtrar acidentes causados por animais da floresta
    public static void filtrarAcidentesPorAnimaisDaFloresta(String arquivoEntrada, String arquivoSaida) {
        String linha;
        String separador = ","; // Separador usado no CSV

        try (BufferedReader br = new BufferedReader(new FileReader(arquivoEntrada));
             BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoSaida))) {

            // Lê a primeira linha que contém o cabeçalho
            String cabecalho = br.readLine();
            if (cabecalho != null) {
                bw.write(cabecalho);
                bw.newLine();
            }

            // Lê e processa cada linha do arquivo
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(separador);

                // Verifica se a coluna 'accident_kind' (índice 5) tem o valor esperado
                if (dados.length > 5 && "collision with forest animals".equals(dados[5])) {
                    bw.write(linha);
                    bw.newLine();
                }
            }

            System.out.println("Arquivo com acidentes causados por animais da floresta gerado com sucesso: " + arquivoSaida);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Método para filtrar pedestres que estavam sob a influência de álcool
    public static void filtrarPedestresSobAlcool(String arquivoEntrada, String arquivoSaida) {
        String linha;
        String separador = ","; // Separador usado no CSV

        try (BufferedReader br = new BufferedReader(new FileReader(arquivoEntrada));
             BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoSaida))) {

            // Lê a primeira linha que contém o cabeçalho
            String cabecalho = br.readLine();
            if (cabecalho != null) {
                bw.write(cabecalho);
                bw.newLine();
            }

            // Lê e processa cada linha do arquivo
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(separador);

                // Verifica se a coluna 'pedestrian_condition' (índice 4) contém "under the influence of alcohol"
                if (dados.length > 3 && dados[3].trim().startsWith("under the influence of alcohol")) {
                    bw.write(linha);
                    bw.newLine();
                }
            }

            System.out.println("Arquivo com pedestres sob a influência de álcool gerado com sucesso: " + arquivoSaida);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
