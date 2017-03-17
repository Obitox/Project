package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class GUI extends Application {

    private Pane pane;
    private Figure[] fields;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setWidth(750);
        primaryStage.setHeight(750);



        pane = new Pane();
        fields = new Figure[40];

        double temp = 0;


        pane.setMaxWidth(600);
        pane.setMaxHeight(600);

        for (int i=0;i<fields.length;i++){
            pane.setMaxHeight(500);
            pane.setMaxWidth(600);
            temp+=60;

            //fields[i] = new Field(new Circle());
            //fields[i].setFill(Color.RED);
            ////Paint p = field[i].getFill();
            ////String s = p.toString();
            ////System.out.println(p.equals(Color.RED)+"asdasdasdasd");
            ////System.out.println(s);
            //field[i].setRadius(25.0);
            //field[i].setCenterX(50.0 + temp);
            //field[i].setCenterY(50.0);

            //pane.getChildren().add(field[i]);
            System.out.println("i: "+temp);
        }


        primaryStage.show();
        primaryStage.setScene(new Scene(pane));
        primaryStage.setTitle("Ludo");
    }
}
