package Ex05;

public class Main {
    public static void main(String[] args) {
        LDE lista = new LDE();

        lista.inserirFim(new Aluno("Ana", 1));
        lista.inserirFim(new Aluno("Bruno", 2));
        lista.inserirFim(new Aluno("Carlos", 3));

        lista.imprimirInicioFim();
        lista.remover(2);
        System.out.println("Após remover Bruno:");
        lista.imprimirFimInicio();
    }
}
