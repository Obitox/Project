package server;

import client.Player;
import communication.Request;
import communication.Response;

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
    public static final String[] colors = {"red", "blue", "green", "yellow"};
    public static final int NUMBER_OF_FIELDS = 40;
    public static volatile int numberOfSignInPlayers = 0;

    private volatile boolean running;

    private DbManager dbManager;
    private ServerSocket serverSocket;
    private List<Player> allPlayers;
    private List<Player> signInPlayers;

    private int[] table;

    public ServerRunnable(){
        this.running = true;
        try {
            //DB db = DB.getInstance();
            dbManager = new DbManager();
            allPlayers = dbManager.getAllPlayers();
            signInPlayers = new ArrayList<Player>();
            table = new int[] {0,0,0,0,0,0,0,0,0,0};

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

                Response response = this.createResponse(request);

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
                        dbPlayer.setId(-1);
                        dbPlayer.setPassword("");
                        response.setPlayer(dbPlayer);
                        response.setDoneAction("none");
                        response.setMessage("Player is already signed in");
                        response.setTable(null);
                    } else if ( signInPlayers.size() < MAX_PLAYERS){
                        response = new Response();
                        this.setColorOfPlayer(dbPlayer);
                        response.setPlayer(dbPlayer);
                        response.setDoneAction("signIn");
                        response.setMessage("Successful sign in");
                        response.setTable(table);
                        signInPlayers.add(dbPlayer);
                        ++numberOfSignInPlayers;
                        //System.out.println("Broj ulogovanih (posle dodavanja): " + signInPlayers.size());
                        System.out.println("Broj ulogovanih (posle dodavanja): " + numberOfSignInPlayers);
                    } else {
                        response = new Response();
                        dbPlayer.setId(-1);
                        dbPlayer.setPassword("");
                        response.setPlayer(dbPlayer);
                        response.setDoneAction("none");
                        response.setMessage("Max number of players is " + MAX_PLAYERS + ". You must wait!");
                        response.setTable(null);
                    }
                    break;
                case "signOut":
                    if (isAlreadySignIn(dbPlayer)){
                        response = new Response();

                        Player responsePlayer = request.getPlayer();
                        responsePlayer.setId(-1);
                        responsePlayer.setPassword("");
                        responsePlayer.setColor("");

                        response.setPlayer(responsePlayer);
                        response.setDoneAction("signOut");
                        response.setMessage("Player is signed out");
                        response.setTable(null);
                        //NEIZBACUJE igraca iz liste ulogovanih!!!
                        this.removePlayerFromList(request.getPlayer(), signInPlayers);
                        //signInPlayers.remove(request.getPlayer());
                        for(Player p : signInPlayers) System.out.println(p);
                        --numberOfSignInPlayers;
                        System.out.println("Broj ulogovanih (posle izbacivanja): " + numberOfSignInPlayers);
                    }
                    break;
                case "refreshTable":
                    // TO DO
                    break;
                case "myMove":
                    if (isAlreadySignIn(dbPlayer)){
                        response = new Response();

                        Player responsePlayer = request.getPlayer();
                        int figureMove = request.getFigureMove();
                        int diceValue = request.getDiceValue();
                        String figureColor = request.getPlayer().getColor();

                        System.out.println("Pomeranje figurice " + figureColor + figureMove + " za " + diceValue);

                        //TO DO
                            //Move specified figure for dice value

                        response.setPlayer(responsePlayer);
                        response.setDoneAction("myMove");
                        response.setMessage("Player played his move");

                        //TO DO
                            //Refresh table
                            //Set refreshed table to response
                        response.setTable(table);
                    }
                    break;
                default:
                    response = new Response();
                    response.setPlayer(dbPlayer);
                    response.setDoneAction("none");
                    response.setMessage("Unknown request!");
                    response.setTable(null);
            }
        } else {
            response = new Response();
            response.setPlayer(null);
            response.setDoneAction("none");
            response.setMessage("Unknown user!");
            response.setTable(null);
        }

        return response;
    }

    private void removePlayerFromList(Player player, List<Player> players){
        Player playerToRemove = null;
        for (Player p : players){
            if(p.getId()==player.getId()){
                playerToRemove = p;
            }
        }
        players.remove(playerToRemove);
    }

    private void setColorOfPlayer(Player dbPlayer){
        int i = signInPlayers.size();
        dbPlayer.setColor(colors[i]);
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
