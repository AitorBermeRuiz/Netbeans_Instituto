package asignaciontareasaitorbermejo;

import java.io.Serializable;
import java.util.ArrayList;

public class Datos implements Serializable{
   private int idTarea = 0;
   private ArrayList<String>tareasAceptadas = new ArrayList<>();

    public int getIdTarea() {
        int aux = idTarea;
        ++idTarea;
        return aux;
    }

    public ArrayList<String> getTareasAceptadas() {
        return tareasAceptadas;
    }

    public void setTareasAceptadas(String tareaString) {
        this.tareasAceptadas.add(tareaString);
    }
    
   
}
