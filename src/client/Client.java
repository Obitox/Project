package client;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import network.DB;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client extends Application {

    private static final String HOST = "192.168.99.109";
    private static final int PORT = 3306;

    private static final String CLIENT_WINDOW_TITLE = "Client window";
    private static final double WINDOW_MIN_WIDTH = 700;
    private static final double WINDOW_MIN_HEIGHT = 500;

    private static final double SCENE_MIN_WIDTH = 700;
    private static final double SCENE_MIN_HEIGHT = 500;



    Stage window;
    Scene logInScene, playingScene;
    Pane rootPaneLogIn, rootPanePlayingScene;

    private Label messageLabel;
    private TextField usernameTextField;
    private PasswordField passwordField;
    private Button btnSignIn;

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
        // Raspored elemenata
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        //elementi scene
        //message
        messageLabel = new Label();
        messageLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
        HBox hbMessageLabel = new HBox(10);
        hbMessageLabel.setAlignment(Pos.CENTER);
        hbMessageLabel.getChildren().add(messageLabel);
        grid.add(hbMessageLabel, 0, 0, 2, 1);

        //scenetitle
        Label sceneTitle = new Label("Welcome");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        HBox hbSceneTitle = new HBox(10);
        hbSceneTitle.setAlignment(Pos.CENTER);
        hbSceneTitle.getChildren().add(sceneTitle);
        grid.add(hbSceneTitle, 0, 1, 2, 1);

        //username
        Label usernameLabel = new Label("User Name:");
        grid.add(usernameLabel, 0, 2);
        usernameTextField = new TextField();
        grid.add(usernameTextField, 1, 2);

        //password
        Label passwordLabel = new Label("Password:");
        grid.add(passwordLabel, 0, 3);
        passwordField = new PasswordField();
        grid.add(passwordField, 1, 3);

        //button
        btnSignIn = new Button("Sign in");
        btnSignIn.setOnAction(event -> {
            sendLogInRequest();
        });
        grid.add(btnSignIn, 1, 4);

        return new Scene(grid, SCENE_MIN_WIDTH, SCENE_MIN_HEIGHT);
    }

    private void sendLogInRequest(){
        String username = usernameTextField.getText();
        String password = passwordField.getText();

        // kreiramo obj request

        if(checkUsernamePassword(username, password)){
            messageLabel.setText("");
            usernameTextField.setText("");
            passwordField.setText("");
            window.setScene(playingScene);
        } else {
            window.setScene(logInScene);
            messageLabel.setText("Neispravan unos!");
        }

        try {
            Socket clientSocket = new Socket(HOST, PORT);
            OutputStream outToServer = clientSocket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(outToServer);
//            oos.writeObject(new Zahtev("book", id, owner, date));
//            oos.flush();
//
//            InputStream inFromServer = clientSocket.getInputStream();
//            ObjectInputStream ois = new ObjectInputStream(inFromServer);
//
//            Odgovor odgovor = (Odgovor) ois.readObject();
//            if(odgovor.getOdradjenaAkcija() != null && odgovor.getOdradjenaAkcija().equals("book")){
//                getMessageLabel().setText("Booking is successful");
//                refreshTableContent(selectedRowIndex, owner, date);
//            } else {
//                getMessageLabel().setText("Booking is not successful! " + odgovor.getMessage() + " Prikazi sve sobe ponovo.");
//            }
//            clearAllDisplayBookingTextFields();
//            getBookButton().setEnabled(false);
//            getCancelBookingButton().setEnabled(false);

            clientSocket.close();
        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }
    
    private boolean checkUsernamePassword(String username, String password){

        //TO DO Dohvatanje passward-a za dati username

        if(username.equals("pera.peric" )&& password.equals("password1")){
            return true;
        }
        return false;
    }

    private Scene createPlayingScene(){
        //elementi scene2
        Label label2 = new Label("Playing scene");
        Button button2 = new Button("Sign out");
        button2.setOnAction(event -> {
            window.setScene(logInScene);
        });

        //layout2 scene2
        HBox layout2 = new HBox(20);
        layout2.getChildren().addAll(label2, button2);
        return new Scene (layout2, SCENE_MIN_WIDTH, SCENE_MIN_HEIGHT);
    }

    
}
