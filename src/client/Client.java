package client;
import communication.Request;
import communication.Response;
import gui.Table;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client extends Application {

    //private static final String HOST = "192.168.99.109";
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 9000;

    private static final String CLIENT_WINDOW_TITLE = "Client window";
    private static final double WINDOW_MIN_WIDTH = 700;
    private static final double WINDOW_MIN_HEIGHT = 500;

    private static final double SCENE_MIN_WIDTH = 700;
    private static final double SCENE_MIN_HEIGHT = 500;



    Stage window;
    Pane rootPaneLogIn, rootPanePlayingScene;

    Scene logInScene;
    private Label messageLabel;
    private TextField usernameTextField;
    private PasswordField passwordField;
    private Button btnSignIn;

    Scene playingScene;
    private Label sceneTitle;
    private Label lblPlayer;
    private Label lblDoneAction;
    private Label lblMessage;

    private Button btnFigura1;
    private Button btnFigura2;
    private Button btnFigura3;
    private Button btnFigura4;
    private Button passON;

    private Button btnSignOut;

    private Player player = null;
    private int[] table = null;

    //

    public static void main(String[] args) {

        launch(args);
    }

    //

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.window = primaryStage;
        this.window.setTitle(CLIENT_WINDOW_TITLE);
        this.window.setMinWidth(WINDOW_MIN_WIDTH);
        this.window.setMinHeight(WINDOW_MIN_HEIGHT);

        this.logInScene = createLogInScene();
        this.playingScene = createPlayingScene();

        this.window.setScene(logInScene);
        //this.window.setScene(playingScene);
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
            onSignIn();
        });
        grid.add(btnSignIn, 1, 4);

        return new Scene(grid, SCENE_MIN_WIDTH, SCENE_MIN_HEIGHT);
    }

    private Scene createPlayingScene(){
        //elementi scene2
//        sceneTitle = new Label("Playing scene");
        sceneTitle = new Label("Playing scene");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

        lblPlayer = new Label("player");
        lblDoneAction = new Label("doneAction");
        lblMessage = new Label("message");


        //BUTTONS FOR TESTINH
        btnFigura1 = new Button("1");
        btnFigura2 = new Button("2");
        btnFigura3 = new Button("3");
        btnFigura4 = new Button("4");
        passON = new Button("0");

        btnFigura1.setOnAction(event -> { onMyMove(event); });
        btnFigura2.setOnAction(event -> { onMyMove(event); });
        btnFigura3.setOnAction(event -> { onMyMove(event); });
        btnFigura4.setOnAction(event -> { onMyMove(event); });
        passON.setOnAction(event -> { onMyMove(event); });


        //INIT BUTTONS
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(btnFigura1,btnFigura2, btnFigura3,btnFigura4, passON);


        btnSignOut = new Button("Sign out");
        btnSignOut.setOnAction(event -> {
            onSignOut();
        });

        //layout2 scene2
        VBox layout2 = new VBox(20);
        layout2.setAlignment(Pos.CENTER);
        layout2.getChildren().addAll(sceneTitle, lblPlayer, lblDoneAction, lblMessage, hBox , btnSignOut);
        return new Scene (layout2, SCENE_MIN_WIDTH, SCENE_MIN_HEIGHT);
    }

    private void clearAllLogInFields(){
        usernameTextField.setText("");
        passwordField.setText("");
    }

//    private boolean checkUsernamePassword(String username, String password){
//        //TO DO Provera username-a i password-a
//        if(username.equals("pera.peric" )&& password.equals("password1")){
//            return true;
//        }
//        return false;
//    }

    private void onSignIn(){
        String username = usernameTextField.getText();
        String password = passwordField.getText();

//        if(checkUsernamePassword(username, password)){
//            messageLabel.setText("");
//            usernameTextField.setText("");
//            passwordField.setText("");
//            window.setScene(playingScene);
//        } else {
//            window.setScene(logInScene);
//            messageLabel.setText("Neispravan unos!");
//        }

        // kreiramo moguceg igraca
        Player player = new Player(username, password);
        // kreiramo obj request
        Request request = new Request("signIn", player);

        try {
            Socket clientSocket = new Socket(HOST, PORT);

            OutputStream outToServer = clientSocket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(outToServer);
            oos.writeObject(request);
            oos.flush();
            System.out.println("Poslat zahtev: " + request);

            InputStream inFromServer = clientSocket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(inFromServer);

            Response response = (Response) ois.readObject();
            clientSocket.close();
            System.out.println("Primljen odgovor: " + response);

            this.doOnResponse(response);

        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void onSignOut(){

        // kreiramo obj request
        Request request = new Request("signOut", player);

        try {
            Socket clientSocket = new Socket(HOST, PORT);

            OutputStream outToServer = clientSocket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(outToServer);
            oos.writeObject(request);
            oos.flush();
            System.out.println("Poslat zahtev: " + request);

            InputStream inFromServer = clientSocket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(inFromServer);

            Response response = (Response) ois.readObject();
            clientSocket.close();
            System.out.println("Primljen odgovor: "+response);

            this.doOnResponse(response);

        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//
//        messageLabel.setText("Successugul sign out");
//        window.setScene(logInScene);
    }

    private void onMyMove(javafx.event.ActionEvent event){
        String text = ((Button)event.getSource()).getText();
        int figureMove = Integer.parseInt(text);
        System.out.println(figureMove);
        // kreiramo obj request
        Request request = new Request("myMove", player);
        request.setFigureMove(figureMove);

        try {
            Socket clientSocket = new Socket(HOST, PORT);

            OutputStream outToServer = clientSocket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(outToServer);
            oos.writeObject(request);
            oos.flush();
            System.out.println("Poslat zahtev: " + request);

            InputStream inFromServer = clientSocket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(inFromServer);

            Response response = (Response) ois.readObject();
            clientSocket.close();
            System.out.println("Primljen odgovor: "+response);

            this.doOnResponse(response);

        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void doOnResponse (Response response){
        player = response.getPlayer();
        String doneAction = response.getDoneAction();
        String message = response.getMessage();

        if(response.getDoneAction().equals("signIn")){
            clearAllLogInFields();
            setUpPlayingScene(player,doneAction, message);
            window.setScene(playingScene);
        } else if(response.getDoneAction().equals("signOut")){
            clearAllLogInFields();
            messageLabel.setText(response.getMessage());
            window.setScene(logInScene);
        }else if(response.getDoneAction().equals("refreshTable")){
            clearAllLogInFields();
            table = response.getTable();
            // TO DO
        } else if(response.getDoneAction().equals("myMove")){
            clearAllLogInFields();
            // TO DO
            System.out.println(response.getMessage());

        } else {
            clearAllLogInFields();
            messageLabel.setText("Sign in is not successful! " + response.getMessage());
            window.setScene(logInScene);
        }
    }

    private void setUpPlayingScene(Player player, String doneAction, String message){
        lblPlayer.setText(String.valueOf(player));
        lblDoneAction.setText(doneAction);
        lblMessage.setText(message);

    }


}
