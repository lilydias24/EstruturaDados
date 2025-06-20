import java.util.Arrays;

public class VetorOrdenado<C extends Comparable<C>, V> implements Mapa<C, V> {
    private static class NoMapa<C, V> {
        C chave;
        V valor;

        NoMapa(C chave, V valor) {
            this.chave = chave;
            this.valor = valor;
        }
    }

    private NoMapa<C, V>[] elementos;
    private int tamanhoAtual;
    private static final int CAPACIDADE_INICIAL = 100000;

    public VetorOrdenado() {
        elementos = new NoMapa[CAPACIDADE_INICIAL];
        tamanhoAtual = 0;
    }

    @Override
    public boolean contemChave(C chave) {
        return buscarIndice(chave) != -1;
    }

    @Override
    public V obterValor(C chave) {
        int index = buscarIndice(chave);
        if (index != -1) {
            return elementos[index].valor;
        }
        return null;
    }

    @Override
    public void incluir(C chave, V valor) {
        if (tamanhoAtual == elementos.length) {
            elementos = Arrays.copyOf(elementos, elementos.length * 2);
        }

        int i = tamanhoAtual - 1;
        while (i >= 0 && elementos[i].chave.compareTo(chave) > 0) {
            elementos[i + 1] = elementos[i];
            i--;
        }
        elementos[i + 1] = new NoMapa<>(chave, valor);
        tamanhoAtual++;
    }

    private int buscarIndice(C chave) {
        int low = 0;
        int high = tamanhoAtual - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = elementos[mid].chave.compareTo(chave);

            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    @Override
    public int tamanho() {
        return tamanhoAtual;
    }

    @Override
    public void imprimir() {
        for (int i = 0; i < tamanhoAtual; i++) {
            System.out.println(elementos[i].valor);
        }
    }

    public int contarSamsung() {
        int count = 0;
        for (int i = 0; i < tamanhoAtual; i++) {
            if (((Celular) elementos[i].valor).isMarcaSamsung()) {
                count++;
            }
        }
        return count;
    }

    public void removerIMEIInferiorOuIgual(int imeiLimite) {
        int newSize = 0;
        for (int i = 0; i < tamanhoAtual; i++) {
            if (((Celular) elementos[i].valor).getIMEI() > imeiLimite) {
                elementos[newSize++] = elementos[i];
            }
        }
        for (int i = newSize; i < tamanhoAtual; i++) {
            elementos[i] = null;
        }
        tamanhoAtual = newSize;
    }
}