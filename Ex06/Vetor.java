package Ex06;
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

    public int encontrarMaiorIterativo() {
        int maior = elementos[0];
        for (int i = 1; i < elementos.length; i++) {
            if (elementos[i] > maior) {
                maior = elementos[i];
            }
        }
        return maior;
    }

    public int encontrarMaiorRecursivo() {
        return encontrarMaiorRecursivo(0, elementos.length - 1);
    }

    private int encontrarMaiorRecursivo(int inicio, int fim) {
        if (inicio == fim) {
            return elementos[inicio];
        } else {
            int meio = (inicio + fim) / 2;
            int maxEsquerda = encontrarMaiorRecursivo(inicio, meio);
            int maxDireita = encontrarMaiorRecursivo(meio + 1, fim);
            return Math.max(maxEsquerda, maxDireita);
        }
    }

    public static void main(String[] args) {
        Vetor vetor = new Vetor(1000);
        vetor.preencherComAleatorios();

        // Medindo tempo da versão iterativa
        long inicioIter = System.nanoTime();
        int maiorIter = vetor.encontrarMaiorIterativo();
        long fimIter = System.nanoTime();
        System.out.println("Maior (Iterativo): " + maiorIter + " | Tempo: " + (fimIter - inicioIter) + " ns");

        // Medindo tempo da versão recursiva
        long inicioRec = System.nanoTime();
        int maiorRec = vetor.encontrarMaiorRecursivo();
        long fimRec = System.nanoTime();
        System.out.println("Maior (Recursivo): " + maiorRec + " | Tempo: " + (fimRec - inicioRec) + " ns");
    }
}
