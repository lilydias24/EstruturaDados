package TrabalhoII;

/** Implementação do TAD Lista usando array dinâmico
 * @author emilly dias e @author eric moraes
 */
public class Lista<T> {
    private T[] elementos;
    private int tamanho;

    // Construtor com capacidade inicial padrão
    @SuppressWarnings("unchecked")
    public Lista() {
        this.elementos = (T[]) new Object[10]; // Capacidade inicial 10
        this.tamanho = 0;
    }

    // Construtor com capacidade inicial específica
    @SuppressWarnings("unchecked")
    public Lista(int capacidade) {
        this.elementos = (T[]) new Object[capacidade];
        this.tamanho = 0;
    }

    // Adiciona um elemento ao final da lista
    public void adicionar(T elemento) {
        if (tamanho == elementos.length) {
            redimensionar();
        }
        elementos[tamanho++] = elemento;
    }

    // Redimensiona o array interno quando necessário
    private void redimensionar() {
        @SuppressWarnings("unchecked")
        T[] novoArray = (T[]) new Object[elementos.length * 2];
        System.arraycopy(elementos, 0, novoArray, 0, tamanho);
        elementos = novoArray;
    }

    // Obtém o elemento na posição especificada
    public T obter(int indice) {
        if (indice < 0 || indice >= tamanho) {
            throw new IndexOutOfBoundsException("Índice inválido: " + indice);
        }
        return elementos[indice];
    }

    // Retorna o número de elementos na lista
    public int tamanho() {
        return tamanho;
    }

    // Verifica se a lista está vazia
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < tamanho; i++) {
            if (i > 0) sb.append(", ");
            sb.append(elementos[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}
