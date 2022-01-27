package Package;
import pqtArrayList2.CAlumno;
import java.util.ArrayList;
import java.util.Scanner;
class $ {public static void $(String is){System.out.println(is);} }

class CAlumno{
	String 	psNombre;	int 	piEdad; 	float 	pfPeso;

	public CAlumno(String isNombre, int iiEdad, float ifPeso) {
		psNombre= isNombre;	piEdad= iiEdad; pfPeso= ifPeso;	}
        
    @Override
    public String toString(){
        return ("Nombre: " +psNombre/*+" Peso: "+pfPeso+" Edad: "+piEdad*/); }
}//CAlumno

public class CArrayList {
	static ArrayList<CAlumno> palAlumnos = new ArrayList<CAlumno>();

	public static void main(String[] args) {
		Scanner woTeclado = new Scanner(System.in);

		boolean wbTerminado = false;
		while(!wbTerminado) {
			$.$("Nombre:"); String wsNombre = woTeclado.nextLine();
			if(wsNombre.contentEquals(""))	wbTerminado = true;

			if(!wbTerminado) {
				$.$("Edad:");int    wiEdad= woTeclado.nextInt();woTeclado.nextLine();
				$.$("Peso:");float  wfPeso= woTeclado.nextInt();woTeclado.nextLine();

				CAlumno woAlumnoNuevo = new CAlumno(wsNombre, wiEdad, wfPeso);
                                palAlumnos.add(woAlumnoNuevo);
                                /*
				if (palAlumnos.size()==0)
					palAlumnos.add(woAlumnoNuevo);
				else{
					boolean wbAniadido = false;
					for(int i=0; i <= palAlumnos.size(); i++){						
						if (palAlumnos.get(i).pfPeso > woAlumnoNuevo.pfPeso){
							palAlumnos.add(i, woAlumnoNuevo);
							wbAniadido = true; break;
						}
					if (!wbAniadido)
						palAlumnos.add(woAlumnoNuevo);
					}
				}*/
			}
		}
		$.$("Todos los alumnos: "+palAlumnos.toString());
                /*
                for (palAlumnos ws: CAlumno){
                    $(ws);
                }*/
	}// main()
}// CMainAlumnos
