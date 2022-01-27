/*7º.Crear un fichero binario llamado Septemp.dat que guarde las temperaturas correspondientes a un día del
     mes de septiembre. La estructura estructura del fichero será: día, hora y temperatura. Los datos
     de dichas temperaturas se sacaran del fichero de texto temperaturas.txt.
  8º.Hacer un programa que lea el fichero SeptGara.dat y calcule la temperatura máxima, la mínima y la media
     del dia indicando cual ha sido la hora mas fría y la mas calurosa. Mostrar los resultados por pantalla.*/
package pqtFileBinarios;
import java.io.*;
import java.util.ArrayList;
import static pqt_$.$.$;
import static pqt_$.$.$$;

public class CFile09BinarioEjercicios {
    
    public static void main(String[] args) throws IOException, EOFException{
        //mvConversionFichero();
        //mvLecturaFichero();
        mvResultados();
    }
    
    static void mvConversionFichero() throws IOException{
        File wf01        = new File("temperaturas.txt");
        FileReader wFr01 = new FileReader(wf01);
        
        File wf02            = new File("temperaturas.dat");
        FileOutputStream fos = new FileOutputStream(wf02);
        DataOutputStream dos = new DataOutputStream(fos);
        
        String wsDiaSemana  = "";
        String wsHora       = "";
        String wsGrados     = "";
        
        int wi;
        int wiNumCampos = 3;
        int wiContador = 0;
        String wsCampo = "";
        
        while ((wi = wFr01.read()) != -1){
            char wc = (char) wi;
            
            if (wc != ';'){
                wsCampo += wc;
                //linea 33, nos permite quitar los saltos de linea que pueda haber en los strings.
                wsCampo = wsCampo.replaceAll(System.getProperty("line.separator"), "");//https://es.stackoverflow.com/questions/192275/como-puedo-eliminar-los-saltos-de-linea-que-me-genera-un-string
            }else{
                wiContador++;
                if (wiContador == 1){
                    wsDiaSemana = wsCampo;
                    wsCampo = "";
                }else if (wiContador == 2){
                    wsHora = wsCampo;
                    wsCampo = "";
                }else if (wiContador == 3){
                    wsGrados = wsCampo;
                    wsCampo = "";
                    wiContador = 0;
                    dos.writeUTF(wsDiaSemana);
                    dos.writeUTF(wsHora);
                    int wiGrados = Integer.parseInt(wsGrados);
                    dos.writeInt(wiGrados);
                }
            }
            
        }// while
    }// mvLecturaFichero()
    
    static void mvLecturaFichero()throws IOException, EOFException{
        File wf02 = new File("temperaturas.dat");
        FileInputStream wfis = new FileInputStream(wf02);
        DataInputStream wdis = new DataInputStream(wfis);
        
        //la excepción la debe de tratar el try, sino da un pequeño error.
        try {
            while (true){
                $(wdis.readUTF());
                $(" "+wdis.readUTF());
                $(" "+wdis.readInt()+"\n");
            }
        } catch (IOException e) {e.getMessage();}
        
    }// mvLecturaFichero()
    
    static void mvResultados() throws IOException, EOFException{
        File wf02 = new File("temperaturas.dat");
        FileInputStream wfis = new FileInputStream(wf02);
        DataInputStream wdis = new DataInputStream(wfis);
        
        //int wi;
        ArrayList<Integer> wi = new ArrayList<>();
        //int wi[] = new int[20];
        
        try {
            int j = 0;
            while (true){
                wdis.readUTF();
                wdis.readUTF();
                wi.add(wdis.readInt());
                j++;
            }
            /*
            for (Integer wi2 : wi){ //el for aquí dentro no funciona, ns pq
                $$(""+wi2); 
            }*/
        } catch (IOException e) {e.getMessage();}
        
        /*for (int i=0; i<wi.size(); i++){
                $(" "+wi.);
        }*/
        /*
        wi.forEach((wi2) -> {
            $$(""+wi2);
        });*/
        for (Integer wi2 : wi){
            $$(""+wi2); 
        }
        
    }// mvResultados()
    
}
