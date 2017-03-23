package communication;

import client.Player;

import java.io.Serializable;

public class Request implements Serializable{
    private String action;
    private Player player;
    private Object object;

    public Request (){

    }

    public Request (String action, Player player){
        super();
        this.action = action;
        this.player = player;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Player getPlayer() {

        return player;
    }

    public void setPlayer(Player player) {

        this.player = player;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "Request{" +
                "action='" + action + '\'' +
                ", player=" + player +
                ", object=" + object +
                '}';
    }
}
