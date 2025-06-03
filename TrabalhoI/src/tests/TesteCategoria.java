package TrabalhoI.src.tests;
import src.model.Categoria;
import src.utils.ImportaCSV;

public class TesteCategoria {
    public static void main(String[] args) {

        ImportaCSV.importarCategorias();

        Categoria.listarCategorias(true);

        Categoria.editarCategoria(1014, "SUV Atualizado");

        Categoria.listarCategorias(false);

        Categoria.removerCategoria(2);

        Categoria.listarCategorias(true);

        Categoria.buscarCategoria(1);
    }
}
