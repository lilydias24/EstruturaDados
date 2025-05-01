package Ex08;

import java.util.Random;

public class Vetor {
    private int[] elementos;

    public Vetor(int tamanho) {
        elementos = new int[tamanho];
    }

    public void preencherComAleatorios() {
        Random rand = new Random();
        for (int i = 0; i < elementos.length; i++) {
            elementos[i] = rand.nextInt(100000);
        }
    }

    public void bubbleSort() {
        int n = elementos.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (elementos[j] > elementos[j + 1]) {
                    int temp = elementos[j];
                    elementos[j] = elementos[j + 1];
                    elementos[j + 1] = temp;
                }
            }
        }
    }

    public static void testarOrdenacao(int tamanho) {
        Vetor v = new Vetor(tamanho);
        v.preencherComAleatorios();
        System.out.println("\nOrdenando vetor com " + tamanho + " elementos...");

        long inicio = System.currentTimeMillis();
        v.bubbleSort();
        long fim = System.currentTimeMillis();

        System.out.println("Tempo para ordenar com Bubble Sort: " + (fim - inicio) + " ms");
    }

    public static void main(String[] args) {
        testarOrdenacao(1000);
        testarOrdenacao(10000);
        testarOrdenacao(100000);
    }
}

