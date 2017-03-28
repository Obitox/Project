package logicConsole;

import sun.rmi.runtime.Log;

import java.util.Scanner;

/**
 * Created by Vlatacom on 23.3.2017..
 */
public class Game extends Thread {
    private Table table;

    public Game(){
        table=new Table();
    }
    @Override
    public void run() {
        boolean game=true;
        Scanner sc= new Scanner(System.in);
        Logic.setTable(table);
        boolean gameOver=true;
        while(gameOver){

            System.out.println("It's player "+table.getHouseID()+" turn");


            do {
                boolean playerInGame=table.getHouseTurn().isInGame();
                for (int i = 0; i < 3; i++) {
                    table.setDiceValue(Dice.diceRoll());
                    System.out.println("Player " + table.getHouseID() + " rolled: " + table.getDiceValue());
                    if (table.getDiceValue() == 6 || playerInGame||!Logic.isParkingInOrder()) break;
                }

                boolean uslov;
                do {
                    System.out.println("Enter the number of the figure you want to move:");
                    int temp = sc.nextInt();
                    if(temp!=0)uslov = Logic.move(temp);
                    else uslov=true;

                } while (!uslov);

            }while(table.getDiceValue()==6);
            gameOver=!Logic.isParkingFull();


            table.incHouseID();


        }
    }
}
