package TrabalhoI.src.tests;
import src.model.Categoria;
import src.model.Veiculo;
import src.utils.ImportaCSV;

public class TesteVeiculo {
    public static void main(String[] args) {

        ImportaCSV.importarDados();

        Veiculo.listarVeiculos(true);

        Veiculo.editarVeiculo("IVI-5T72", "Civic", "Honda", 2017, 160, 5, Categoria.buscarCategoria(1012));

        Veiculo.listarVeiculos(false);

        Veiculo.removerVeiculo("IVY-5357");

        Veiculo.listarVeiculos(true);
    }
}
