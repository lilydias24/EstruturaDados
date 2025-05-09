package Ex09;

public class PilhaLista implements IPilha {
    private No topo;
    private int tamanho;

    public PilhaLista() {
        this.topo = null;
        this.tamanho = 0;
    }

    @Override
    public boolean push(Object info) {
        No novo = new No(info);
        novo.setProximo(topo);
        topo = novo;
        tamanho++;
        return true;
    }

    @Override
    public Object pop() {
        if (isEmpty()) {
            System.out.println("Pilha vazia!");
            return null;
        }
        Object info = topo.getInfo();
        topo = topo.getProximo();
        tamanho--;
        return info;
    }

    @Override
    public Object top() {
        return isEmpty() ? null : topo.getInfo();
    }

    @Override
    public boolean isEmpty() {
        return topo == null;
    }

    @Override
    public int size() {
        return tamanho;
    }

    public void imprimir() {
        No atual = topo;
        System.out.println("Estado atual da pilha:");
        while (atual != null) {
            System.out.println(atual.getInfo());
            atual = atual.getProximo();
        }
    }
}

