package Ex14;

public class Main {
    public static void main(String[] args) {
        ABB arvore = new ABB();
        
        // Inserindo elementos na árvore
        int[] valores = {63, 7, 69, 2, 59, 65, 90, 52, 60, 83};
        for (int valor : valores) {
            arvore.add(valor);
        }

        // Testando os métodos de percurso
        arvore.preOrdem();
        arvore.emOrdem();
        arvore.posOrdem();
        arvore.imprimeLargura();

        // Testando o método de busca
        System.out.println("Busca por 60 (iterativa): " + (arvore.buscaIter(60) != null));
        System.out.println("Busca por 60 (recursiva): " + (arvore.buscaRec(60) != null));
        System.out.println("Busca por 100: " + (arvore.buscaIter(100) != null));

        // Testando remoção
        System.out.println("\nRemovendo 60 (folha): " + arvore.remove(60));
        System.out.println("Busca por 60 após remoção: " + (arvore.buscaIter(60) != null));
        arvore.emOrdem();

        System.out.println("\nRemovendo 69 (um filho): " + arvore.remove(69));
        arvore.emOrdem();

        System.out.println("\nRemovendo 63 (dois filhos, raiz): " + arvore.remove(63));
        arvore.emOrdem();
    }
}
