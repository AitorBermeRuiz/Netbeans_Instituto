package pqtBBDD;
import java.sql.*;
import static pqt_$.$.$;
import static pqt_$.$.$$;

public class CBBDD02 {
    static Connection con;
    static Statement  stmt;
    static ResultSet  rs;
    
    public static void main(String args[]){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url  = "jdbc:mysql://localhost/Bd01";
            String usr  = "root";
            String pswd = "";
            con = DriverManager.getConnection (url,usr,pswd);
            stmt = con.createStatement();
            
            //main2();
            main1();
            
            rs.close(); stmt.close(); con.close();
        }
        catch(ClassNotFoundException	e) {$$("- "+e);}
        //catch(com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException e) {$$("-- "+e);}
        catch(SQLException 		e) {$$("-- "+e);}
        catch(Exception 		e) {$$("--- "+e);}
    }//main()

    public static void main1(){        
        try {
            rs = stmt.executeQuery("SELECT k, asNb FROM tJava;");
            $$("Codigo\tNombre");
            while(rs.next()) 
                $$(rs.getInt(1)+"\t"+ rs.getString("asNb"));
        }
        catch(SQLException 		e) {$$(". "+e);}
        catch(Exception 		e) {$$(".. "+e);}
    }//main1()

    public static void main2(){        
        try {
            boolean wb;
            int wi;
            wb = stmt.execute("Drop table if exists tJava;");           
            wb = stmt.execute("create table tJava (k int, asNb varchar(33));"); 

            wi = stmt.executeUpdate("insert into tJava values (1, 'aaa');");
            wi = stmt.executeUpdate("insert into tJava values (2, 'bbb');");
            wi = stmt.executeUpdate("insert into tJava values (3, 'ccc');");
            wi = stmt.executeUpdate("update tJava set asNb = 'aaaa-dos' where k = 1;");
            wi = stmt.executeUpdate("delete from tJava where (k = 2);");

            rs = stmt.executeQuery("SELECT * FROM tJava");
            $$("Codigo\tNombre");
            while(rs.next()){
                $$(""+rs.getInt(1)+"\t"+rs.getString(2));
            }
        }
        catch(SQLException 		e) {$$(". "+e);}
        catch(Exception 		e) {$$(".. "+e);}
    }//main()

}// CBBDD02