package ficheros_binarios;

import java.io.*;
import java.util.Scanner;

public class CEjRepaso {
    static Scanner poTeclado = new Scanner(System.in);
    
    public static void main(String[] args) {
        try {
            Ej1();
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado"+e);
        }catch (IOException IOe){
            System.out.println(IOe.getMessage());
        }
    }// main
    
    private static void Ej1()throws FileNotFoundException, IOException{//throws se desentiende, envia la excepcion a otro.
        /*
        Crea una aplicación que pida por teclado la cantidad de números aleatorios enteros positivos que
        se van a guardar en un fichero binario. 
        El rango de los números aleatorios estará entre 0 y 100, incluyendo el 100.
        Cada vez que se ejecute la aplicación se añadiran números al fichero sin borrar los anteriores. 
        Mostrar en pantalla el fichero creado.
        */
        
        File f1 = new File("Ej1Binarios.dat");
        //FileOutputStream fos1 = new FileOutputStream(f1);
        //DataOutputStream dos1 = new DataOutputStream();
        DataOutputStream dos1 = new DataOutputStream(new FileOutputStream(f1));
        DataInputStream dis1 = new DataInputStream(new FileInputStream(f1));
        
        int wiCantNum, wiNumAleatorio,wiNumLeer;
        System.out.println("Dime la cantidad de numeros aleatorios que quieres generar: ");
        
        for(wiCantNum= poTeclado.nextInt();wiCantNum>0;--wiCantNum){
            wiNumAleatorio =(int) Math.floor( Math.random()*101);
            dos1.writeInt(wiNumAleatorio);
        }
        try {
           while (true) {            
            wiNumLeer = dis1.readInt();
            System.out.println(wiNumLeer+", ");
        } 
        } catch (IOException be) {be.getMessage();
        }
        
    }
}// CEjRepaso
