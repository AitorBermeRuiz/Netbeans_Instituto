package pqtFile;
import java.util.Scanner; 
import java.io.*;
import static pqt_$.$.$;
import static pqt_$.$.$$;

public class CFile05Ejercicio {
    static Scanner poTeclado = new Scanner(System.in);
    
    public static void main(String[] args) {main04();}// main()
    
    static void main01(){
        /*Pr_1. Hacer un programa que cree un fichero de texto (f1) con las líneas siguientes:
            Esta es la primera línea.
            Y ésta es la segunda y última línea.*/
        $$("---main01---");
        File wf01 = new File("file01.txt");
        try {
            FileWriter wfw01 = new FileWriter(wf01, true);
            wfw01.write("Esta es la primera linea.\n");
            wfw01.write("Y esta es la segunda y última línea.\n");
            wfw01.close();
            ///$("Mira que el fichero se haya creado correctamente antes de borrarlo.");poTeclado.nextLine();
            ///wf01.delete();
            ///$$("Fichero "+wf01.getName()+" borrado.");
        } catch (IOException e) {e.getMessage();}
    }// main01()
    
    static void main02(){
        /*main02 no llega a funcionar del todo bien, los espacios en blanco no los consigue quitar*/
        /*Pr_2. Hacer otro programa que lea el fichero anterior (f1) y que escriba otro fichero (f2) con el contenido
          del primero, pero eliminando los espacios en blanco, las eñes y las vocales acentuadas.*/
        $$("---main02---");
        File wf01 = new File("file01.txt");
        File wf02 = new File("file02.txt");
        try {
            FileReader wfr01 = new FileReader(wf01);
            $$("Lo primero es leer el contenido del archivo "+wf01.getName()+", resultado:\n");
            int wi;
            while ((wi = wfr01.read()) != -1)
                $(""+(char) wi);
            
            FileReader wfr02 = new FileReader(wf01);// cada while necesita su propio file reader
            $$("\nAhora quitaremos los espacios en blanco, las ñ, las tildes y el\nresultado lo meteremos en "+wf02.getName()+":\n");
            FileWriter wfw02 = new FileWriter(wf02 );
            while ((wi = wfr02.read()) != -1){
                char wcWi = ((char) wi);
                
                if (wcWi == ' '){wcWi = '\0';// buscando en internet \0 es la forma de representar "vacío" en los char
                }else if (wcWi == 'ñ'){wcWi = '\0';
                }else if (wcWi == 'á' || wcWi == 'é' || wcWi == 'í' || wcWi == 'ó' || wcWi == 'ú'){wcWi = '\0';}
                
                $(""+wcWi);
                wfw02.write(wcWi);
            }
            wfw02.close();
        } catch (IOException e) {e.getMessage();}
    }// main02()
    
    static void main03(){
        /*Pr_2. Hacer otro programa que lea el fichero anterior (f1) y que escriba otro fichero (f2) con el contenido
          del primero, pero eliminando los espacios en blanco, las eñes y las vocales acentuadas.*/
        $$("---main03---");
        File wf01 = new File("file01.txt");
        File wf02 = new File("file02.txt");
        try {
            FileReader wfr01 = new FileReader(wf01);
            $$("Lo primero es leer el contenido del archivo "+wf01.getName()+", resultado:\n");
            int wi;
            while ((wi = wfr01.read()) != -1)
                $(""+(char) wi);
            
            FileReader wfr02 = new FileReader(wf01);// cada while necesita su propio file reader
            $$("\nAhora quitaremos los espacios en blanco, las ñ, las tildes y el\nresultado lo meteremos en "+wf02.getName()+":\n");
            FileWriter wfw02 = new FileWriter(wf02);
            while ((wi = wfr02.read()) != -1){
                char wcWi = ((char) wi);
                
                if (wcWi == ' '){wcWi = '\0';// buscando en internet \0 es la forma de representar "vacío" en los char
                }else if (wcWi == 'ñ'){wcWi = '\0';
                }else if (wcWi == 'á' || wcWi == 'é' || wcWi == 'í' || wcWi == 'ó' || wcWi == 'ú'){wcWi = '\0';}
                
                $(""+wcWi);
                
                //es increible las vueltas que le he tenido que dar para hacer que me imprima el file02.txt sin espacios
                String wsVacio = "";
                //wfw02.write((wcWi == '\0') ? wsVacio : wcWi);
                if (wcWi == '\0')wfw02.write(wsVacio);
                else wfw02.write(wcWi);
            }
            wfw02.close();
        } catch (IOException e) {e.getMessage();}
    }// main03()
    
    static void main04(){
        /*Pr_3. Hacer otro programa que abra los dos ficheros anteriores y que escriba un fichero f3 en el que se vaya
          mezclando un carácter del fichero f1 con otro del fichero f2, exepto que el carácter a escribir sea una mayúscula,
          en tal caso, convertirlo en minúscula.*/
        $$("---main04---");
        /*métodos para pasar a mayúsculas y minusculas
        char char1UpperCase = Character.toUpperCase(char1);
        char char2LowerCase = Character.toLowerCase(char2);
        */
        try {
            FileReader wfr01 = new FileReader("file01.txt");
            FileReader wfr02 = new FileReader("file02.txt");
            FileWriter wfw03 = new FileWriter("file03.txt");
            
            int wi2 = 0;
            char wc;
            while ( wi2<100 /*(wi2 = wfr01.read()) != -1*/) {
                int wi;
                while ((wi = wfr01.read()) != -1){
                    wc = (char) wi;
                    wc = Character.toLowerCase(wc);
                    $(""+wc);
                    wfw03.write(wc);
                    break;
                }
                while ((wi = wfr02.read()) != -1){
                    wc = (char) wi;
                    wc = Character.toLowerCase(wc);
                    $(""+wc);
                    wfw03.write(wc);
                    break;
                }
                wi2++;
            }
            wfw03.close();
        } catch (IOException e) {e.getMessage();}
    }// main04()
}
