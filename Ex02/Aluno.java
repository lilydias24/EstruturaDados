class Aluno {
    private double nota;
    private String nome;
    private int idade;

    public Aluno(double nota, String nome, int idade) {
        this.nota = nota;
        this.nome = nome;
        this.idade = idade;
    }

    public double getNota() { return nota; }
    public String getNome() { return nome; }
    public int getIdade() { return idade; }

    public void setNota(double nota) { this.nota = nota; }
    public void setNome(String nome) { this.nome = nome; }
    public void setIdade(int idade) { this.idade = idade; }
}
