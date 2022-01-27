/*
Se desea gestionar el correo entrante en una oficina de correos. En la oficina existen varios puestos, con un empleado en cada uno, atendiendo a los clientes
que traen correos a enviar. El proyecto calculará cuanto debe pagar cada cliente para franquear su correo y cuanto ha facturado un puesto.

Para ello se darán de alta las siguientes clases:
Clase Correo
•	Atributos: peso (expresado en gramos. Decimal),
        express (booleano indica si el correo debe enviarse de forma rápida o no),
        dirección ( es la dirección de envío del correo, es una cadena de  caracteres)
•	Constructor de 3 parámetros. 
•	Constructor de 2 parámetros : peso y express. La dirección vale “”. Se debe utilizar el constructor de 3 parámetros.
•	Métodos:
o	toString()
o	esValido() un correo es válido si su dirección tiene información
o	franquearBasico(): devuelve un decimal con el precio básico que debe pagar el cliente al enviar el correo.  Si el correo no es válido devuelve 0€.
        En caso contrario el franqueo son 2.
o	franquear():  si es un correo no express , devuelve franquearBasico(). Si es express, devuelve el doble.

Métodos y atributos deben heredarse en las clases hijas

Clase Carta hija de Correo
•	Atributos: formato(es el tamaño de la carta “A4”, “A5”, .., es una cadena de  caracteres)
•	Constructor de 4 parámetros. 
•	Constructor de 3parámetros : peso, express, formato. La dirección vale “”.
•	Métodos: (los métodos que no se  nombran son los mismos que en la clase Correo)
o	toString()
o	franquearBasico(): devuelve un decimal con el precio básico que debe pagar el cliente al enviar el correo.  Si el correo no es válido devuelve 0€.
        En caso contrario si el formato es “A4” el franqueo son 2€, y cualquier otro formato son 3.5€. Además se le añade una cantidad que corresponde con el 1% del peso.
        Por ejemplo para una carta con los datos [dirección: avenida de la Onu Móstoles, peso : 200gramos, formato: “A5”] el precio será 3.5€ +200*0.01= 5.5€.

Clase Paquete hija de Correo
•	Atributos: volumen (es el tamaño del paquete medido en centímetros cúbicos.  Decimal)
•	Constructor de 4 parámetros. 
•	Constructor de 3 parámetros : peso,  express, volumen. La dirección vale “”.
•	Métodos: (los métodos que no se nombran son los mismos que en la clase Correo)
o	toString()
o	franquearBasico(): devuelve un decimal con el precio básico que debe pagar el cliente al enviar el correo.  Si el correo no es válido devuelve 0€.
        En caso contrario el franqueo es el volumen *0.025 más el 1% del peso.
        Por ejemplo para una paquete con los datos [dirección: avenida de la Onu Móstoles, peso : 200gramos, volumen: 400] el precio será 400*0.025 +200*0.01= 12€.
o	esValido() un paquete es válido si su dirección tiene información y además el volumen es inferior a 500 cm3. No aceptamos paquetes más grandes.

Clase Empleado 
•	Atributos: nombre (Decimal). ListaCorreos : es una lista con todos los correos que ha atendido el empleado ese día
•	Constructor de  parámetro: el nombre. 
•	Métodos: 
o	toString()
o	añadirCorreo(Correo correo): añadir un correo en la lista de correos del empleado
o	hacerCaja(): debe calcular cuanto ha cobrado el empleado con los franqueos del día.

Desde el programa principal:
•	Dar de alta el empleado Pepe Pérez.
•	Pepe atiende a varios clientes que le traen los siguientes correos. Insertarlos en su lista de correos
o	Carta [ peso: 20gr; express: SÍ; dirección: no hay; formato: “A3”]
o	Carta [ peso: 20gr; express: SÍ; dirección: “Avenida de la Onu Móstoles”; formato: “A3”]
o	Carta [ peso: 5gr; express: NO; dirección: “Avenida de la Onu Móstoles”; formato: “A4”]
o	Paquete [peso: 100gr; express: SÍ; dirección: “Gran Vía Madrid”; volumen: 200cm3]
o	Paquete [peso: 100gr; express: NO; dirección: “Gran Vía Madrid”; volumen: 600cm3]
•	Visualizar por pantalla cuánto ha facturado Pepe hoy.
*/
package pqtHerencia;
import static pqt_$.$.$;
import static pqt_$.$.$$;
import java.util.ArrayList;

