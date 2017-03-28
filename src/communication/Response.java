package communication;

import client.Player;

import java.io.Serializable;
import java.util.Arrays;

public class Response implements Serializable {
    private int[] table;
    private Player player;
    private String doneAction;
    private String message;

    public Response(){


    }

    public int[] getTable() {
        return table;
    }

    public void setTable(int[] table) {
        this.table = table;
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
                "tabla=" + Arrays.toString(table) +
                ", player=" + player +
                ", doneAction='" + doneAction + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
