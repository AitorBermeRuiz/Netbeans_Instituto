/*
Ejercicio Carrera de vehículos.

Se trata de "simular" una carrera en la que participan vehículos de tres tipos, motos, coches y camiones, cada uno de ellos con un conductor.
Del conductor nos va a interesar su nombre y su edad, y de los vehículos, su matrícula y la velocidad a la que está actualmente.

Todos los vehículos pueden arrancar, acelerar, frenar y parar. Todas estas acciones afectan a la velocidad del vehículo incrementando o
decrementando su velocidad de la siguiente forma: 

Acción		Vehículo	Moto 	Coche 	Camion

arrancar 	v=10		
acelerar	v+=5		+20	+10	+5
frenar		v-=5		-8	-9	-10
parar		v=0

Ojo!, en el caso de los coches, si la edad del conductor es mayor de 30, el incremento de la velocidad es de 4 y no de 10. 

De los conductores nos interesa conocer sólo su nombre y su edad.

En el main del programa, crear un coche, una moto y un camión, cada uno con su respectivo conductor.
Luego iniciar una carrera entre los tres, de forma que a cada vehículo se le acelera o frena un número indeterminado de veces,
hasta que se decide parar a cada vehículo. El estado de cada vehículo (su matrícula y velocidad) se irá mostrando cada vez que varíe su velocidad.*/
package pqtHerencia;
import static pqt_$.$.$;
import static pqt_$.$.$$;
import java.util.Scanner;

public class C07Herencia {
    public static void main(String[] args) {
        Scanner woTeclado = new Scanner(System.in);
        
        CConductor1 woConductor01 = new CConductor1("Martín", 11);
        CConductor1 woConductor02 = new CConductor1("Carlos", 22);
        CConductor1 woConductor03 = new CConductor1("Laura", 33);
        
        CMoto1 woMoto01 = new CMoto1("Motoooo", woConductor01);
        CCoche1 woCoche01 = new CCoche1("Coche_22", woConductor02);
        CCoche1 woCoche02 = new CCoche1("Coche_33", woConductor03);
        CCamion1 woCamion01 = new CCamion1("Camión", woConductor03);
        
        $$("CARRERA, enter = continuar");
        while (true){
            woMoto01.mvAcelerar();
            woCoche01.mvAcelerar();
            woCoche02.mvAcelerar();
            woCamion01.mvAcelerar();
            
            woMoto01.mvFrenar();
            woCoche01.mvFrenar();
            woCoche02.mvFrenar();
            woCamion01.mvFrenar();
            
            $$(woMoto01.toString());
            $$(woCoche01.toString());
            $$(woCoche02.toString());
            $$(woCamion01.toString());
            
            String wsWhile = "";
            wsWhile = woTeclado.nextLine();
            if(!wsWhile.equals("")) break;
        }// while
        
    }// main()
}// C07Herencia

abstract class CVehiculo1 {
    String psMatricula;
    int piVelocidad = 0;
    CConductor1 poConductor;

    public CVehiculo1(String isMatricula, CConductor1 ioCConductor) {
        psMatricula = isMatricula; poConductor = ioCConductor;
    }
    
    public void mvArrancar(){
        piVelocidad = 10;
    }// mvArrancar()
    
    public void mvAcelerar(){
        piVelocidad += 5;
    }// mvAcelerar()
    
    public void mvFrenar(){
        piVelocidad -= 5;
    }// mvFrenar()
    
    public void mvParar(){
        piVelocidad = 0;
    }// mvParar()

    @Override
    public String toString() {
        return "Matrícula: "+psMatricula+"\tVelocidad: "+piVelocidad+"\tConductor: ("+poConductor.toString()+")";
    }// toString()
    
    
    
}// CVehiculo1

class CMoto1 extends CVehiculo1{
    public CMoto1(String isMatricula, CConductor1 ioCConductor) {
        super(isMatricula, ioCConductor);
    }
    
    @Override
    public void mvAcelerar(){
        piVelocidad += 20;
    }// mvAcelerar()
    
    @Override
    public void mvFrenar(){
        piVelocidad -= 8;
    }// mvFrenar()
    
}// CMoto1

class CCoche1 extends CVehiculo1{
    public CCoche1(String isMatricula, CConductor1 ioCConductor) {
        super(isMatricula, ioCConductor);
    }
    
    @Override
    public void mvAcelerar(){
        if (poConductor.piEdad>30) piVelocidad += 4;
        else piVelocidad += 10;
    }// mvAcelerar()
    
    @Override
    public void mvFrenar(){
        piVelocidad -= 9;
    }// mvFrenar()
    
}// CCoche1

class CCamion1 extends CVehiculo1{
    public CCamion1(String isMatricula, CConductor1 ioCConductor) {
        super(isMatricula, ioCConductor);
    }

    @Override
    public void mvFrenar(){
        piVelocidad -= 10;
    }// mvFrenar()
    
}// CCamion1

class CConductor1 {
    String psNombre;
    int piEdad;

    public CConductor1(String isNombre, int iiEdad) {
        psNombre = isNombre; piEdad = iiEdad;
    }

    @Override
    public String toString() {
        return "Nombre: "+psNombre+"\tEdad: "+piEdad;
    }// toString()
}// CConductor1