# Simulador de Supermercado — Estrutura de Dados

Este projeto simula o funcionamento de um supermercado com múltiplos caixas, utilizando estruturas de dados implementadas do zero em Java. O objetivo é demonstrar o uso de listas e filas para gerenciar o atendimento de clientes em um ambiente de simulação interativo no terminal.

## Funcionalidades

- **Simulação de atendimento em caixas:** Cada caixa possui uma fila própria de clientes.
- **Chegada aleatória de clientes:** A cada passo de tempo, há uma chance de um novo cliente chegar ao supermercado.
- **Distribuição automática:** Novos clientes são direcionados ao caixa com a menor fila.
- **Atendimento sequencial:** Cada caixa atende um cliente por vez, decrementando o tempo de atendimento a cada passo.
- **Estatísticas em tempo real:** Exibe o número de clientes atendidos, clientes em fila, tempo de simulação, etc.
- **Interface colorida no terminal:** Utiliza códigos ANSI para destacar informações importantes.

## Estruturas de Dados

- [`Lista<T>`](Lista.java): Lista dinâmica genérica para armazenar os caixas.
- [`Fila<T>`](Fila.java): Fila circular genérica para gerenciar a ordem de atendimento dos clientes em cada caixa.
- [`Caixa`](Caixa.java): Representa um caixa do supermercado, com sua fila de clientes e controle de atendimento.
- [`Cliente`](Cliente.java): Representa um cliente, com tempo de atendimento e estatísticas de espera.
- [`CoresTerminal`](CoresTerminal.java): Utilitário para formatação colorida da saída no terminal.

## Como executar

1. Compile todos os arquivos `.java` do projeto.
2. Execute a classe principal:

```sh
java TrabalhoII.Supermercado