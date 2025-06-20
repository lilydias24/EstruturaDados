package Ex13;

public class ABB {
    private Noh raiz;

    // Classe interna para representar os nós da árvore
    private static class Noh {
        int valor;
        Noh esq;
        Noh dir;
        Noh pai;

        Noh(int v) {
            this.valor = v;
            this.esq = null;
            this.dir = null;
            this.pai = null;
        }
    }

    // Verifica se a árvore está vazia
    public boolean isEmpty() {
        return this.raiz == null;
    }

    // Método público para inserção iterativa
    public void add(int element) {
        if (isEmpty()) {
            this.raiz = new Noh(element);
        } else {
            Noh aux = this.raiz;
            while (aux != null) {
                if (element < aux.valor) {
                    if (aux.esq == null) {
                        Noh newNode = new Noh(element);
                        aux.esq = newNode;
                        newNode.pai = aux;
                        return;
                    }
                    aux = aux.esq;
                } else {
                    if (aux.dir == null) {
                        Noh newNode = new Noh(element);
                        aux.dir = newNode;
                        newNode.pai = aux;
                        return;
                    }
                    aux = aux.dir;
                }
            }
        }
    }

    // Método público para inserção recursiva
    public void recursiveAdd(int element) {
        if (isEmpty()) {
            this.raiz = new Noh(element);
        } else {
            recursiveAdd(this.raiz, element);
        }
    }

    // Método privado auxiliar para inserção recursiva
    private void recursiveAdd(Noh node, int element) {
        if (element < node.valor) {
            if (node.esq == null) {
                Noh newNode = new Noh(element);
                node.esq = newNode;
                newNode.pai = node;
                return;
            }
            recursiveAdd(node.esq, element);
        } else {
            if (node.dir == null) {
                Noh newNode = new Noh(element);
                node.dir = newNode;
                newNode.pai = node;
                return;
            }
            recursiveAdd(node.dir, element);
        }
    }

    // Método público para busca
    public boolean busca(int element) {
        return busca(this.raiz, element);
    }

    // Método privado auxiliar para busca
    private boolean busca(Noh node, int element) {
        if (node == null) {
            return false;
        }
        if (element == node.valor) {
            return true;
        } else if (element < node.valor) {
            return busca(node.esq, element);
        } else {
            return busca(node.dir, element);
        }
    }

    // Método para percorrer a árvore em ordem (esquerda, raiz, direita)
    public void emOrdem() {
        System.out.print("Percurso em ordem: ");
        emOrdem(this.raiz);
        System.out.println();
    }

    private void emOrdem(Noh node) {
        if (node != null) {
            emOrdem(node.esq);
            System.out.print(node.valor + " ");
            emOrdem(node.dir);
        }
    }

    // Método para percorrer a árvore em pré-ordem (raiz, esquerda, direita)
    public void preOrdem() {
        System.out.print("Percurso em pré-ordem: ");
        preOrdem(this.raiz);
        System.out.println();
    }

    private void preOrdem(Noh node) {
        if (node != null) {
            System.out.print(node.valor + " ");
            preOrdem(node.esq);
            preOrdem(node.dir);
        }
    }

    // Método para percorrer a árvore em pós-ordem (esquerda, direita, raiz)
    public void posOrdem() {
        System.out.print("Percurso em pós-ordem: ");
        posOrdem(this.raiz);
        System.out.println();
    }

    private void posOrdem(Noh node) {
        if (node != null) {
            posOrdem(node.esq);
            posOrdem(node.dir);
            System.out.print(node.valor + " ");
        }
    }
}
