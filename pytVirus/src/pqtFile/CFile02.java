package pqtFile;
import java.util.Scanner;
import java.io.*;
import java.nio.file.Files;    /// el renameTo está NO RECOMENDADO actualmente
                                /// mejor usar el Files.move()
import static pqt_$.$.$;
import static pqt_$.$.$$;

public class CFile02 {
    static Scanner poTeclado = new Scanner(System.in);
    static char pc;
    public static void mvIntro(String is){ 
        System.out.println(is+" ##"); String ws1 = poTeclado.nextLine();
    }//mvPulsaUnaTecla()

    public static void main(String[] args) { $$("123"); main0(); }// main()  
    
     public static void main0() { 
        pc = File.separatorChar;
        CFile02.mvIntro("Cuando aparezca este símbolo ## \nsignifica que debe pulsar una tecla.");
        CFile02.mvIntro("Sitúese en el directorio raiz del proyecto.\nVamos a crear ficheros y Directorios");
        
        File f1 = new File("MiFichero1.txt");
        File f2 = new File("MiFichero2.txt"); 
        File f3 = new File("kk/MiFichero3.txt".replace('/', pc)); // la carpeta kk si existe
        File f31 = new File("kkk/MiFichero31.txt".replace('/', pc));   // la carpeta kkk no existe
        File f4 = new File("kk", "MiFichero4.txt".replace('/', pc)); // un constructor con dos parámetros
        File dir1 = new File("dir1");
        File dir2 = new File("ruta2/dir2".replace('/', pc));
        File dir3 = new File("ruta3/dir3".replace('/', pc));        
        File f6 = new File(dir1, "MiFichero6.txt");        
        try{
            f1.createNewFile();
            f2.createNewFile();
            f3.createNewFile(); // ok porque existe previamente el directorio kk
            f31.createNewFile(); // mal porque NO existe previamente el directorio kkk
            f4.createNewFile();
            dir1.mkdir();
            dir2.mkdir(); // mal porque mkdir no puede crear una rama de directorios. mkdirs() sí que puede
            dir3.mkdirs();  
            f6.createNewFile();
        }catch (IOException ioe) {$$(ioe.getMessage()); ioe.printStackTrace();}          
        mvIntro("Comprobar que se han creado CORRECTAMENTE los ficheros y Directorios");

        $$("Nombre del fichero:     " + f1.getName());
        $$("Path relativo:          " + f1.getPath());
        $$("Path absoluto:          " + f1.getAbsolutePath());       
        $$("Permiso de lectura:     " + f1.canRead());
        $$("Permiso de escritura:   " + f1.canWrite());
        $$("Longitud:               " + f1.length());
        $$("Es un Fichero:          " + f1.isFile());
        $$("Es un Directorio:       " + f1.isDirectory()); 
        $$("Antes de borrarlo:      " + f1.exists());
        f1.delete(); 
        $$("después de borrarlo:    " + f1.exists()); 
        mvIntro("Comprobar que los datos del fichro MiFichero1.txt son CORRECTOS.");

        mvIntro("Vamos a listar el dir actual y su padre.");

        File dir11 = new File(".");
        String [] was = dir11.list();        
        $("Total de Ficheros y directorios: "+was.length + "\n" + 
                "Path absoluto: "+dir11.getAbsolutePath() + "\nFicheros:\n" );
        for(String ws : was) $$(ws); $$("");

        dir11 = new File("..");
        was = dir11.list();        
        $("Total de Ficheros y directorios: "+was.length + "\n" + 
                "Path absoluto: "+dir11.getAbsolutePath() + "\nFicheros:" );
        for(String ws : was) $$(ws);  $$("");    

        mvIntro("Comprobar que el contenido de . y .. son CORRECTOS");

        mvIntro("Vamos a crear el ficheroViejo.txt ");
        File fViejo = new File("FicheroViejo.txt"); 
        try{ fViejo.createNewFile(); }catch (IOException ioe) {ioe.printStackTrace();} 
        mvIntro("Comprobar que se ha creado el MiFicheroViejo.txt");
        
        mvIntro("Vamos a crear el ficheroNuevo.txt ");
        File fNuevo = new File("FicheroNuevo.txt");
        try{ fNuevo.createNewFile(); }catch (IOException ioe) {ioe.printStackTrace();}
        mvIntro("Comprobar que se ha creado el MiFicheroNuevo.txt");

        mvIntro("Vamos a borrar el ficheroNuevo.txt en caso de que exista");
        if (fNuevo.exists()) fNuevo.delete();
        $$("Despues de borrar el fNUevo:      " + fNuevo.exists());
        mvIntro("Conmpruebe que ya NO EXISTE el ficheroNuevo.txt");

        mvIntro("Vamos a renombrar el FicheroViejo.txt como FicheroNuevo");

        $$("Nombre del fichero fViejo:     " + fViejo.getName());   
        if (fViejo.renameTo(fNuevo)) 
            $$("Se ha renombrado");
        else 
            $$("NO se ha renombrado");

        $$("después de renombrar el fViejo a fNuevo:    " + fViejo.exists()); 
        $$("Nombre del fichero fViejo:     " + fViejo.getName());     

        $$("después de renombrar Existe el ficheroNuevo?:    " + fNuevo.exists()); 
        $$("Nombre del ficheroNuevo:     " + fNuevo.getName());     
 
     }// main0()


}//CMainCodigo5