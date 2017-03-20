package gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
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


    //Pane Init
    private GridPane redGridPane;
    private GridPane blueGridPane;
    private GridPane greenGridPane;
    private GridPane yellowGridPane;

    //ButtonArray Init
    private Button [][]redButtons;
    private Button [][]blueButtons;
    private Button [][]greenButtons;
    private Button [][]yellowButtons;

    private int temp=0;
    // Parking Arrays
    private Field[] redParking;
    private Field[] blueParking;
    private Field[] yellowParking;
    private Field[] greenParking;

    // House Arrays
    private Field[] redHouse;
    private Field[] blueHouse;
    private Field[] yellowHouse;
    private Field[] greenHouse;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setWidth(1200);
        primaryStage.setHeight(900);


        //RedButtonArray initSize
        redButtons = new Button[2][2];

        //RedGrid pane
        redGridPane = new GridPane();


        //RedButtonsArray Element init
        int counter=0;
        for (int i=0;i<redButtons.length;i++)
        {
            for (int j=0;j<redButtons.length;j++) {
                counter++;
                redButtons[i][j] = new Button(""+counter);
                redGridPane.add(redButtons[i][j],j,i);
            }
        }

        //Set position of GridPane
        redGridPane.setLayoutX(900);
        redGridPane.setLayoutY(60);

        //BlueButtonArray initSize
        blueButtons = new Button[2][2];

        //BlueGrid pane
        redGridPane = new GridPane();


        //RedButtonsArray Element init
        int counterButton=0;
        for (int i=0;i<redButtons.length;i++)
        {
            for (int j=0;j<redButtons.length;j++) {
                counterButton++;
                redButtons[i][j] = new Button(""+counterButton);
                redGridPane.add(redButtons[i][j],j,i);
            }
        }

        //Set position of GridPane
        redGridPane.setLayoutX(900);
        redGridPane.setLayoutY(60);




        pane = new Pane();
        pane.getChildren().add(redGridPane);
        arrayOfCircles = new Field[40];
        testButton = new Button("Move");

        pane.getChildren().add(testButton);

        //ArraysParking
        redParking = new Field[4];
        blueParking = new Field[4];
        greenParking = new Field[4];
        yellowParking = new Field[4];

        //ArraysHouse
        redHouse = new Field[4];
        blueHouse = new Field[4];
        yellowHouse = new Field[4];
        greenHouse = new Field[4];

        //Init redHouse
        int houseTemp=0;
        for (int i=0;i<redHouse.length;i++)
        {
            houseTemp+=60;
            redHouse[i] = new Field(new Circle(25));
            redHouse[i].getFieldShape().setCenterX(720+houseTemp);
            redHouse[i].getFieldShape().setCenterY(60);
            if(houseTemp==180)
            {
                houseTemp=60;
            }
            if(i>1){

                redHouse[i].getFieldShape().setCenterY(120);
                redHouse[i].getFieldShape().setCenterX(720+houseTemp);
            }
            pane.getChildren().add(redHouse[i].getFieldShape());
            redHouse[i].setColor(Color.RED);
        }


        //Init blueHouse
        houseTemp=0;
        for (int i=0;i<blueHouse.length;i++)
        {
            houseTemp+=60;
            blueHouse[i] = new Field(new Circle(25));
            blueHouse[i].getFieldShape().setCenterX(720+houseTemp);
            blueHouse[i].getFieldShape().setCenterY(240);
            if(houseTemp==180)
            {
                houseTemp=60;
            }
            if(i>1){

                blueHouse[i].getFieldShape().setCenterY(300);
                blueHouse[i].getFieldShape().setCenterX(720+houseTemp);
            }
            pane.getChildren().add(blueHouse[i].getFieldShape());
            blueHouse[i].setColor(Color.BLUE);
        }
        //Init yellowHouse
        houseTemp=0;
        for (int i=0;i<yellowHouse.length;i++)
        {
            houseTemp+=60;
            yellowHouse[i] = new Field(new Circle(25));
            yellowHouse[i].getFieldShape().setCenterX(720+houseTemp);
            yellowHouse[i].getFieldShape().setCenterY(420);
            if(houseTemp==180)
            {
                houseTemp=60;
            }
            if(i>1){

                yellowHouse[i].getFieldShape().setCenterY(480);
                yellowHouse[i].getFieldShape().setCenterX(720+houseTemp);
            }
            pane.getChildren().add(yellowHouse[i].getFieldShape());
            yellowHouse[i].setColor(Color.YELLOW);
        }

        //Init greenHouse
        houseTemp=0;
        for (int i=0;i<greenHouse.length;i++)
        {
            houseTemp+=60;
            greenHouse[i] = new Field(new Circle(25));
            greenHouse[i].getFieldShape().setCenterX(720+houseTemp);
            greenHouse[i].getFieldShape().setCenterY(600);
            if(houseTemp==180)
            {
                houseTemp=60;
            }
            if(i>1){
                greenHouse[i].getFieldShape().setCenterY(660);
                greenHouse[i].getFieldShape().setCenterX(720+houseTemp);
            }
            pane.getChildren().add(greenHouse[i].getFieldShape());
            greenHouse[i].setColor(Color.GREEN);
        }

        int parkingTemp =0;
        //Init redParking
        for (int i = 0; i< redParking.length; i++)
        {
            parkingTemp +=60;
            redParking[i] = new Field(new Circle(25));
            redParking[i].getFieldShape().setCenterY(60+ parkingTemp);
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



        parkingTemp =0;
        //Init blueParking
        for (int i = 0; i< blueParking.length; i++)
        {
            parkingTemp +=60;
            blueParking[i] = new Field(new Circle(25));
            blueParking[i].getFieldShape().setCenterY(600);
            blueParking[i].getFieldShape().setCenterX(660- parkingTemp);
            blueParking[i].setColor(Color.BLUE);
            pane.getChildren().add(blueParking[i].getFieldShape());
        }

        //Init greenParking
        parkingTemp =0;
        for (int i = 0; i< greenParking.length; i++)
        {
            parkingTemp +=60;
            greenParking[i] = new Field(new Circle(25));
            greenParking[i].getFieldShape().setCenterY(660- parkingTemp);
            greenParking[i].getFieldShape().setCenterX(120);
            greenParking[i].setColor(Color.GREEN);
            pane.getChildren().add(greenParking[i].getFieldShape());
        }

        //Init yellowParking
        parkingTemp =0;
        for (int i = 0; i< yellowParking.length; i++)
        {
            parkingTemp +=60;
            yellowParking[i] = new Field(new Circle(25));
            yellowParking[i].getFieldShape().setCenterY(120);
            yellowParking[i].getFieldShape().setCenterX(60+ parkingTemp);
            yellowParking[i].setColor(Color.YELLOW);
            pane.getChildren().add(yellowParking[i].getFieldShape());
        }





        pane.setMaxWidth(1200);
        pane.setMaxHeight(900);

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
