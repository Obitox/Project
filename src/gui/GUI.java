package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class GUI extends Application {

    private Pane pane;
    private Circle[] field;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setWidth(750);
        primaryStage.setHeight(750);



        pane = new Pane();
        field = new Circle[10];
        double temp = 0;


        pane.setMaxWidth(600);
        pane.setMaxHeight(600);

        for (int i=0;i<field.length;i++){
            pane.setMaxHeight(500);
            pane.setMaxWidth(600);
            temp+=60;
            field[i] = new Circle();
            field[i].setRadius(25.0);
            field[i].setCenterX(50.0 + temp);
            field[i].setCenterY(50.0);

            pane.getChildren().add(field[i]);
            System.out.println("i: "+temp);
        }


        primaryStage.show();
        primaryStage.setScene(new Scene(pane));
        primaryStage.setTitle("Ludo");
    }
}
