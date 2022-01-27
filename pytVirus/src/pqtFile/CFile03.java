package pqtFile;
import java.util.Scanner; 
import java.io.*;
//import pqt_$.$;
import static pqt_$.$.$;
import static pqt_$.$.$$;
/// persistencia
/// clase File Fichero o directorio existente o no

public class CFile03 {
/// persistencia
/// clase File Fichero o directorio existente o no
// main()   llama al mainXX() con el que estamos trabajando
// main00() explica la clase File
// main01() un ejercicio de la clase File
// main02() creamos un fichero con texto y lo comprobamos
// main03() añadimos texto a un fichero existente con texto anterior 
// main04() leemos un fichero de texto caracter a carácter y lo mostramos
// main05() leemos un fichero de texto línea a línea y lo mostramos. Y ...
// main05() ... utilizamos varios catch
// main06() leemos un fichero de texto y guardamos en un array de char 
// main07() leer una linea dentro de la condición del while
// main08() BufferedWriter y newLine. PrintWriter y println

    public static void main(String[] args) {main04();}//main()  
    
    public static void main00() {
        $$("--------------- salida del main00");

        Scanner woTeclado = new Scanner(System.in);
        String ws1 = woTeclado.nextLine();
/// import java.io.File;

//C:\Users\iciar\Documents\NetBeansProjects\Virus
        File f1 = new File("MiFichero1.txt");
        File f2 = new File("MiFichero2.txt"); 
///        File f22 = new File("C:\kk\MiFichero22.txt");
///C:\kk
        File f3 = new File("C:\\kk\\MiFichero3.txt"); // la carpeta kk si existe
        //File f31 = new File ("C:\\kkk\\MiFichero31.txt");   // la carpeta kkk no existe
        File f4 = new File("C:\\kk", "MiFichero4.txt"); // un constructor con dos parámetros
        File dir1 = new File("dir1");
        File dir2 = new File("ruta2\\dir2");
        File dir3 = new File("ruta3\\dir3");        
        File f6 = new File(dir1, "MiFichero6.txt");
        
        try{
            f1.createNewFile();
            f2.createNewFile();
            f3.createNewFile();
            //f31.createNewFile();
            f4.createNewFile();
            dir1.mkdir();
            dir2.mkdir();
            dir3.mkdirs();  
            f6.createNewFile();
        }catch (IOException ioe) {ioe.printStackTrace();}            

        $$("Nombre del fichero:     " + f1.getName());
        $$("Path relativo:          " + f1.getPath());
        $$("Path absoluto:          " + f1.getAbsolutePath());       
        $$("Permiso de lectura:     " + f1.canRead());
        $$("Permiso de escritura:   " + f1.canWrite());
        $$("Longitud:               " + f1.length());
        $$("Es un Fichero:          " + f1.isFile());
        $$("Es un Directorio:       " + f1.isDirectory()); 
        $$("Antes de borrarlo:      " + f1.exists());
        f1.delete(); // borramos f1  
        $$("después de borrarlo:    " + f1.exists()); 
        
        File dir11 = new File(".");
        String [] was = dir11.list();        
        $("Total de Ficheros y directorios: "+was.length + "\n" + 
                "Path absoluto: "+dir11.getAbsolutePath() + "\nFicheros:\n" );
        for(String ws : was) $$(ws); $$("");
        
        dir11 = new File("..");
        was = dir11.list();        
        $("Total de Ficheros y directorios: "+was.length + "\n" + 
                "Path absoluto: "+dir11.getAbsolutePath() + "\nFicheros:\n" );
        for(String ws : was) $$(ws);  $$("");    

         String ws = woTeclado.nextLine();       
        
        File f99 = new File("Fichero99.txt");       
        if (f99.exists())
            f99.delete();
        $$("Despues de borrar el f99:      " + f99.exists());
          ws = woTeclado.nextLine();
       
        $$("Nombre del fichero:     " + f2.getName());   
        f2.renameTo(f99);  // Le cambiamos el nombre 
        $$("después de renombrarlo:    " + f2.exists()); 
        $$("Nombre del fichero:     " + f2.getName());     

        $$("después de renombrarlo:    " + f99.exists()); 
        $$("Nombre del fichero:     " + f99.getName());     

     }//main0()
    
    public static void main01() {
        $$("--------------- salida del main01");

        File f = new File("fichero.txt");
        $$("Nombre: " + f.getName());
        $$("Camino: " + f.getPath());
        if (f.exists()) {
            $$("Fichero existente");
            if (f.canWrite())
                $$(" y se puese Escribir");
            $$("La longitud del fichero son " + f.length() + " bytes");
        } else 
            $$("El fichero no existe.");
        
    }//main1()
    ///////////////////////////////////////////////// fin del vídeo 08
    public static void main02(){
    $$("--------------- salida del main02");

    try{
        File f = new File("fichero.txt");
        FileWriter fw = new FileWriter(f);
        fw.write("Estoy probando la clase FileV2");
               // 123456789-123456789-123456789-123456789-123456789-
        fw.close();
        //C:\Users\iciar\Documents\NetBeansProjects\Virus
        
        FileReader fr= new FileReader(f);
        $$("Nombre: "+f.getName());
        $$("Camino: "+f.getPath());
        if(f.exists()){
            $$("Fichero SI existe");
            if (f.canWrite())
                $$("Se puede escribir");
            $$("La longitud del fichero es: " + f.length()+" caracteres.");
        }else
            $$("El fichero NO existe");
        fr.close();
        
    }catch(IOException e){$$("Error");}
    
    
    }//main2()

