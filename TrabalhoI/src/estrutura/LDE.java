package TrabalhoI.src.estrutura;
public class LDE<T> {

    private Noh<T> inicio;
    private Noh<T> fim;
    private int tamanho;

    public LDE() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public Noh<T> getInicio() {
        return inicio;
    }

    public Noh<T> getFim() {
        return fim;
    }

    public boolean estahVazia() {
        return inicio == null;
    }

    public int tamanho() {
        return tamanho;
    }

    public void insereInicio(T info) {
        Noh<T> novo = new Noh<>(info);

        if (inicio == null) {
            inicio = novo;
            fim = novo;
        } else {
            novo.setProx(inicio);
            inicio.setAnt(novo);
            inicio = novo;
        }

        tamanho++;
    }

    public void insereFim(T info) {
        Noh<T> novo = new Noh<>(info);

        if (fim == null) {
            inicio = novo;
            fim = novo;
        } else {
            novo.setAnt(fim);
            fim.setProx(novo);
            fim = novo;
        }

        tamanho++;
    }

    public boolean remove(T info) {
        Noh<T> p = inicio;

        while (p != null && !p.getInfo().equals(info)) {
            p = p.getProx();
        }

        if (p == null) {
            return false;
        }

        if (p == inicio) {
            inicio = p.getProx();
            if (inicio != null) {
                inicio.setAnt(null);
            } else {
                fim = null;
            }
        } else if (p.getProx() == null) {
            p.getAnt().setProx(null);
            fim = p.getAnt();
        } else {
            p.getAnt().setProx(p.getProx());
            p.getProx().setAnt(p.getAnt());
        }

        tamanho--;
        return true;
    }

    public void imprimeInicioFim() {
        Noh<T> p = inicio;
        while (p != null) {
            System.out.println(p.getInfo());
            p = p.getProx();
        }
    }

    public void imprimeFimInicio() {
        Noh<T> p = fim;
        while (p != null) {
            System.out.println(p.getInfo());
            p = p.getAnt();
        }
    }

    public Noh<T> buscar(T info) {
        Noh<T> p = inicio;
        while (p != null) {
            if (p.getInfo().equals(info)) {
                return p;
            }
            p = p.getProx();
        }
        return null;
    }
    
    public Noh<T> buscarPersonalizado(T info, java.util.function.BiPredicate<T, T> comparador) {
        Noh<T> p = inicio;
        while (p != null) {
            if (comparador.test(p.getInfo(), info)) {
                return p;
            }
            p = p.getProx();
        }
        return null;
    }
}
