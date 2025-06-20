package Ex13;

public class Main {
    public static void main(String[] args) {
        ABB arvore = new ABB();
        
        // Inserindo elementos na árvore
        arvore.add(70);
        arvore.add(30);
        arvore.add(12);
        arvore.add(110);
        arvore.add(80);
        arvore.add(75);
        arvore.add(9);
        arvore.add(87);
        arvore.add(400);
        arvore.add(450);
        arvore.add(2);
        arvore.add(3);

        // Testando os métodos de percurso
        arvore.emOrdem();
        arvore.preOrdem();
        arvore.posOrdem();

        // Testando o método de busca
        System.out.println("Busca por 80: " + arvore.busca(80));
        System.out.println("Busca por 100: " + arvore.busca(100));
    }
}
