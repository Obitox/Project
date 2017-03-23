package server;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import network.DB;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;


public class Server extends Application implements Runnable{

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

    private Label lblRequestTitle;
    private Label lblRequestPlayer;
    private Label lblRequstAction;
    private Label lblRequestObject;

    private Label lblResponseTitle;
    private Label lblResponsePlayer;
    private Label lblResponseAction;
    private Label lblResponseMessage;
    private Label lblResponseObject;

    //private DbManager dbManager;
    ServerSocket serverSocket;

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

        try {
            //dbManager = new DbManager();
            //DB db = DB.getInstance();
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            System.out.println("Exception pri kreiranju Server socketa");
            e.printStackTrace();
        }
    }

    private Scene createServerScene(){
        lblRequestTitle = new Label("REQUEST");
        lblRequestPlayer = new Label("player");
        lblRequstAction = new Label("action");
        lblRequestObject = new Label("requestObject");

        VBox vbRequest = new VBox(20);
        vbRequest.setAlignment(Pos.CENTER);
        vbRequest.getChildren().addAll(lblRequestTitle, lblRequestPlayer, lblRequstAction, lblRequestObject);

        lblResponseTitle = new Label("RESPONSE");
        lblResponsePlayer = new Label("player");
        lblResponseAction = new Label("action");
        lblResponseMessage = new Label("message");
        lblResponseObject = new Label("responseObject");

        VBox vbResponse = new VBox(20);
        vbResponse.setAlignment(Pos.CENTER);
        vbResponse.getChildren().addAll(lblResponseTitle, lblResponsePlayer, lblResponseAction, lblResponseMessage, lblResponseObject);

        VBox layoutServer = new VBox(20);
        layoutServer.setAlignment(Pos.CENTER);
        layoutServer.getChildren().addAll(vbRequest, vbResponse);

        return new Scene(layoutServer, SCENE_MIN_WIDTH, SCENE_MIN_HEIGHT);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Socket server = serverSocket.accept();

                System.out.println("Zahtev prihvacen sa: " + server.getRemoteSocketAddress());

                ObjectInputStream ois = new ObjectInputStream(server.getInputStream());
//                Zahtev zahtev = (Zahtev) ois.readObject();
//                getMessageLabel().setText(DisplayMessagesServer.PRIMANJE + zahtev.toString());
//
//                Odgovor odgovor = null;
//                if(zahtev.getAction().equals("getAllRooms")){
//                    odgovor = new Odgovor();
//                    odgovor.setSobe(dbManager.getAllPlayers());
//                    odgovor.setOdradjenaAkcija(zahtev.getAction());
//                } else if(zahtev.getAction().equals("book")) {
//                    odgovor = new Odgovor();
//                    int id = zahtev.getId();
//                    String owner = zahtev.getOwner();
//                    String date  = zahtev.getDate();
//                    try{
//                        dbManager.book(id, owner, date);
//                        odgovor.setOdradjenaAkcija("book");
//                    } catch(BookingException be){
//                        odgovor.setMessage(be.getMessage());
//                    }
//                } else if(zahtev.getAction().equals("cancelBooking")) {
//                    odgovor = new Odgovor();
//                    int id = zahtev.getId();
//                    try{
//                        dbManager.cancelBooking(id);
//                        odgovor.setOdradjenaAkcija("cancelBooking");
//                    } catch(CancelBookingException cbe){
//                        odgovor.setMessage(cbe.getMessage());
//                    }
//                }

                ObjectOutputStream oos = new ObjectOutputStream(server.getOutputStream());
//                oos.writeObject(odgovor);
//                getOutputMessageLabel().setText(DisplayMessagesServer.USPESNO + odgovor.toString());
                oos.flush();

                server.close();
            } catch (SocketTimeoutException s) {
                System.out.println("Socket timed out!");
                break;
            } catch (IOException e) {
                System.out.println("IOException Server obrada zahteva");
                e.printStackTrace();
                break;
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
            }
        }
    }
}
