package pqtFileBinarios;
import java.io.*;
import java.util.*;

public class CFile10Serializable {
    public static void main(String[] args) { main4(); }

    public static void main1() {
        // escribir y leer objetos
        CPersona woPersona1=new CPersona("Pablo",20);
        CPersona woPersona2=new CPersona("Rosa",35);
        try{
            File f1 = new File("datos1.obj");
            FileOutputStream    fos= new FileOutputStream   (f1);
            ObjectOutputStream  oos= new ObjectOutputStream (fos);
            oos.writeObject(woPersona1); oos.writeObject(woPersona2);
            oos.close(); fos.close();
        }catch (IOException ex) {System.out.println(ex);}
        try{
            FileInputStream     fis= new FileInputStream    ("datos1.obj");
            ObjectInputStream   ois= new ObjectInputStream  (fis);
            try{
                while(true){                    
///                    CCliente wo=(CCliente)ois.readObject();
                    CPersona wo=(CPersona)ois.readObject();
                    System.out.println("Persona= "+wo);
                }
            }catch(EOFException e){ /* No hay nada que hacer aquí */}
             catch (ClassCastException  ex) {System.out.println(":::::"+ex);}
             catch (ClassNotFoundException  ex) {System.out.println("-----"+ex);}
            ois.close(); fis.close();
        }catch (IOException             ex) {System.out.println(ex);}
    }//main1()    

    public static void main2() {
        // Para probar el transient
        CCliente woCliente = new CCliente("Pepe", "3001284");
        System.out.println("En Memoria - Cliente= "+woCliente);
        try{
            FileOutputStream    fos=new FileOutputStream    ("Cliente.obj");
            ObjectOutputStream  oos=new ObjectOutputStream  (fos);

            oos.writeObject(woCliente); 

            oos.close();fos.close();
            
            FileInputStream     fis=new FileInputStream     ("Cliente.obj");
            ObjectInputStream   ois=new ObjectInputStream   (fis);
            woCliente= (CCliente) ois.readObject();
            System.out.println("En Fichero - Cliente= "+woCliente);
            ois.close(); fis.close();
        }catch (IOException ex)             {System.out.println(ex);}
         catch (ClassNotFoundException ex)  {System.out.println(ex);}
    }//main2()
    
    public static void main3() {
        // Añadir objetos al final del fichero con fichero auxiliar
        try{ //SE CREA EL FICHERO CON 2 REGISTROS
            FileOutputStream    fos= new FileOutputStream   ("datos3.obj");
            ObjectOutputStream  oos= new ObjectOutputStream (fos);
            oos.writeObject(new CPersona("Pepe"  ,40));
            oos.writeObject(new CPersona("Carmen",15));
            oos.close(); fos.close();
        }catch (IOException ex) {System.out.println(ex);}    

        try{ //SE LEE EL FICHERO CON TODOS LOS DATOS
            FileInputStream     fis= new FileInputStream    ("datos3.obj");
            ObjectInputStream   ois= new ObjectInputStream  (fis);
            try{
                while(true) System.out.println("Persona= " + ((CPersona) ois.readObject()));                
            }catch (EOFException            ex) {}
             catch (ClassNotFoundException  ex) {System.out.println(ex);}
            ois.close(); fis.close();
        }catch (IOException ex) {System.out.println(ex);}
        System.out.println("--------");

        
        try{ //SE AÑADEN 2 REGISTROS MÁS USANDO EL PRIMER MÉTODO
            File f1=new File("datos3.obj");
            FileInputStream fis= new FileInputStream(f1);
            ObjectInputStream ois=new ObjectInputStream(fis);

            File f=new File("auxiliar.obj");
            FileOutputStream fos= new FileOutputStream(f);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            
            try{
                while(true){
                    CPersona woPsn=(CPersona)ois.readObject();
                    oos.writeObject(woPsn);
                }
            }catch(EOFException             e) {}
             catch(ClassNotFoundException   e) {System.out.println(e);}            
        
            oos.writeObject(new CPersona("Juan",50));        
            oos.writeObject(new CPersona("Maria",35));

            ois.close(); fis.close();
            oos.close(); fos.close();

            f1.delete(); f.renameTo(f1);

        }catch (IOException ex) {System.out.println(ex);}
        
        try{ //SE LEE EL FICHERO CON TODOS LOS DATOS
            FileInputStream     fis= new FileInputStream    ("datos3.obj");
            ObjectInputStream   ois= new ObjectInputStream  (fis);
            try{
                while(true) System.out.println("Persona= " + ((CPersona) ois.readObject()));                
            }catch (EOFException            ex) {}
             catch (ClassNotFoundException  ex) {System.out.println(ex);}
            ois.close(); fis.close();
        }catch (IOException ex) {System.out.println(ex);}
    }//main3()

