package server;

import client.Player;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbManager {

    public DbManager(){
    }

    public List<Player> getAllPlayers(){
        DB db = DB.getInstanca();

        String sql= "SELECT * "+
                    "FROM players ";
        ResultSet rs = db.selectUpit(sql);

        List<Player> players = new ArrayList<Player>();
        try{
            while(rs.next()){
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("pass");

                Player player = new Player (id, username, password);

                players.add(player);
            }
        } catch(SQLException e){
            System.out.println("Exception prilikom dohvatanja svih Igraca!");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return players;
    }

    public Player selectPlayer(int id){
        Player player = null;
        DB db = DB.getInstanca();
        String sql= "SELECT * " +
                    "FROM players  " +
                    "WHERE id=" + id;
        ResultSet rs = db.selectUpit(sql);
        try{
            if(rs.next()){
                String username = rs.getString("username");
                String password = rs.getString("pass");

                player = new Player (id, username, password);
            }
        } catch(SQLException e){
            System.out.println("Exception prilikom dohvatanja Igraca!");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return player;
    }

//    public boolean book(int id, String klijent, String datum) throws BookingException {
//        DB db = DB.getInstanca();
//        Soba soba = selectSoba(id);
//        if(soba.getKlijent() != null){
//            throw new BookingException("Soba je vec bukirana!");
//        }
//
//        String sql = "UPDATE sobe " +
//                "SET klijent='" + klijent +"', datum='"+ datum + "' " +
//                "WHERE id=" + id;
//
//        if(db.uidUpit(sql) > 0) {
//            System.out.println("Soba je uspesno update-ovana u Bazi!");
//            return true;
//        } else {
//            System.out.println("Soba je nije update-ovana u Bazi!");
//            return false;
//        }
//    }
//
//    public boolean cancelBooking(int id) throws CancelBookingException{
//        DB db = DB.getInstanca();
//        Soba soba = selectSoba(id);
//        if(soba.getKlijent() == null){
//            throw new CancelBookingException("Soba je vec otkazana!");
//        }
//        String sql = "UPDATE sobe " +
//                "SET klijent=" + null +", datum="+ null + " " +
//                "WHERE id=" + id;
//        if(db.uidUpit(sql) > 0) {
//            System.out.println("Soba je uspesno update-ovana u Bazi!");
//            return true;
//        } else {
//            System.out.println("Soba je nije update-ovana u Bazi!");
//            return false;
//        }
//    }

}
