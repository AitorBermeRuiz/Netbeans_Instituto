package Ej5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import SocketsEjercicio6.Registro.Parametros;


public class Servidor {

	private static ArrayList<Registro> registros;
	//private static Socket socket;
	private static BufferedReader br;
	private static BufferedWriter bw;
	public static void main(String[] args) {
		registros = new ArrayList<Registro>();

		try {
			@SuppressWarnings("resource")
			ServerSocket ssocket = new ServerSocket(15000);
			while (true) {
				Socket socket = ssocket.accept();
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				//Leemos la opci�n elegida por el usuario
				String opcion = br.readLine();
				// 1 = insertar
				if (opcion.equals("1")) {
					opcionInsertar();
				}
				// otro = consultar
				else {
					opcionConsultar();
				}
			}
		} catch (IOException e) {
			System.out.println("Error al crear el socket. �Puerto ocupado?");
		}
	}
	
	
	private static void opcionInsertar() {
		String registroBruto;
		try {
			registroBruto = br.readLine();
			Registro registro = new Registro(registroBruto);
			boolean insertado = insertarRegistro(registro);
			if (insertado) {
				System.out.println("Insertado correctamente. " + registro.toString());
			} else {
				System.out.println("El registro ya existe en la base de datos");
			}
		} catch (IOException e) {
			System.out.println("Problema al leer del socket");
		}
	}

	private static boolean insertarRegistro(Registro registro) {
		boolean exito = true;
		for (int i = 0; i < registros.size() && exito; ++i) {
			if (registro.esIgualA(registros.get(i))) {
				exito = false;
			}
		}
		if (exito) {
			registros.add(registro);
		}
		return exito;
	}
	
	private static void opcionConsultar() {
		try {
			String mensaje = br.readLine();
			String[] elementos = mensaje.split("/");
			Registro.Parametros p = Parametros.fromInt(Integer.parseInt(elementos[0]));
			String valor=elementos[1];
			ArrayList<String> registrosResultado = consultarRegistro(p,valor);
			for (String registro: registrosResultado) {
				bw.write(registro+"\n");
				bw.flush();
			}
			bw.write("FIN");
		} catch (IOException e) {
			System.out.println("Problema al leer del socket");
		}
	}
	
	
	private static ArrayList<String> consultarRegistro(Registro.Parametros p, String valor) {
		ArrayList<String> coincidentes = new ArrayList<String>();
		for (Registro r : registros) {
			if (r.coincide(p, valor)) {
				coincidentes.add(r.toString());
			}
		}
		return coincidentes;
	}

}
