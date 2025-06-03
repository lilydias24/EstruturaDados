package TrabalhoI.src.model;
import src.estrutura.LDE;
import src.estrutura.Noh;
import src.utils.Estilo;

public class Categoria {
    private String nome;
    private int identificador;
    private static LDE<Categoria> listaCategorias = new LDE<>();

    public Categoria(String nome, int identificador) {
        this.nome = nome;
        this.identificador = identificador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    @Override
    public String toString() {
        return "Categoria: " + nome + ", Identificador: " + identificador;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Categoria outro = (Categoria) obj;
        return identificador == outro.identificador;
    }

    public static void cadastrarCategoria(String nome, int identificador) {
        Categoria novaCategoria = new Categoria(nome, identificador);
        if (listaCategorias.buscar(novaCategoria) != null) {
            System.out.println("Já existe uma categoria com este nome. Não é possível cadastrar.");
            return;
        }
        listaCategorias.insereFim(novaCategoria);
        System.out.println(Estilo.negrito + Estilo.verde + "Categoria cadastrada com sucesso!" + Estilo.reset);
    }

    public static void listarCategorias(boolean ordemNormal) {
        if (listaCategorias.estahVazia()) {
            System.out.println(Estilo.negrito + Estilo.vermelho + "Nenhuma categoria cadastrada. Não é possível listar." + Estilo.reset);
            return;
        }

        System.out.println("==== Lista de Categorias ====");
        if (ordemNormal) {
            listaCategorias.imprimeInicioFim();
        } else {
            listaCategorias.imprimeFimInicio();
        }
    }

    public static Categoria buscarCategoria(int identificador) {
        Categoria temp = new Categoria("", identificador);
        Noh<Categoria> noh = listaCategorias.buscar(temp);

        if (noh != null) {
            return noh.getInfo();
        }
        return null;
    }

    public static void editarCategoria(int identificador, String novoNome) {
        Categoria temp = new Categoria("", identificador);
        Noh<Categoria> noh = listaCategorias.buscar(temp);

        if (noh == null) {
            System.out.println(Estilo.negrito + Estilo.vermelho + "Categoria não encontrada. Não foi possível editar." + Estilo.reset);
            return;
        }

        Categoria c = noh.getInfo();
        c.setNome(novoNome);
        System.out.println(Estilo.negrito + Estilo.verde + "Categoria editada com sucesso!" + Estilo.reset);
    }

    public static void removerCategoria(int identificador) {
        Categoria temp = new Categoria("", identificador);
    
        // Verifica se há veículos associados à categoria
        for (Noh<Veiculo> noh = Veiculo.getListaVeiculos().getInicio(); noh != null; noh = noh.getProx()) {
            if (noh.getInfo().getCategoria().getIdentificador() == identificador) {
                System.out.println(Estilo.negrito + Estilo.vermelho + "Não é possível remover a categoria. Existem veículos associados a ela." + Estilo.reset);
                return;
            }
        }
    
        // Remove a categoria se não houver veículos associados
        boolean removido = listaCategorias.remove(temp);
    
        if (removido) {
            System.out.println(Estilo.negrito + Estilo.verde + "Categoria removida com sucesso!" + Estilo.reset);
        } else {
            System.out.println(Estilo.negrito + Estilo.vermelho + "Categoria não encontrada. Não foi possível remover." + Estilo.reset);
        }
    }
} 