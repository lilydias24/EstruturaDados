public class Main {

    private static final int NUM_CELULARES = 100;
    private static final int IMEI_LIMITE_REMOCAO = 802050000;

    public static void main(String[] args) {
        System.out.println("--- Testando Vetor Ordenado ---");
        testarMapa(new VetorOrdenado<>());

        System.out.println("\n--- Testando Lista Duplamente Encadeada Ordenada ---");
        testarMapa(new LDEOrdenada<>());

        System.out.println("\n--- Testando Árvore Binária de Busca ---");
        testarMapa(new ABB<>());
    }

    private static void testarMapa(Mapa<Integer, Celular> mapa) {
        long startTime, endTime;

        // 1. Inserir 100.000 celulares diretamente
        startTime = System.nanoTime();
        for (int i = 0; i < NUM_CELULARES; i++) {
            Celular celular = new Celular();
            mapa.incluir(celular.getIMEI(), celular);
        }
        endTime = System.nanoTime();
        System.out.println("Tempo de inserção de " + NUM_CELULARES + " celulares: " + (endTime - startTime) / 1_000_000.0 + " ms");

        // 2. Apresentar todos os celulares em ordem crescente de número IMEI
        System.out.println("\n--- Impressão em ordem crescente de IMEI ---");
        startTime = System.nanoTime();
        mapa.imprimir();
        endTime = System.nanoTime();
        System.out.println("Tempo de impressão de todos os celulares: " + (endTime - startTime) / 1_000_000.0 + " ms");
        System.out.println("Tamanho atual do mapa: " + mapa.tamanho());

        // 3. Verificar quantos celulares são da marca Samsung
        System.out.println("\n--- Contagem de celulares Samsung ---");
        startTime = System.nanoTime();
        int samsungCount = 0;
        if (mapa instanceof VetorOrdenado) {
            samsungCount = ((VetorOrdenado<Integer, Celular>) mapa).contarSamsung();
        } else if (mapa instanceof LDEOrdenada) {
            samsungCount = ((LDEOrdenada<Integer, Celular>) mapa).contarSamsung();
        } else if (mapa instanceof ABB) {
            samsungCount = ((ABB<Integer, Celular>) mapa).contarSamsung();
        }
        endTime = System.nanoTime();
        System.out.println("Número de celulares Samsung: " + samsungCount);
        System.out.println("Tempo para verificar celulares Samsung: " + (endTime - startTime) / 1_000_000.0 + " ms");

        // 4. Remover todos os celulares com número IMEI igual ou inferior à 802050000
        System.out.println("\n--- Remoção de celulares com IMEI <= " + IMEI_LIMITE_REMOCAO + " ---");
        startTime = System.nanoTime();
        if (mapa instanceof VetorOrdenado) {
            ((VetorOrdenado<Integer, Celular>) mapa).removerIMEIInferiorOuIgual(IMEI_LIMITE_REMOCAO);
        } else if (mapa instanceof LDEOrdenada) {
            ((LDEOrdenada<Integer, Celular>) mapa).removerIMEIInferiorOuIgual(IMEI_LIMITE_REMOCAO);
        } else if (mapa instanceof ABB) {
            ((ABB<Integer, Celular>) mapa).removerIMEIInferiorOuIgual(IMEI_LIMITE_REMOCAO);
        }
        endTime = System.nanoTime();
        System.out.println("Tempo para remover celulares com IMEI <= " + IMEI_LIMITE_REMOCAO + ": " + (endTime - startTime) / 1_000_000.0 + " ms");
        System.out.println("Novo tamanho do mapa: " + mapa.tamanho());

        // Re-imprimir após remoção para verificar
        System.out.println("\n--- Impressão após remoção ---");
        mapa.imprimir();
    }
}