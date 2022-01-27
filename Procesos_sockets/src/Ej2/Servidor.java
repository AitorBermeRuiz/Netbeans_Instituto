package Ej2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Servidor {

	public static void main(String[] args) {
		int puerto=15000;
		byte[] mensaje=recibirMensaje(puerto);
		if (mensaje==null) {
			System.out.println("Ha habido un error en la recepci�n del mensaje");
		}
		else {
			procesarMensaje(mensaje);
		}
	}
	
	private static byte[] recibirMensaje(int puerto) {
		byte[] buffer;
		DatagramSocket ds = getSocketParaRecibir(puerto);
		if (ds==null) {
			buffer=null;
			System.out.println("Error en la creaci�n del socket");
		}
		else {
			//Elegimos una longitud arbitraria: se supone que en esa longitud tiene que caber el mensaje del cliente.
			buffer = new byte[100];
			DatagramPacket dp = new DatagramPacket(buffer,buffer.length);
			try {
				ds.receive(dp);
			} catch (IOException e) {
				buffer = null;
			}
			
		}
		return buffer;
	}
	
	
	private static DatagramSocket getSocketParaRecibir(int puerto) {
		DatagramSocket ds;
		try {
			ds=new DatagramSocket(puerto);
		} catch (SocketException e) {
			ds=null;
		}
		return ds;
	}
	
	
	private static void procesarMensaje(byte[] mensaje) {
		//byte[] mensajeLimpio = limpiarVacios(mensaje);	
		//String cadena = new String(mensajeLimpio);
		//otra forma:
		String cadena = new String(mensaje).trim();
		//Ahora se analiza el mensaje de acuerdo a lo que indica el enunciado
		System.out.println("Longitud del mensaje: "+cadena.length());
		System.out.println("N�mero de palabras: "+cadena.split(" ").length);
		char primerCaracter = Character.toLowerCase(cadena.charAt(0));
		if (caracterEstaEnCadena(primerCaracter,"aeiou")) {
			System.out.println("El texto empieza por vocal");
		}
		else {
			System.out.println("El texto empieza por consonante");
		}
		if (primerCaracter==cadena.charAt(0)) {
			System.out.println("El texto empieza por min�scula");
		}
		else {
			System.out.println("El texto empieza por may�scula");
		}
	}
	
	private static boolean caracterEstaEnCadena(char caracter, String cadena) {
		boolean encontrado=false;
		for (int i=0;i<cadena.length()&&!encontrado;++i) {
			if (cadena.charAt(i)==caracter) encontrado=true;
		}
		return encontrado;
	}
	
	//Esta ser�a una forma artensanal de hacerlo. La funci�n trim() hace lo mismo sobre un String
	/*private static byte[] limpiarVacios(byte[] mensaje) {
		//Buscamos el �ltimo 0
		int posUltimoCero=0;
		boolean salir=false;
		for (int i=mensaje.length;i>=0 && !salir;--i) {
			if (mensaje[i]!=0) {
				posUltimoCero=i+1;
				salir=true;
			}
		}
		//Rellenamos un array nuevo
		byte[] mensajeLimpio=new byte[posUltimoCero];
		for (int i=0;i<mensajeLimpio.length;++i) {
			mensajeLimpio[i]=mensaje[i];
		}
		return mensajeLimpio;
	}*/

}
