import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		int[] numeros = pedirNumerosAlUsuario();
		ArrayList<Integer>[] divisores = calcularDivisores(numeros);
		int mcd = calcularMCD(divisores);
		int mcm = calcularMCM(numeros);

		System.out.println("El MCD es: " + mcd);
		System.out.println("El MCM es: " + mcm);

	}

	private static int[] pedirNumerosAlUsuario() {
		Scanner sc = new Scanner(System.in);
		System.out.println("¿Cuántos números quieres introducir?");
		int cantidadDeNumeros = sc.nextInt();
		int[] numeros = new int[cantidadDeNumeros];
		for (int i = 0; i < numeros.length; ++i) {
			System.out.println("Introduce el siguiente número:");
			numeros[i] = sc.nextInt();
		}
		return numeros;
	}

	private static ArrayList<Integer>[] calcularDivisores(int[] numeros) {
		ArrayList<Integer>[] divisores = new ArrayList[numeros.length];
		for (int i = 0; i < numeros.length; ++i) {
			divisores[i] = calcularDivisoresDeUnNumero(numeros[i]);
		}
		return divisores;
	}
	

	private static ArrayList<Integer> calcularDivisoresDeUnNumero(int numero) {
		ArrayList<Integer> divisores = new ArrayList<Integer>();
		for (int i = 1; i <= numero; ++i) {
			if (numero % i == 0)
				divisores.add(i);
		}
		return divisores;
	}

	private static int calcularMCD(ArrayList<Integer>[] divisores) {
		int mcd = 1;
		// Recorremos de mayor a menor todos los divisores del primer número
		for (int i = divisores[0].size() - 1; i > 0 && mcd == 1; --i) {
			// El primer divisor que esté en todas las listas de divisores
			// es el mcd
			if (buscarNumeroEnListas(divisores[0].get(i), divisores)) {
				mcd = divisores[0].get(i);
			}
		}
		return mcd;
	}

	private static boolean buscarNumeroEnListas(int numero, ArrayList<Integer>[] listas) {
		boolean esComun = true;
		for (int i = 1; i < listas.length && esComun; ++i) {
			if (listas[i].indexOf(numero) < 0) {
				// El divisor no está en la lista de j: el número
				// no puede ser el mcd
				esComun = false;
			}
		}
		return esComun;
	}

	private static int calcularMCM(int[] numeros) {
		// Primero buscamos el mayor de todos
		int maximo = buscarElMayor(numeros);
		// Después vamos calculando múltiplos suyos y comprobamos si son
		// múltiplos de todos los demás
		int mcm = 0;
		int contador = 1;
		while (mcm == 0) {
			int multiplo = maximo * contador;
			if (esMultiploDeTodos(multiplo, numeros)) {
				mcm = multiplo;
			}
			++contador;
		}
		return mcm;
	}

	private static int buscarElMayor(int[] numeros) {
		int maximo = 0;
		for (int i = 0; i < numeros.length; ++i) {
			if (numeros[i] > maximo) {
				maximo = numeros[i];
			}
		}
		return maximo;
	}

	private static boolean esMultiploDeTodos(int numero, int[] lista) {
		boolean respuesta = true;
		for (int i = 0; i < lista.length && respuesta; ++i) {
			if (numero % lista[i] != 0) {
				respuesta = false;
			}
		}
		return respuesta;
	}

}
