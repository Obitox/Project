package gui;

import javafx.scene.paint.Color;

/**
 * Created by Vlatacom on 17.3.2017..
 */
public class Parking {
    Field[] fields;
    Color color;

    public Parking(Color color) {
        this.color = color;


    }

    public boolean isFreeToPark(int steps){
        return false;
    }
}
