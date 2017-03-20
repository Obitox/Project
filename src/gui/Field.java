package gui;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Field {
    public static final Color defaultColor = Color.BLACK;
    private static int counter = 0;

    private int id = 0;
    private Color color;
    private Circle  fieldShape;


    public Field(Circle circle){
        id = counter++;
        color = defaultColor;
        this.fieldShape = circle;
    }

    public int getId() {
        return id;
    }

    public void setColor(Color color) {
        this.fieldShape.setFill(color);
    }
    public Color getColor() {
        return color;
    }

    public Circle getFieldShape() {
        return fieldShape;
    }

    public boolean isTaken(){
        if(color!=defaultColor) {
            return false;
        }else{
            return true;
        }
    }
}
