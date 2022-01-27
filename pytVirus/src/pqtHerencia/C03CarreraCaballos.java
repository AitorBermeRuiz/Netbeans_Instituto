/*
class CCaballo
-psNombre
-pfPeso
-piVelocidadActual
-piVelocidadMaxima
-poJockey
+mvAcelerar()
+mvDesAcelerar()

class CJockey
-psNombre
-piEdad
-piNumPremios
*/
package pqtHerencia;
import static pqt_$.$.$;
import static pqt_$.$.$$;
public class C03CarreraCaballos {
    public static void main(String[] args) {
        CJockey  woJockey01  = new CJockey("Juán"  ,11,1);
        CJockey  woJockey02  = new CJockey("María" ,22,2);
        CJockey  woJockey03  = new CJockey("Andrés",33,3);
        
        CPony    woCPony01   = new CPony("Pepito", 245, 200);
        
        CCaballo woCaballo01 = new CCaballo("Bala"  , 111, 110, woJockey01);
        CCaballo woCaballo02 = new CCaballo("Rápido", 112, 150, woJockey02);
        CCaballo woCaballo03 = new CCaballo("Veloz" , 113, 130, woJockey03, woCPony01);
        
        for(int i = 0;i<3;i++){
            woCaballo01.mvAcelerar(20);
            woCPony01.mvAcelerar(25);
            woCaballo02.mvAcelerar(50);
            woCaballo03.mvAcelerar(10);
        }// for
        $$("Caballos:");
        $$(woCaballo01.toString());
        $$(woCaballo02.toString());
        $$(woCaballo03.toString());
        
    }// main()
}// C03CarreraCaballos

class CJockey {
    String psNombre;
    int piEdad, piNumPremios;
    
    public CJockey(String isNombre, int iiEdad, int iiNumPremios){
        psNombre = isNombre; piEdad = iiEdad; piNumPremios = iiNumPremios;
    }
}// CJockey

class CPadreCaballoPoni {
    String  psNombre;
    float   pfPeso;
    int     piVelocidadActual = 0,
            piVelocidadMaxima;
    
    public CPadreCaballoPoni(String isNombre, float ifPeso, int iiVelocidadMaxima){
        psNombre = isNombre; pfPeso = ifPeso; piVelocidadMaxima = iiVelocidadMaxima;
    }
    
    public void mvAcelerar(int wiVelocidad){
        if((piVelocidadActual + wiVelocidad)<=piVelocidadMaxima)
            piVelocidadActual = piVelocidadActual + wiVelocidad;
    }
    
    public void mvDesAcelerar(int wiVelocidad){
        if((piVelocidadActual - wiVelocidad)>=0)
            piVelocidadActual = piVelocidadActual - wiVelocidad;
    }

    @Override
    public String toString() {
        return "Nombre: "+psNombre+" VelocidadActual: "+piVelocidadActual+" Velocidad Máxima: "+piVelocidadMaxima;
    }
    
}// CPadreCaballoPoni

class CCaballo extends CPadreCaballoPoni {
    CJockey poJockey;
    CPony   poPoni;
    
    CCaballo (String isNombre, float ifPeso, int iiVelocidadMaxima, CJockey ioCJockey){
        super(isNombre,ifPeso,iiVelocidadMaxima);
        poJockey = ioCJockey;
    }
    
    CCaballo (String isNombre, float ifPeso, int iiVelocidadMaxima, CJockey ioCJockey, CPony ioPony){
        super(isNombre,ifPeso,iiVelocidadMaxima);
        poJockey = ioCJockey;
        poPoni   = ioPony;
    }

    @Override
    public String toString() {
        return super.toString()+(poPoni!=null?", Poni que lo acompaña: "+poPoni:", No lo acompaña ningún pony");
    }
    
}// CCaballo

class CPony extends CPadreCaballoPoni {
    
    CPony (String isNombre, float ifPeso, int iiVelocidadMaxima){
        super(isNombre, ifPeso, iiVelocidadMaxima);
    }
    
}// CPony