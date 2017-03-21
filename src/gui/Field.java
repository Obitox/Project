package gui;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Field extends Circle {
    public static final Color defaultColor = Color.BLACK;
    private static int counter = 0;

    private int id = 0;
    private Color color;
    private Circle  fieldShape;


    public Field(){
        id = counter++;
        color = defaultColor;
        this.setRadius(25);
    }

    public int getFieldId() {
        return id;
    }

    public void setColor(Color color) {
        this.setFill(color);
    }
    public Color getColor() {
        return color;
    }

    public boolean isTaken(){
        if(color!=defaultColor) {
            return false;
        }else{
            return true;
        }
    }
}
