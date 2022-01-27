
package ficheros;

import java.util.Scanner; 
import java.io.*;
/**
 *
 * @author aitor
 */
public class Ficheros {
    static Scanner poTeclado = new Scanner(System.in);
    public static void main(String[] args) {main00();}//main()  
    

//import pqt_System.out.print.System.out.print;

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


    
    public static void main00() {
        System.out.println("--------------- salida del main00");

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

        System.out.println("Nombre del fichero:     " + f1.getName());
        System.out.println("Path relativo:          " + f1.getPath());
        System.out.println("Path absoluto:          " + f1.getAbsolutePath());       
        System.out.println("Permiso de lectura:     " + f1.canRead());
        System.out.println("Permiso de escritura:   " + f1.canWrite());
        System.out.println("Longitud:               " + f1.length());
        System.out.println("Es un Fichero:          " + f1.isFile());
        System.out.println("Es un Directorio:       " + f1.isDirectory()); 
        System.out.println("Antes de borrarlo:      " + f1.exists());
        f1.delete(); // borramos f1  
        System.out.println("después de borrarlo:    " + f1.exists()); 
        
        File dir11 = new File(".");
        String [] was = dir11.list();        
        System.out.print("Total de Ficheros y directorios: "+was.length + "\n" + 
                "Path absoluto: "+dir11.getAbsolutePath() + "\nFicheros:\n" );
        for(String ws : was) System.out.println(ws); System.out.println("");
        
        dir11 = new File("..");
        was = dir11.list();        
        System.out.print("Total de Ficheros y directorios: "+was.length + "\n" + 
                "Path absoluto: "+dir11.getAbsolutePath() + "\nFicheros:\n" );
        for(String ws : was) System.out.println(ws);  System.out.println("");    

         String ws = woTeclado.nextLine();       
        
        File f99 = new File("Fichero99.txt");       
        if (f99.exists())
            f99.delete();
        System.out.println("Despues de borrar el f99:      " + f99.exists());
          ws = woTeclado.nextLine();
       
        System.out.println("Nombre del fichero:     " + f2.getName());   
        f2.renameTo(f99);  // Le cambiamos el nombre 
        System.out.println("después de renombrarlo:    " + f2.exists()); 
        System.out.println("Nombre del fichero:     " + f2.getName());     

        System.out.println("después de renombrarlo:    " + f99.exists()); 
        System.out.println("Nombre del fichero:     " + f99.getName());     

     }//main0()
    
    public static void main01() {
        System.out.println("--------------- salida del main01");

        File f = new File("fichero.txt");
        System.out.println("Nombre: " + f.getName());
        System.out.println("Camino: " + f.getPath());
        if (f.exists()) {
            System.out.println("Fichero existente");
            if (f.canWrite())
                System.out.println(" y se puese Escribir");
            System.out.println("La longitud del fichero son " + f.length() + " bytes");
        } else 
            System.out.println("El fichero no existe.");
        
    }//main1()
    ///////////////////////////////////////////////// fin del vídeo 08
    
    public static void main02(){
        System.out.println("-------EJECUCION MAIN 2-------");
        int wiPrueba = 3;
        try {
            File f = new File("fichero2.txt");
            
            FileWriter  fr = new FileWriter(f, true);
            fr.write("Escritura en el fichero del main2\nPrueba: "+wiPrueba+"\n");
            fr.close();
            System.out.println("Nombre: "+f.getName());
            System.out.println("Rura: "+ f.getAbsolutePath());
            if (f.exists()){
                System.out.println("Fichero SI existe");
                if (f.canWrite())
                    System.out.println("Se puede escribir en el");
                System.out.println("La longitud del fichero es de: " +f.length() +" caracteres");
            } else 
                System.out.println("El Fichero NO existe");
        } catch (Exception e) {System.out.println("Error al crear el archivo...");        }
    
    
    }//main2()

