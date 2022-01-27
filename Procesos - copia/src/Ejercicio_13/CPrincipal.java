package Ejercicio_13;

public class CPrincipal {
    public static void main(String[] args) {
        CDatos datos = new CDatos();
    
        Thread Productor = new Thread(new HProductor(datos));
        Thread Consumidor = new Thread(new HConsumidor(datos));
        Productor.start();
        Consumidor.start();
        
        try {
            Productor.join();
            Consumidor.join();
        } catch (InterruptedException e) { e.printStackTrace();}
        
    }// main    
}// CPrincipal
