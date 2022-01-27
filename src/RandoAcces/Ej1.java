/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RandoAcces;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ej1 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File f=new File("registros.dat");
        Scanner teclado = new Scanner(System.in);
        
        RandomAccessFile raf=new RandomAccessFile(f,"rw");
        int c;
        System.out.println("Introducir cantidad de registros a crear ");
        c=teclado.nextInt();
        for(int i=1;i<=c;i++){
            raf.writeInt(i);
            for(int j=1;j<=i;j++)
              raf.writeDouble(Math.random()*10);
        }   
            
       raf.seek(0);
       int n;
       try{
           while(true){
             n=raf.readInt();
             System.out.print(n+": ");
             for(int i=1;i<=n;i++)
                 System.out.print(raf.readDouble()+" ");
               System.out.println();
           }
       }catch(EOFException e){}
       int pos;  
       do{
           System.out.println("Introducir numero de registro a mostrar (1,"+c+")");
           pos=teclado.nextInt();
       }while(pos<1 || pos>c);
       
       int suma=0;
       
       for(int i=1;i<pos;i++)
         suma=suma+i;
       
       long salto=(pos-1)*4+suma*8;
       
       System.out.println(pos+" "+suma+" "+salto);
       
       raf.seek(0); 
       raf.seek(salto);
       
       n=raf.readInt();
       
       System.out.print(n+" ");
       
       for(int i=1;i<=n;i++)
       System.out.print(raf.readDouble()+" ");
       
       
       
        raf.close();
            
        }
    }
  


