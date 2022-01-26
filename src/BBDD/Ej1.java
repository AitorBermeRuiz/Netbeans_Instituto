/*
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
            
            ResultSet rs=st.executeQuery("SELECT * FROM `notas`;");
            while(rs.next()){
                String Mat = rs.getString(1);
                String COD = rs.getString(2);
                int Nota1 = rs.getInt(3);
                int Nota2 = rs.getInt(4);
                int Nota3 = rs.getInt(5);
                int NotaMedia = (Nota1+Nota2+Nota3)/3;
                String x2 = ("INSERT INTO notasfinales VALUES ("rs.getString(1)","rs.getString(2)","NotaMedia");");
                st.executeUpdate(x2);
            }
            
            /*String xx = ("SELECT t4.APEL_NOM,t1.NOMBRE,t4.nota1,t4.nota2,t4.nota3 from asignaturas t1 LEFT JOIN ( select t2.MAT,t2.APEL_NOM,t3.COD,t3.NOTA1,t3.NOTA2,t3.NOTA3 from alumnos t2 join notas t3 on t2.MAT = t3.Mat)t4 on t1.COD = t4.COD");
            rs = st.executeQuery(xx);
            System.out.println("Nombre alumno \t Nombre asignatura  nota1  nota2  nota3");
            while (rs.next()) {   
                
                System.out.println(rs.getString(1)+"\t "+rs.getString(2)+"\t "+rs.getInt(3)+" "+rs.getInt(4)+" "+rs.getInt(5));
            }*/
            st.close();conn.close();
            
            
            
            
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Ej1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}