package Ex11;

public class FilaLista implements IFila {
    private Noh inicio;
    private Noh fim;
    private int tamanho;
    
    public FilaLista() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }
    
    @Override
    public boolean add(Object info) {
        Noh novo = new Noh(info);
        if (this.isEmpty()) {
            inicio = novo;
        } else {
            fim.setProx(novo);
        }
        fim = novo;
        tamanho++;
        return true;
    }
    
    @Override
    public boolean remove() {
        if (this.isEmpty()) {
            return false;
        }
        
        if (inicio == fim) { // Só tem um elemento
            inicio = null;
            fim = null;
        } else {
            inicio = inicio.getProx();
        }
        tamanho--;
        return true;
    }
    
    @Override
    public boolean isEmpty() {
        return (inicio == null);
    }
    
    @Override
    public int size() {
        return tamanho;
    }
    
    // Método para imprimir a fila
    public void imprimir() {
        if (this.isEmpty()) {
            System.out.println("Fila vazia!");
            return;
        }
        
        System.out.print("Fila de Alunos: [");
        Noh atual = inicio;
        while (atual != null) {
            System.out.print(atual.getInfo());
            atual = atual.getProx();
            if (atual != null) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        System.out.println("Tamanho: " + this.size());
    }
}