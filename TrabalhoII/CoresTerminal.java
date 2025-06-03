package TrabalhoII;

public class CoresTerminal {
    // Códigos ANSI para cores
    public static final String RESET = "\033[0m";
    public static final String NEGRITO = "\033[1m";
    public static final String ITALICO = "\033[3m";
    
    // Cores de texto
    public static final String PRETO = "\033[30m";
    public static final String VERMELHO = "\033[31m";
    public static final String VERDE = "\033[32m";
    public static final String AMARELO = "\033[33m";
    public static final String AZUL = "\033[34m";
    public static final String MAGENTA = "\033[35m";
    public static final String CIANO = "\033[36m";
    public static final String BRANCO = "\033[37m";
    
    // Cores de fundo
    public static final String FUNDO_PRETO = "\033[40m";
    public static final String FUNDO_VERMELHO = "\033[41m";
    public static final String FUNDO_VERDE = "\033[42m";
    public static final String FUNDO_AMARELO = "\033[43m";
    public static final String FUNDO_AZUL = "\033[44m";
    public static final String FUNDO_MAGENTA = "\033[45m";
    public static final String FUNDO_CIANO = "\033[46m";
    public static final String FUNDO_BRANCO = "\033[47m";
    
    // Combinações úteis
    public static String titulo(String texto) {
        return NEGRITO + AZUL + texto + RESET;
    }
    
    public static String sucesso(String texto) {
        return NEGRITO + VERDE + texto + RESET;
    }
    
    public static String alerta(String texto) {
        return NEGRITO + AMARELO + texto + RESET;
    }
    
    public static String erro(String texto) {
        return NEGRITO + VERMELHO + texto + RESET;
    }
    
    public static String dado(String texto) {
        return NEGRITO + CIANO + texto + RESET;
    }

    private static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static String repeatChar(char c, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static String borda(String texto) {
        String linha = repeatChar('═', texto.length() + 2);
        return MAGENTA + 
               "╔" + linha + "╗\n" +
               "║ " + texto + " ║\n" +
               "╚" + linha + "╝" + 
               RESET;
    }
    
    public static void mostrarPaleta() {
        System.out.println("Cores disponíveis:");
        System.out.println(PRETO + "Preto" + RESET);
        System.out.println(VERMELHO + "Vermelho" + RESET);
        System.out.println(VERDE + "Verde" + RESET);
        System.out.println(AMARELO + "Amarelo" + RESET);
        System.out.println(AZUL + "Azul" + RESET);
        System.out.println(MAGENTA + "Magenta" + RESET);
        System.out.println(CIANO + "Ciano" + RESET);
        System.out.println(BRANCO + "Branco" + RESET);
        
        System.out.println("\nEstilos:");
        System.out.println(NEGRITO + "Negrito" + RESET);
        System.out.println(ITALICO + "Itálico" + RESET);
    }
}