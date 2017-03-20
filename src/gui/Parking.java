package gui;

import javafx.scene.paint.Color;

/**
 * Created by Vlatacom on 17.3.2017..
 */
public class Parking {
    Field[] fields;
    Color color;
    Color defaultColor;

    public Parking(Color color) {
        this.color = color;
        if(color.equals(Color.RED)){
            defaultColor = Color.rgb(255, 124, 124);
        } else if(color.equals(Color.BLUE)){
            defaultColor = Color.rgb(178, 178, 255);
        } else if(color.equals(Color.GREEN)){
            defaultColor = Color.rgb(168, 255, 168);
        } else {
            defaultColor = Color.LIGHTYELLOW;
        }


    }

    public boolean isFreeToPark(int steps){
        return false;
    }
}