public class C04Polimorfismo {
    public static void main(String[] args) {
        /*Desde el programa principal:
          •	Dar de alta el empleado Pepe Pérez.
          •	Pepe atiende a varios clientes que le traen los siguientes correos. Insertarlos en su lista de correos
          o	Carta [ peso: 20gr; express: SÍ; dirección: no hay; formato: “A3”]
          o	Carta [ peso: 20gr; express: SÍ; dirección: “Avenida de la Onu Móstoles”; formato: “A3”]
          o	Carta [ peso: 5gr; express: NO; dirección: “Avenida de la Onu Móstoles”; formato: “A4”]
          o	Paquete [peso: 100gr; express: SÍ; dirección: “Gran Vía Madrid”; volumen: 200cm3]
          o	Paquete [peso: 100gr; express: NO; dirección: “Gran Vía Madrid”; volumen: 600cm3]
          •	Visualizar por pantalla cuánto ha facturado Pepe hoy.*/
        
        CEmpleado woEmpleado01 = new CEmpleado("Pepe Pérez");
        CCarta    woCarta01    = new CCarta(20, true, "A4");
        CCarta    woCarta02    = new CCarta(20, true, "Avenida de la Onu Móstoles", "A3");
        CCarta    woCarta03    = new CCarta(5, false, "Avenida de la Onu Móstoles", "A4");
        CPaquete  woCPaquete01 = new CPaquete(100, true, "Gran Vía Madrid", 200);
        CPaquete  woCPaquete02 = new CPaquete(100, false, "Gran Vía Madrid", 600);
        
        woEmpleado01.mvAñadirCorreo(woCarta01);
        woEmpleado01.mvAñadirCorreo(woCarta02);
        woEmpleado01.mvAñadirCorreo(woCarta03);
        woEmpleado01.mvAñadirCorreo(woCPaquete01);
        woEmpleado01.mvAñadirCorreo(woCPaquete02);
        
        $$(""+woEmpleado01.toString());
    }// main()
}// C04Polimorfismo

class CCorreo {
    /*Clase Correo
•	Atributos: peso (expresado en gramos. Decimal),
        express (booleano indica si el correo debe enviarse de forma rápida o no),
        dirección ( es la dirección de envío del correo, es una cadena de  caracteres)
•	Constructor de 3 parámetros. 
•	Constructor de 2 parámetros : peso y express. La dirección vale “”. Se debe utilizar el constructor de 3 parámetros.
•	Métodos:
o	toString()
o	esValido() un correo es válido si su dirección tiene información
o	franquearBasico(): devuelve un decimal con el precio básico que debe pagar el cliente al enviar el correo.
        - Si el correo no es válido devuelve 0€.
        - En caso contrario el franqueo son 2.
o	franquear():  si es un correo no express , devuelve franquearBasico(). Si es express, devuelve el doble.*/
    
    float   pfPeso;//gramos
    boolean pbExpress;
    String  psDireccion = "";
    
    public CCorreo(float ifPeso, boolean ibExpress, String isDireccion) {
        pfPeso = ifPeso; pbExpress = ibExpress; psDireccion = isDireccion;
    }
    
    public CCorreo(float ifPeso, boolean ibExpress) {
        pfPeso = ifPeso; pbExpress = ibExpress;
    }
    
    public boolean mbDireccionValido(){
        if (psDireccion.equals(""))return false;
        else return true;
    }// mbDireccionValido()

    public float mfFranquearBasico() {
        if (mbDireccionValido()) return 2;
        else return 0;
    }// mfFranquearBasico()

    public float mfFranquear() {
        if (pbExpress) return mfFranquearBasico()*2;
        else return mfFranquearBasico();
    }// mfFranquear()

    @Override
    public String toString() {
        String wsDireccion = " No tiene dirección";
        if (psDireccion != null) wsDireccion = "\tDirección: "+psDireccion;
        return "\nPeso(gramos): "+pfPeso+"\tEnvío Express: "+pbExpress+wsDireccion+"\t\tFranqueoPagado: "+mfFranquear();
    }// toString()
    
}// CCorreo

class CCarta extends CCorreo {
/*Clase Carta hija de Correo
•	Atributos: formato(es el tamaño de la carta “A4”, “A5”, .., es una cadena de  caracteres)
•	Constructor de 4 parámetros. 
•	Constructor de 3parámetros : peso, express, formato. La dirección vale “”.
•	Métodos: (los métodos que no se  nombran son los mismos que en la clase Correo)
o	toString()
o	franquearBasico(): devuelve un decimal con el precio básico que debe pagar el cliente al enviar el correo.  Si el correo no es válido devuelve 0€.
        En caso contrario si el formato es “A4” el franqueo son 2€, y cualquier otro formato son 3.5€. Además se le añade una cantidad que corresponde con el 1% del peso.
        Por ejemplo para una carta con los datos [dirección: avenida de la Onu Móstoles, peso : 200gramos, formato: “A5”] el precio será 3.5€ +200*0.01= 5.5€.*/
    
