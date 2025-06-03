package TrabalhoI.src;

import src.controller.*;
import src.utils.Estilo;
import src.utils.ImportaCSV;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;
        ImportaCSV.importarDados();
        do {
            System.out.println(Estilo.negrito + Estilo.azul + "\n<<<----------- LOCADORA DE VEÍCULOS ---------->> \n" );
            System.out.println(Estilo.roxo + "\t 1. Gerenciar Clientes");
            System.out.println("\n\t 2. Gerenciar Veículos");
            System.out.println("\n\t 3. Gerenciar Categorias");
            System.out.println("\n\t 4. Gerenciar Locações");
            System.out.println("\n\t 0. <- Sair" + Estilo.reset);
            System.out.println(Estilo.negrito + Estilo.azul + "\n <<------------------------------------------->> \n" + Estilo.reset);
            System.out.print(Estilo.negrito + Estilo.amarelo + ">> Escolha uma das opções acima : " + Estilo.reset);
            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(Estilo.negrito + Estilo.vermelho + "Entrada inválida! Digite apenas números." + Estilo.reset);
                scanner.nextLine();
                continue;
            }
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    controllerClientes.menuClientes(scanner);
                    break;
                case 2:
                    controllerVeiculos.menuVeiculos(scanner);
                    break;
                case 3:
                    controllerCategorias.menuCategorias(scanner);
                    break;
                case 4:
                    controllerLocacoes.menuLocacoes(scanner);
                    break;
                case 0:
                    System.out.println(Estilo.negrito + Estilo.branco +"\nEncerrando o programa..." + Estilo.reset);
                    break;
                default:
                    System.out.println(Estilo.negrito + Estilo.vermelho + "Opção inválida!" + Estilo.reset);
            }
        } while (opcao != 0);

        scanner.close();
    }
}
