package server;

import client.Player;
import communication.Request;
import communication.Response;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.List;


public class Server extends Application{

    //private static final String HOST = "192.168.99.109";
    private static final int PORT = 9000;

    private static final String SERVER_WINDOW_TITLE = "Server window";
    private static final double SERVER_WINDOW_MIN_WIDTH = 700;
    private static final double SERVER_WINDOW_MIN_HEIGHT = 500;

    private static final double SCENE_MIN_WIDTH = 700;
    private static final double SCENE_MIN_HEIGHT = 500;

    Stage serverWindow;
    Pane rootPane;
    Scene serverScene;

    private Button btnTurnOn;
    private Button btnTurnOff;

    private ServerRunnable sr;

    private DbManager dbManager;
    private ServerSocket serverSocket;
    private List<Player> players;

    private static final Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
    private static int numberOfSignInPlayers = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.serverWindow = primaryStage;
        this.serverWindow.setTitle(SERVER_WINDOW_TITLE);
        this.serverWindow.setMinWidth(SERVER_WINDOW_MIN_WIDTH);
        this.serverWindow.setMinHeight(SERVER_WINDOW_MIN_HEIGHT);

        serverScene = createServerScene();

        this.serverWindow.setScene(serverScene);
        this.serverWindow.show();
    }

    private Scene createServerScene(){
        btnTurnOn = new Button("TURN ON");
        btnTurnOn.setOnAction(event -> onTurnOn());
        btnTurnOff = new Button("TURN OFF");
        btnTurnOff.setOnAction(event -> onTurnOff());

        VBox layoutServer = new VBox(20);
        layoutServer.setAlignment(Pos.CENTER);
        layoutServer.getChildren().addAll(btnTurnOn, btnTurnOff);

        return new Scene(layoutServer, SCENE_MIN_WIDTH, SCENE_MIN_HEIGHT);
    }

    private void onTurnOn(){
        sr = new ServerRunnable();
        Thread t = new Thread(sr);
    }

    private void onTurnOff(){
        sr.stopThread();
    }

}
