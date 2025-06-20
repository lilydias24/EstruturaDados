public class ABB<C extends Comparable<C>, V> implements Mapa<C, V> {
    private static class NoMapa<C, V> {
        C chave;
        V valor;
        NoMapa<C, V> esquerda;
        NoMapa<C, V> direita;

        NoMapa(C chave, V valor) {
            this.chave = chave;
            this.valor = valor;
            this.esquerda = null;
            this.direita = null;
        }
    }

    private NoMapa<C, V> raiz;
    private int tamanhoAtual;

    public ABB() {
        raiz = null;
        tamanhoAtual = 0;
    }

    @Override
    public boolean contemChave(C chave) {
        return obterValor(chave) != null;
    }

    @Override
    public V obterValor(C chave) {
        return obterValorRecursivo(raiz, chave);
    }

    private V obterValorRecursivo(NoMapa<C, V> no, C chave) {
        if (no == null) {
            return null;
        }
        int cmp = chave.compareTo(no.chave);
        if (cmp < 0) {
            return obterValorRecursivo(no.esquerda, chave);
        } else if (cmp > 0) {
            return obterValorRecursivo(no.direita, chave);
        } else {
            return no.valor;
        }
    }

    @Override
    public void incluir(C chave, V valor) {
        raiz = incluirRecursivo(raiz, chave, valor);
    }

    private NoMapa<C, V> incluirRecursivo(NoMapa<C, V> no, C chave, V valor) {
        if (no == null) {
            tamanhoAtual++;
            return new NoMapa<>(chave, valor);
        }
        int cmp = chave.compareTo(no.chave);
        if (cmp < 0) {
            no.esquerda = incluirRecursivo(no.esquerda, chave, valor);
        } else if (cmp > 0) {
            no.direita = incluirRecursivo(no.direita, chave, valor);
        } else {
            // Atualiza valor se a chave já existe
            no.valor = valor;
        }
        return no;
    }

    @Override
    public int tamanho() {
        return tamanhoAtual;
    }

    @Override
    public void imprimir() {
        imprimirEmOrdem(raiz);
    }

    private void imprimirEmOrdem(NoMapa<C, V> no) {
        if (no != null) {
            imprimirEmOrdem(no.esquerda);
            System.out.println(no.valor);
            imprimirEmOrdem(no.direita);
        }
    }

    public int contarSamsung() {
        return contarSamsungRecursivo(raiz);
    }

    private int contarSamsungRecursivo(NoMapa<C, V> no) {
        if (no == null) {
            return 0;
        }
        int count = 0;
        if (((Celular) no.valor).isMarcaSamsung()) {
            count++;
        }
        count += contarSamsungRecursivo(no.esquerda);
        count += contarSamsungRecursivo(no.direita);
        return count;
    }

    public void removerIMEIInferiorOuIgual(int imeiLimite) {
        raiz = removerIMEIInferiorOuIgualRecursivo(raiz, imeiLimite);
    }

    private NoMapa<C, V> removerIMEIInferiorOuIgualRecursivo(NoMapa<C, V> no, int imeiLimite) {
        if (no == null) {
            return null;
        }

        no.esquerda = removerIMEIInferiorOuIgualRecursivo(no.esquerda, imeiLimite);
        no.direita = removerIMEIInferiorOuIgualRecursivo(no.direita, imeiLimite);

        if (((Celular) no.valor).getIMEI() <= imeiLimite) {
            tamanhoAtual--;
            if (no.esquerda == null) {
                return no.direita;
            } else if (no.direita == null) {
                return no.esquerda;
            } else {
                NoMapa<C, V> temp = encontrarMenorValor(no.direita);
                no.chave = temp.chave;
                no.valor = temp.valor;
                no.direita = removerIMEIInferiorOuIgualRecursivo(no.direita, ((Celular)temp.valor).getIMEI());
            }
        }
        return no;
    }

    private NoMapa<C, V> encontrarMenorValor(NoMapa<C, V> no) {
        while (no.esquerda != null) {
            no = no.esquerda;
        }
        return no;
    }
}
