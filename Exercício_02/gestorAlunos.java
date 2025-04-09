import java.util.Arrays;

public class gestorAlunos {
    public static void main(String[] args) {
        Aluno[] listaAlunos = new Aluno[3];
        
        listaAlunos[0] = new Aluno(8.5, "Douglas", 20);
        listaAlunos[1] = new Aluno(7.3, "Alex", 26);
        listaAlunos[2] = new Aluno(0.0, "Leonardo", 24);

        listaAlunos = adicionarAluno(listaAlunos, new Aluno(9.5, "Maria", 22));
        listaAlunos = adicionarAluno(listaAlunos, new Aluno(6.7, "João", 23));
        
        exibirListaAlunos(listaAlunos);
        
        System.out.println("Total de alunos cadastrados: " + contarAlunos(listaAlunos));
        System.out.println("A lista tem pelo menos X alunos? " + possuiQuantidade(listaAlunos, 1));
        
        listaAlunos = excluirAluno(listaAlunos, 1);
        
        System.out.println("Lista de alunos após remoção:");
        exibirListaAlunos(listaAlunos);
    }

    public static Aluno[] adicionarAluno(Aluno[] lista, Aluno novo) {
        int qtdAtual = contarAlunos(lista);
        
        if (qtdAtual == lista.length) {
            lista = Arrays.copyOf(lista, lista.length * 2);
        }
        
        lista[qtdAtual] = novo;
        return lista;
    }

    public static Aluno[] excluirAluno(Aluno[] lista, int posicao) {
        if (posicao < 0 || posicao >= contarAlunos(lista)) {
            System.out.println("Índice inválido para exclusão.");
            return lista;
        }
        
        for (int i = posicao; i < lista.length - 1; i++) {
            lista[i] = lista[i + 1];
        }
        
        lista[lista.length - 1] = null;
        return lista;
    }

    public static int contarAlunos(Aluno[] lista) {
        int total = 0;
        for (Aluno aluno : lista) {
            if (aluno != null) {
                total++;
            }
        }
        return total;
    }

    public static boolean possuiQuantidade(Aluno[] lista, int qtd) {
        return contarAlunos(lista) >= qtd;
    }
    
    public static void exibirListaAlunos(Aluno[] lista) {
        System.out.println("Lista de Alunos:");
        for (Aluno aluno : lista) {
            if (aluno != null) {
                System.out.println("Nome: " + aluno.getNome() + ", Nota: " + aluno.getNota() + ", Idade: " + aluno.getIdade());
            }
        }
    }
}
