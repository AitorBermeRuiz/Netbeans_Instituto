package asignaciontareasaitorbermejo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {
    public static void main(String[] args) {

        Datos datos = new Datos();
        
         try {
            @SuppressWarnings("resource")
            ServerSocket ssocket = new ServerSocket(15799);
            
            System.out.println("Esperando comunicacion...");
            Socket socketObj = ssocket.accept();
            Socket socketMsg = ssocket.accept();
            ObjectOutputStream oos=new ObjectOutputStream(socketObj.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(socketMsg.getInputStream()));
            System.out.println("Comunicacion realicada!!");
            
            boolean continuar = true;
            while (continuar==true) {
                
                Tarea tarea= new Tarea(datos);
                oos.writeObject(tarea);
                oos.flush();
//Comprueba en el primer if si la tarea es rechazada y si ademas la duración es = a 1 entonces salrá del bucle e irá al metodo grabador
//si no es rechazada la tarea guarda los datos en el arraylist de datos para su posterior grabación
                String respuesta = br.readLine();
                if(respuesta.equals("0")&&tarea.getDuracion()==1){
                    datos.setTareasAceptadas(tarea.toString());
                    continuar=false;
                    grabador(datos);
                }
                if (respuesta.equals("1"))
                   datos.setTareasAceptadas(tarea.toString());
            }
            socketObj.close();socketMsg.close();ssocket.close();

        }catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);}
    }

    private static void grabador(Datos datos) {
        
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("datos_tareas.txt"));
            ArrayList<String>alTareasAceptadas = datos.getTareasAceptadas();
            for (String tarea: alTareasAceptadas){
                bw.write(tarea+"\n");
            }
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
