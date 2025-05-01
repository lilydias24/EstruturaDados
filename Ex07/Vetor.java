package Ex07;

public class Vetor {
    private int[] elementos;
    private int tamanho;

    public Vetor(int capacidade) {
        elementos = new int[capacidade];
        tamanho = 0;
    }

    public void adicionar(int elemento) {
        if (tamanho < elementos.length) {
            elementos[tamanho++] = elemento;
        }
    }

    public int buscaBinariaIterativa(int valor) {
        int inicio = 0;
        int fim = tamanho - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            if (elementos[meio] == valor) return meio;
            else if (elementos[meio] > valor) fim = meio - 1;
            else inicio = meio + 1;
        }
        return -1;
    }

    public int buscaBinariaRecursiva(int valor) {
        return buscaBinariaRecursiva(valor, 0, tamanho - 1);
    }

    private int buscaBinariaRecursiva(int valor, int inicio, int fim) {
        if (inicio > fim) return -1;
        int meio = (inicio + fim) / 2;
        if (elementos[meio] == valor) return meio;
        else if (elementos[meio] > valor)
            return buscaBinariaRecursiva(valor, inicio, meio - 1);
        else
            return buscaBinariaRecursiva(valor, meio + 1, fim);
    }

    public static void main(String[] args) {
        Vetor vetor = new Vetor(1000);
        for (int i = 1; i <= 1000; i++) {
            vetor.adicionar(i);
        }

        int valorBuscado = 1000;

        long inicioIter = System.nanoTime();
        int resultadoIter = vetor.buscaBinariaIterativa(valorBuscado);
        long fimIter = System.nanoTime();

        long inicioRec = System.nanoTime();
        int resultadoRec = vetor.buscaBinariaRecursiva(valorBuscado);
        long fimRec = System.nanoTime();

        System.out.println("Busca Binária Iterativa encontrou a posição: " + resultadoIter +
                " em " + (fimIter - inicioIter) + " ns");

        System.out.println("Busca Binária Recursiva encontrou a posição: " + resultadoRec +
                " em " + (fimRec - inicioRec) + " ns");
    }
}

