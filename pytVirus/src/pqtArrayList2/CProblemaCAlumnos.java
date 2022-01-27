package pqtArrayList2;
import java.util.*;

class CAlumno{
    private String  psNombre;
    private int     piEdad;
    private float   pfPeso;

    public CAlumno(String isNombre, int iiEdad, float ifPeso) {
            psNombre = isNombre; piEdad = iiEdad; pfPeso = ifPeso;	}

    public String   get_sNombre()   {return psNombre;}
    public int      get_iEdad()     {return piEdad;}
    public float    get_fPeso()     {return pfPeso;}

    public void set_sNombre (String isNombre)   {psNombre  = isNombre;}
    public void set_iEdad   (int    iiEdad)     {piEdad    = iiEdad;  }
    public void set_fPeso   (float  ifPeso)     {pfPeso    = ifPeso;  }
}//CAlumno



public class CProblemaCAlumnos {
    private ArrayList<CAlumno> 	palListaAux 	= new ArrayList<CAlumno>();
    private ArrayList<Float> 	palListapfPesos = new ArrayList<Float>();
    private ArrayList<CAlumno> 	palListaFinal 	= new ArrayList<CAlumno>();

    public void mvAniadirAlumno(CAlumno ioAlumno) {
            palListaAux.add		(ioAlumno);
            palListapfPesos.add (ioAlumno.get_fPeso());
    }// mvAniadirAlumno()


    public void mvCrearListadoOrdenado() {
        while(palListaAux.size() > 0) {
            int 	wiIndiceDelMasPequenio = 0;
            float 	wfPesoDelMenor = listapfPesos.get(0);

            for(int i = 0; i < listapfPesos.size(); i++) {
                if(listapfPesos.get(i) < wfPesoDelMenor) {
                    wfPesoDelMenor = listapfPesos.get(i);
                    wiIndiceDelMasPequenio = i;
                }
            }
            palListaFinal.add(palListaAux.get(wiIndiceDelMasPequenio));
            palListaAux.remove(wiIndiceDelMasPequenio);
            listapfPesos.remove(wiIndiceDelMasPequenio);
        }
    }//mvCrearListadoOrdenado()

    public void mvImprimirLista() {
        for(CAlumno i : lista) {
            System.out.println("\n\npsNombre: " + i.getpsNombre());
            System.out.println("piEdad: "       + i.getpiEdad());
            System.out.println("pfPeso: " 	+ i.getpfPeso());
        }
    }//mvImprimirLista()


    public static void main(String[] args) {
            Scanner             woTeclado   = new Scanner(System.in);
            CProblemaCAlumnos   woEjercicio = new CProblemaCAlumnos();

            boolean wbTerminado = false;
            while(!wbTerminado) {
                    System.out.println("**NUEVO CAlumno**");
                    System.out.println("DIME EL psNombre DEL CAlumno:");
                    String wsNombre = woTeclado.nextLine();

                    if(wsNombre.contentEquals(""))
                            wbTerminado = true;

                    if(!wbTerminado) {
                            System.out.println("DIME LA piEdad DEL CAlumno:");
                            int wiEdad = woTeclado.nextInt();woTeclado.nextLine();
                            System.out.println("DIME EL pfPeso DEL CAlumno:");
                            float wfPeso = woTeclado.nextInt();woTeclado.nextLine();
                            System.out.println();
                            woTeclado.nextLine();

                            CAlumno woAlumno = new CAlumno(wsNombre, wiEdad, wfPeso);
                            woEjercicio.mvAniadirAlumno(woAlumno);
                    }
            }

            woEjercicio.mvCrearListadoOrdenado();
            woEjercicio.mvImprimirLista();
            woTeclado.close();
    }//main()

}//CProblemaCAlumnos
