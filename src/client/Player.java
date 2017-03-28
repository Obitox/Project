package client;

import javafx.scene.paint.Color;

import java.io.Serializable;

public class Player implements Serializable {
    private int id;
    private String username;
    private String password;
    private String color;

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

    public Player(int id, String username, String password, String color){
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

    public String getColor() {
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

    public void setColor(String color) {
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
