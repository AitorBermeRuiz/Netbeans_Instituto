package fichero_xml_dom;

public class Datos1 {
    private String id,nombre;
    private int nota1,nota2,proyecto,practica;

    public Datos1(String id, String nombre, int nota1, int nota2, int proyecto, int practica) {
        this.id = id;
        this.nombre = nombre;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.proyecto = proyecto;
        this.practica = practica;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNota1() {
        return nota1;
    }

    public int getNota2() {
        return nota2;
    }

    public int getProyecto() {
        return proyecto;
    }

    public int getPractica() {
        return practica;
    }
}
