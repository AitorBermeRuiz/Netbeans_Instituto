package Ej2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args) {
		String mensaje = "Nunca entrar�a en un club que me admitiese como socio.";
		int puerto = 15000;
		String direccion = "localhost";
		enviarMensaje(mensaje,direccion,puerto);
	}
	
	private static void enviarMensaje(String mensaje, String direccion, int puerto) {
		byte[] buffer=mensaje.getBytes();
		InetAddress dir = getDireccion(direccion);
		DatagramSocket ds = getSocketParaEnviar();
		if (dir==null || ds==null) {
			System.out.println("Error con la direcci�n o con el socket");
		}
		else {
			DatagramPacket dp=new DatagramPacket(buffer,buffer.length,dir,puerto);
			try {
				ds.send(dp);
			} catch (IOException e) {
				System.out.println("Error de entrada/salida");
			}
		}
	}
	
	
	private static InetAddress getDireccion(String direccion) {
		InetAddress dir;
		try {
			//La direcci�n es la del servidor
			 dir = InetAddress.getByName(direccion);
		} catch (UnknownHostException e) {
			dir=null;
		}
		return dir;
	}
	
	private static DatagramSocket getSocketParaEnviar() {
		DatagramSocket ds;
		try {
			ds=new DatagramSocket();
		} catch (SocketException e) {
			ds=null;
		}
		return ds;
	}
	
	

}
