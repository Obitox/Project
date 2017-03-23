package client;

import javafx.scene.paint.Color;

public class Player {
    private int id;
    private String username;
    private String password;
    private Color color;

    public Player(){
    }

    public Player(String username, String password){
        this.id = -1;
        this.username = username;
        this.password = password;
        this.color = null;
    }

    public Player(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Player(int id, String username, String password, Color color){
        this.id = id;
        this.username = username;
        this.password = password;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Color getColor() {
        return color;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", color=" + color +
                '}';
    }
}
