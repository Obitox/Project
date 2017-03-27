package guifxml;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import jdk.nashorn.internal.objects.annotations.Constructor;

import java.net.URL;
import java.util.*;

import javafx.collections.ObservableList;
import javafx.collections.ListChangeListener;
import javafx.collections.FXCollections;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    ArrayList<Circle> listOfCircles = new ArrayList<>();



    @FXML
    GridPane GridOFAllElements;

    @FXML
    Button Button1;

    @FXML
    StackPane stackPane;

    @FXML
    Circle x4;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {


       // init();

    }

    @FXML
    private void handleButtonAction(ActionEvent event) {




        for(int i=0;i<40;i++)
        {
            listOfCircles.add((Circle) GridOFAllElements.getChildren().get(i));

        }
        //listOfCircles.get(10).setFill(Color.RED);


}
}
