package pqtBBDD;
import java.sql.*;

public class CBBDD01 {
    public static void main(String[] args) {
        
    }// main()
    
    static void mvConnection() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn;
            conn=DriverManager.getConnection("jdbc:mysql://localhost/bbdd","root","");
        }catch(ClassNotFoundException cnfe){
            System.out.println("Driver JBDC no encontrado");
            cnfe.printStackTrace();
        }catch(SQLException sqle){
            System.out.println("Error al conectarse a la BD");
            sqle.printStackTrace();
        }catch(Exception e){
            System.out.println("Error general");
            e.printStackTrace();
        }
    }
    
}// CBBDD01