    String psFormato;//A4, A5,...

    public CCarta(float ifPeso, boolean ibExpress, String isDireccion, String isFormato) {
        super(ifPeso, ibExpress, isDireccion);
        psFormato = isFormato;
    }
    
    public CCarta(float ifPeso, boolean ibExpress, String isFormato) {
        super(ifPeso, ibExpress);
        psFormato = isFormato;
    }
    
    @Override
    public float mfFranquearBasico() {
        if (super.mfFranquearBasico()==2){//si me devuelve 2 quiere decir que es válido
            if (psFormato.equals("A4")) {return (float) (2+(pfPeso*0.01));}//1º las comas son los puntos
            else {return (float) (3.5+(pfPeso*0.01));}//2º había que hacerle un casting a float, deduzco que me sacaba muchos decimales ya que me exigía poner un double
        }else return 0;
    }// mfFranquearBasico()
    
    @Override
    public String toString() {
        return super.toString()+"\tFormato: "+psFormato;
    }// toString()
}// CCarta

class CPaquete extends CCorreo {
/*Clase Paquete hija de Correo
•	Atributos: volumen (es el tamaño del paquete medido en centímetros cúbicos.  Decimal)
•	Constructor de 4 parámetros. 
•	Constructor de 3 parámetros : peso,  express, volumen. La dirección vale “”.
•	Métodos: (los métodos que no se nombran son los mismos que en la clase Correo)
o	toString()
o	franquearBasico(): devuelve un decimal con el precio básico que debe pagar el cliente al enviar el correo.  Si el correo no es válido devuelve 0€.
        En caso contrario el franqueo es el volumen *0.025 más el 1% del peso.
        Por ejemplo para una paquete con los datos [dirección: avenida de la Onu Móstoles, peso : 200gramos, volumen: 400] el precio será 400*0.025 +200*0.01= 12€.
o	esValido() un paquete es válido si su dirección tiene información y además el volumen es inferior a 500 cm3. No aceptamos paquetes más grandes.*/

    float pfVolumen;//cm3
    
    public CPaquete(float ifPeso, boolean ibExpress, String isDireccion, float ifVolumen) {
        super(ifPeso, ibExpress, isDireccion);
        pfVolumen = ifVolumen;
    }
    
    public CPaquete(float ifPeso, boolean ibExpress, float ifVolumen) {
        super(ifPeso, ibExpress);
        pfVolumen = ifVolumen;
    }

    @Override
    public String toString() {
        return super.toString()+"\t\tVolumen(cm3): "+pfVolumen;
    }// toString()
    
    @Override
    public float mfFranquearBasico() {
        if (super.mfFranquearBasico()==2){//si me devuelve 2 quiere decir que es válido
            return (float) (pfVolumen*0.025+pfPeso*0.01);
        }else return 0;
    }// mfFranquearBasico()
    
    @Override
    public boolean mbDireccionValido() {
        if(super.mbDireccionValido() && pfVolumen<500) return true;
        else return false;
    }// mbDireccionValido()
    
}// CPaquete

class CEmpleado {
/*Clase Empleado 
•	Atributos: nombre (Decimal). ListaCorreos : es una lista con todos los correos que ha atendido el empleado ese día
•	Constructor de  parámetro: el nombre. 
•	Métodos: 
o	toString()
o	añadirCorreo(Correo correo): añadir un correo en la lista de correos del empleado
o	hacerCaja(): debe calcular cuanto ha cobrado el empleado con los franqueos del día.*/

    String psNombre;
    float pfDineroCobrado;
    ArrayList<CCorreo> polCorreo = new ArrayList<>();

    public CEmpleado(String isNombre) {
        psNombre = isNombre;
    }
    
    public void mvAñadirCorreo(CCorreo io){polCorreo.add(io);}
    
    public float mfCalcularCaja(){
        float wfTotal = 0;
        for (CCorreo ws : polCorreo){
            wfTotal += ws.mfFranquear();
        }// for
        return wfTotal;
    }// mfCalcularCaja()
    
    @Override
    public String toString() {
        String wsCorreos = "";
        for (CCorreo ws : polCorreo){
            wsCorreos += ws.toString();
        }
        return "Nombre: "+psNombre+
             "\nDinero Cobrado: "+mfCalcularCaja()+
             "\nCorreos: "+wsCorreos;
    }// toString()
    
}// CEmpleado