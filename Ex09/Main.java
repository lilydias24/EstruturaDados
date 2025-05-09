package Ex09;

public class Main {
    public static void main(String[] args) {
        PilhaLista pilha = new PilhaLista();

        pilha.push(new Aluno("Diana", 101));
        pilha.push(new Aluno("Victor", 102));
        pilha.push(new Aluno("Estephani", 103));

        pilha.imprimir();

        System.out.println("Topo: " + pilha.top());
        pilha.pop();
        pilha.imprimir();
    }
}
