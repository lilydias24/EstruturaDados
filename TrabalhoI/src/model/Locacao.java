package TrabalhoI.src.model;

import java.time.LocalDate;

import src.estrutura.LDE;
import src.estrutura.Noh;
import src.utils.Estilo;

public class Locacao {
    private String cnhCliente;
    private String placaVeiculo;
    private LocalDate dataRetirada;
    private LocalDate dataDevolucao;
    private double valor;

    static LDE<Locacao> listaLocacoes = new LDE<>();

    public Locacao(String cnhCliente, String placaVeiculo, LocalDate dataRetirada, LocalDate dataDevolucao, double valor) {
        this.cnhCliente = cnhCliente;
        this.placaVeiculo = placaVeiculo;
        this.dataRetirada = dataRetirada;
        this.dataDevolucao = dataDevolucao;
        this.valor = valor;
    }

    public String getCnhCliente() {
        return cnhCliente;
    }

    public void setCnhCliente(String cnhCliente) {
        this.cnhCliente = cnhCliente;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public LocalDate getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(LocalDate dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Locação{" +
                "CNH Cliente='" + cnhCliente + '\'' +
                ", Placa Veículo='" + placaVeiculo + '\'' +
                ", Data Retirada=" + dataRetirada +
                ", Data Devolução=" + dataDevolucao +
                ", Valor=" + valor +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Locacao locacao = (Locacao) obj;
        return placaVeiculo.equals(locacao.placaVeiculo);
    }

    // Métodos estáticos para manipulação de locações
    public static void cadastrarLocacao(String cnhCliente, String placaVeiculo, LocalDate dataRetirada, LocalDate dataDevolucao, double valor) {
        
        if (Cliente.buscarPorCNH(cnhCliente) == null) {
            System.out.println(Estilo.negrito + Estilo.vermelho + "Cliente não encontrado!" + Estilo.reset);
            return;
        }
        
        if (Veiculo.buscarVeiculo(placaVeiculo) == null) {
            System.out.println(Estilo.negrito + Estilo.vermelho + "Veículo não encontrado!" + Estilo.reset);
            return;
        }

        if (!veiculoDisponivel(placaVeiculo)) {
            System.out.println(Estilo.negrito + Estilo.vermelho + "Veículo já está locado!" + Estilo.reset);
            return;
        }

        if (dataRetirada.isAfter(dataDevolucao)) {
            System.out.println(Estilo.negrito + Estilo.vermelho + "A data de retirada não pode ser posterior à data de devolução." + Estilo.reset);
            return;
        }
    
        if (valor < 0) {
            System.out.println(Estilo.negrito + Estilo.vermelho + "O valor da locação não pode ser negativo." + Estilo.reset);
            return;
        }
        
        Locacao novaLocacao = new Locacao(cnhCliente, placaVeiculo, dataRetirada, dataDevolucao, valor);
        listaLocacoes.insereFim(novaLocacao);
        System.out.println(Estilo.negrito + Estilo.verde + "Locação cadastrada com sucesso!" + Estilo.reset);
    }

    public static void listarLocacoes(boolean ordemNormal) {
        if (listaLocacoes.estahVazia()) {
            System.out.println(Estilo.negrito + Estilo.vermelho + "Nenhuma locação cadastrada." + Estilo.reset);
            return;
        }

        System.out.println("==== Lista de Locações ====");
        if (ordemNormal) {
            listaLocacoes.imprimeInicioFim();
        } else {
            listaLocacoes.imprimeFimInicio();
        }
    }

    public static boolean veiculoDisponivel(String placaVeiculo) {
        Locacao temp = new Locacao(null, placaVeiculo, null, null, 0);
        return listaLocacoes.buscar(temp) == null;
    }

    public static void devolverVeiculo(String placaVeiculo) {
        Locacao temp = new Locacao(null, placaVeiculo, null, null, 0);
        boolean removido = listaLocacoes.remove(temp);

        if (removido) {
            System.out.println(Estilo.negrito + Estilo.verde + "Veículo devolvido com sucesso!" + Estilo.reset);
        } else {
            System.out.println(Estilo.negrito + Estilo.vermelho + "Locação não encontrada." + Estilo.reset);
        }
    }

    public static Locacao buscarLocacao(String placaVeiculo) {
        Locacao temp = new Locacao(null, placaVeiculo, null, null, 0);
        Noh<Locacao> noh = listaLocacoes.buscar(temp);

        if (noh != null) {
            return noh.getInfo();
        }
        return null;
    }
}