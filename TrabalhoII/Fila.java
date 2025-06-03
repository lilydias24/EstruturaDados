package TrabalhoII;

/**
 * Implementação do TAD Fila usando array
 * @author emilly dias e @author eric moraes
 */

public class Fila<T> {
    private T[] elementos;     // Array para armazenar os elementos
    private int tamanho;      // Quantidade de elementos na fila
    private int inicio;       // Índice do primeiro elemento
    private int fim;          // Índice onde o próximo elemento será inserido

    // Construtor com capacidade inicial padrão
    public Fila() {
        this(10); 
    }

    // Construtor com capacidade inicial especificada
    @SuppressWarnings("unchecked")
    public Fila(int capacidade) {
        this.elementos = (T[]) new Object[capacidade];
        this.tamanho = 0;
        this.inicio = 0;
        this.fim = 0;
    }

    public void enfileirar(T elemento) {
        if (tamanho == elementos.length) {
            redimensionar();
        }
        
        elementos[fim] = elemento;
        fim = (fim + 1) % elementos.length; // Trata a fila circular
        tamanho++;
    }

    private void redimensionar() {
        @SuppressWarnings("unchecked")
        T[] novoArray = (T[]) new Object[elementos.length * 2];
        
        for (int i = 0; i < tamanho; i++) {
            novoArray[i] = elementos[(inicio + i) % elementos.length];
        }
        
        elementos = novoArray;
        inicio = 0;
        fim = tamanho;
    }

    public T desenfileirar() {
        if (estaVazia()) {
            throw new IllegalStateException("Fila vazia!");
        }
        
        T elemento = elementos[inicio];
        elementos[inicio] = null;
        inicio = (inicio + 1) % elementos.length;
        tamanho--;
        
        return elemento;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public T primeiro() {
        if (estaVazia()) {
            throw new IllegalStateException("Fila vazia!");
        }
        
        return elementos[inicio];
    }

    public int tamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        for (int i = 0; i < tamanho; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(elementos[(inicio + i) % elementos.length]);
        }
        
        sb.append("]");
        return sb.toString();
    }
}
