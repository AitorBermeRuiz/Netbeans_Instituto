/*
clase Multimedia para almacenar información de los objetos de tipo multimedia (películas, discos, mp3,mp4…).
Esta clase contiene título, autor, formato, y duración como propiedades.
El formato puede ser uno de los siguientes: wav, mp3, midi, avi, mov, mpg, cdAudio y dvd. 
El valor de todos los atributos se pasa por parámetro en el momento de crear el objeto.
Esta clase tiene además, un método para devolver cada uno de los atributos y un método toString() que devuelve la información del objeto.
Por último, un método equals() que recibe un objeto de tipo Multimedia y devuelve true en caso de que el título y
el autor sean iguales y false en caso contrario.

Escribe una clase Película que herede de la clase Multimedia anterior. La clase Película tiene, además de los atributos heredados,
un actor principal y una actriz principal.
Se permite que uno de los dos sea nulo, pero no los dos. --> PENDIENTE
La clase debe tener dos métodos para obtener los nuevos atributos y debe sobreescribir el método toString() para reflejar la nueva
información.

Escribe una clase ListaMultimedia para almacenar objetos de tipo multimedia.
La clase debe tener un atributo, que sea un array de objetos Multimedia y un entero para contar cuantos objetos hay almacenados.
Además, tiene un constructor y los siguientes métodos:
el constructor recibe un entero por parámetro indicando el número máximo de objetos que va a almacenar.
int size(): devuelve el número de objetos que hay en la lista.
boolean add(Multimedia m): añade el objeto al final de la lista, y devuelve true, en caso de que la lista esté llena, devuelve false.
Multimedia get(int position): devuelve el objeto situado en la posición especificada.
String toString(): devuelve la información de los objetos que están en la lista.
//////////////
Escribe una aplicación dónde:
Se cree un objeto de tipo ListaMultimedia de tamaño 10, luego se creen trece películas y se añadan a la lista y por último, se muestre
la lista por pantalla.

A continuación, escribe una clase Disco, que herede de la clase Multimedia ya realizada. La clase Disco tiene, aparte de los elementos heredados,
un atributo para almacenar el género al que pertenece (rock, pop, ópera…). La clase debe tener un método para obtener el nuevo atributo y
debe sobreescribir el método toString() para que devuelva toda la información.
 */
package pqtHerencia;
import java.util.ArrayList;
import static pqt_$.$.$;
import static pqt_$.$.$$;

public class C01Herencia {
    public static void main(String[] args) {
        CListaMultimedia woListaMulti = new CListaMultimedia(2);
        
        CMultimedia woMultimedia01 = new CMultimedia("titulo01", "formato01", "wav", 4);
        CPelicula   woPelicula01 = new CPelicula("titulo01", "formato01", "wav", 4, "jymy", "carla");
        
        woListaMulti.mbAñadir(woMultimedia01);
        woListaMulti.mbAñadir(woPelicula01);
        
        $$(woListaMulti.toString());
        
        
    }// main()
}// C01Herencia

class CMultimedia {
    String psTitulo, psAutor, psFormato;
    int piDuracion;

    public CMultimedia(String isTitulo, String isAutor, String isFormato, int iiDuracion)  {
        if(isFormato.equals("wav")||isFormato.equals("mp3")||isFormato.equals("midi")||isFormato.equals("avi")||
            isFormato.equals("mov")||isFormato.equals("mpg")||isFormato.equals("cdAudio")||isFormato.equals("dvd")) psFormato = isFormato;
        else psFormato = "'formato no válido'";
        psAutor = isAutor; psTitulo = isTitulo; piDuracion = iiDuracion;
    }

    public int    getPiDuracion() {return piDuracion;}
    public String getPsTitulo()   {return psTitulo;}
    public String getPsAutor()    {return psAutor;}
    public String getPsFormato()  {return psFormato;}

    @Override
    public String toString() {
        return "\n--> Título: "+psTitulo+" Autor: "+psAutor+" Formato: "+psFormato+"\nDuración: "+piDuracion;
    }

    static boolean mvEquals(CMultimedia wo){
        if(wo.psTitulo==wo.psAutor)return true;
        else return false;
    }
    
}// CMultimedia

class CPelicula extends CMultimedia {
    String psActor, psActriz;

    CPelicula(String isTitulo, String isAutor, String isFormato, int iiDuracion, String isActor, String isActriz) {
        super(isTitulo, isAutor, isFormato, iiDuracion);
        psActor = isActor; psActriz = isActriz;
    }

    public void setPsActor(String psActor) {
        this.psActor = psActor;
    }

    String getPsActor() {return psActor;}
    String getPsActriz() {return psActriz;}
    
    @Override
    public String toString() {
        return super.toString()+" Actor: "+psActor+" Actriz: "+psActriz+"\n";
    }
    
}// CPelicula

class CListaMultimedia {
    
    ArrayList<CMultimedia> wolMultimedia = new ArrayList<>();
    int piNumObjetosMultimedia = wolMultimedia.size();
    int piNumMaxObj;
    
    public CListaMultimedia(int iiNumMaxObj) {
        piNumMaxObj = iiNumMaxObj;
    }

    public int getPiNumObjetosMultimedia() {return piNumObjetosMultimedia;}
    
    public boolean mbAñadir(CMultimedia wo) {
        if (piNumObjetosMultimedia <= piNumMaxObj) {
            wolMultimedia.add(wo);return true;
        }else
            return false;
    }// mbAñadir()
    
    public String msMultimediaPosicion (int iiPosicion){
        CMultimedia wo = wolMultimedia.get(iiPosicion);
        return wo.toString();
    }// CMultimedia()

    @Override
    public String toString() {
        String wsTodo = "";
        for (CMultimedia ws : wolMultimedia){
            wsTodo += ws.toString();
        }// for
        return wsTodo;
    }// toString()
    
}// CListaMultimedia

//class CDisco extends CMultimedia{ --> No esta hecha pq es sencilla.
/*A continuación, escribe una clase Disco, que herede de la clase Multimedia ya realizada. La clase Disco tiene, aparte de los elementos heredados,
un atributo para almacenar el género al que pertenece (rock, pop, ópera…). La clase debe tener un método para obtener el nuevo atributo y
debe sobreescribir el método toString() para que devuelva toda la información.*/
    
    
//}// CDisco



























//Creamos nuestra propia exception para utilizarla en la clase pelicula
class ExceptionNulls extends Exception {
    public ExceptionNulls(String msg) {
        super(msg);
    }
}// ExceptionNulls