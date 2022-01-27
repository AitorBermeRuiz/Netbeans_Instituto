
package asignaciontareasaitorbermejo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Tarea implements Serializable{
    private int id, duracion;
    private Datos datos;
   
    public Tarea(Datos datos) {
        this.datos = datos;
        this.id = datos.getIdTarea();
        this.duracion =(int) Math.floor(Math.random()*3+1);
    }
    public int getId() {
        return id;
    }

    public int getDuracion() {
        return duracion;
    }

    @Override
    public String toString() {
        return "id=" + id + ", duracion=" + duracion;
    }
    
}
