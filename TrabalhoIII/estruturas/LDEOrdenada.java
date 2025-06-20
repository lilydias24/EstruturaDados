public class LDEOrdenada<C extends Comparable<C>, V> implements Mapa<C, V> {
    private static class NoMapa<C, V> {
        C chave;
        V valor;
        NoMapa<C, V> proximo;
        NoMapa<C, V> anterior;

        NoMapa(C chave, V valor) {
            this.chave = chave;
            this.valor = valor;
            this.proximo = null;
            this.anterior = null;
        }
    }

    private NoMapa<C, V> cabeca;
    private int tamanhoAtual;

    public LDEOrdenada() {
        cabeca = null;
        tamanhoAtual = 0;
    }

    @Override
    public boolean contemChave(C chave) {
        return buscarNo(chave) != null;
    }

    @Override
    public V obterValor(C chave) {
        NoMapa<C, V> no = buscarNo(chave);
        return (no != null) ? no.valor : null;
    }

    @Override
    public void incluir(C chave, V valor) {
        NoMapa<C, V> noExistente = buscarNo(chave);
        if (noExistente != null) {
            noExistente.valor = valor;
            return;
        }

        NoMapa<C, V> novoNo = new NoMapa<>(chave, valor);

        if (cabeca == null || cabeca.chave.compareTo(chave) > 0) {
            novoNo.proximo = cabeca;
            if (cabeca != null) {
                cabeca.anterior = novoNo;
            }
            cabeca = novoNo;
        } else {
            NoMapa<C, V> atual = cabeca;
            while (atual.proximo != null && atual.proximo.chave.compareTo(chave) < 0) {
                atual = atual.proximo;
            }
            novoNo.proximo = atual.proximo;
            if (atual.proximo != null) {
                atual.proximo.anterior = novoNo;
            }
            atual.proximo = novoNo;
            novoNo.anterior = atual;
        }
        tamanhoAtual++;
    }

    private NoMapa<C, V> buscarNo(C chave) {
        NoMapa<C, V> atual = cabeca;
        while (atual != null && atual.chave.compareTo(chave) <= 0) {
            if (atual.chave.compareTo(chave) == 0) {
                return atual;
            }
            atual = atual.proximo;
        }
        return null;
    }

    @Override
    public int tamanho() {
        return tamanhoAtual;
    }

    @Override
    public void imprimir() {
        NoMapa<C, V> atual = cabeca;
        while (atual != null) {
            System.out.println(atual.valor);
            atual = atual.proximo;
        }
    }

    public int contarSamsung() {
        int count = 0;
        NoMapa<C, V> atual = cabeca;
        while (atual != null) {
            if (((Celular) atual.valor).isMarcaSamsung()) {
                count++;
            }
            atual = atual.proximo;
        }
        return count;
    }

    public void removerIMEIInferiorOuIgual(int imeiLimite) {
        NoMapa<C, V> atual = cabeca;
        while (atual != null) {
            NoMapa<C, V> proximo = atual.proximo; // Guarda o próximo antes de remover
            if (((Celular) atual.valor).getIMEI() <= imeiLimite) {
                if (atual.anterior != null) {
                    atual.anterior.proximo = atual.proximo;
                } else {
                    cabeca = atual.proximo;
                }
                if (atual.proximo != null) {
                    atual.proximo.anterior = atual.anterior;
                }
                tamanhoAtual--;
            }
            atual = proximo;
        }
    }
}