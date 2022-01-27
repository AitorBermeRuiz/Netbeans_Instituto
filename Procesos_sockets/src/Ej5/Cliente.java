package Ej5;;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	private static Socket s;
	private static BufferedWriter bw;
	private static BufferedReader br;
	private static Scanner sc;

	public static void main(String[] args) {
		InetAddress direccionServidor = getDireccion("localhost");
		int puerto = 15000;
		s = getSocket(direccionServidor, puerto);
		if (s != null) {
			try {
				sc = new Scanner(System.in);
				bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
				br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				pedirOpcionAlUsuario();

			} catch (IOException e) {
				System.out.println("Error al crear los canales de comunicaci�n.");
			}
		}
	}

	private static void pedirOpcionAlUsuario() {
		boolean opcionValida = false;
		System.out.println("�Qu� deseas hacer? (1=insertar registro, 2=consultar registros)");
		do {
			String opcion = sc.nextLine();
			if (opcion.equals("1")) {
				opcionInsertar();
				opcionValida = true;
			} else if (opcion.equals("2")) {
				opcionConsultar();
				opcionValida = true;
			}
		} while (!opcionValida);
	}

	private static void opcionInsertar() {
		try {
			bw.write("1\n");
			String mensaje = pedirDatosAlUsuario();
			bw.write(mensaje);
			bw.flush();
			s.close();
		} catch (IOException e) {
			System.out.println("Error al enviar el mensaje");
		}
	}

	private static void opcionConsultar() {
		try {
			bw.write("2\n");
			bw.flush();
			String mensaje = pedirDatosDeConsultaAlUsuario();
			bw.write(mensaje+"\n");
			bw.flush();
			// Ahora esperamos una serie de valores hasta recibir fin
			System.out.println("Registros que coinciden:");
			String resultado;
			do {
				resultado = br.readLine();
				if (resultado != "FIN") {
					System.out.println(resultado);
				}
			} while (resultado != "FIN");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static InetAddress getDireccion(String direccion) {
		InetAddress dir;
		try {
			// La direcci�n es la del servidor
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

	// Esta funci�n pide los datos al usuario y prepara el mensaje para mandarlo al
	// servidor
	private static String pedirDatosAlUsuario() {
		System.out.println("Introduce un nombre:");
		String nombre = sc.nextLine();
		System.out.println("Introduce el primer apellido:");
		String apellido1 = sc.nextLine();
		System.out.println("Introduce el segundo apellido:");
		String apellido2 = sc.nextLine();
		System.out.println("Introduce la edad:");
		int edad = -1;
		do {
			try {
				edad = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				// Ha introducido un valor no v�lido
			} finally {
				if (edad < 0)
					System.out.println("Edad no v�lida, introduce un n�mero");
			}
		} while (edad < 0);
		return nombre + "/" + apellido1 + "/" + apellido2 + "/" + edad;
	}

	private static String pedirDatosDeConsultaAlUsuario() {
		System.out.println("�Por qu� valor deseas filtrar? (0=nombre, 1=apellido1, 2=apellido2");
		String parametro = sc.nextLine();
		System.out.println("�Qu� valor deseas buscar?");
		String valor = sc.nextLine();
		return parametro + "/" + valor;
	}

}
