public class Main {
    public static void main(String[] args) {
        // Criar mapa com capacidade inicial 10 (será ajustado para o próximo primo)
        MapaHashVetor mapa = new MapaHashVetor(10);
        
        // Inserir alunos
        mapa.put(736435217, new Aluno(736435217, "Bart"));
        mapa.put(879995247, new Aluno(879995247, "Homer"));
        mapa.put(524109227, new Aluno(524109227, "Lisa"));
        mapa.put(996411117, new Aluno(996411117, "Meggie"));
        
        // Imprimir o estado do mapa
        System.out.println("Estado do mapa após inserções:");
        mapa.imprimir();
        
        // Buscar um aluno
        Aluno aluno = mapa.get(524109227);
        System.out.println("\nAluno encontrado: " + aluno);
        
        // Remover um aluno
        Aluno removido = mapa.remove(879995247);
        System.out.println("\nAluno removido: " + removido);
        
        // Imprimir o estado após remoção
        System.out.println("\nEstado do mapa após remoção:");
        mapa.imprimir();
    }
}
