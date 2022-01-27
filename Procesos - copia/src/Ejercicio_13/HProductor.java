package Ejercicio_13;

public class HProductor implements Runnable{
    CDatos datos;

    public HProductor(CDatos datos) {
        this.datos = datos;
    }


    @Override
    public void run() {
        
        String fraseCompleta = "Hola buenas tardes, me gustan las fresas y las ciruelas $$-/FIN/-$$";
        String[] palabras = fraseCompleta.split(" ");
        for (int i =0;i<fraseCompleta.length();++i){
            System.out.println("Productor guarda: "+palabras[i]);
            datos.Productor(palabras[i]);
        }
    }// run
}// HProductor
