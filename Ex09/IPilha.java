package Ex09;

public interface IPilha {
    boolean push(Object info);
    Object pop();
    Object top();
    boolean isEmpty();
    int size();
}
