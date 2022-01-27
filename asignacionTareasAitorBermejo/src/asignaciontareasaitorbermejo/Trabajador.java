package asignaciontareasaitorbermejo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Trabajador {
            
    public static void main(String[] args) {
        InetAddress direcionServidor = getDireccion("localhost");
        int puerto = 15799,horasTrabajo =40;
        Socket sObj = getSocket(direcionServidor, puerto);
        Socket sMsg = getSocket(direcionServidor, puerto);
        if (sObj != null && sMsg != null){
            try {
                ObjectInputStream ois=new ObjectInputStream(sObj.getInputStream());
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(sMsg.getOutputStream()));
                boolean continuar = true;
                String enviar = "0";//0 Tarea rechazada, 1 Tarea aceptada
                while (continuar) {
                    Tarea tarea2 = (Tarea) ois.readObject();
                    int horasTarea = tarea2.getDuracion();
                    System.out.print(horasTrabajo+",");
                    //Cuando acepte la tarea enviara un 1 si no la acepta enviara un 0 y se comprobara si la tarea denegada es un 1, entonces saldrá del bucle
                    if (horasTrabajo>=horasTarea){
                        horasTrabajo-=horasTarea;
                        enviar = "1";
                    }else{
                        if (horasTarea==1){
                            continuar=false;
                        }
                        enviar="0";
                    }
                    bw.write(enviar+"\n");
                    bw.flush();

                    System.out.println(tarea2.toString()+", "+horasTrabajo);
                }
            } catch (IOException ex) {
                System.out.println("Error al crear los canales de comunicación.");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Trabajador.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        cerrarSocket(sObj);cerrarSocket(sMsg);
        
    }

    private static InetAddress getDireccion(String direccion) {
        InetAddress dir;
        
        try {
            dir = InetAddress.getByName(direccion);
        } catch (UnknownHostException e) {
            dir = null;        
        }
        return dir;
    }

    private static Socket getSocket(InetAddress dir, int puerto) {
        Socket socket;
        try {
            socket = new Socket(dir, puerto);
        } catch (IOException e) {
            socket = null;
        }
        return socket;
    }

    private static void cerrarSocket(Socket s) {
        try {
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(Trabajador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
