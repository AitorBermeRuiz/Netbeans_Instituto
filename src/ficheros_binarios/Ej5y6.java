package ficheros_binarios;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*5º.Hacer un programa que cree un fichero binario que contendrá el nombre, apellidos, edad, número
 de teléfono, dirección de email, ciudad de residencia, nacionalidad y profesión de una persona.
6º.Tomando como base el fichero creado en el ejercicio anterior, hacer un programa que lea los datos de
 las personas y los copie en otros ficheros distintos según se traten de menores de edad, adultos o mayores
 de 65 años. Escribir en pantalla los 3 nuevos ficheros creados.*/
public class Ej5y6 {
    static Scanner poTeclado = new Scanner(System.in);
    public static void main(String[] args) {
        crearFichero();
        leerFichero();
    }
    private static void crearFichero(){
        try {
            DataOutputStream dos= new DataOutputStream(new FileOutputStream("PersonasPorEdad.dat"));
            
            System.out.println("Nombre, esc para salir");String nombre = poTeclado.nextLine();
            while (!nombre.equals("esc")) {                
                dos.writeUTF(nombre);
                System.out.println("Edad:");dos.writeInt(poTeclado.nextInt());poTeclado.nextLine();
                System.out.println("Email:");dos.writeUTF(poTeclado.nextLine());
                System.out.println("Nombre:");nombre = poTeclado.nextLine();
            }
            dos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ej5y6.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ej5y6.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static void leerFichero(){
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream("PersonasPorEdad.dat"));
            
            while (true) {                
                System.out.println("Nombre: "+dis.readUTF()+", Edad: "+dis.readInt()+", Email: "+dis.readUTF());
            }
        }catch (EOFException EOFe){System.out.println("FINAL DEL FICHERO"+ EOFe.getMessage());}
        catch (FileNotFoundException ex) {
            Logger.getLogger(Ej5y6.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ej5y6.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
