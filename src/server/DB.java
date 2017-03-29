package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.MysqlDataTruncation;

public class DB {
    private Connection conn;
    private static DB instanca;

    private DB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/vlatacom_baza","root","");
            //DriverManager.getConnection("jdbc:mysql://192.168.99.109:3306/vlatacom_baza", "vlatacom", "123");
            System.out.println("Uspesna konekcija!");
        }catch(Exception e){
            System.out.println("Neuspesna konekcija!");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    public static DB getInstanca(){
        if(instanca==null) instanca = new DB();
        return instanca;
    }

    public ResultSet selectUpit(String sql){
        try{
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(sql);
        }catch (Exception e){
            System.err.println("Neuspesan select!");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return null;
        }
    }

    public int uidUpit(String sql){
        try{
            Statement stmt = conn.createStatement();
            return stmt.executeUpdate(sql);
        }catch(MysqlDataTruncation e){
            System.out.println("Prekoracenje opsega u bazi podataka");
            System.out.println("Neuspesan update!");
            return -1;
        }catch(Exception e){
            System.err.println("Neuspesan update!");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return -1;
        }
    }
}
