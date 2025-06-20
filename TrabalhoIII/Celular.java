import java.util.Random;

public class Celular implements Comparable<Celular>{
    private int IMEI;
    private String marca;

    private static int numCelulares = 0;
    private static Random geradorIMEI = new Random();
    private static Random geradorMarca = new Random();

    public Celular(){
        geraIMEI();
        geraMarca();
    }

    private void geraIMEI(){
        if(this.numCelulares % 2 == 0)
            this.IMEI = 802050000 - geradorIMEI.nextInt(50000);
        else
            this.IMEI = 802050000 + geradorIMEI.nextInt(50000);
        this.numCelulares++;
    }

    private void geraMarca(){
        int c = geradorMarca.nextInt(6);
        switch(c){
            case 0: this.marca = "Apple"; break;
            case 1: this.marca = "Samsung"; break;
            case 2: this.marca = "Xiaomi"; break;
            case 3: this.marca = "Motorola"; break;
            case 4: this.marca = "Oppo"; break;
            case 5: this.marca = "Huawei"; break;
            default: new Exception("ERRO NA GERAÇÃO DA MARCA");
        }
    }

    public String getMarca() {
        return this.marca;
    }
    public int getIMEI() {
        return this.IMEI;
    }

    public boolean isMarcaSamsung(){
        return (this.marca.equalsIgnoreCase("Samsung"));
    }

    @Override
    public int compareTo(Celular cel) {
        if (this.IMEI > cel.getIMEI()) return 1;
        else if (this.IMEI < cel.getIMEI()) return -1;
        else return 0;
    }

    @Override
    public String toString(){
        return "Celular IMEI: "+ this.IMEI + " marca: "+ this.marca;
    }

}
