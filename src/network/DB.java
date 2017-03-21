package network;

import java.sql.Connection;
import java.sql.DriverManager;
public class DB {
    private static DB instance;
    private static final int MAX_CON = 4;
    private static final Connection[] bafer = new Connection[MAX_CON];
    private int first = 0, last = 0, free = MAX_CON;
    private DB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            for (int i = 0; i < MAX_CON; i++) {
                bafer[i] =
                        DriverManager.getConnection("jdbc:mysql://192.168.99.109:3306/ludo", "vlatacom", "123");
                        System.out.println("Connection sucessful");
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());

            e.printStackTrace();
        }
    }

    public static DB getInstance() {
        if (instance == null) {
            instance = new DB();
        }
        return instance;
    }
    public synchronized Connection getConnection() {
        if (free == 0) {
            return null;
        }
        free--;
        Connection con = bafer[first];
        first = (first + 1) % MAX_CON;
        return con;
    }
    public synchronized void putConnection(Connection con) {
        if (con == null) {
            return;
        }
        free++;
        bafer[last] = con;
        last = (last + 1) % MAX_CON;
    }
}
