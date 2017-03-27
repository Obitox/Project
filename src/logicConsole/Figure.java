package logicConsole;

/**
 * Created by Vlatacom on 23.3.2017..
 */
public class Figure {
    private static int counter=0;
    private int id;
    private int position;
    private boolean inGame;
    private boolean inParking;

    public Figure(int houseID,int position){
        this.id=((counter++)%4+1)+houseID*10;
        this.position=position;
        this.inGame=false;
        this.inParking=false;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public boolean isInGame() {
        return inGame;
    }

    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }

    public boolean isInParking() {
        return inParking;
    }

    public void setInParking(boolean inParking) {
        this.inParking = inParking;
    }
}
