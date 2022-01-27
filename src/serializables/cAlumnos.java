package serializables;

import java.io.Serializable;

public class cAlumnos implements Serializable{
    String dni,nombre;
    int edad;

    public cAlumnos(String dni, String nombre, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }


    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "cAlumnos{" + "dni=" + dni + ", nombre=" + nombre +", Edad: "+edad+ '}';
    }
    
    
}
