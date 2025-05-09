package Ex05;

public class LDE {
    private NoDuplo inicio;
    private NoDuplo fim;

    public LDE() {
        this.inicio = null;
        this.fim = null;
    }

    public void inserirFim(Object obj) {
        NoDuplo novo = new NoDuplo(obj);
        if (inicio == null) {
            inicio = fim = novo;
        } else {
            fim.proximo = novo;
            novo.anterior = fim;
            fim = novo;
        }
    }

    private NoDuplo buscarPorMatricula(int matricula) {
        NoDuplo atual = inicio;
        while (atual != null) {
            if (atual.info instanceof Aluno) {
                Aluno a = (Aluno) atual.info;
                if (a.getMatricula() == matricula) {
                    return atual;
                }
            }
            atual = atual.proximo;
        }
        return null;
    }
    
    public boolean remover(int matricula) {
        NoDuplo alvo = buscarPorMatricula(matricula);
        if (alvo == null) return false;

        if (alvo == inicio && alvo == fim) {
            inicio = fim = null;
        } else if (alvo == inicio) {
            inicio = alvo.proximo;
            inicio.anterior = null;
        } else if (alvo == fim) {
            fim = alvo.anterior;
            fim.proximo = null;
        } else {
            alvo.anterior.proximo = alvo.proximo;
            alvo.proximo.anterior = alvo.anterior;
        }
        return true;
    }

    public void imprimirInicioFim() {
        System.out.println("Início → Fim:");
        NoDuplo atual = inicio;
        while (atual != null) {
            System.out.println(atual.info);
            atual = atual.proximo;
        }
    }

    public void imprimirFimInicio() {
        System.out.println("Fim → Início:");
        NoDuplo atual = fim;
        while (atual != null) {
            System.out.println(atual.info);
            atual = atual.anterior;
        }
    }
}
