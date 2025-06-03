package TrabalhoI.src.tests;
import src.model.Cliente;

public class TesteCliente {

    public static void main(String[] args) {

        Cliente.cadastrarCliente("João", "123456", "99999-9999", "11111111111");
        Cliente.cadastrarCliente("Maria", "654321", "88888-8888", "22222222222");

        Cliente.listarClientes(true);

        Cliente.editarCliente("11111111111", "João da Silva", "123456", "99999-0000");

        Cliente.listarClientes(false);

        Cliente.removerCliente("22222222222");

        Cliente.listarClientes(true);
    }
}