    public static void main03() {
        $$("--------------- salida del main03");

        String wsFrase = "segundo mensaje:\n";
        try {
            File f = new File("fw1.txt");
            FileWriter fw1 = new FileWriter(f, true);
                //Para añadir información al fichero se pondría :
                // FileWriter escribir=new FileWriter(archivo,true);
            fw1.write(wsFrase);
            fw1.close(); //IMPORTANTE!!! SI NO se cierra, NO SE GUARDA LA INFORMACIÓN
        } catch (Exception e) {
            $$("Error al escribir en el fichero");
        }
    }//main3()
    ///////////////////////////////////////////////// fin del vídeo 10
    public static void main04() {
        $$("--------------- salida del main04");

        int c;
        try {
            FileReader lector = new FileReader("texto.txt");
            c = lector.read();           
            while (c != -1) {
                $(""+(char) c);
                c = lector.read();
            }
            lector.close();
            
            $$("\n\nlectura con read dentro de la condición del while: ");
            FileReader fr = new FileReader(new File("texto.txt"));
            int wi;
            while ((wi= fr.read()) != -1)  
                $("" + (char) wi);
            fr.close();                    
            
        } catch (Exception e) {
            $$("Error al leer");
        }
    }
    ///////////////////////////////////////////////// fin del vídeo 12
    public static void main05() {
        $$("--------------- salida del main05");

        String texto = "";
        try {
            FileReader fr = new FileReader("texto.txt");
            BufferedReader br = new BufferedReader(fr);
            texto = br.readLine();
            while (texto != null) {
                $$(texto);
                texto = br.readLine();
            }
            br.close();
            fr.close();
            
            $$("\n\nlectura con readLine dentro de la condición del while: ");
            fr = new FileReader("texto.txt");
            br = new BufferedReader(fr);
            //texto = br.readLine();
            while ((texto = br.readLine()) != null) {
                $$(texto);
                //texto = br.readLine();
            }
            br.close();
            fr.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
        } catch (IOException e) {
            System.out.println("Error al leer el fichero");
        }
    }
        
    public static void main06(){
        $$("--------------- salida del main06");

        try{
            FileReader fr = new FileReader(new File("fw1.txt"));
            int wi;
            while ((wi= fr.read()) != -1)  
                $("" + (char) wi);
            fr.close(); fr= null;  
            $$("\n------------------------------");
            
            fr = new FileReader(new File("fw1.txt"));
            char [] wac = new char[10];  
            $$("..1234567890");
            while ((wi = fr.read(wac)) != -1 ){ 
                $("..");
                System.out.println(wac); 
                ///$$(String.copyValueOf(wac));
            }
            fr.close();                                    
            $$("\n------------------------------");

            FileWriter fw = new FileWriter(new File("fw1.txt"), true); 
            fw.write('z');
            fw.append('y');
            
            String [] was = {"aa", "bb", "cc", "dd"};
            for(int i=0; i<was.length; i++)
                fw.write(was[i] + "-");            
            fw.close(); 
            
        }catch(IOException ioe){$$("Error de entrada salida");}            
    }//main6()
 
    public static void main07(){
        $$("--------------- salida del main07");
        
        try{        
            BufferedReader br = new BufferedReader(new FileReader("fw1.txt"));
            String ws; 
            while ((ws = br.readLine()) != null) 
                $$(ws);            
            br.close();
        }catch(IOException ioe){$$("Error de entrada salida");}
    }//main7()

    public static void main08(){
        $$("--------------- salida del main08");

        try{        
            BufferedWriter bw = new BufferedWriter(new FileWriter("fw1.txt"));
            for(int i=0; i<8; i++){
                bw.write("linea numero "+(i+1));
                bw.newLine();
            }
            bw.close();
            
            BufferedReader br = new BufferedReader(new FileReader("fw1.txt"));
            String ws; 
            while ((ws = br.readLine()) != null) 
                $$(ws);            
            br.close();  
            
            
            PrintWriter pw = new PrintWriter(new FileWriter("fw1.txt"));
            for(int i=0; i<8; i++)
                pw.println("linea numero "+(i+101));
            pw.close();
            
            
            br = new BufferedReader(new FileReader("fw1.txt")); 
            while ((ws = br.readLine()) != null) 
                $$(ws);            
            br.close();                 
        }catch(IOException ioe){$$("Error de entrada salida");}  
        
    }//main7()    
}//CVirusMain



