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
    private Field[] redParking;
    private Field[] blueParking;
    private Field[] yellowParking;
    private Field[] greenParking;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setWidth(900);
        primaryStage.setHeight(900);



        pane = new Pane();
        arrayOfCircles = new Field[40];
        testButton = new Button("Move");

        pane.getChildren().add(testButton);

        //Arrays
        redParking = new Field[4];
        blueParking = new Field[4];
        greenParking = new Field[4];
        yellowParking = new Field[4];

        int houseTemp=0;
        //Init redParking
        for (int i = 0; i< redParking.length; i++)
        {
            houseTemp+=60;
            redParking[i] = new Field(new Circle(25));
            redParking[i].getFieldShape().setCenterY(60+houseTemp);
            redParking[i].getFieldShape().setCenterX(600);
            redParking[i].setColor(Color.RED);
            pane.getChildren().add(redParking[i].getFieldShape());
        }


        testButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                int dice = random.nextInt(6)+1;
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
        //Init blueParking
        for (int i = 0; i< blueParking.length; i++)
        {
            houseTemp+=60;
            blueParking[i] = new Field(new Circle(25));
            blueParking[i].getFieldShape().setCenterY(600);
            blueParking[i].getFieldShape().setCenterX(660-houseTemp);
            blueParking[i].setColor(Color.BLUE);
            pane.getChildren().add(blueParking[i].getFieldShape());
        }

        //Init greenParking
        houseTemp=0;
        for (int i = 0; i< greenParking.length; i++)
        {
            houseTemp+=60;
            greenParking[i] = new Field(new Circle(25));
            greenParking[i].getFieldShape().setCenterY(660-houseTemp);
            greenParking[i].getFieldShape().setCenterX(120);
            greenParking[i].setColor(Color.GREEN);
            pane.getChildren().add(greenParking[i].getFieldShape());
        }

        //Init yellowParking
        houseTemp=0;
        for (int i = 0; i< yellowParking.length; i++)
        {
            houseTemp+=60;
            yellowParking[i] = new Field(new Circle(25));
            yellowParking[i].getFieldShape().setCenterY(120);
            yellowParking[i].getFieldShape().setCenterX(60+houseTemp);
            yellowParking[i].setColor(Color.YELLOW);
            pane.getChildren().add(yellowParking[i].getFieldShape());
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
