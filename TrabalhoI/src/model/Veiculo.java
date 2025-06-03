package TrabalhoI.src.model;
import src.estrutura.LDE;
import src.estrutura.Noh;
import src.utils.Estilo;

public class Veiculo {

    private String placa;
    private String modelo;
    private String marca;
    private int ano;
    private int potencia;
    private int lugares;
    private Categoria categoria;
    private static LDE<Veiculo> listaVeiculos = new LDE<>();

    public Veiculo(String placa, String modelo, String marca, int ano, int potencia, int lugares, Categoria categoria) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.potencia = potencia;
        this.lugares = lugares;
        this.categoria = categoria;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getLugares() {
        return lugares;
    }

    public void setLugares(int lugares) {
        this.lugares = lugares;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Veiculo)) return false;
        Veiculo outro = (Veiculo) obj;
        return placa.equals(outro.placa);
    }

    @Override
    public String toString() {
        return "Placa: " + placa + ", Modelo: " + modelo + ", Marca: " + marca +
               ", Ano: " + ano + ", Potência: " + potencia + ", Lugares: " + lugares +
               ", Categoria: " + categoria.getNome();
    }

    public static void cadastrarVeiculo(String placa, String modelo, String marca, int ano, int potencia, int lugares, Categoria categoria) {
        Veiculo novo = new Veiculo(placa, modelo, marca, ano, potencia, lugares, categoria);

        if (listaVeiculos.buscar(novo) != null) {
            System.out.println(Estilo.negrito + Estilo.vermelho + "Já existe veículo com esta placa." + Estilo.reset);
            return;
        }

        listaVeiculos.insereFim(novo);
        System.out.println(Estilo.negrito + Estilo.verde + "Veículo cadastrado com sucesso." + Estilo.reset);
    }

    public static void listarVeiculos(boolean ordemNormal) {
        if (listaVeiculos.estahVazia()) {
            System.out.println(Estilo.negrito + Estilo.vermelho + "Nenhum veículo cadastrado." + Estilo.reset);
            return;
        }

        System.out.println("==== Lista de Veículos ====");
        if (ordemNormal) {
            listaVeiculos.imprimeInicioFim();
        } else {
            listaVeiculos.imprimeFimInicio();
        }
    }

    public static Veiculo buscarVeiculo(String placa) {
        Veiculo temp = new Veiculo(placa, "", "", 0, 0, 0, null);
        Noh<Veiculo> noh = listaVeiculos.buscar(temp);

        if (noh != null) {
            return noh.getInfo();
        }
        return null;
    }

    public static void editarVeiculo(String placa, String novoModelo, String novaMarca, int novoAno, int novaPotencia, int novosLugares, Categoria novaCategoria) {
        Veiculo temp = new Veiculo(placa, "", "", 0, 0, 0, null);
        Noh<Veiculo> noh = listaVeiculos.buscar(temp);

        if (noh == null) {
            System.out.println(Estilo.negrito + Estilo.vermelho + "Veículo não encontrado." + Estilo.reset);
            return;
        }

        Veiculo v = noh.getInfo();
        v.setModelo(novoModelo);
        v.setMarca(novaMarca);
        v.setAno(novoAno);
        v.setPotencia(novaPotencia);
        v.setLugares(novosLugares);
        v.setCategoria(novaCategoria);

        System.out.println(Estilo.negrito + Estilo.verde + "Dados do veículo atualizados." + Estilo.reset);
    }

    public static void removerVeiculo(String placa) {
        // Verifica se há locações associadas ao veículo
        for (Noh<Locacao> noh = Locacao.listaLocacoes.getInicio(); noh != null; noh = noh.getProx()) {
            if (noh.getInfo().getPlacaVeiculo().equals(placa)) {
                System.out.println(Estilo.negrito + Estilo.vermelho + "Não é possível remover o veículo. Existem locações associadas a ele." + Estilo.reset);
                return;
            }
        }
    
        // Remove o veículo se não houver locações associadas
        Veiculo temp = new Veiculo(placa, "", "", 0, 0, 0, null);
        boolean removido = listaVeiculos.remove(temp);
    
        if (removido) {
            System.out.println(Estilo.negrito + Estilo.verde + "Veículo removido com sucesso!" + Estilo.reset);
        } else {
            System.out.println(Estilo.negrito + Estilo.vermelho + "Veículo não encontrado." + Estilo.reset);
        }
    }

    public static void filtrarVeiculos(Integer potenciaMinima, Integer lugares, String nomeCategoria) {
        if (listaVeiculos.estahVazia()) {
            System.out.println(Estilo.negrito + Estilo.vermelho + "Nenhum veículo cadastrado." + Estilo.reset);
            return;
        }
    
        // System.out.println("==== Veículos Filtrados ====");
        boolean encontrou = false;
    
        for (Noh<Veiculo> noh = listaVeiculos.getInicio(); noh != null; noh = noh.getProx()) {
            Veiculo veiculo = noh.getInfo();
    
            boolean atendePotencia = (potenciaMinima == null || veiculo.getPotencia() >= potenciaMinima);
            boolean atendeLugares = (lugares == null || veiculo.getLugares() == lugares);
            boolean atendeCategoria = (nomeCategoria == null || veiculo.getCategoria().getNome().equalsIgnoreCase(nomeCategoria));
    
            if (atendePotencia && atendeLugares && atendeCategoria) {
                System.out.println(veiculo);
                encontrou = true;
            }
        }
    
        if (!encontrou) {
            System.out.println(Estilo.negrito + Estilo.vermelho + "Nenhum veículo encontrado com os critérios especificados." + Estilo.reset);
        }
    }

    public static LDE<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }
}