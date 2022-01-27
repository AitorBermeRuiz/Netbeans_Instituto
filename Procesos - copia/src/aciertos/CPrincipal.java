package aciertos;

public class CPrincipal {
    public static void main(String[] args) {
        int numDeHilos = 5,numTiradasPorHilo = 5000;
        int tiradasTotales =(numTiradasPorHilo*numDeHilos);

        CDatos datos = new CDatos();
        CHilos hilos = new CHilos(numTiradasPorHilo,datos);
        Thread[] t = new Thread[numDeHilos];

        for (int i = 0;i<numDeHilos;++i){
            t[i] = new Thread(hilos);
            t[i].start();
        }
        
        for (int i = 0;i<numDeHilos;++i){
            try {
                t[i].join();
            } catch (InterruptedException ex) {}
        }
        datos.setTiradasTotales(tiradasTotales);
        double pi = datos.getPi();
        System.out.println(pi);
        System.out.println(datos.getNumAciertos());
    }// main   
}// CPrincipal 
