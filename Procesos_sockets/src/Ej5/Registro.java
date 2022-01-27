package Ej5;;

public class Registro {

	public enum Parametros {
		Nombre, Apellido1, Apellido2, NoValido;

		public static Parametros fromInt(int valor) {
			Parametros p;
			switch (valor) {
			case 0:
				p = Nombre;
				break;
			case 1:
				p = Apellido1;
				break;
			case 2:
				p = Apellido2;
				break;
			default:
				p = NoValido;
			}
			return p;
		}
	};

	private String nombre;
	private String apellido1;
	private String apellido2;
	private int edad;

	public Registro(String nombre, String apellido1, String apellido2, int edad) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.edad = edad;
	}

	public Registro(String datos) {
		String[] elementos = datos.split("/");
		this.nombre = elementos[0];
		this.apellido1 = elementos[1];
		this.apellido2 = elementos[2];
		this.edad = Integer.parseInt(elementos[3]);
	}

	public boolean esIgualA(Registro registro) {
		return (nombre.equals(registro.getNombre()) && apellido1.equals(registro.getApellido1())
				&& apellido2.equals(registro.getApellido2()) && edad == registro.getEdad());
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public int getEdad() {
		return edad;
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + " " + apellido1 + " " + apellido2 + ". Edad: " + edad;
	}

	public boolean coincide(Parametros p, String valor) {
		boolean respuesta = false;
		switch (p) {
		case Nombre:
			respuesta = valor.equals(nombre);
			break;
		case Apellido1:
			respuesta = valor.equals(apellido1);
			break;
		case Apellido2:
			respuesta = valor.equals(apellido2);
			break;
		default:
			respuesta = false;
		}
		return respuesta;
	}

}
