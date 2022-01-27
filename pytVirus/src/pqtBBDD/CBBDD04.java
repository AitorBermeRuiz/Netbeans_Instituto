/*PreparedStatement
    Las sentencias preparadas permiten la “precompilación” del código SQL antes
    de ser ejecutado, permitiendo consultas o actualizaciones más eficientes.
    En el momento de compilar la sentencia SQL, se analiza cuál es la estrategia
    adecuada según las tablas, las columnas, los índices y las condiciones de
    búsqueda implicados. Este proceso, obviamente, consume tiempo de
    procesador, pero al realizar la compilación una sola vez, se logra mejorar el
    rendimiento en siguientes consultas con valores diferentes.
    Otra ventaja de las sentencias preparadas es que permiten la parametrización:
    la sentencia SQL se escribe una vez, indicando las posiciones de los datos que
    van a cambiar y, cada vez que se utilice, se le proporcionará los argumentos
    necesarios que serán sustituidos en los lugares correspondientes. Los
    parámetros se especifican con el carácter ‘?’.
    Para dar valor a estos parámetros se utilizan los métodos setXXX, de la clase
    PreparedStatement, donde XXX será el tipo de los datos que se asigna al
    parámetro, indicando el número del parámetro (que empieza desde 1) y el valor
    que se va a dar.
    Ejemplo:
        Connection con=DriverManager.getConnection(url, user, password);
        PreparedStatement ps=con.prepareStatement("insert into Autor values (?,?)");
        ps.setInt(1,valor);
        ps.setString(2,valor);
        ps.executeUpdate();*/

package pqtBBDD;
import java.sql.*;

import static pqt_$.$.$;
import static pqt_$.$.$$;

public class CBBDD04 {
    static Connection           poConexion;    
    static PreparedStatement    poPreparada;
    static Statement            poInstruccion;  
    static ResultSet            poTabla;     
    
    public static void main(String args[]){    
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String wsProtocolo_Driver_Pc_Bd = "jdbc:mysql://localhost/Bd01";
            poConexion = DriverManager.getConnection (wsProtocolo_Driver_Pc_Bd,"root","");
            poInstruccion = poConexion.createStatement();

            boolean wb;
            wb = poInstruccion.execute("Drop table if exists tJava;");                       
            wb = poInstruccion.execute("create table tJava (k int, asNb varchar(33));");             
            
            poPreparada = poConexion.prepareStatement("insert into tJava values (?,?)");

            poPreparada.setInt      (1, 101);
            poPreparada.setString   (2, "Registro ciento uno");
            poPreparada.executeUpdate();
            
            poPreparada.setInt      (1, 102);
            poPreparada.setString   (2, "Registro ciento dos");
            poPreparada.executeUpdate();

            
            poTabla= poInstruccion.executeQuery("SELECT k, asNb FROM tJava");
            $$("Codigo\tNombre");
            while(poTabla.next()){
                int wi = poTabla.getInt("k");
                if (wi > 101)
                $$(poTabla.getInt("k")+"\t"+poTabla.getString("asNb"));            
            }
            poPreparada.close(); poTabla.close(); poInstruccion.close(); poConexion.close();
        }
        catch(ClassNotFoundException	e) {$$("- "+e);}
        catch(SQLException 		e) {$$("-- "+e);}
        catch(Exception 		e) {$$("--- "+e);}
        
    }// main()
    
    public static void main2(){        
        try {
            int wi;

            poTabla= poInstruccion.executeQuery("SELECT k, asNb FROM tJava");
            $$("Codigo\tNombre");
            while(poTabla.next()) 
                $$(poTabla.getInt("k")+"\t"+poTabla.getString(2));
        }
        catch(SQLException 		e) {$$(". "+e);}
        catch(Exception 		e) {$$(".. "+e);}
    }// main2()
    
}//CSentenciasPreparadas