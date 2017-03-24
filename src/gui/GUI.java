package gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
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
    private Table table;

    //Game sense
    int playerTurn=0;


    //TESTING BUTTON
    int currentPosition=10;
    private int dice;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        //TESTING testButtonInit
        testButton = new Button("Move");

        //Setting window size
        primaryStage.setWidth(1200);
        //primaryStage.setHeight(900);
        primaryStage.setHeight(700);

        //GAME SENSE
        //playerTurn = 0;

        //Main Pane Init
        pane = new Pane();

        //Init game Table
        initGameTable(pane);

        //Calling initButtons
        initButtons(pane);

        //Calling buttonTest ONLY MEANT FOR TESTING BUTTON CONTROL
        pane.getChildren().add(testButton);


        //Displaying main scene in gui and setting its title
        primaryStage.show();
        primaryStage.setScene(new Scene(pane));
        primaryStage.setTitle("Ludo");
    }



    //Init entire Table
    public void initGameTable(Pane pane){

        table = new Table(pane);
        //table.start();
        //testButton.setOnAction(table);
        testButton.setOnAction(e -> {
            //testButton.setDisable(true);
            //boolean disabled = testButton.isDisabled();
        //    System.out.println(disabled);
       dice=table.diceRoll(playerTurn);
        playerTurn=(++playerTurn)%4;
        System.out.println("Next player is: "+playerTurn);
        });

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
    //public void buttonTest(Pane pane){

        //Random random = new Random();
//
        ////TESTING
        //testButton = new Button("Move");
//
        //testButton.setOnAction(new EventHandler<ActionEvent>() {
        //    @Override public void handle(ActionEvent e) {
        //        dice = random.nextInt(6)+1;
        //        System.out.println("Dice roll: "+dice);
        //        if(currentPosition>0){
        //            arrayOfCircles[currentPosition].setFill(Color.BLACK);
        //        }
        //        if(dice + currentPosition > 39){
        //            currentPosition =0;
        //        }
        //        else {
        //            arrayOfCircles[dice + currentPosition].setFill(Color.RED);
        //            currentPosition += dice;
        //        }
//
        //    }
        //});

        //pane.getChildren().add(testButton);
    //}
}
