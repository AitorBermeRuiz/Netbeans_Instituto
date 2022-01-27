package serializables;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EjMenu {
   static Scanner poTeclado = new Scanner(System.in);
   static cAlumnos alumno;
   static int contado = 0;
    public static void main(String[] args) {
        boolean continuar = true;
        while (continuar) {        
            
            System.out.println("\t----MENU----\n1: Dar de alta un nuevo usuario\n2: Buscar un usuario por DNI\n3: Mostrar Todos\n4: Eliminar un usuario\n5: Salir");
            int opcion = poTeclado.nextInt();poTeclado.nextLine();
            
            switch(opcion){
                case 1: darDeAlta();     break;
                case 2: darDeAlta();     break;
                case 3: mostrarTodos();     break;
                case 4: darDeAlta();     break;
                case 5: continuar=false; break;
            }
        }
    }
    
    private static void darDeAlta(){
        try {
             ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Usuarios.dat"));

            if(contado==0){
                ++contado;

                    System.out.println("Dni");
                    String dni = poTeclado.nextLine();
                    
                    System.out.println("Nombre");
                    String nombre = poTeclado.nextLine();
                    System.out.println("Edad");
                    int edad =poTeclado.nextInt(); poTeclado.nextLine();

                    alumno = new cAlumnos(dni, nombre, edad);

                    oos.writeObject(alumno);
                    oos.close();
            }else{
                System.out.println("Segunda opcion");
                File f = new File("Usuarios.dat");
                File fAux = new File("Aux.dat");
                
                ObjectOutputStream oosAux = new ObjectOutputStream(new FileOutputStream(fAux));
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
                try {
                    while (true) {                    
                        alumno = (cAlumnos) ois.readObject();
                        oosAux.writeObject(alumno);
                    }
                } catch (EOFException EOFe) {
                }
                
                System.out.println("Dni");
                String dni = poTeclado.nextLine();
                System.out.println("Nombre");
                String nombre = poTeclado.nextLine();
                System.out.println("Edad");
                int edad = poTeclado.nextInt();poTeclado.nextLine();

                alumno = new cAlumnos(dni, nombre, edad);
                oosAux.writeObject(alumno);
                
                oosAux.close();ois.close();oos.close();
                f.delete();
                fAux.renameTo(f);
            }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(EjMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(EjMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
    
    
    private static void buscarUsuario(){
        
    }
    
    private static void mostrarTodos(){
       try {
           try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Usuarios.dat"))) {
               try {
                   while (true) {
                       alumno = (cAlumnos)ois.readObject();
                       System.out.println(alumno.toString());
                   }
               } catch (EOFException eofe) {
               } catch (ClassNotFoundException ex) {
                   Logger.getLogger(EjMenu.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
       } catch (IOException ex) {
           Logger.getLogger(EjMenu.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
}
