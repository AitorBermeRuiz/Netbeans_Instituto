package ficheros;

import java.util.Scanner;
import java.io.*;
/**
 *
 * @author aitor
 */
public class EjRepaso {
    static Scanner poTeclado = new Scanner(System.in);
    public static void main(String[] args) {Ej6();}// main
    
    public static void Ej1(){
        /*
         Hacer un programa que genere un fichero de texto llamado parrafo.txt, en el
         que se vayan introduciendo frases . Se finalizará de introducir datos cuando
         se pulse un *.
        */
        String wsString;
        File F1 = new File("parrafo.txt");
        try {
            FileWriter Fw1 = new FileWriter(F1);
            System.out.println("EXIT BY TYPING: *");
            System.out.print("What do you want to write?:");
            wsString = poTeclado.nextLine();

            while (!wsString.equals("*")) {                
  
                Fw1.write(wsString+"\n");
                System.out.print("What do you want to write?:");
                wsString = poTeclado.nextLine();
                
            }// while
            Fw1.close();
            
            FileReader Fr1 = new FileReader(F1);
            BufferedReader Bf1 = new BufferedReader(Fr1);
            
            String ws;
            while ((ws = Bf1.readLine())!= null) {                
                System.out.println(ws);
            }
            Fr1.close();Bf1.close();
        }catch (FileNotFoundException FNF){
            System.out.println("File not found");
        }catch (Exception e) {
            System.out.println("Error...");
        }
    }// Ej1
    
    public static void Ej2(){
        /*
         Sea el fichero de texto parrafo.txt, hacer un programa cuente el número de
        veces que aparece cada letra de la a a la z y luego escriba los resultados en un
        archivo de texto que se llamará letras.txt. Finalmente, mostrar el archivo 
        resultante.
        */
        File f2 =new File("parrafo.txt");
        int wiCount = 0;
        try {
            FileReader fr2 = new FileReader(f2);
            int wi;
            while ((wi = fr2.read()) != -1) {                
                wiCount++;
                System.out.print((char) wi);
            }
            fr2.close();
            System.out.println("Numero de palabras: "+wiCount);
        } catch (Exception e) {
        }
    }    
    
    public static void Ej3(){
        /*
         Hacer un programa que muestre cuántas líneas hay en el fichero parrafo.txt, 
         le pida al usuario un numero comprendido en ese rango y escriba por pantalla
         la frase que ocupa dicha posición.
        */
        
        try {
            FileReader fr3 = new FileReader(new File("parrafo.txt"));
            BufferedReader br3 = new BufferedReader(fr3);
            
            String ws;
            int wiCount= 0;
            while ((ws = br3.readLine()) !=null )               
                wiCount++;
            
            int wiNum = 0;
            do {                
                System.out.println("Dime una frase a mostrar entre 1 y "+wiCount);
                wiNum = poTeclado.nextInt();
            } while (wiNum <=0 || wiNum > wiCount);
            br3.close();fr3.close();
            
            FileReader fr3_1 = new FileReader(new File("parrafo.txt"));
            BufferedReader br3_1 = new BufferedReader(fr3_1);
            
            int wiAux =0;
                while (( ws = br3_1.readLine()) !=null){
            wiAux++;
            if(wiAux ==wiNum){
                System.out.print(ws);
                }
            }
            br3_1.close();fr3_1.close();
        } catch (Exception e) { System.out.println(e);
        }
    }// Ej3
    
    public static void Ej4(){
        /*
         Hacer un programa que actualice el fichero del ejercicio 1, quitándole las
         vocales. Escribir por pantalla dicho fichero, es decir, parrafo.txt.
        */
        
        File f1 = new File("parrafo.txt");
        File f2 = new File("AuxiliarAyuda.txt");
        try {
            FileReader FrPrincipal = new FileReader(f1);
            FileWriter FwAuxiliar = new FileWriter(f2);
            int wiAux = 0;
            while ((wiAux = FrPrincipal.read()) != -1) {  
                if (wiAux == ('a') || wiAux == ('e')|| wiAux == ('i')|| wiAux == ('o')|| wiAux == ('u'))
                    FwAuxiliar.write("*");
                else 
                    FwAuxiliar.write(wiAux);
                
            }
            FrPrincipal.close(); FwAuxiliar.close();
            
            f1.delete();
            f2.renameTo(f1);
            FileReader fr2 = new FileReader("parrafo.txt");
            wiAux = 0;
            while ((wiAux = fr2.read()) != -1) {                
                System.out.print((char) wiAux);                
            }
        } catch (Exception e) {
        }
    }// Ej4
    
    public static void Ej5(){
     /* Una empresa guarda los datos de sus empleados en un fichero de texto tal
        que a cada empleado se le dedica una línea con el siguiente formato:
        Nombre y apellidos(separados por , edad, número de hijos y estado civil. ₎
 
        Felipe_Garcia_Lopez 30 2 Casado
        Hacer un programa que calcule cuál es la edad media de los empleados.
         Para pasar de cadena a entero, se hace de la siguiente forma:
        int numEntero = Integer.parseInt(numCadena);*/   
        
        String ws;
        int SumEdad = 0;
        String[] wisFrase;
        int wiNumDeClientes = 0;
        try {
            FileReader fr1 = new FileReader("Ejercicio5.txt");
            BufferedReader br1 = new BufferedReader(fr1);
            while ((ws = br1.readLine())!=null) {                
                wisFrase = ws.split(" ");
                SumEdad = SumEdad + Integer.parseInt(wisFrase[1]);
                wiNumDeClientes++;
            }
            System.out.println("Media de edad de los empleados: "+(SumEdad/wiNumDeClientes));
            br1.close();fr1.close();
        } catch (Exception e) {
        }
    }// Ej5
    
    public static void  Ej6(){
        /*  Hacer un programa que lea el fichero de texto, “texto.txt”, y genere otro llamado 
            “invertido.txt”, en el que se guardarán las frases del primero pero invertidas. Mostrar en
             pantalla el nuevo fichero.
             Ej: texto.txt invertido.txt
            Esto es un ejemplo olpmeje nu se otsE */
        
        File fi = new  File("texto.txt");
        //File f2 = new File("invertido.txt");

        try {
            FileReader Fr1 = new FileReader(fi);
            BufferedReader br1 = new BufferedReader(Fr1);
            //FileWriter fw2 = new FileWriter(f2);
            String ws;
            String wsInvertido= "";
            while ((ws = br1.readLine()) != null) {                
                for ( int i = ws.length()-1; i >= 0; --i){
                    wsInvertido += ws.substring(i, i+1);
                }
                System.out.println(wsInvertido);

            }
            br1.close();Fr1.close();
            
            
        } catch (Exception e) {
        }
    }// Ej6
}// EjRepaso
