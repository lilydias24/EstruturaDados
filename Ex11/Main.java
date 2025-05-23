package Ex11;

public class Main {
    public static void main(String[] args) {
        FilaLista filaAlunos = new FilaLista();
        
        // Adicionando alunos na fila
        filaAlunos.add(new Aluno("João Silva", 12345));
        filaAlunos.add(new Aluno("Maria Souza", 54321));
        filaAlunos.add(new Aluno("Carlos Oliveira", 98765));
        
        // Imprimindo a fila
        filaAlunos.imprimir();
        
        // Removendo um aluno
        filaAlunos.remove();
        System.out.println("\nApós remover um aluno:");
        filaAlunos.imprimir();
        
        // Adicionando mais alunos
        filaAlunos.add(new Aluno("Ana Costa", 13579));
        filaAlunos.add(new Aluno("Pedro Rocha", 24680));
        
        System.out.println("\nApós adicionar mais alunos:");
        filaAlunos.imprimir();
    }
}