    public static void main4() {                       
        //Añadir objetos a un fichero sin añadir cabecera
        
        try{ //SE CREA EL FICHERO CON 2 REGISTROS
            FileOutputStream    fos= new FileOutputStream   ("datos3.obj");// si no ponemos true sobrescribe lo anterior, deja el archivo en blanco
            ObjectOutputStream  oos= new ObjectOutputStream (fos);
            oos.close(); fos.close();
        }catch (IOException ex) {System.out.println(ex);}           
        
        
        try{ //SE LEE EL FICHERO CON TODOS LOS DATOS
            FileInputStream     fis= new FileInputStream    ("datos3.obj");
            ObjectInputStream   ois= new ObjectInputStream  (fis);
            try{
                while(true){
                    CPersona wo = (CPersona) ois.readObject();
                    if(wo instanceof CPersona)  System.out.println("Persona= "+ wo);
                }
            }catch(EOFException e){}
            ois.close(); fis.close();
        }catch (IOException             ex) {System.out.println("123"+ex);}
         catch (ClassNotFoundException  ex) {System.out.println(ex);}
        System.out.println("--------------");

        try{ //SE AÑADEN 2 REGISTROS MÁS USANDO EL SEGUNDO MÉTODO
            FileOutputStream    fos= new FileOutputStream   ("datos3.obj", true);
            ClaseOutput         co = new ClaseOutput        (fos);
            co.writeObject(new CPersona("Pepi",53));
            co.writeObject(new CPersona("Julia",17));
            co.writeObject(new CHombre("ManoloBis",53, 100));
            co.writeObject(new CMujer("MariaBis",17, 77.66f));
            
            co.close(); fos.close();
        }catch (IOException ex) {System.out.println("-133-"+ex);}

        try{ //SE LEE EL FICHERO CON TODOS LOS DATOS
            FileInputStream     fis= new FileInputStream    ("datos3.obj");
            ObjectInputStream   ois= new ObjectInputStream  (fis);
            try{
                while(true){
                    CPersona wo = (CPersona) ois.readObject();
                    ///System.out.println("Persona= "+ wo);
                    
                    if(wo instanceof CHombre)   System.out.println("Hombre = "+ wo);
                    else if(wo instanceof CMujer)    System.out.println("Mujer = "+ wo);
                    else if(wo instanceof CPersona)   System.out.println("Persona = "+ wo);
                }
            }catch(EOFException e){}
            ois.close(); fis.close();
        }catch (IOException             ex) {System.out.println("145"+ex);}
         catch (ClassNotFoundException  ex) {System.out.println(ex);}
    }//main4()    
    
static class CPersona implements Serializable{
    String  psNombre;
    int     piEdad;
    public CPersona(String is,int ii) {psNombre=is; piEdad=ii;}
    void mvCambiarEdad(int ii){piEdad=ii;}
    @Override
    public String toString(){return("Nombre: "+psNombre+" Edad: "+piEdad);}
}//CPersona
static class CHombre extends CPersona implements Serializable{
    int     piPeso;
    public CHombre(String is,int ii, int iiPeso) {super(is, ii); piPeso = iiPeso;}
    @Override
    public String toString(){return(super.toString()+" Peso "+piPeso);}
}//CPersona
static class CMujer extends CPersona implements Serializable{
    float   pfEstatura; 
    public CMujer(String is,int ii, float ifEstatura) {super(is, ii); pfEstatura=ifEstatura;}
    @Override
    public String toString(){return(super.toString()+" Estatura "+pfEstatura);}
}//CPersona
static class CCliente implements Serializable{
                String  psNombre;
    transient   String  psCuenta;
    CCliente(String isNb, String isCta) {psNombre=isNb; psCuenta=isCta;}    
    @Override
    public String toString(){
        String ws = "";
        ws += "Nombre: " + psNombre + "\tCuenta: ";
        if(psCuenta==null) ws+="No disponible"; else ws+=psCuenta;
        return ws;
    }//mvEscribir()
}
static class ClaseOutput extends ObjectOutputStream {
    ClaseOutput(FileOutputStream f)     throws IOException{super(f);}
    @Override
    protected void writeStreamHeader()  throws IOException{}
}
}//CSerializacion





