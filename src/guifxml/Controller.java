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
    Pane PaneOfFields;
    // END OF ALL FIELDS



    //ALL PARKINGS CONNECTIONS WITH FXML
    //Pane of Red Parking - Connection with FXML
    @FXML
    Pane PaneOfRedParkings;

    //Pane of Blue Parking - Connection with FXML
    @FXML
    Pane PaneOfBlueParkings;

    //Pane of Yellow Parking - Connection with FXML
    @FXML
    Pane PaneOfYellowParkings;

    //Pane of Green Parking - Connection with FXML
    @FXML
    Pane PaneOfGreenParkings;
    //END OF ALL PARKINGS CONNECTIONS WITH FXML.





    //ALL HOUSES CONNECTION WITH FXML
    //Pane of RED Houses - Connection with FXML
    @FXML
    Pane PaneOfRedHouses;

    //Pane of Blue Houses - Connection with FXML
    @FXML
    Pane PaneOfBlueHouses;

    //Pane of Yellow Houses - Connection with FXML
    @FXML
    Pane PaneOfYellowHouses;

    //Pane Green Houses - Connection with FXML
    @FXML
    Pane PaneOfGreenHouses;
    //END OF ALL HOUSE CONNECTIONS WITH FXML




    //ALL BUTTON CONNECTION WITH FXML
    //PANE OF RED BUTTONS
    @FXML
    Pane PaneOfRedButtons;

    //PANE OF BLUE BUTTONS
    @FXML
    Pane PaneOfBlueButtons;

    //PANE OF YELLOW BUTTONS;
    @FXML
    Pane PaneOfYellowButtons;

    //PANE OF GREEN BUTTONS
    @FXML
    Pane PaneOfGreenButtons;
    //END OF ALL BUTTON CONNECTIONS WITH FXML





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
            arrayOfFields[i] = (Circle) PaneOfFields.getChildren().get(i);
        }

        //INIT METHOD FOR PARKING
        initParkings();

        //INIT METHOD FOR HOUSES
        initHouses();

        //INIT METHOD FOR BUTTONS
        initButtons();

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
        for (int i=0;i<arrayOfRedParkings.length;i++)
        {
            arrayOfRedParkings[i] = (Circle) PaneOfRedParkings.getChildren().get(i);
        }
        for (int i=0;i<arrayOfBlueParkings.length;i++)
        {
            arrayOfBlueParkings[i] = (Circle) PaneOfBlueParkings.getChildren().get(i);
        }
        for (int i=0;i<arrayOfYellowParkings.length;i++)
        {
            arrayOfYellowParkings[i] = (Circle) PaneOfYellowParkings.getChildren().get(i);
        }
        for (int i=0;i<arrayOfGreenParkings.length;i++)
        {
            arrayOfGreenParkings[i] = (Circle) PaneOfGreenParkings.getChildren().get(i);
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
        for (int i=0;i<arrayOfRedHouses.length;i++)
        {
            arrayOfRedHouses[i] = (Circle) PaneOfRedHouses.getChildren().get(i);
        }
        for (int i=0;i<arrayOfBlueHouses.length;i++)
        {
            arrayOfBlueHouses[i] = (Circle) PaneOfBlueHouses.getChildren().get(i);
        }
        for (int i=0;i<arrayOfYellowHouses.length;i++)
        {
            arrayOfYellowHouses[i] = (Circle) PaneOfYellowHouses.getChildren().get(i);
        }
        for (int i=0;i<arrayOfGreenHouses.length;i++)
        {
            arrayOfGreenHouses[i] = (Circle) PaneOfGreenHouses.getChildren().get(i);
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
        for (int i=0;i<arrayOfRedButtons.length;i++)
        {
            arrayOfRedButtons[i] = (Button) PaneOfRedButtons.getChildren().get(i);
        }
        for (int i=0;i<arrayOfBlueButtons.length;i++)
        {
            arrayOfBlueButtons[i] = (Button) PaneOfBlueButtons.getChildren().get(i);
        }
        for (int i=0;i<arrayOfYellowButtons.length;i++)
        {
            arrayOfYellowButtons[i] = (Button) PaneOfYellowButtons.getChildren().get(i);
        }
        for (int i=0;i<arrayOfGreenButtons.length;i++)
        {
            arrayOfGreenButtons[i] = (Button) PaneOfGreenButtons.getChildren().get(i);
        }

    }



}
