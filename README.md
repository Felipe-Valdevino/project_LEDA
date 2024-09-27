# Análise Comparativa de Algoritmos de Ordenação sobre acidentes de trânsito na República Checa, ocorridos entre 2016 e 2022

Este projeto tem como objetivo analisar e comparar a eficiência de diferentes algoritmos de ordenação aplicados a um dataset contendo informações sobre acidentes de trânsito na República Checa, ocorridos entre 2016 e 2022.

## Os algoritmos abordados incluem:

- *Selection Sort*
- *Insertion Sort*
- *Quick Sort*
- *Merge Sort*
- *Counting Sort*
- *Heapsort*
- *Quick Sort com Mediana 3*

## Metodologia

Os algoritmos foram aplicados a um arquivo CSV contendo informações de acidentes de trânsito, e os tempos de execução foram registrados para análise comparativa em diferentes cenários: melhor caso e pior caso.

### Cenários de Teste

Os dados foram extraídos do arquivo road_accidents_czechia_2016_2022.csv. Para os testes, foram gerados conjuntos representando:

- *Melhor Caso*: Dados ordenados previamente em ordem crescente.
- *Pior Caso*: Dados em ordem decrescente.

### Arquivos Utilizados

- execution_times_time: Contém os tempos de execução medidos para os diferentes algoritmos de ordenação ao longo do tempo.
- execution_timesData: Contém dados processados de cada execução dos algoritmos, separados por data do acidente.

## Ambiente de Execução

O projeto foi desenvolvido na IDE *Eclipse*, utilizando Java. A estrutura do projeto foi organizada em diversas classes, facilitando a manutenção e o reuso do código.

## Conclusão

Os resultados mostram que o *Counting Sort, **Merge Sort, e **Quick Sort* se destacam em eficiência, enquanto *Insertion Sort* e *Selection Sort* têm desempenhos mais fracos, especialmente em listas maiores ou desordenadas. A escolha do algoritmo de ordenação deve considerar o tipo de dados e as condições de ordenação para otimizar o desempenho.
