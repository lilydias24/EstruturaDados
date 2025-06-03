package TrabalhoI.src.estrutura;
public class Noh<T> {

    private T info;
    private Noh<T> ant;
    private Noh<T> prox;

    public Noh(T info) {
        this.info = info;
        this.ant = null;
        this.prox = null;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Noh<T> getAnt() {
        return ant;
    }

    public void setAnt(Noh<T> ant) {
        this.ant = ant;
    }

    public Noh<T> getProx() {
        return prox;
    }

    public void setProx(Noh<T> prox) {
        this.prox = prox;
    }
}
