
package practicasocket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Trabajador {
    public static void main(String[] args) {
        InetAddress direcionServidor = obtenerDirServidor("localhost");
        int puerto = 15334;
        try {
            Socket s = new Socket(direcionServidor,puerto);
            
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            
            String frase = "Hola caraculo. Me recibes¿?¿?";
            
            bw.write(frase);
            bw.flush();
            String recibido = br.readLine();
            
            System.out.println(recibido);
        } catch (IOException ex) {
            Logger.getLogger(Trabajador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static InetAddress obtenerDirServidor(String direccion){
       InetAddress dir;
        try {
            dir = InetAddress.getByName(direccion);
        } catch (UnknownHostException ex) {
            dir = null;
        }
        return dir;
    }
}
