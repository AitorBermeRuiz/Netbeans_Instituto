/*Simular una carrera de vehículos creando 3 vehículos con sus respectivos conductores. Uno de los
  vehículos será una moto, otro un coche y el tercero un camión. Hay que cargar los tres
  vehículos en un ArrayList llamado "Carrera".
  
  Para los vehículos se utilizará una clase CVehiculo y para los conductores la clase CConductor.
  La clase Conductor contendrá el nombre del conductor, su edad y el número de puntos que posee.

  La clase CVehiculo contendrá su matrícula (String), la velocidad a la que se mueve y el conductor 
  que lo conduce. También tendrá el método "acelerar" para aumentar la velocidad en una cantidad de
  km/h que se le pase en la llamada y otro "frenar" para disminuir la velocidad en otra cantidad
  de km/h que también se le pasará en la llamada.

  La velocidad máxima a la que se puede circular es de 120 km/h.

  Para probar el programa, se introducirán los datos "a capón", aunque luego se puedan introducir 
  por teclado.

  -Antes de comenzar la carrera con los tres vehículos, se crearán y asignarán los conductores 
  "Juan" la moto, "María" el coche y "Andrés" el camión.

  -Una vez comenzada, aceleran todos 20 km/h, y luego todos frenan 10 km/h. Este proceso se 
   repite 3 veces.

  -La moto acelera exactamente la cantidad que se le pide.
  -El coche, acelera el doble de lo que se le pide más una cantidad fija de 2 km/h.
  -El camión acelera la mitade de lo que se le pide.
  -Todos frenan la cantidad que se les ordena.
  -Deben utilizarse tres métodos distintos "acelerar" con códigos diferentes.

  -Finalmente, se mostrarán las velocidades finales de los tres vehículos, sus matrículas y el
   nombre de sus conductores.
  -Utilizar el polimorfismo para resolver este problema.*/

package pqtHerencia;
import java.util.ArrayList;
import java.util.Scanner;

public class C02CarreraVehiculos {
    public static void main(String[] args) {
        
        ArrayList<CVehiculo> wloVehiculos = new ArrayList<>();
        Scanner woTeclado = new Scanner(System.in);
        
		CConductor woCo1 = new CConductor("Juan",   29, 9);
		CConductor woCo2 = new CConductor("Maria",  21, 12);
		CConductor woCo3 = new CConductor("Andres", 23, 5);
        
        
        for(int i = 0; i<3; i++){
            System.out.print("Tipo (Moto/Coche/Camion: "); String wsTipo= woTeclado.nextLine();
            System.out.print("Matrícula: "); String wsMatricula 		= woTeclado.nextLine();
            System.out.print("Velocidad: "); int 	 wiVelocidad 		= woTeclado.nextInt(); woTeclado.nextLine();
            
			if (wsTipo.equals("Moto" )){CMoto woMoto      = new CMoto(wsMatricula, wiVelocidad, woCo1);
										wloVehiculos.add(woMoto);} 
			if (wsTipo.equals("Coche")){CCoche woCoche    = new CCoche(wsMatricula, wiVelocidad, woCo2);
										wloVehiculos.add(woCoche);} 
			if (wsTipo.equals("Camion")){CCamion woCamion = new CCamion(wsMatricula, wiVelocidad, woCo3);
										wloVehiculos.add(woCamion);}								
        } //for
		
		//Acelerar(+20) y frenar(-10) x3; aqui utiliza el polimorfidmo en el segundo for
        for(int i = 0; i<3;i++){         
            int wiAc = 20;
            int wiFre = 10;         
			
			//polimorfismo
			for(CVehiculo wo : wloVehiculos){                
                wo.mvAcelerar(20);
                wo.mvFrenar(10);
            }
		}                
        
        //Mostrar datos
        for(CVehiculo wo : wloVehiculos){
            System.out.println(wo.toString()); 
        }// for
        
    }// main()
    
} //class EXT2_Carrera

class CConductor{ String psNombre; int piEdad; int piPuntos;

    public CConductor(String isNombre, int iiEdad, int iiPuntos) {
        psNombre = isNombre; piEdad = iiEdad; piPuntos = iiPuntos; }		

    @Override
    public String toString(){
        return ("Nombre: " + psNombre + " - Edad: " + piEdad + " - Puntos: " + piPuntos); }
    
} // CConductor

abstract class CVehiculo{ String psMatricula; int piVelocidad; CConductor poConductor;

    public CVehiculo(String isMatricula, int iiVelocidad, CConductor ioConductor) {
        psMatricula = isMatricula; piVelocidad = iiVelocidad; poConductor = ioConductor; }

    @Override
    public String toString(){
        return ("Matricula: "+psMatricula+"\nVelocidad: "+piVelocidad+"\nConductor"+poConductor); }

    public void mvAcelerar(int iiAceleracion){
		piVelocidad = (piVelocidad + iiAceleracion < 120) ? piVelocidad + iiAceleracion : 120; }

    public void mvFrenar(int iiFrenado){
		piVelocidad = (piVelocidad - iiFrenado > 0) ? piVelocidad - iiFrenado : 0; }
		
} // CVehiculo

class CMoto extends CVehiculo{

    public CMoto(String psMatricula, int piVelocidad, CConductor poConductor) {
        super(psMatricula, piVelocidad, poConductor); }   
    
}// CMoto()

class CCoche extends CVehiculo{

    public CCoche(String isMatricula, int iiVelocidad, CConductor ioConductor) {
        super(isMatricula, iiVelocidad, ioConductor); }

	@Override 
    public void mvAcelerar(int iiAceleracion){
		int wiIncremento = 2*iiAceleracion + 2;
		super.mvAcelerar(wiIncremento); }
    
}// CCoche()

class CCamion extends CVehiculo{


    public CCamion(String isMatricula, int iiVelocidad, CConductor ioConductor) {
        super(isMatricula, iiVelocidad, ioConductor); }

	@Override 
    public void mvAcelerar(int iiAceleracion){
		int wiIncremento = (int) (iiAceleracion/2) ;
		super.mvAcelerar(wiIncremento); }
    
}// CCamion


