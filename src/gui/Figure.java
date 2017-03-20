package gui;

import javafx.scene.paint.Color;

/**
 * Created by Vlatacom on 17.3.2017..
 */
public class Figure {
    private static int counter= 0;
    private int id;
    private int position;
    private Color color;


    public Figure(int position, Color c){
        //goes from 1 to 4 BLAGOJE
        id = ++counter;
        this.color = c;
        this.position = position;
    }

    public int getId() {
        return id;
    }


    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Color getColor() {
        return color;
    }


}
