
package Ejercicio_13;

public class HConsumidor implements Runnable{
    CDatos datos;
    public HConsumidor(CDatos datos){
        this.datos = datos;
    }//contructor

    @Override
    public void run() {
        String palabraAnalizar = "",palabrasConPalabraClave="";
        while (!palabraAnalizar.equals("$$-/FIN/-$$")) {            
            palabraAnalizar = datos.Consumidor();
            if (palabraAnalizar.contains(datos.getPalabraClave())){
                palabrasConPalabraClave+=", "+palabraAnalizar;
                System.out.println("-----"+palabraAnalizar+" ES UNA PALABRA CLAVE-----");
            }else
                System.out.println("-----"+palabraAnalizar+" NOO!! ES UNA PALABRA CLAVE-----");
        }
        datos.setPalabrasConPalabraClave(palabrasConPalabraClave);
        System.out.println(palabrasConPalabraClave);
    }
}// HConsumidor
