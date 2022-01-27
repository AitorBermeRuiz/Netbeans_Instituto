/* nueva brenchLKJHDFKLH DSAODHF OIU DFS OIDS
Una vez creada la base de datos hacer un programa en Java que cree una nueva
 tabla llamada NotasFinales que tendrá la siguiente estructura:
 NotasFinales(Mat,Cod,NotaMedia);
 Y cuyos valores se sacaran de la tabla Notas.
 Por último se imprimirá un listado de todos los alumnos con el siguiente formato:

 Nombre Alumno Nombre Asignatura Nota1 Nota2 Nota3 NotaMedia
 ------------- -----------------  -      -     -      -
 ------------- -----------------  -      -     -      -
 ------------- -----------------  -      -     -      -
 */
package BBDD;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

public class Ej1 {
    public static void main(String[] args) {
        try {
               System.out.println("hola");
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn =DriverManager.getConnection("jdbc:mysql://localhost/instituto","root","");
            Statement st=conn.createStatement();
            // Creacion de tabla
            String tabla = "CREATE TABLE IF NOT EXISTS notasfinales("
                    + "Mat  VARCHAR(10) NOT NULL," 
                    + "COD  tinyint(2) NOT NULL DEFAULT '0',"
                    + "NotaMedia INT(2) DEFAULT NULL,"
                    + "PRIMARY KEY (Mat,Cod),"
                    + "FOREIGN KEY (Mat)  REFERENCES ALUMNOS (Mat),"
                    + "FOREIGN KEY (COD) REFERENCES  ASIGNATURAS (COD))";
            st.execute(tabla);
            
            Statement st2 = conn.createStatement();
            ResultSet rs=st2.executeQuery("SELECT * FROM notas;");
            Statement st3 = conn.createStatement();
            while(rs.next()){
                String Mat = rs.getString(1);
                String COD = rs.getString(2);
                int Nota1 = rs.getInt(3);
                int Nota2 = rs.getInt(4);
                int Nota3 = rs.getInt(5);
                int NotaMedia = (Nota1+Nota2+Nota3)/3;
                String x2 = "INSERT INTO notasfinales VALUES ('"+Mat+"',"+COD+","+NotaMedia+")";
                st3.executeUpdate(x2);
            }
            
            String xx = ("select t6.APEL_NOM,t5.NOMBRE,t6.nota1, t6.nota2,t6.nota3,t6.notamedia from asignaturas t5 INNER JOIN(select t4.COD,t1.APEL_NOM,t4.NOTA1,t4.NOTA2,t4.NOTA3,t4.notamedia from alumnos t1 join (SELECT t2.*,t3.NotaMedia from notas t2 JOIN notasfinales t3 on t2.COD = t3.COD)t4 on t1.MAT = t4.Mat)t6 on t5.COD = t6.COD;");
            Statement st4 = conn.createStatement();
            rs = st4.executeQuery(xx);
            System.out.println("Nombre alumno Nombre asignatura nota1  nota2  nota3 notamedia");
            while (rs.next()) {   
                
                System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4)+" "+rs.getInt(5)+" "+rs.getInt(6));
            }
            st.close();conn.close();
            
            
            
            
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Ej1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