    public static void main03() {
        System.out.println("--------------- salida del main03");

        String wsFrase = "tercero  mensaje:\n";
        try {
            File f = new File("fw1.txt");
            FileWriter fw1 = new FileWriter(f, true);
                //Para añadir información al fichero se pondría :
                // FileWriter escribir=new FileWriter(archivo,true);
            fw1.write(wsFrase);
            fw1.close(); //IMPORTANTE!!! SI NO se cierra, NO SE GUARDA LA INFORMACIÓN
        } catch (Exception e) {
            System.out.println("Error al escribir en el fichero");
        }
    }//main3()
        ///////////////////////////////////////////////// fin del vídeo 10

    public static void main04() {
        System.out.println("--------------- salida del main04");

        int c;
        try {
            FileReader lector = new FileReader("texto.txt");
            c = lector.read();           
            while (c != -1) {
                System.out.print(""+(char) c);
                c = lector.read();
            }
            lector.close();
            
            System.out.println("\n\nlectura con read dentro de la condición del while: ");
            FileReader fr = new FileReader(new File("texto.txt"));
            int wi;
            while ((wi= fr.read()) != -1)  
                System.out.print("" + (char) wi);
            fr.close();                    
            
        } catch (Exception e) {
            System.out.println("Error al leer");
        }
    }
        ///////////////////////////////////////////////// fin del vídeo 12

