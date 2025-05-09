package Ex05;

public class NoDuplo {
    Object info;
    NoDuplo anterior;
    NoDuplo proximo;

    public NoDuplo(Object info) {
        this.info = info;
        this.anterior = null;
        this.proximo = null;
    }
}
