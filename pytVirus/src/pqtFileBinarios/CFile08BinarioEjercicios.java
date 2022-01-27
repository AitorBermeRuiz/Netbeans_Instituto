package pqtFileBinarios;
import java.io.*;
import java.util.Scanner;
import static pqt_$.$.$;
import static pqt_$.$.$$;
/*3º. Realizar un programa que lea de teclado los siguientes datos y los almacene en un fichero binario
      llamado "datosbeca.bin".
        . Nombre y apellido de un supuesto becario.
        . Sexo (H-M)
        . Edad (20-60)
        . Numero de suspensos del curso anterior (0-4).
        . Residencia familiar (SI o NO)
        . Ingresos anuales de la familia.
  4º. Realizar un programa que, partiendo del fichero binario “datosbeca.bin”, calcule la cuantía de la
      beca (en caso de que la haya). El total de la beca se calcula como sigue:
        • Base fija de 1500€
        • Si los ingresos anuales de la familia son menores o iguales a la media (12.000€), la beca
          se incrementa en 500€, en caso contrario no lleva complementos.
        • Si la edad de la persona es inferior a 23 años, 200€ de gratificación, si es mayor no hay gratificación.
        • Si no hay suspensos en el curso anterior, hay una gratificación de 500€, 1 suspenso 200€,
          si hay 2 o mas suspensos no hay beca.
        • Si vive de alquiler (no residencia familiar), 1000€ más de gratificación.
      Visualizar el nombre de cada uno de los becarios y su cuantía total (sólo los que tienen beca).*/

public class CFile08BinarioEjercicios {
    static Scanner poTeclado = new Scanner(System.in);
    
    public static void main(String[] args) throws FileNotFoundException, IOException{
        ///mvCrearFichero();
        mvCalcularBeca();
    }
    
    private static boolean isNumeric(String cadena){//esto es para que nos compruebe si es de tipo number
        try {
                Integer.parseInt(cadena);
                return true;
        } catch (NumberFormatException nfe){
                return false;
        }
    }
    
    static void mvCrearFichero() throws IOException{
        File             fVj = new File("datosBeca.dat");
        FileOutputStream fos = new FileOutputStream(fVj, true);
        DataOutputStream dos = new DataOutputStream(fos);
        
        while (true){
            
            $$("\nNo escribir nada = salir del bucle");
            $("Nombre y apellidos: ");
            String wsNombre = poTeclado.nextLine(); wsNombre = wsNombre.trim();
            if (wsNombre.equals(""))break;
            dos.writeUTF(wsNombre);
            
            while (true){
                $("Sexo 'H' || 'M': ");
                String wsSexo = poTeclado.nextLine(); wsSexo = wsSexo.toLowerCase().trim();
                dos.writeUTF(wsSexo);
                if (wsSexo.equals("h") || wsSexo.equals("m")) break;
                else $$("Has introducido algo diferente a 'h' || 'm'.");
            }
            
            while (true){
                $("Edad '20-60': ");
                int wiEdad = poTeclado.nextInt(); poTeclado.nextLine();
                ///if (isNumeric(wsNombre)) //hay una forma de hacer una comprobación de si es int o no, pero requiere que se introduzca un string;
                dos.writeInt(wiEdad);
                if (wiEdad >= 20 && wiEdad <= 60) break;
                else $$("Has introducido valores inadecuados.");
            }
            
            while(true){
                $("Número de suspensos del curso anterior '0-4': ");
                int wiSuspensos = poTeclado.nextInt(); poTeclado.nextLine();
                dos.writeInt(wiSuspensos);
                if (wiSuspensos >= 0 && wiSuspensos <= 5) break;
                else $$("Has introducido valores inadecuados.");
            }
            
            while(true){
                $("Residencia familiar 'SI-NO': ");
                String wsBoolean = poTeclado.nextLine(); wsBoolean = wsBoolean.toLowerCase().trim();
                boolean wbResFamiliar;//increible, no solo hay que inicializarla, si no ponerla un valor por defecto, por ejemplo "true", si no da un extraño error...
                ///boolean wbResFamiliar;
                if (wsBoolean.equals("si")){
                    wbResFamiliar = true;
                    dos.writeBoolean(wbResFamiliar);
                    break;
                }else if (wsBoolean.equals("no")){
                    wbResFamiliar = false;
                    dos.writeBoolean(wbResFamiliar);
                    break;
                }else $$("Has introducido algo diferente a 'si' || 'no'.");
            }
            
            $("Ingresos anuales de la familia: ");
            int wiIngresos = poTeclado.nextInt(); poTeclado.nextLine();
            dos.writeInt(wiIngresos);
        }
        dos.close();
    }// mvCrearFichero()

    static void mvCalcularBeca() throws IOException, EOFException{
        File            fVj = new File("datosBeca.dat");
        FileInputStream fis = new FileInputStream(fVj);
        DataInputStream dis = new DataInputStream(fis);
        
        try {
            while (true){
                int wiBeca = 1500;
                //Es importante que los datos se lean en orden
                String  wsNombre      = dis.readUTF();
                String  wsSexo        = dis.readUTF();
                int     wiEdad        = dis.readInt();
                int     wiSuspensos   = dis.readInt();
                boolean wbResFamiliar = dis.readBoolean();
                int     wiIngresos    = dis.readInt();
                if (wiIngresos <= 12000)    wiBeca = wiBeca + 500;
                if (wiEdad < 23)            wiBeca = wiBeca + 200;
                if(!wbResFamiliar)          wiBeca = wiBeca + 1000;
                if (wiSuspensos == 0)       wiBeca = wiBeca + 500;
                else if (wiSuspensos == 1)  wiBeca = wiBeca + 200;
                else                        wiBeca = 0;
                
                if (wiBeca != 0) {
                    $$(wsNombre+" - "+wsSexo+" -  "+wiEdad+" - "+wiSuspensos+" - "+wbResFamiliar+" - "+wiIngresos);
                    $$("Beca: "+wiBeca+"\n");
                }
                ///$$(dis.readUTF()+dis.readInt());
                ///dis.close(); // si ponemos esto solo nos lee la primera fila, falla
            }// while
        }catch (IOException e) {e.getMessage();}
    }// mvCalcularBeca()
    
}// CFile08BinarioEjercicios