    public static void main05() {
        System.out.println("--------------- salida del main05");

        String texto = "";
        try {
            FileReader fr = new FileReader("texto.txt");
            BufferedReader br = new BufferedReader(fr);
            texto = br.readLine();
            while (texto != null) {
                System.out.println(texto);
                texto = br.readLine();
            }
            br.close();
            fr.close();
            
            System.out.println("\n\nlectura con readLine dentro de la condición del while: ");
            fr = new FileReader("texto.txt");
            br = new BufferedReader(fr);
            //texto = br.readLine();
            while ((texto = br.readLine()) != null) {
                System.out.println(texto);
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
        System.out.println("--------------- salida del main06");

        try{
            FileReader fr = new FileReader(new File("fw1.txt"));
            int wi;
            while ((wi= fr.read()) != -1)  
                System.out.print("" + (char) wi);
            fr.close(); fr= null;  
            System.out.println("\n------------------------------");
            
            fr = new FileReader(new File("fw1.txt"));
            char [] wac = new char[10];  
            System.out.println("..1234567890");
            while ((wi = fr.read(wac)) != -1 ){ 
                System.out.print("..");
                System.out.println(wac); 
                ///System.out.println(String.copyValueOf(wac));
            }
            fr.close();                                    
            System.out.println("\n------------------------------");

            FileWriter fw = new FileWriter(new File("fw1.txt"), true); 
            fw.write('z');
            fw.append('y');
            
            String [] was = {"aa", "bb", "cc", "dd"};
            for(int i=0; i<was.length; i++)
                fw.write(was[i] + "-");            
            fw.close(); 
            
        }catch(IOException ioe){System.out.println("Error de entrada salida");}            
    }//main6()
 
    public static void main07(){
        System.out.println("--------------- salida del main07");
        
        try{        
            BufferedReader br = new BufferedReader(new FileReader("fw1.txt"));
            String ws; 
            while ((ws = br.readLine()) != null) 
                System.out.println(ws);            
            br.close();
        }catch(IOException ioe){System.out.println("Error de entrada salida");}
    }//main7()

    public static void main08(){
        System.out.println("--------------- salida del main08");

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
                System.out.println(ws);            
            br.close();  
            
            
            PrintWriter pw = new PrintWriter(new FileWriter("fw1.txt"));
            for(int i=0; i<8; i++)
                pw.println("linea numero "+(i+101));
            pw.close();
            
            
            br = new BufferedReader(new FileReader("fw1.txt")); 
            while ((ws = br.readLine()) != null) 
                System.out.println(ws);            
            br.close();                 
        }catch(IOException ioe){System.out.println("Error de entrada salida");}  
        
    }//main7()    
    
    public static void main4Mio() {
        String wsFrase;
        File f4 = new File("fichero4_mio.txt");
        
        try {
            FileWriter fw4 = new FileWriter(f4, true);
            System.out.println("ESC PARA DEJAR DE ESCRIBIR EN EL FICHERO");
            while (true) {                
                         
            System.out.print("Que quieres escribir en el archivo?: ");
            wsFrase = poTeclado.nextLine();
            if ((wsFrase.toLowerCase()).equals("esc") )
                break;
            else
                fw4.write(wsFrase+"\n");
            }
            fw4.close();
            
            FileReader fr4 = new FileReader(f4);
            int wi;
            while((wi = fr4.read()) != -1){
                System.out.print( (char)wi );
            }
            fr4.close();
        } catch (Exception e) {
            System.out.println("Error...");
        }
    }//main4Mio
    public static void main05mio() {
        String wsFrase;
        File f5 = new File("fichero5_mio.txt");
        
        try {
            FileWriter fw5 = new FileWriter(f5, true);
            System.out.println("ESC PARA DEJAR DE ESCRIBIR EN EL FICHERO");
            while (true) {                
                         
            System.out.print("Que quieres escribir en el archivo?: ");
            wsFrase = poTeclado.nextLine();
            if ((wsFrase.toLowerCase()).equals("esc") )
                break;
            else
                fw5.write(wsFrase+"\n");
            }
            fw5.close();
            
            FileReader fr5 = new FileReader(f5);
            BufferedReader br5 = new BufferedReader(fr5);
            String ws;
            while((ws = br5.readLine()) != null){
                System.out.print(ws+"\n");
            }
            fr5.close();
        }catch (FileNotFoundException e){
            System.out.println("Fichero no encontrado"+e);
        }
        catch (Exception e) {
            System.out.println("Error...");
        }
    }// main05mio
    public static void main6Mio() {
        String wsFrase;
        File f6 = new File("fichero6_mio.txt");
        
        try {
            FileWriter fw6 = new FileWriter(f6);
            System.out.println("ESC PARA DEJAR DE ESCRIBIR EN EL FICHERO");
            while (true) {                
                         
            System.out.print("Que quieres escribir en el archivo?: ");
            wsFrase = poTeclado.nextLine();
            if ((wsFrase.toLowerCase()).equals("esc") )
                break;
            else
                fw6.write(wsFrase);
            }
            fw6.close();
            
            FileReader fr6 = new FileReader(f6);
             int wi;
             char [] wa = new char[10];
             int i= 0;
            while((wi = fr6.read()) != -1){
               
                wa[i] = (char)wi;
                System.out.print( wa[i] );
                i++;
            }
            fr6.close();
        } catch (Exception e) {
            System.out.println("Error..." +e);
        }
    }// main6Mio
    
    public static void ej1Prueba(){
        try {
            FileWriter fw = new FileWriter("f1.txt");
            fw.write("Esta es la primera línea.\n");
            fw.write("Y ésta es la segunda y última línea.\n");
            fw.close();

        } catch (IOException e) {System.out.println(e);}
        
    }
    public static void ej2Prueba(){
        int wi;
        
        try {
            FileReader frAntiguo = new FileReader("f1.txt");
            FileWriter fw2 = new FileWriter("f2.txt",true);
            while((wi =frAntiguo.read())!= -1){
                String wc = ("" + (char)wi);
                if((wc.equals("ñ") )||(wc.equals("Ñ") ))
                    fw2.write("n");
                else if(wc.equals(" "))
                    fw2.write("");
                else if (wc.equals("á"))
                    fw2.write("a");
                else if (wc.equals("í"))
                    fw2.write("i");
                else if(wc.equals("ó"))
                    fw2.write("o");
                else if(wc.equals("ú"))
                    fw2.write("u");
                else if(wc.equals("é"))
                    fw2.write("e");
                else
                    fw2.write((char)wi);
            }
            frAntiguo.close();
            fw2.close();
        } catch (IOException e) {System.out.println(e); }
    }
}//CV

