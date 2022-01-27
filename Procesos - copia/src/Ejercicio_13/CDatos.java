package Ejercicio_13;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CDatos {
    private String palabra = "",palabraClave = "as",palabrasConPalabraClave;
    private Boolean continuarP =true,continuarC = false;
    public synchronized void Productor(String palabra){
        while (!continuarP) {            
            try {
                System.out.println("Productor esta esperando a CONSUMIDOR");
                wait();
            } catch (InterruptedException ex) {ex.printStackTrace();}
        }
        this.palabra = palabra;
        continuarP=false;
        continuarC=true;
        notifyAll();
    }
    
    public synchronized String Consumidor(){
        while (!continuarC||palabra.equals("")) {            
            try {
                System.out.println("Consumidor esta esperando a PRODUCTOR");
                wait();
            } catch (InterruptedException ex) {ex.printStackTrace();}
        }
        continuarC=false;
        continuarP=true;
        notifyAll();
        return palabra;        
    }
    public String getPalabraClave() {
        return palabraClave;
    }

    public String getPalabrasConPalabraClave() {
        return palabrasConPalabraClave;
    }

    public void setPalabrasConPalabraClave(String palabrasConPalabraClave) {
        this.palabrasConPalabraClave = palabrasConPalabraClave;
    }
    
    
}
