package gui;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Created by Vlatacom on 17.3.2017..
 */
public class Field {
    private static int counter = 0;
    private int id = 0;
    private Color color;
    Circle  fieldShape;
    public static final Color defaultColor = Color.BLACK;;

    public Field(Circle circle){
        id = counter++;
        color = defaultColor;
        this.fieldShape = circle;
    }

    public int getId() {
        return id;
    }

    public Circle getFieldShape() {
        return fieldShape;
    }


    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
