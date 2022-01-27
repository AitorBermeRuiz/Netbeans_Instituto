package practicasocket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Jefe {
    public static void main(String[] args) {
        try {
            @SuppressWarnings("resource")
            ServerSocket sserver = new ServerSocket(15334);
            while (true) {                
               Socket socket = sserver.accept();
               BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
               BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));         

               String frase = br.readLine();
               System.out.println(frase);

               String fraseADevolver = frase +". Mensaje recibido correctamente";
               bw.write(fraseADevolver);
               bw.flush();   
            }
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(Jefe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
