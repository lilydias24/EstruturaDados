public interface Mapa<C, V> {
    public boolean contemChave(C chave);
    public V obterValor(C chave); // 
    public void incluir(C chave, V valor);
    public int tamanho();
    public void imprimir(); // 
}