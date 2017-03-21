package communication;

import java.io.Serializable;

public class Request implements Serializable{
    private boolean isLogIn;
    private boolean isUpdated;

    private Player player;

    public Request (){

    }

    public boolean isLogIn() {
        return isLogIn;
    }

    public boolean isUpdated() {
        return isUpdated;
    }

    public Player getPlayer() {
        return player;
    }

    public void setLogIn(boolean logIn) {
        isLogIn = logIn;
    }

    public void setUpdated(boolean updated) {
        isUpdated = updated;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
