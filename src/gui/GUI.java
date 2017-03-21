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

    //TESTING BUTTON
    int currentPosition=0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Setting window size
        primaryStage.setWidth(1200);
        primaryStage.setHeight(900);


        //Main Pane Init
        pane = new Pane();

        //Calling initFields
        initFields(pane);

        //Calling initHouses
        initHouses(pane);

        //Calling initParkings
        initParkings(pane);

        //Calling initButtons
        initButtons(pane);

        //Calling buttonTest ONLY MEANT FOR TESTING BUTTON CONTROL
        buttonTest(pane);

        primaryStage.show();
        primaryStage.setScene(new Scene(pane));
        primaryStage.setTitle("Ludo");
    }



    //Init all the parkings RED BLUE GREEN YELLOW
    public void initParkings(Pane pane){

        //ArraysParking size init
        redParking = new Field[4];
        blueParking = new Field[4];
        greenParking = new Field[4];
        yellowParking = new Field[4];

        int parkingTemp =0;
        //Init redParking
        for (int i = 0; i< redParking.length; i++)
        {
            parkingTemp +=60;
            redParking[i] = new Field();
            redParking[i].setCenterY(60+ parkingTemp);
            redParking[i].setCenterX(600);
            redParking[i].setColor(Color.RED);
            pane.getChildren().add(redParking[i]);
        }

        parkingTemp =0;
        //Init blueParking
        for (int i = 0; i< blueParking.length; i++)
        {
            parkingTemp +=60;
            blueParking[i] = new Field();
            blueParking[i].setCenterY(600);
            blueParking[i].setCenterX(660- parkingTemp);
            blueParking[i].setColor(Color.BLUE);
            pane.getChildren().add(blueParking[i]);
        }

        //Init greenParking
        parkingTemp =0;
        for (int i = 0; i< greenParking.length; i++)
        {
            parkingTemp +=60;
            greenParking[i] = new Field();
            greenParking[i].setCenterY(660- parkingTemp);
            greenParking[i].setCenterX(120);
            greenParking[i].setColor(Color.GREEN);
            pane.getChildren().add(greenParking[i]);
        }

        //Init yellowParking
        parkingTemp =0;
        for (int i = 0; i< yellowParking.length; i++)
        {
            parkingTemp +=60;
            yellowParking[i] = new Field();
            yellowParking[i].setCenterY(120);
            yellowParking[i].setCenterX(60+ parkingTemp);
            yellowParking[i].setColor(Color.YELLOW);
            pane.getChildren().add(yellowParking[i]);
        }
    }






    //Init all the houses RED GREEN BLUE YELLOW
    public void initHouses(Pane pane){
        //ArraysHouse
        redHouse = new Field[4];
        blueHouse = new Field[4];
        yellowHouse = new Field[4];
        greenHouse = new Field[4];

        //Init redHouse
        int houseTemp=0;
        int colorChanger=0;
        double opacityChanger=1.0;
        for (int i=0;i<redHouse.length;i++)
        {
            houseTemp+=60;
            colorChanger+=45;
            opacityChanger-=0.1;
            redHouse[i] = new Field();
            redHouse[i].setCenterX(720+houseTemp);
            redHouse[i].setCenterY(60);
            if(houseTemp==180)
            {
                houseTemp=60;
            }
            if(i>1){

                redHouse[i].setCenterY(120);
                redHouse[i].setCenterX(720+houseTemp);
            }
            pane.getChildren().add(redHouse[i]);
            redHouse[i].setColor(Color.rgb(255-colorChanger,0,0,opacityChanger));
        }


        //Init blueHouse
        houseTemp=0;
        for (int i=0;i<blueHouse.length;i++)
        {
            houseTemp+=60;
            blueHouse[i] = new Field();
            blueHouse[i].setCenterX(720+houseTemp);
            blueHouse[i].setCenterY(240);
            if(houseTemp==180)
            {
                houseTemp=60;
            }
            if(i>1){

                blueHouse[i].setCenterY(300);
                blueHouse[i].setCenterX(720+houseTemp);
            }
            pane.getChildren().add(blueHouse[i]);
            blueHouse[i].setColor(Color.BLUE);
        }
        //Init yellowHouse
        houseTemp=0;
        for (int i=0;i<yellowHouse.length;i++)
        {
            houseTemp+=60;
            yellowHouse[i] = new Field();
            yellowHouse[i].setCenterX(720+houseTemp);
            yellowHouse[i].setCenterY(420);
            if(houseTemp==180)
            {
                houseTemp=60;
            }
            if(i>1){

                yellowHouse[i].setCenterY(480);
                yellowHouse[i].setCenterX(720+houseTemp);
            }
            pane.getChildren().add(yellowHouse[i]);
            yellowHouse[i].setColor(Color.YELLOW);
        }

        //Init greenHouse
        houseTemp=0;
        for (int i=0;i<greenHouse.length;i++)
        {
            houseTemp+=60;
            greenHouse[i] = new Field();
            greenHouse[i].setCenterX(720+houseTemp);
            greenHouse[i].setCenterY(600);
            if(houseTemp==180)
            {
                houseTemp=60;
            }
            if(i>1){
                greenHouse[i].setCenterY(660);
                greenHouse[i].setCenterX(720+houseTemp);
            }
            pane.getChildren().add(greenHouse[i]);
            greenHouse[i].setColor(Color.GREEN);
        }
    }



    //Init field elements
    public void initFields(Pane pane){
        arrayOfCircles = new Field[40];
        for(int i=0;i<arrayOfCircles.length;i++){
            arrayOfCircles[i] = new Field();
            if(i>=0 && i<11) {
                arrayOfCircles[i].setCenterX(60 + temp);
                arrayOfCircles[i].setCenterY(60);
                temp+=60;
                if(temp == 660){
                    temp = 60;
                }
            }
            else if(i>=11 && i <21){
                arrayOfCircles[i].setCenterY(60+temp);
                arrayOfCircles[i].setCenterX(660);
                temp+=60;
                if(temp==660)
                {
                    temp = 60;
                }
            }
            else if(i>=21 && i<31)
            {
                arrayOfCircles[i].setCenterX(660-temp);
                arrayOfCircles[i].setCenterY(660);
                temp+=60;
                if(temp==660)
                {
                    temp = 60;
                }
            }
            else
            {
                arrayOfCircles[i].setCenterX(60);
                arrayOfCircles[i].setCenterY(660-temp);
                temp+=60;
            }

            pane.getChildren().add(arrayOfCircles[i]);
        }
    }

    //Init Buttons on GUI
    public void initButtons(Pane pane){

        //RedButtonArray initSize
        redButtons = new Button[2][2];

        //RedGrid pane
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

        //Set position of RedGridPane
        redGridPane.setLayoutX(900);
        redGridPane.setLayoutY(60);
        pane.getChildren().add(redGridPane);

        //BlueButtonArray initSize
        blueButtons = new Button[2][2];

        //BlueGrid pane
        blueGridPane = new GridPane();


        //BlueButtonsArray Element init
        counterButton=0;
        for (int i=0;i<blueButtons.length;i++)
        {
            for (int j=0;j<blueButtons.length;j++) {
                counterButton++;
                blueButtons[i][j] = new Button(""+counterButton);
                blueGridPane.add(blueButtons[i][j],j,i);
            }
        }

        //Set position of BlueGridPane
        blueGridPane.setLayoutX(900);
        blueGridPane.setLayoutY(250);
        pane.getChildren().add(blueGridPane);



        //YellowButtonArray initSize
        yellowButtons = new Button[2][2];

        //YellowGrid pane
        yellowGridPane = new GridPane();


        //YellowButtonArray Element init
        counterButton=0;
        for (int i=0;i<yellowButtons.length;i++)
        {
            for (int j=0;j<yellowButtons.length;j++) {
                counterButton++;
                yellowButtons[i][j] = new Button(""+counterButton);
                yellowGridPane.add(yellowButtons[i][j],j,i);
            }
        }

        //Set position of YellowGridPane
        yellowGridPane.setLayoutX(900);
        yellowGridPane.setLayoutY(430);
        pane.getChildren().add(yellowGridPane);




        //GreenButtonArray initSize
        greenButtons = new Button[2][2];

        //GreenGrid pane
        greenGridPane = new GridPane();


        //GreenButtonArray Element init
        counterButton=0;
        for (int i=0;i<greenButtons.length;i++)
        {
            for (int j=0;j<greenButtons.length;j++) {
                counterButton++;
                greenButtons[i][j] = new Button(""+counterButton);
                greenGridPane.add(greenButtons[i][j],j,i);
            }
        }

        //Set position of GreenGridPane
        greenGridPane.setLayoutX(900);
        greenGridPane.setLayoutY(600);
        pane.getChildren().add(greenGridPane);

    }


    //TESTING BUTTON CONTROL
    public void buttonTest(Pane pane){

        Random random = new Random();

        //TESTING
        testButton = new Button("Move");

        testButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                int dice = random.nextInt(6)+1;
                System.out.println("Dice roll: "+dice);
                if(currentPosition>0){
                    arrayOfCircles[currentPosition].setFill(Color.BLACK);
                }
                if(dice + currentPosition > 39){
                    currentPosition =0;
                }
                else {
                    arrayOfCircles[dice + currentPosition].setFill(Color.RED);
                    currentPosition += dice;
                }
            }
        });

        pane.getChildren().add(testButton);
    }
}
