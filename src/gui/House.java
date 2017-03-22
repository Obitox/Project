package gui;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * Created by Vlatacom on 17.3.2017..
 */
public class  House {
    private int startPosition;
    private int endPosition;
    private Color defaultColor;
    private Color color;
    private Figure[] arrayOfFigures = new Figure[4];
    private Field[] fields = new Field[4];
    private Pane pane;

    public House(Color color,Pane pane) {
        this.color = color;
        this.pane=pane;
        //Init house, depending on color draw me house(RED GREEN BLUE YELLOW)
        initHouseFields(color);

        for(int i=0; i<arrayOfFigures.length;i++)
        {
            arrayOfFigures[i]=new Figure(color,startPosition);
        }
    }

    private int calcEndPosition(){
        int temp = startPosition + 39;
        if (temp > 39) {
            temp = temp - 39;
        }
        return temp;
    }

    public void initHouseFields(Color color)
    {
        int houseTemp=0;
        int colorChanger =0;
        double opacityChanger = 1.0;
        for (int i=0;i<fields.length;i++)
        {
            if(color.equals(Color.YELLOW)){
                startPosition = 0;
                endPosition = this.calcEndPosition();
                houseTemp+=60;
                colorChanger+=45;
                opacityChanger-=0.1;
                fields[i] = new Field();
                fields[i].setCenterX(720+houseTemp);
                fields[i].setCenterY(60);
                if(houseTemp==180)
                {
                    houseTemp=60;
                }
                if(i>1){

                   fields[i].setCenterY(120);
                   fields[i].setCenterX(720+houseTemp);
                }
                pane.getChildren().add(fields[i]);
                fields[i].setColor(color);
            } else if(color.equals(Color.RED)){
                startPosition = 9;
                endPosition = this.calcEndPosition();
                houseTemp+=60;
                fields[i] = new Field();
                fields[i].setCenterX(720+houseTemp);
                fields[i].setCenterY(240);
                if(houseTemp==180)
                {
                    houseTemp=60;
                }
                if(i>1){
                    fields[i].setCenterY(300);
                    fields[i].setCenterX(720+houseTemp);
                }
                pane.getChildren().add(fields[i]);
                fields[i].setColor(Color.RED);
            } else if(color.equals(Color.BLUE)){
                startPosition = 19;
                endPosition = this.calcEndPosition();
                houseTemp+=60;
                fields[i] = new Field();
                fields[i].setCenterX(720+houseTemp);
                fields[i].setCenterY(420);
                if(houseTemp==180)
                {
                    houseTemp=60;
                }
                if(i>1){
                    fields[i].setCenterY(480);
                    fields[i].setCenterX(720+houseTemp);
                }
                pane.getChildren().add(fields[i]);
                fields[i].setColor(Color.BLUE);
            } else {
                startPosition = 29;
                endPosition = this.calcEndPosition();
                houseTemp+=60;
                fields[i] = new Field();
                fields[i].setCenterX(720+houseTemp);
                fields[i].setCenterY(600);
                if(houseTemp==180)
                {
                    houseTemp=60;
                }
                if(i>1){
                    fields[i].setCenterY(660);
                    fields[i].setCenterX(720+houseTemp);
                }
                pane.getChildren().add(fields[i]);
                fields[i].setColor(Color.GREEN);
            }
        }
    }
    public boolean playerInGame(){
        for (int i=0;i<arrayOfFigures.length;i++){
            if(arrayOfFigures[i].isAmIinGame()==true) return true;

        }
        return false;
    }


}
