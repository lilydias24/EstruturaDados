package TrabalhoII;

/**
 * Representação de um cliente no supermercado
 * @author emilly dias e @author eric moraes
 */

public class Cliente {
    private int idCliente;           // Número único de identificação do cliente
    private int tempoAtendimento;    // Tempo total necessário para atendimento (em passos)
    private int tempoEspera;         // Tempo que o cliente ficou na fila (para estatísticas)

    public Cliente(int idCliente, int tempoAtendimento) {
        this.idCliente = idCliente;
        this.tempoAtendimento = tempoAtendimento;
        this.tempoEspera = 0;
    }

    public int getidCliente() {
        return idCliente;
    }

    public int getTempoAtendimento() {
        return tempoAtendimento;
    }

    public int getTempoEspera() {
        return tempoEspera;
    }

    public void incrementarTempoEspera() {
        this.tempoEspera++;
    }

    public void decrementarTempoAtendimento() {
        if (this.tempoAtendimento > 0) {
            this.tempoAtendimento--;
        }
    }

    /* Método para verificar se o cliente terminou de ser atendido
     return true se o tempo de atendimento chegou a zero */
    public boolean atendimentoConcluido() {
        return tempoAtendimento == 0;
    }

    @Override
    public String toString() {
        return "Cliente #" + idCliente + " (" + tempoAtendimento + " min)";
    }
}