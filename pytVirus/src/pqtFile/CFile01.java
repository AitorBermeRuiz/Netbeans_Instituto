package pqtFile;
import java.io.*;
import static pqt_$.$.$;
import static pqt_$.$.$$;

public class CFile01 {
    public static void main(String[] args) {
        main4();
    }//main()
    
    public static void main1() {
        $$("main1");
        File f = new File("fichero.txt");
        $$("Nombre: " + f.getName());
        $$("Camino: " + f.getPath());
        
        //Si no hacemos algo con el archivo no se crea, si usamos el filewriter(f) el archivo ya existe.
        try {
            FileWriter fw = new FileWriter(f);
            fw.close();//Para ver la importancia del close, si no lo ponemos, f.delete() no funciona.
        }catch(IOException e){$$("Error");}
        
        if (f.exists()) {
            $$("Fichero existente");
            if (f.canWrite())
                $$(" y se puese Escribir");
            $$("La longitud del fichero son " + f.length() + " bytes");
        } else 
            $$("El fichero no existe.");
        
        f.delete();//Sin fw.close() no funciona.

    }// main1()
    
    public static void main2(){
        $$("main2");
        String hola = "hola";
        int num = 5;
        try{
            
            File f = new File("fichero.txt");
            FileWriter fw = new FileWriter(f);
            fw.write("Estoy probando la clase File"+num);
            fw.close();

            FileReader fr = new FileReader(f);
            $$("Nombre: "+f.getName());
            $$("Camino: "+f.getPath());
            if(f.exists()){
                $$("Fichero SI existe");
                if (f.canWrite())
                    $$("Se puede escribir");
                $$("La longitud del fichero es: " + f.length()+" bytes.");
            }else
                $$("El fichero NO existe");
            $$(""+fr.read());//Devuelve --> 69
            fr.close();
            
            f.delete();
        }catch(IOException e){$$("Error");}
        
    
    }// main2()

    public static void main3() {
        $$("main3");
        String wsFrase = "segundo mensaje:  ";
        try {
            File f = new File("texto.txt");
            FileWriter fw = new FileWriter(f, true);//el true es para añadir texto al texto anteriormente escrito.
                //Para añadir información al fichero se pondría :
                // FileWriter escribir=new FileWriter(archivo,true);
            fw.write(wsFrase);
            fw.close(); //IMPORTANTE SI NO, NO SE GUARDA LA INFORMACIÓN
        } catch (IOException e) {
            $$("Error al escribir");
        }
    }// main3()
    
    public static void main4() {
        $$("main4");
        int c;
        try {
            FileReader fr = new FileReader("texto.txt");
            c = fr.read();
            while (c != -1) {
                $(""+(char) c);
                c = fr.read();//¿que hace esto? esto hace que no entre en bucle es com el i++ del fileReader
            }
            fr.close();
        } catch (IOException e) {
            $$("Error al leer "+e.getMessage());
        }
    }// main4()
    
    public static void main5() {
        $$("main5");
        String texto = "";
        try {
            FileReader fr = new FileReader("texto.txt");
            BufferedReader br = new BufferedReader(fr);
            texto = br.readLine();
            while (texto != null) {
                $(texto);
                texto = br.readLine();
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
        } catch (IOException e) {
            System.out.println("Error al leer el fichero");
        }
    }// main5()
 
}//CVirusMain

