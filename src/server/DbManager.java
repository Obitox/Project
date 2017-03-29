package server;

import client.Player;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbManager {
    private DB db;

    public DbManager(){
        this.db = DB.getInstanca();
    }

    public List<Player> getAllPlayers(){

        String sql= "SELECT * "+
                    "FROM players ";
        ResultSet rs = db.selectUpit(sql);

        List<Player> players = new ArrayList<Player>();
        try{
            while(rs.next()){
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");

                Player player = new Player (id, username, password);

                players.add(player);
            }
        } catch(SQLException e){
            System.out.println("Exception prilikom dohvatanja svih Igraca!");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return players;
    }

    public Player getPlayer(String username, String password){
        Player player = null;
        String sql= "SELECT * " +
                    "FROM players  " +
                    "WHERE username= '"+ username +"' AND password= '"+ password +"'";
        ResultSet rs = db.selectUpit(sql);
        try{
            if(rs.next()){
                int id = rs.getInt("id");

                player = new Player (id, username, password);
            }
        } catch(SQLException e){
            System.out.println("Exception prilikom dohvatanja Igraca!");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return player;
    }

    public Player selectPlayer(int id){
        Player player = null;
        String sql= "SELECT * " +
                    "FROM players  " +
                    "WHERE id=" + id;
        ResultSet rs = db.selectUpit(sql);
        try{
            if(rs.next()){
                String username = rs.getString("username");
                String password = rs.getString("password");

                player = new Player (id, username, password);
            }
        } catch(SQLException e){
            System.out.println("Exception prilikom dohvatanja Igraca!");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return player;
    }

    public boolean updatePlayer(int id, String username, String password) {

        String sql = "UPDATE players " +
                     "SET username='" + username +"', password='"+ password+ "' " +
                     "WHERE id=" + id;

        if(db.uidUpit(sql) > 0) {
            System.out.println("Igrac je uspesno update-ovan u Bazi!");
            return true;
        } else {
            System.out.println("Igrac nije update-ovan u Bazi!");
            return false;
        }
    }

    public boolean createPlayer(String username, String password) {

        String sql = "INSERT INTO players (username, password)" +
                     "VALUES ('" + username +"', '"+ password+ "' )";

        if(db.uidUpit(sql) > 0) {
            System.out.println("Igrac je uspesno kreiran u Bazi!");
            return true;
        } else {
            System.out.println("Igrac nije kreiran u Bazi!");
            return false;
        }
    }

}
