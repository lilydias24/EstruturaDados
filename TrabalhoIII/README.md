# Trabalho III — Estrutura de Dados

Este projeto reúne implementações de diferentes estruturas de dados avançadas em Java, aplicadas ao contexto de gerenciamento de objetos do tipo `Celular`. O trabalho segue os requisitos propostos na disciplina de Estrutura de Dados — UNIPAMPA, 2025/01.

## Estruturas Implementadas

- **Árvore Binária de Busca (ABB):** Estrutura para armazenar e buscar celulares de forma eficiente.
- **Lista Duplamente Encadeada Ordenada (LDEOrdenada):** Lista que mantém os elementos sempre ordenados.
- **Mapa (HashMap customizado):** Estrutura de mapeamento para acesso rápido por chave.
- **Vetor Ordenado:** Vetor que mantém os elementos em ordem crescente ou decrescente.

As implementações dessas estruturas estão na pasta [`estruturas/`](estruturas/).

## Principais Arquivos

- [`Main.java`](Main.java): Classe principal para execução e testes das estruturas.
- [`Celular.java`](Celular.java): Classe modelo representando um celular, com atributos relevantes.
- [`estruturas/ABB.java`](estruturas/ABB.java): Implementação da árvore binária de busca.
- [`estruturas/LDEOrdenada.java`](estruturas/LDEOrdenada.java): Implementação da lista duplamente encadeada ordenada.
- [`estruturas/Mapa.java`](estruturas/Mapa.java): Implementação de um mapa/hashmap.
- [`estruturas/VetorOrdenado.java`](estruturas/VetorOrdenado.java): Implementação do vetor ordenado.

## Como Executar

1. Compile todos os arquivos `.java` do diretório.
2. Execute a classe principal:

```sh
java Main