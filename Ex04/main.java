package Ex04;

public class main {
    public static void main(String[] args) {
        ListaEncadeada<Aluno> listaAlunos = new ListaEncadeada<>();

        listaAlunos.inserir(new Aluno(9.5, "Ana", 20));
        listaAlunos.inserir(new Aluno(8.0, "Bruno", 22));
        listaAlunos.inserir(new Aluno(7.2, "Carla", 21));

        listaAlunos.imprimir();
    }
}
