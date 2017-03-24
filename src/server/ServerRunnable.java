package server;

import client.Player;
import communication.Request;
import communication.Response;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

public class ServerRunnable implements Runnable {
    //private static final String HOST = "192.168.99.109";
    public static final int PORT = 9000;

    public static final int MAX_PLAYERS = 4;
    public static final int MIN_PLAYERS = 2;
    public static final Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
    public static int numberOfSignInPlayers = 0;

    private volatile boolean running;

    private DbManager dbManager;
    private ServerSocket serverSocket;
    private List<Player> allPlayers;
    private List<Player> signInPlayers;

    public ServerRunnable(){
        this.running = true;
        try {
            //DB db = DB.getInstance();
            dbManager = new DbManager();
            allPlayers = dbManager.getAllPlayers();
            signInPlayers = new ArrayList<Player>();
            serverSocket = new ServerSocket(PORT);
            System.out.println("Kreiran serverSocket");
        } catch (IOException e) {
            System.out.println("Exception pri kreiranju Server socketa");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Runnable r = new ServerRunnable();
        Thread t = new Thread(r);
        t.start();
    }

    public void stopThread(){
        running = false;
    }

    @Override
    public void run() {
        System.out.println("Startovana nit za osluskivanje zahteva");
        while (running) {
            try {
                Socket server = serverSocket.accept();

                ObjectInputStream ois = new ObjectInputStream(server.getInputStream());
                Request request = (Request) ois.readObject();
                System.out.println("Zahtev: " + request);
                System.out.println("Prihvacen sa: " + server.getRemoteSocketAddress());

                Response response = createResponse(request);

                ObjectOutputStream oos = new ObjectOutputStream(server.getOutputStream());
                oos.writeObject(response);
                oos.flush();
                System.out.println("Odgovor: " + response);
                System.out.println("Poslat na: " + server.getRemoteSocketAddress());

                server.close();
            } catch (SocketTimeoutException s) {
                System.out.println("Socket timed out!");
                break;
            } catch (IOException e) {
                System.out.println("IOException Server obrada zahteva");
                e.printStackTrace();
                break;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private Response createResponse(Request request){
        Player possiblePlayer = request.getPlayer();
        Response response = null;

        Player dbPlayer = dbManager.getPlayer(possiblePlayer.getUsername(), possiblePlayer.getPassword());
        if(dbPlayer != null){
            switch (request.getAction()){
                case "signIn":
                    if (isAlreadySignIn(dbPlayer)){
                        response = new Response();
                        response.setPlayer(dbPlayer);
                        response.setDoneAction("none");
                        response.setMessage("Player is already signed in");
                        response.setObject(null);
                    } else if ( numberOfSignInPlayers++ < MAX_PLAYERS){
                        response = new Response();
                        response.setPlayer(dbPlayer);
                        response.setDoneAction("signIn");
                        response.setMessage("Successful sign in");
                        response.setObject(null);
                        signInPlayers.add(new Player(dbPlayer.getId(), dbPlayer.getUsername(), dbPlayer.getPassword()));
                    } else {
                        response = new Response();
                        response.setPlayer(dbPlayer);
                        response.setDoneAction("none");
                        response.setMessage("Max number of players is " + MAX_PLAYERS + ". You must wait!");
                        response.setObject(null);
                    }
                    break;
                case "refreshTable":
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
                    break;
                case "myMove":
//                    odgovor = new Odgovor();
//                    int id = zahtev.getId();
//                    try{
//                        dbManager.cancelBooking(id);
//                        odgovor.setOdradjenaAkcija("cancelBooking");
//                    } catch(CancelBookingException cbe){
//                        odgovor.setMessage(cbe.getMessage());
//                    }
                    break;
                default:
                    response = new Response();
                    response.setPlayer(null);
                    response.setDoneAction("none");
                    response.setMessage("Unknown request!");
                    response.setObject(null);
            }
        } else {
            response = new Response();
            response.setPlayer(null);
            response.setDoneAction("none");
            response.setMessage("Unknown user!");
            response.setObject(null);
        }
        return response;
    }

    private boolean isAlreadySignIn(Player dbPlayer){
        for (Player p: signInPlayers){
            if(p.getId() == dbPlayer.getId()){
                return true;
            }
        }
        return false;
    }

}
