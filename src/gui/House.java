package gui;

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

    public House(Color color) {
        this.color = color;

        if(color.equals(Color.RED)){
            startPosition = 0;
            endPosition = this.calcEndPosition();
        } else if(color.equals(Color.BLUE)){
            startPosition = 9;
            endPosition = this.calcEndPosition();
        } else if(color.equals(Color.GREEN)){
            startPosition = 19;
            endPosition = this.calcEndPosition();
        } else {
            startPosition = 29;
            endPosition = this.calcEndPosition();
        }
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


}
