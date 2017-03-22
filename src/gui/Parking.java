package gui;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * Created by Vlatacom on 17.3.2017..
 */
public class Parking {
    Field[] fields = new Field[4];
    Color color;
    Color defaultColor;
    Pane pane;



    public Parking(Color color,Pane pane) {
        this.color = color;
        this.pane = pane;
       //if(color.equals(Color.RED)){
       //    defaultColor = Color.rgb(255, 124, 124);
       //} else if(color.equals(Color.BLUE)){
       //    defaultColor = Color.rgb(178, 178, 255);
       //} else if(color.equals(Color.GREEN)){
       //    defaultColor = Color.rgb(168, 255, 168);
       //} else {
       //    defaultColor = Color.LIGHTYELLOW;
       //}
        initParkingFields(color);


    }

    public boolean isFreeToPark(int steps){
        return false;
    }

    public void initParkingFields(Color color)
    {
        int parkingTemp =0;
        int colorChanger =0;
        double opacityChanger = 1.0;
        for (int i=0;i<fields.length;i++)
        {
            if(color.equals(Color.YELLOW)){
                parkingTemp +=60;
                fields[i] = new Field();
                fields[i].setCenterY(120);
                fields[i].setCenterX(60+ parkingTemp);
                fields[i].setColor(color);
                pane.getChildren().add(fields[i]);
            } else if(color.equals(Color.RED)){
                parkingTemp +=60;
                fields[i] = new Field();
                fields[i].setCenterY(60+ parkingTemp);
                fields[i].setCenterX(600);
                fields[i].setColor(color);
                pane.getChildren().add(fields[i]);
            } else if(color.equals(Color.BLUE)){
                parkingTemp +=60;
                fields[i] = new Field();
                fields[i].setCenterY(600);
                fields[i].setCenterX(660- parkingTemp);
                fields[i].setColor(color);
                pane.getChildren().add(fields[i]);
            } else {
                parkingTemp +=60;
                fields[i] = new Field();
                fields[i].setCenterY(660- parkingTemp);
                fields[i].setCenterX(120);
                fields[i].setColor(color);
                pane.getChildren().add(fields[i]);
            }
        }
    }
}
