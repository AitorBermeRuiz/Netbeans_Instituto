/*Crea una aplicación que almacene los datos básicos de un vehículo matricula(String), marca
     (String), tamaño de deposito (double) y modelo (String), en un fichero binario. Los datos se
     pediran por teclado. Una vez creado el fichero mostrar por pantalla todos los datos de cada
     coche.*/

package ficheros_binarios;

import java.io.*;
public class CEjercicio02 {
    public static void main(String[] args) {
        try {
            crearFichero();
        } catch (Exception e) {
        }
    }// main()
    private static void crearFichero() throws FileNotFoundException{
        
        DataOutputStream dos= new DataOutputStream(new FileOutputStream("Matriculas.dat"));
        
    }// crearFichero()
}// CEjercicio02
