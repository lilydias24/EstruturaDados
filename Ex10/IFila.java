package Ex10;

public interface IFila {
    public boolean add(Object info);  // insere elemento no final
    public boolean remove();         // remove elemento do início
    public boolean isEmpty();        // verifica se está vazia
    public int size();               // retorna o tamanho atual
}