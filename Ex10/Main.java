package Ex10;

public class Main {
    public static void main(String[] args) {
        // Cria uma fila com capacidade para 5 elementos
        FilaVetor fila = new FilaVetor(5);
        
        // Adiciona os elementos
        fila.add(10);
        fila.add(20);
        fila.add(30);
        fila.imprimir();
        
        // Remove o elemento
        fila.remove();
        fila.imprimir();
        
        // Adicionar mais elementos (testando comportamento circular)
        fila.add(40);
        fila.add(50);
        fila.add(60);
        fila.imprimir();
        
        // Remove todos os elementos
        while (!fila.isEmpty()) {
            fila.remove();
            fila.imprimir();
        }
    }
}