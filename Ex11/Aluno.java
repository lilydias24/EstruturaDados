package Ex11;

public class Aluno {
    private String nome;
    private int matricula;
    
    public Aluno(String nome, int matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }
    
    @Override
    public String toString() {
        return nome + " (" + matricula + ")";
    }
    
    // Getters e Setters (opcional)
    public String getNome() { return nome; }
    public int getMatricula() { return matricula; }
}
