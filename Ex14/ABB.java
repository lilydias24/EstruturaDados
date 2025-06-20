package Ex14;

import java.util.LinkedList;
import java.util.Queue;

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

        @Override
        public String toString() {
            return Integer.toString(valor);
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

    // BUSCA ITERATIVA (retorna o nó encontrado ou null)
    public Noh buscaIter(int element) {
        Noh aux = this.raiz;
        while (aux != null) {
            if (aux.valor == element) return aux;
            if (element < aux.valor) aux = aux.esq;
            else aux = aux.dir;
        }
        return null;
    }

    // BUSCA RECURSIVA (retorna o nó encontrado ou null)
    public Noh buscaRec(int element) {
        return buscaRec(this.raiz, element);
    }

    private Noh buscaRec(Noh node, int element) {
        if (node == null) return null;
        if (element == node.valor) return node;
        if (element < node.valor)
            return buscaRec(node.esq, element);
        else
            return buscaRec(node.dir, element);
    }

    // MÉTODOS DE IMPRESSÃO (PERCURSOS)

    // Percurso em pré-ordem (raiz, esquerda, direita)
    public void preOrdem() {
        System.out.print("Pré-ordem: ");
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

    // Percurso em ordem (esquerda, raiz, direita) - ordenado
    public void emOrdem() {
        System.out.print("Em ordem: ");
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

    // Percurso em pós-ordem (esquerda, direita, raiz)
    public void posOrdem() {
        System.out.print("Pós-ordem: ");
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

    // Percurso em largura (BFS)
    public void imprimeLargura() {
        System.out.print("Em largura: ");
        if (this.raiz == null) return;
        
        Queue<Noh> fila = new LinkedList<>();
        fila.add(this.raiz);
        
        while (!fila.isEmpty()) {
            Noh atual = fila.poll();
            System.out.print(atual.valor + " ");
            
            if (atual.esq != null) fila.add(atual.esq);
            if (atual.dir != null) fila.add(atual.dir);
        }
        System.out.println();
    }

    // MÉTODO DE REMOÇÃO
    public boolean remove(int valor) {
        Noh nohParaRemover = buscaIter(valor);
        if (nohParaRemover == null) return false;
        
        return removeNoh(nohParaRemover);
    }

    private boolean removeNoh(Noh noh) {
        // Caso 1: Nó é folha (sem filhos)
        if (noh.esq == null && noh.dir == null) {
            if (noh.pai == null) { // é a raiz
                raiz = null;
            } else if (noh.pai.esq == noh) {
                noh.pai.esq = null;
            } else {
                noh.pai.dir = null;
            }
            return true;
        }
        
        // Caso 2: Nó tem apenas um filho
        if (noh.esq == null || noh.dir == null) {
            Noh filho = (noh.esq != null) ? noh.esq : noh.dir;
            
            if (noh.pai == null) { // é a raiz
                raiz = filho;
            } else if (noh.pai.esq == noh) {
                noh.pai.esq = filho;
            } else {
                noh.pai.dir = filho;
            }
            filho.pai = noh.pai;
            return true;
        }
        
        // Caso 3: Nó tem dois filhos
        Noh sucessor = encontrarSucessor(noh.dir);
        noh.valor = sucessor.valor;
        return removeNoh(sucessor);
    }

    private Noh encontrarSucessor(Noh noh) {
        Noh atual = noh;
        while (atual.esq != null) {
            atual = atual.esq;
        }
        return atual;
    }
}
