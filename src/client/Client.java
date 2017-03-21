package client;
import network.DB;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Client extends Application {

    private static final String CLIENT_WINDOW_TITLE = "Client window";
    private static final double WINDOW_MIN_WIDTH = 700;
    private static final double WINDOW_MIN_HEIGHT = 500;

    private static final double SCENE_MIN_WIDTH = 700;
    private static final double SCENE_MIN_HEIGHT = 500;



    Stage window;
    Scene logInScene, playingScene;
    Pane rootPaneLogIn, rootPanePlayingScene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.window = primaryStage;
        this.window.setTitle(CLIENT_WINDOW_TITLE);
        this.window.setMinWidth(WINDOW_MIN_WIDTH);
        this.window.setMinHeight(WINDOW_MIN_HEIGHT);

        this.logInScene = createLogInScene();
        this.playingScene = createPlayingScene();

        this.window.setScene(logInScene);
        this.window.show();
    }

    private Scene createLogInScene(){

        //elements

        rootPaneLogIn = new Pane();
        logInScene = new Scene(rootPaneLogIn, SCENE_MIN_WIDTH, SCENE_MIN_HEIGHT);

        return logInScene;
    }

    private Scene createPlayingScene(){

        //elements

        rootPanePlayingScene = new Pane();
        playingScene = new Scene(rootPanePlayingScene, SCENE_MIN_WIDTH, SCENE_MIN_HEIGHT);

        return playingScene;
    }

}
