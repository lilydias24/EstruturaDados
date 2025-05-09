package Ex04;

public class ListaEncadeada<T> {
    private No<T> cabeca;

    public ListaEncadeada() {
        this.cabeca = null;
    }

    public void inserir(T elemento) {
        No<T> novoNo = new No<>(elemento);
        if (cabeca == null) {
            cabeca = novoNo;
        } else {
            No<T> atual = cabeca;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNo;
        }
    }

    public void imprimir() {
        No<T> atual = cabeca;
        while (atual != null) {
            System.out.println(atual.dado);
            atual = atual.proximo;
        }
    }
}
