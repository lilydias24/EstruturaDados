package TrabalhoII;

/*
 * Representação de um caixa do supermercado
 * @author emilly dias e @author eric moraes
 */

public class Caixa {
    private int idCaixa;                    // Número identificador do caixa
    private Fila<Cliente> filaClientes;     // Fila de clientes esperando
    private Cliente clienteAtual;           // Cliente sendo atendido no momento
    private int tempoRestanteAtendimento;   // Tempo restante para término do atendimento
    private int clientesAtendidos;          // Contador de clientes atendidos (para estatísticas)

    public Caixa(int idCaixa) {
        this.idCaixa = idCaixa;
        this.filaClientes = new Fila<>();
        this.clienteAtual = null;
        this.tempoRestanteAtendimento = 0;
        this.clientesAtendidos = 0;
    }

    // Adiciona um novo cliente à fila deste caixa
    public void adicionarCliente(Cliente cliente) {
        filaClientes.enfileirar(cliente);
    }

    /* Atualiza o estado do caixa em um passo de tempo
       return true se um cliente terminou de ser atendido neste passo */
    public boolean atualizarAtendimento() {
        // Incrementa tempo de espera para todos na fila
        for (int i = 0; i < filaClientes.tamanho(); i++) {
            Cliente c = filaClientes.primeiro();
            filaClientes.desenfileirar();
            c.incrementarTempoEspera();
            filaClientes.enfileirar(c);
        }

        if (clienteAtual == null && !filaClientes.estaVazia()) {
            // Se não está atendendo ninguém e tem fila, começa a atender o próximo
            iniciarProximoAtendimento();
            return false;
        }

        if (clienteAtual != null) {
            // Decrementa o tempo de atendimento
            tempoRestanteAtendimento--;
            clienteAtual.decrementarTempoAtendimento();

            if (tempoRestanteAtendimento <= 0) {
                // Atendimento concluído
                finalizarAtendimento();
                return true;
            }
        }
        return false;
    }

    // Inicia o atendimento do próximo cliente da fila
    private void iniciarProximoAtendimento() {
        if (!filaClientes.estaVazia()) {
            clienteAtual = filaClientes.desenfileirar();
            tempoRestanteAtendimento = clienteAtual.getTempoAtendimento();
        }
    }

    //Finaliza o atendimento do cliente atual
    private void finalizarAtendimento() {
        clientesAtendidos++;
        clienteAtual = null;
        tempoRestanteAtendimento = 0;

        // Se tem mais clientes na fila, inicia o próximo
        if (!filaClientes.estaVazia()) {
            iniciarProximoAtendimento();
        }
    }

    public int getidCaixa() {
        return idCaixa;
    }

    public int getTamanhoFila() {
        return filaClientes.tamanho();
    }

    public Cliente getClienteAtual() {
        return clienteAtual;
    }

    public int getTempoRestanteAtendimento() {
        return tempoRestanteAtendimento;
    }

    public int getClientesAtendidos() {
        return clientesAtendidos;
    }

    public boolean estaLivre() {
        return clienteAtual == null;
    }

    public Fila<Cliente> getFila() {
        return this.filaClientes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Caixa ").append(idCaixa).append(": ");
        
        if (clienteAtual != null) {
            sb.append("[Atendendo: ").append(clienteAtual)
              .append(" (").append(tempoRestanteAtendimento).append(" min restantes)] ");
        } else {
            sb.append("[Livre] ");
        }
        
        sb.append("Fila: ").append(filaClientes);
        
        return sb.toString();
    }
}