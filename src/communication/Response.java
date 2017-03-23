package communication;

import client.Player;

import java.io.Serializable;

public class Response implements Serializable {
    private Object object;
    private Player player;
    private String doneAction;
    private String message;

    public Response(){

    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getDoneAction() {
        return doneAction;
    }

    public void setDoneAction(String doneAction) {
        this.doneAction = doneAction;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Response{" +
                "object=" + object +
                ", player=" + player +
                ", doneAction='" + doneAction + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
