/*
Ejercicio de Alumnos-Asignaturas-Profesores.
============================================
---Versión 1: Desarrollar un programa en Java que defina las clases  
CAlumno, CAsignatura y CProfesor, con las siguientes propiedades: 

CAlumno: psNombre, psApellido1, pdNacimiento, piDni, paoAsignatura, paiNota;
CAsignatura: piCodigo, psNombre, poProfesor, piHorasSemanales;
CProfesor: psNombre, psApellido1, pdNacimiento, piDni, piSueldo, psTitulo;

Y en la clase CAlumnoMain1 crear los alumnos, asignaturas y profesores siguientes:

Pedro, Santana,   03/12/2001, 1234, [Java, Marcas],           [0,0]
María, Ruiz,      04/11/2000, 2345, [Java, Entornos, Marcas], [1,1]
Esther Rodríguez, 05/10/1999, 3456, [Marcas],                 [5]

11, Java, Manuel,     8
22, Marcas, Carolina, 4
33, Entornos, Javier, 3

Manuel, Santana,   01/01/1980, 4567, 1000, Informática
Carolina, Ruiz,    02/02/1981, 5678, 2000, Informática
Javier, Rodríguez, 03/03/1982, 6789, 3000, CiberSeguridad

Luego, imprimir por orden todos los datos de los alumnos, por ejemplo:
Pedro--Santana--03/12/2001--1234--[Java, Marcas]--[0,0]
Se debe comprobar que los nombres y apellidos no sean mayores de 20 caracteres y que los dni no sean superiores al 10000.

---Versión 2: Modificar el programa anterior, para que las asignaturas se guarden en un ArrayList y no en un array.

---Versión 3: Modificar el programa anterior para que los imprima en orden de edad de los alumnos y de los profesores.
 */
package pqtHerencia;
import static pqt_$.$.$;
import static pqt_$.$.$$;

public class C06Herencia {
    public static void main(String[] args) {
        CProfesor woProfesor01 = new CProfesor("Manuel", "Santana", "01/01/1981", 4567, 1000, "Informática");
        CProfesor woProfesor02 = new CProfesor("Carolina", "Ruiz", "02/02/1982", 5678, 2000, "Informática");
        CProfesor woProfesor03 = new CProfesor("Javier", "Rodríguez", "03/03/1983", 6789, 3000, "Informática");
        
        CAsignatura woAsignatura01 = new CAsignatura(11, "Java", woProfesor01, 8);
        CAsignatura woAsignatura02 = new CAsignatura(22, "Marcas", woProfesor02, 4);
        CAsignatura woAsignatura03 = new CAsignatura(33, "Entornos", woProfesor03, 3);
        
        //Antes de crear el alumno hay que crear sus listas de asignaturas y notas
        CAsignatura[] waoAsignaturaAl01 = new CAsignatura[2];
        waoAsignaturaAl01[0] = woAsignatura01;
        waoAsignaturaAl01[1] = woAsignatura02;
        int[] wiNotasAl01 = new int[2];
        wiNotasAl01[0] = 0;
        wiNotasAl01[1] = 0;
        CAlumno woAlumno01 = new CAlumno("Pedro", "Santana", "03/12/2001", 1234, waoAsignaturaAl01, wiNotasAl01);
        
        CAsignatura[] waoAsignaturaAl02 = new CAsignatura[3];
        waoAsignaturaAl02[0] = woAsignatura01;
        waoAsignaturaAl02[1] = woAsignatura03;
        waoAsignaturaAl02[2] = woAsignatura02;
        int[] wiNotasAl02 = new int[3];
        wiNotasAl02[0] = 1;
        wiNotasAl02[1] = 1;
        wiNotasAl02[2] = 3;
        CAlumno woAlumno02 = new CAlumno("Pedro", "Santana", "03/12/2001", 1234, waoAsignaturaAl02, wiNotasAl02);
        
        CAsignatura[] waoAsignaturaAl03 = new CAsignatura[1];
        waoAsignaturaAl03[0] = woAsignatura02;
        int[] wiNotasAl03 = new int[1];
        wiNotasAl03[0] = 5;
        CAlumno woAlumno03 = new CAlumno("Pedro", "Santana", "03/12/2001", 1234, waoAsignaturaAl03, wiNotasAl03);
        
        $$(""+woAlumno01.toString());
        $$(""+woAlumno02.toString());
        $$(""+woAlumno03.toString());
        
    }// main()
}// C06Herencia

class CPersona{
    String psNombre, psApellido, pdNacimiento;
    int piDni;

    public CPersona(String isNombre, String isApellido, String idNacimiento, int iiDni) {
        if(isNombre.length()<=20 && isApellido.length()<=20){
            psNombre = isNombre; psApellido = isApellido; pdNacimiento = idNacimiento; piDni = iiDni;
        }else {psNombre = "ERROR has introducido más de 20 carácteres";}
    }

    @Override
    public String toString() {
        return "Nombre: "+psNombre+"\tApellido: "+psApellido+"\tFechaNacimiento: "+pdNacimiento+"\tDni: "+piDni;
    }// toString()
    
}// CPersona

class CAlumno extends CPersona{
    CAsignatura[] paoAsignatura = new CAsignatura[3];
    int[]           paiNota     = new int[3];

    public CAlumno(String isNombre, String isApellido, String idNacimiento, int iiDni, CAsignatura[] iaoAsignatura, int[] iaiNota) {
        super(isNombre, isApellido, idNacimiento, iiDni); paoAsignatura = iaoAsignatura; paiNota = iaiNota;
    }

    @Override
    public String toString() {
        String ws = "";
        for(int i=0; i<paoAsignatura.length; i++){
            ws += paoAsignatura[i].toString()+": "+paiNota[i];
        }
        return super.toString()+ws;
    }// toString()
    
}// CAlumno

class CProfesor extends CPersona{
    String psTitulo;
    int piSueldo;

    public CProfesor(String isNombre, String isApellido, String idNacimiento, int iiDni, int iiSueldo, String isTitulo) {
        super(isNombre, isApellido, idNacimiento, iiDni); piSueldo = iiSueldo; psTitulo = isTitulo;
    }

    @Override
    public String toString() {
        return super.toString()+" Sueldo: "+piSueldo+" Titulación: "+psTitulo;
    }// toString()
    
}// CProfesor

class CAsignatura {
    int piCodigo, piHorasSemanales;
    String psNombre;
    CProfesor poProfesor;

    public CAsignatura(int iiCodigo, String isNombre, CProfesor ioProfesor, int iiHorasSemanales) {
        piCodigo = iiCodigo; psNombre = isNombre; poProfesor = ioProfesor; piHorasSemanales = iiHorasSemanales;
    }

    @Override
    public String toString() {
        return "\t"+psNombre;
    }// toString()
    
}// CAsignatura

