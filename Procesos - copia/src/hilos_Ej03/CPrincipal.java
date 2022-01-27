/*
 *Crear un programa en Java que utilice 5 hilos que representa el número de vocales totales. Para contar el
 *número de vocales que hay en un determinado texto (que puede ser introducido por teclado o estar en un
 *fichero). Cada hilo se encargará de contar una vocal diferente, actualizando todos los hilos una misma variable
 */

package hilos_Ej03;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class CPrincipal {
    public static void main(String[] args) {
        String vocales = "aeiou";
        CDatos datos = new CDatos();
        Scanner poTeclado = new Scanner(System.in);
        System.out.println("Dime la frase para contar las vocales: ");
        String texto = poTeclado.nextLine();
        
        Thread [] hilos = new Thread[vocales.length()];

        for (int i=0; i<vocales.length();++i){
            hilos[i] = new Thread(new CHilos(texto,vocales.charAt(i),datos));
            hilos[i].start();
        }
        
        for (int i=0;i<hilos.length;++i){
            try {
             hilos[i].join();
        } catch (InterruptedException ex) {
            Logger.getLogger(CPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(datos.getContador());
    }
}
