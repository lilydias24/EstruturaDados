package Ex01;
public class Main {
    public static void main(String[] args) {
        PontoCartesiano p1 = new PontoCartesiano(2, 3);
        PontoCartesiano p2 = new PontoCartesiano(5, 7);

        System.out.println("Ponto 1: " + p1);
        System.out.println("Ponto 2: " + p2);
        System.out.println("Distância entre os pontos: " + p1.distanciaEuclidiana(p2));

        // Testando os setters
        p1.setX(1);
        p1.setY(1);
        System.out.println("Novo Ponto 1: " + p1);
        System.out.println("Nova Distância: " + p1.distanciaEuclidiana(p2));
    }
}
