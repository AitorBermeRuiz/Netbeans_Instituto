package pytvirus;

import java.util.Scanner; 
import java.io.*;
//import pqt_$.$;
import static pqt_$.$.$;
import static pqt_$.$.$$;

/// persistencia
/// clase File Fichero o directorio existente o no

public class CVirusMain {
    public static void main(String[] args) { $$("123");  main1();}//main()  
    
     public static void main0() {
        Scanner woTeclado = new Scanner(System.in);
         $$("--");
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
    
    public static void main1() {
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
 
    
    
}//CVirusMain