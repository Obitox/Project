package guifxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import java.util.*;

public class Controller {


    // ALL FIELDS
    //Pane of FIELDS - Connection with FXML
    @FXML
    Pane PaneOfEverything;
    // END OF ALL FIELDS


    //DECLARING PARKING ARRAYS
    // Init Parking
    Circle []arrayOfRedParkings;
    Circle []arrayOfBlueParkings;
    Circle []arrayOfYellowParkings;
    Circle []arrayOfGreenParkings;
    //END OF DECLARING PARKING ARRAYS

    //ONLY MEANT FOR TESTING, TO BE DELETED.
    @FXML
    Button btnTest;

    int currentPosition=0;
    int dice=0;
    //END OF TESTING DECLARATIONS AND CONNECTIONS WITH FXML


    //DECLARING ARRAY OF FIELDS
    Circle []arrayOfFields;
    //END OF DECLARING ARRAY OF FIELDS


    @FXML
    public void initialize() {

        //Init FIELDS
        arrayOfFields = new Circle[40];
        for (int i=0;i<arrayOfFields.length;i++)
        {
            arrayOfFields[i] = (Circle) PaneOfEverything.getChildren().get(i);
        }

        ////INIT METHOD FOR PARKING
        //initParkings();
//
        ////INIT METHOD FOR HOUSES
        //initHouses();
//
        ////INIT METHOD FOR BUTTONS
        //initButtons();

    }

    @FXML
    public void Clicked(ActionEvent event){
        Random random = new Random();
        dice = random.nextInt(6)+1;
        System.out.println("Dice roll: "+dice);
        if(currentPosition>0){
            arrayOfFields[currentPosition].setFill(Color.BLACK);
        }
        if(dice + currentPosition > 39){
            currentPosition =0;
        }
        else {
            arrayOfFields[dice + currentPosition].setFill(Color.RED);
            currentPosition += dice;
        }
    }

    //INIT PARKING ARRAYS
    public void initParkings(){

        //DECLARATION OF ALL PARKING ARRAYS
        Circle []arrayOfRedParkings;
        Circle []arrayOfBlueParkings;
        Circle []arrayOfYellowParkings;
        Circle []arrayOfGreenParkings;

        //INIT Size of All Parking Arrays
        arrayOfRedParkings = new Circle[4];
        arrayOfBlueParkings = new Circle[4];
        arrayOfYellowParkings = new Circle[4];
        arrayOfGreenParkings = new Circle[4];

        //INIT Parking Arrays with FXML Objects
        for (int i=40;i<44;i++)
        {
            arrayOfRedParkings[i] = (Circle) PaneOfEverything.getChildren().get(i);
        }
        for (int i=44;i<48;i++)
        {
            arrayOfBlueParkings[i] = (Circle) PaneOfEverything.getChildren().get(i);
        }
        for (int i=48;i<52;i++)
        {
            arrayOfYellowParkings[i] = (Circle) PaneOfEverything.getChildren().get(i);
        }
        for (int i=52;i<56;i++)
        {
            arrayOfGreenParkings[i] = (Circle) PaneOfEverything.getChildren().get(i);
        }
    }

    //INIT HOUSE ARRAYS
    public void initHouses(){

        //DECLARATION OF ALL HOUSE ARRAYS
        Circle []arrayOfRedHouses;
        Circle []arrayOfBlueHouses;
        Circle []arrayOfYellowHouses;
        Circle []arrayOfGreenHouses;

        //INIT SIZE OF ALL HOUSE ARRAYS
        arrayOfRedHouses = new Circle[4];
        arrayOfBlueHouses = new Circle[4];
        arrayOfYellowHouses = new Circle[4];
        arrayOfGreenHouses = new Circle[4];

        //INIT HOUSE Arrays with FXML Objects
        for (int i=56;i<60;i++)
        {
            arrayOfRedHouses[i] = (Circle) PaneOfEverything.getChildren().get(i);
        }
        for (int i=60;i<64;i++)
        {
            arrayOfBlueHouses[i] = (Circle) PaneOfEverything.getChildren().get(i);
        }
        for (int i=64;i<68;i++)
        {
            arrayOfYellowHouses[i] = (Circle) PaneOfEverything.getChildren().get(i);
        }
        for (int i=68;i<72;i++)
        {
            arrayOfGreenHouses[i] = (Circle) PaneOfEverything.getChildren().get(i);
        }
    }

    //INIT BUTTONS FOR FIGURE CONTROL
    public void initButtons(){

        //DECLARATION OF ALL BUTTON ARRAYS
        Button []arrayOfRedButtons;
        Button []arrayOfBlueButtons;
        Button []arrayOfYellowButtons;
        Button []arrayOfGreenButtons;

        //INIT SIZE OF ALL BUTTON ARRAYS
        arrayOfRedButtons = new Button[4];
        arrayOfBlueButtons = new Button[4];
        arrayOfYellowButtons = new Button[4];
        arrayOfGreenButtons = new Button[4];

        //INIT BUTTON ARRAYS WITH OBJECTS FROM FXML
        for (int i=72;i<76;i++)
        {
            arrayOfRedButtons[i] = (Button) PaneOfEverything.getChildren().get(i);
        }
        for (int i=76;i<80;i++)
        {
            arrayOfBlueButtons[i] = (Button) PaneOfEverything.getChildren().get(i);
        }
        for (int i=80;i<84;i++)
        {
            arrayOfYellowButtons[i] = (Button) PaneOfEverything.getChildren().get(i);
        }
        for (int i=84;i<88;i++)
        {
            arrayOfGreenButtons[i] = (Button) PaneOfEverything.getChildren().get(i);
        }

    }



}
