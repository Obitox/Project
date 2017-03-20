package gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.Random;

public class GUI extends Application {

    private Pane pane;
    private Field[] arrayOfCircles;
    private Button testButton;
    private int currentPosition=0;
    private Random random = new Random();

    private int temp=0;
    // House Arrays
    private Field[] redHouses;
    private Field[] blueHouses;
    private Field[] yellowHouses;
    private Field[] greenHouses;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setWidth(750);
        primaryStage.setHeight(750);



        pane = new Pane();
        arrayOfCircles = new Field[40];
        testButton = new Button("Move");

        pane.getChildren().add(testButton);

        //Arrays
        redHouses = new Field[4];
        blueHouses = new Field[4];
        greenHouses = new Field[4];
        yellowHouses = new Field[4];

        int houseTemp=0;
        //Init redHouses
        for (int i=0;i<redHouses.length;i++)
        {
            houseTemp+=60;
            redHouses[i] = new Field(new Circle(25));
            redHouses[i].getFieldShape().setCenterY(60+houseTemp);
            redHouses[i].getFieldShape().setCenterX(600);
            pane.getChildren().add(redHouses[i].getFieldShape());
        }


        testButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                int dice = random.nextInt(5)+1;
                System.out.println("Dice roll: "+dice);
                if(currentPosition>0){
                    arrayOfCircles[currentPosition].getFieldShape().setFill(Color.BLACK);
                }
                if(dice + currentPosition > 39){
                    currentPosition =0;
                }
                else {
                    arrayOfCircles[dice + currentPosition].getFieldShape().setFill(Color.RED);
                    currentPosition += dice;
                }
            }
        });



        houseTemp=0;
        //Init blueHouses
        for (int i=0;i<blueHouses.length;i++)
        {
            houseTemp+=60;
            blueHouses[i] = new Field(new Circle(25));
            blueHouses[i].getFieldShape().setCenterY(600);
            blueHouses[i].getFieldShape().setCenterX(660-houseTemp);
            pane.getChildren().add(blueHouses[i].getFieldShape());
        }

        //Init greenHouses
        houseTemp=0;
        for (int i=0;i<greenHouses.length;i++)
        {
            houseTemp+=60;
            greenHouses[i] = new Field(new Circle(25));
            greenHouses[i].getFieldShape().setCenterY(660-houseTemp);
            greenHouses[i].getFieldShape().setCenterX(120);
            pane.getChildren().add(greenHouses[i].getFieldShape());
        }

        //Init yellowHouses
        houseTemp=0;
        for (int i=0;i<yellowHouses.length;i++)
        {
            houseTemp+=60;
            yellowHouses[i] = new Field(new Circle(25));
            yellowHouses[i].getFieldShape().setCenterY(120);
            yellowHouses[i].getFieldShape().setCenterX(60+houseTemp);
            pane.getChildren().add(yellowHouses[i].getFieldShape());
        }





        pane.setMaxWidth(600);
        pane.setMaxHeight(600);

        for(int i=0;i<arrayOfCircles.length;i++){
            arrayOfCircles[i] = new Field(new Circle(25));
            if(i>=0 && i<11) {
                arrayOfCircles[i].getFieldShape().setCenterX(60 + temp);
                arrayOfCircles[i].getFieldShape().setCenterY(60);
                temp+=60;
                if(temp == 660){
                    temp = 60;
                }
            }
            else if(i>=11 && i <21){
                arrayOfCircles[i].getFieldShape().setCenterY(60+temp);
                arrayOfCircles[i].getFieldShape().setCenterX(660);
                temp+=60;
                if(temp==660)
                {
                    temp = 60;
                }
            }
            else if(i>=21 && i<31)
            {
                arrayOfCircles[i].getFieldShape().setCenterX(660-temp);
                arrayOfCircles[i].getFieldShape().setCenterY(660);
                temp+=60;
                if(temp==660)
                {
                    temp = 60;
                }
            }
            else
            {
                arrayOfCircles[i].getFieldShape().setCenterX(60);
                arrayOfCircles[i].getFieldShape().setCenterY(660-temp);
                temp+=60;
            }

            pane.getChildren().add(arrayOfCircles[i].getFieldShape());
        }


        primaryStage.show();
        primaryStage.setScene(new Scene(pane));
        primaryStage.setTitle("Ludo");
    }
}
