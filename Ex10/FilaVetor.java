package Ex10;

public class FilaVetor implements IFila {
    private int nElemFila;    // número de elementos na fila
    private int inicio;       // índice do início da fila
    private Object[] vetFila; // vetor para armazenar os elementos

    // Construtor que recebe o tamanho da fila
    public FilaVetor(int tamFila) {
        this.nElemFila = 0;
        this.inicio = 0;
        this.vetFila = new Object[tamFila];
    }

    // Método para inserir um elemento no final da fila
    @Override
    public boolean add(Object info) {
        if (this.nElemFila == vetFila.length) {
            System.out.println("Capacidade da fila esgotada");
            return false;
        }
        int fim = (this.inicio + this.nElemFila) % this.vetFila.length;
        this.vetFila[fim] = info;
        this.nElemFila++;
        return true;
    }

    // Método para remover um elemento do início da fila
    @Override
    public boolean remove() {
        if (this.isEmpty()) {
            System.out.println("Fila está vazia");
            return false;
        }
        this.inicio = (this.inicio + 1) % this.vetFila.length;
        this.nElemFila--;
        return true;
    }

    // Método para verificar se a fila está vazia
    @Override
    public boolean isEmpty() {
        return (this.nElemFila == 0);
    }

    // Método para obter o tamanho atual da fila
    @Override
    public int size() {
        return this.nElemFila;
    }

    // Método para imprimir a fila
    public void imprimir() {
        if (this.isEmpty()) {
            System.out.println("Fila vazia");
            return;
        }
        
        System.out.print("Fila: [");
        for (int i = 0; i < this.nElemFila; i++) {
            int pos = (this.inicio + i) % this.vetFila.length;
            System.out.print(vetFila[pos]);
            if (i < this.nElemFila - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        
        // mostra estado interno do vetor
        System.out.print("Vetor: [");
        for (int i = 0; i < vetFila.length; i++) {
            System.out.print(vetFila[i] != null ? vetFila[i] : "null");
            if (i < vetFila.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        System.out.println("Início: " + inicio + ", Fim: " + 
                          ((inicio + nElemFila) % vetFila.length) + 
                          ", Elementos: " + nElemFila);
    }
}

