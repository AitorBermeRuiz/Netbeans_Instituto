package aciertos;

public class CHilos implements Runnable{
    int numTiradas;
    CDatos datos;
    public CHilos(int numTiradas, CDatos datos) {
        this.numTiradas = numTiradas;
        this.datos = datos;
    }
    @Override
    public void run() {
        for (int i =0;i<numTiradas;++i){
        double puntoX = Math.random();
        double puntoY = Math.random();    
        if((Math.sqrt(Math.pow(puntoX-0.5,2) + Math.pow(puntoY-0.5,2)))<=0.5)
            datos.setNumAciertos(1);
            
        
        }
    }
    
}
