/*
v1)
Una BD con dos tablas: 
tCantante(k int, dni string , nombre string)
tCd (k int primary Key, titulo string, xCantante int,  ForeingKey (xCantante) references (tCantante));

Crear las dos tablas en una BD mySql con 3 cantantes y 4 Cd
El Cd X es del cantante Y:
Cd Cantante
1  2
2  2
3  2
4  1

Listar todos los cantantes con los Cd suyos.


V2) 
Un Cd puede contener canciones de varios cantantes.
Cd Cantante

Tendremos entonces Una BD con tres tablas:

tCd (k int primary key, titulo string )
tCantante(k int primary key, dni string , nombre string)
tCdCantante(xCantante int, xCd int, ForeingKey (xCantante) references (tCantante), ForeingKey (xCd) references (tCd)))

xCd         xCantante
1           2
1           1
3           2
4           1
5           1
5           3
5           2
 */
package pqtBBDD;
import java.sql.*;
import java.util.*;
import static pqt_$.$.$;
import static pqt_$.$.$$;

public class CBBDD05ejerCantantes {
    static Connection con;
    static Statement  stmt;
    static ResultSet  res;
    
    public static void main(String[] args) {
        mvConectarBBDD();
        mvCrearTablas();
        mvListarCantantes();
        mvDesConectarBBDD();
    }// main()
    
    static void mvConectarBBDD(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url  = "jdbc:mysql://localhost/Bd01", usr  = "root", pswd = "";
            con = DriverManager.getConnection(url, usr, pswd);
            stmt = con.createStatement();
        }
        catch (ClassNotFoundException e){$$("Exception ClassNotFoundException: "+e.getMessage());}
        catch (SQLException e)          {$$("Exception SQLException: "+e.getMessage());}
        catch (Exception e)             {$$("Exception: "+e.getMessage());}
    }// mvConectarBBDD()
    static void mvDesConectarBBDD(){
        try {
            if(res  != null) res.close();
            if(stmt != null) stmt.close();
            if(con  != null) con.close();
        } catch (SQLException e) {$("Error SQL"+e);}
    }// mvDesConectarBBDD()
    
    static void mvCrearTablas(){
        try {
            //Creamos las tablas y les insertamos los datos
            //INCREIBLE, hay que tener cuidado con que tabla se borra antes, eso o hacer un cascade
            stmt.execute("Drop table if exists tCdCantantes;");
            stmt.execute("Drop table if exists tCds;");
            stmt.execute("Drop table if exists tCantantes;");
            
            stmt.execute("Create table tCantantes ("
                            + "numCantante INTEGER(10) primary key,"
                            + "dni varchar(10),"
                            + "nombre varchar(20)"
                        + ");");
            stmt.execute("Create table tCds ("
                            + "num integer(10) primary key,"
                            + "titulo varchar(20),"
                            + "numCantante integer(10),"//);");
                            + "FOREIGN KEY (numCantante) References tCantantes(numCantante)"
                        + ");");
            stmt.execute("Create table tCdCantantes ("
                            + "cd integer(10),"
                            + "cantante integer(10),"
                            + "FOREIGN KEY (cd) References tCds(num),"
                            + "FOREIGN KEY (cantante) References tCantantes(numCantante)"
                        + ");");
            
            stmt.execute("insert into tcantantes values (01, '1111a', 'carolina');");
            stmt.execute("insert into tcantantes values (02, '2222a', 'marta');");
            stmt.execute("insert into tcantantes values (03, '3333a', 'laura');");
            
            stmt.execute("insert into tcds values (01, 'manga', '02');");
            stmt.execute("insert into tcds values (02, 'rock', '02');");
            stmt.execute("insert into tcds values (03, 'jocker', '02');");
            stmt.execute("insert into tcds values (04, 'rocket', '03');");
            stmt.execute("insert into tcds values (05, 'rambo', '03');");
            
            stmt.execute("insert into tcdcantantes values (01, 02);");
            stmt.execute("insert into tcdcantantes values (01, 01);");
            stmt.execute("insert into tcdcantantes values (03, 02);");
            stmt.execute("insert into tcdcantantes values (04, 01);");
            stmt.execute("insert into tcdcantantes values (05, 01);");
            stmt.execute("insert into tcdcantantes values (05, 03);");
            stmt.execute("insert into tcdcantantes values (05, 02);");
        }
        catch (SQLException e) {$$("Exception SQLException: "+e.getMessage());}
        catch (Exception e)    {$$("Exception: "+e.getMessage());}
    }// mvCrearTablas()
    static void mvListarCantantes(){
        try {
            res = stmt.executeQuery("select * from tcantantes;");
            $$("numCantante\tdni\tnombre");$$("-----------\t---\t------");
            ArrayList<Integer> wi = new ArrayList<>();
            while (res.next()) {
                $$(""+res.getInt(1)+"\t\t"+res.getString(2)+"\t"+res.getString(3));
                wi.add(res.getInt(1));
            }
            $$("");
            for(Integer wii : wi){
                res = stmt.executeQuery("select * from tcds where numCantante = '"+wii+"'");
                $$("Canciones de nº "+wii);
                boolean wb = true;
                while (res.next()){
                    $$(""+res.getInt(1)+"\t\t"+res.getString(2)+"\t"+res.getInt(3));
                    wb = false;
                }
                if(wb)$$("La cantante nº "+wii+" no tiene canciones");
            }// for
            
        } catch (SQLException e) {e.getMessage();}
    }// mvListarCantantes()
}// CBBDD05ejerCantantes

//Create table tCds (num integer,titulo varchar(20),numCantante integer,CONSTRAINT tca_nca_pk PRIMARY KEY (num),CONSTRAINT tca_nca_fk FOREIGN KEY (numCantante) REFERENCES tCantantes(num));