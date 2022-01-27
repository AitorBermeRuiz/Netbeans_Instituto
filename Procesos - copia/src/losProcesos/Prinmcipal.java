package losProcesos;
import java.io.IOException;
import  java.lang.*;
import java.io.*;
/**
 *
 * @author Alumno
 */
public class Prinmcipal {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("ping","8.8.8.8");
        
        try {
            Process xx=pb.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(xx.getInputStream()));
            String mensaje = "";
            while ((mensaje = br.readLine())!=null) {                
                System.out.println(mensaje);
            }
        } catch (IOException IOe) {
        }
    }
}
