package pqtFileBinarios;
import java.io.*;
import java.util.Scanner;
import static pqt_$.$.$;
import static pqt_$.$.$$;
/*1º. Crea una aplicación que pida por teclado la cantidad de números aleatorios enteros positivos que
      se van a guardar en un fichero binario.
      El rango de los números aleatorios estará entre 0 y 100, incluyendo el 100.
      Cada vez que se ejecute la aplicación se añadiran números al fichero sin borrar los anteriores.
      Mostrar en pantalla el fichero creado.*/

public class CFile07BinarioEjercicios {
    static Scanner poTeclado = new Scanner(System.in);
    
    public static void main(String[] args) throws FileNotFoundException, IOException{
        mvCrearNumeros();
        mvMostrarNumeros();
    }
    
    static void mvCrearNumeros() throws FileNotFoundException, IOException{ 
        File             fVj = new File("numerosAleatorios.dat");
        FileOutputStream fos = new FileOutputStream(fVj, true);
        DataOutputStream dos = new DataOutputStream(fos);
        
        $("Cantidad de números aleatorios a introducir: ");
        int wiCantNum = poTeclado.nextInt();poTeclado.nextLine();
        $$("");
        
        while (wiCantNum != 0){
            int wi = (int) Math.floor(Math.random()*101); // valores de 0 a 100, excluyendo el 101
            dos.writeInt(wi);
            ///$$(""+wi);
            wiCantNum--;
        }
    }// mvCrearNumeros()
    
    static void mvMostrarNumeros() throws FileNotFoundException{ 
        File            fVj = new File("numerosAleatorios.dat");
        FileInputStream fis = new FileInputStream(fVj);
        DataInputStream dis = new DataInputStream(fis);
        
        try {
            int wiContador = 0;
            while (true){
                wiContador++;
                int wiNum = dis.readInt();
                $(""+wiNum+", ");
                if (wiContador % 10 == 0){$$("");} // lo hace todo más visible
            }
        } catch (IOException e) {e.getMessage();}
        
        
    }// mvMostrarNumeros()

}// CFile07BinarioEjercicios