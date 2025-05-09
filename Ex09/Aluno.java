package Ex09;

public class Aluno {
    private String nome;
    private int matricula;

    public Aluno(String nome, int matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Aluno{" + "nome='" + nome + '\'' + ", matricula=" + matricula + '}';
    }
}

