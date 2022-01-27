/*
Enunciado del ejercicio: 

En una empresa se tiene un fichero binario “nominas.dat” que almacena en cada registro 
el nombre de cada empleado (String) con el número de días de baja (int) y su nómina (double). 
Hacer un programa que actualice las nóminas de forma que:
- a los que tengan 0 días de baja se le hace un aumento del 5%, 
- a los que tengan entre 1 y 3 días de baja se quedan con la misma nómina, 
- a los que tengan entre 4 y 10 se les baja un 10% y 
- a los que tengan más de 10 días de baja se les se elimina del fichero.
Finalmente, se escribirá en pantalla el fichero “nominas.dat” ya actualizado, indicando
a cuantos empleados se ha dado de baja.
*/
package ficheros;

import java.util.Scanner;
import java.io.*;

/**
 *
 * @author aitor
 */
public class FicherosBinarios {
     static int piNumBaja;
    static Scanner poTeclado = new Scanner(System.in);
    public static void main(String[] args) {
        mvCrearFichero();
    }// main
    
    public static void mvCrearFichero(){
        String wsNombre;
        int wiDiasBaja;
        double wdNomina;
        try {
            File Fnominas = new File("nominas.dat");
            FileOutputStream fos = new FileOutputStream(Fnominas);
            DataOutputStream dos = new DataOutputStream(fos);
            
            System.out.println("----PEDIDA DE DATOS (intro para salir)----");

            while (true) {    
                System.out.print("Nombre: "); wsNombre= poTeclado.nextLine();
                if (wsNombre.equals("")){
                    System.out.println("----PEDIDA DE DATOS FINALIZADA...----");break;
                }
                System.out.print("\nDias de baja:"); wiDiasBaja = poTeclado.nextInt(); poTeclado.nextLine();
                System.out.print("\nNomina: "); wdNomina = poTeclado.nextDouble(); poTeclado.nextLine();
                dos.writeUTF(wsNombre);dos.writeInt(wiDiasBaja);dos.writeDouble(wdNomina);
            }// while
            dos.close();fos.close();
            mvActualizarFichero();
        } catch (IOException e) {System.out.println(e);}        
    }// mvCrearFichero
    
    public static void mvActualizarFichero(){
        String wsNombre;
        int wiDiasBaja;
        double wdNomina;
        double wdNewNomina;
        piNumBaja= 0;
        try {
            
       
            File Fnominas = new File("nominas.dat");
            FileInputStream fis = new FileInputStream(Fnominas);
            DataInputStream dis = new DataInputStream(fis);
            
            File fAux = new File("Auxiliar.dat");
            FileOutputStream fos = new FileOutputStream(fAux);
            DataOutputStream dos = new DataOutputStream(fos);
            try {
                while (true) {                
                    wsNombre = dis.readUTF();
                    wiDiasBaja = dis.readInt();
                    wdNomina = dis.readDouble();
                    if(wiDiasBaja>10){
                        piNumBaja++;
                    } else{
                        dos.writeUTF(wsNombre);
                        dos.writeInt(wiDiasBaja);
                        if (wiDiasBaja <= 0){
                            wdNewNomina = (wdNomina*1.05);
                            dos.writeDouble(wdNewNomina);}
                        if (wiDiasBaja >0&& wiDiasBaja<4){
                            wdNewNomina = wdNomina;
                            dos.writeDouble(wdNewNomina);}
                        if (wiDiasBaja > 3&& wiDiasBaja<11){
                            wdNewNomina = (wdNomina*0.90);
                            dos.writeDouble(wdNewNomina);}
                    }
                }
            } catch (EOFException e) {System.out.println("----FICHERO ACTUALIZADO CORRECTAMENTE----");
            } catch (IOException IOe){System.out.println(IOe);}
                
            fis.close();dis.close();
            fos.close();dos.close();
            Fnominas.delete();
            fAux.renameTo(Fnominas);
            mvMostrarFichero();
         } catch (Exception e) {
        }
    }// mvActualizarFichero    
    
    public static void mvMostrarFichero(){
        try {
            File fNominasAct = new File("nominas.dat");
            FileInputStream fis = new FileInputStream(fNominasAct);
            DataInputStream dis = new DataInputStream(fis);
            
            while (true) {                
                System.out.println("Nombre: "+dis.readUTF()+"\nDias de baja: "+dis.readInt()+"\nNuevo salario: "+dis.readDouble());               
            }
        } catch (EOFException EOe) {System.out.println("Empleados dados de baja: " +piNumBaja+"\n----LECTURA DE DATOS CORRECTA----");
        } catch (IOException IOe){System.out.println("Error no identificado: "+IOe);}
    }// mvMostrarFichero
}// FicherosBinarios


