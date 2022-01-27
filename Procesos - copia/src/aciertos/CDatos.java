package aciertos;

public class CDatos {
    private int numAciertos = 0, tiradasTotales = 0;
    private double pi = 0;
    public int getNumAciertos(){
        return numAciertos;
    }
    public synchronized void setNumAciertos(int numAciertos){
        this.numAciertos += numAciertos;
    }
    public void setTiradasTotales(int tiradasTotales){
        this.tiradasTotales = tiradasTotales;
    }
    public double getPi(){
        pi= ((numAciertos*4)/tiradasTotales);
        return pi;
    }
}
