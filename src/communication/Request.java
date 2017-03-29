package communication;

import client.Player;

import java.io.Serializable;

public class Request implements Serializable{
    private String action;
    private Player player;
    private Object object;
    private int figureMove;
    private int diceValue;

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

    public int getFigureMove() {
        return figureMove;
    }

    public void setFigureMove(int figureMove) {
        this.figureMove = figureMove;
    }

    public int getDiceValue() {
        return diceValue;
    }

    public void setDiceValue(int diceValue) {
        this.diceValue = diceValue;
    }

    @Override
    public String toString() {
        return "Request{" +
                "action='" + action + '\'' +
                ", player=" + player +
                ", object=" + object +
                ", figureMove=" + figureMove +
                ", diceValue=" + diceValue +
                '}';
    }
}
