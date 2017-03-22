package gui;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.Random;

/**
 * Created by Vlatacom on 17.3.2017..
 */
public class Table extends Thread implements EventHandler {
    /*

    niz od 4 kucica
    niz od 40 polja
    niz od 4 parkinga
     */
    House redHouse;
    House blueHouse;
    House greenHouse ;
    House yellowHouse;

    Parking redParking;
    Parking blueParking;
    Parking greenParking;
    Parking yellowParking;
    Field[] arrayOfFields;

    //TESTING PURPOUSE
    int dice;
    Random random = new Random();
    int currentPosition=0;

    public Table(Pane pane){

        redHouse = new House(Color.RED,pane);
        blueHouse = new House(Color.BLUE,pane);
        greenHouse = new House(Color.GREEN,pane);
        yellowHouse = new House(Color.YELLOW,pane);

        redParking = new Parking(Color.RED,pane);
        blueParking = new Parking(Color.BLUE,pane);
        greenParking = new Parking(Color.GREEN,pane);
        yellowParking = new Parking(Color.YELLOW,pane);
        arrayOfFields = new Field[40];
        initFields(pane);
    }
    public void initFields(Pane pane) {
        int temp=0;
        for (int i = 0; i < arrayOfFields.length; i++) {
            arrayOfFields[i] = new Field();
            if (i >= 0 && i < 11) {
                arrayOfFields[i].setCenterX(60 + temp);
                arrayOfFields[i].setCenterY(60);
                temp += 60;
                if (temp == 660) {
                    temp = 60;
                }
            } else if (i >= 11 && i < 21) {
                arrayOfFields[i].setCenterY(60 + temp);
                arrayOfFields[i].setCenterX(660);
                temp += 60;
                if (temp == 660) {
                    temp = 60;
                }
            } else if (i >= 21 && i < 31) {
                arrayOfFields[i].setCenterX(660 - temp);
                arrayOfFields[i].setCenterY(660);
                temp += 60;
                if (temp == 660) {
                    temp = 60;
                }
            } else {
                arrayOfFields[i].setCenterX(60);
                arrayOfFields[i].setCenterY(660 - temp);
                temp += 60;
            }

            pane.getChildren().add(arrayOfFields[i]);
        }
    }
    //@Override
    //public void run(){
    //    for (int i=0;i<100;i++) {
    //        System.out.println("Hello World");
    //        try {
    //            sleep(500);
    //        } catch (InterruptedException ie) {
    //            ie.printStackTrace();
    //        }
    //    }
    //}

    @Override
    public void handle(Event event) {
        String e = event.getSource().toString();
        if(e.equals("move"))
        {
            dice = random.nextInt(6)+1;
            System.out.println("Dice roll: "+dice);
            if(currentPosition>0){
                arrayOfFields[currentPosition].setFill(Color.BLACK);
            }
            if(dice + currentPosition > 39){
                currentPosition =0;
            }
            else {
                arrayOfFields[dice + currentPosition].setFill(Color.RED);
                currentPosition += dice;
            }

        }
    }

    public int diceRoll(int playerTurn)
    {
        switch(playerTurn){
            case 0:
                if(yellowHouse.playerInGame())
                {
                    dice = random.nextInt(6)+1;
                    System.out.println("Dice roll: "+dice);
                    return dice;

                }
                else
                    {
                        for (int i=0;i<3;i++)
                        {

                            if((dice = random.nextInt(6)+1)==6)
                            {
                                System.out.println("Dice roll: "+dice);
                                return dice;
                            }
                            else System.out.println("Dice roll: "+dice);
                        }
                    }
                break;
            case 1:
                if(redHouse.playerInGame())
                {
                    dice = random.nextInt(6)+1;
                    System.out.println("Dice roll: "+dice);
                    return dice;

                }
                else
                {
                    for (int i=0;i<3;i++)
                    {

                        if((dice = random.nextInt(6)+1)==6)
                        {
                            System.out.println("Dice roll: "+dice);
                            return dice;
                        }
                        else System.out.println("Dice roll: "+dice);
                    }
                }
                break;
            case 2:
                if(blueHouse.playerInGame())
                {
                    dice = random.nextInt(6)+1;
                    System.out.println("Dice roll: "+dice);
                    return dice;

                }
                else
                {
                    for (int i=0;i<3;i++)
                    {

                        if((dice = random.nextInt(6)+1)==6)
                        {
                            System.out.println("Dice roll: "+dice);
                            return dice;
                        }
                        else System.out.println("Dice roll: "+dice);
                    }
                }
                break;

            case 3:
                if(greenHouse.playerInGame())
                {
                    dice = random.nextInt(6)+1;
                    System.out.println("Dice roll: "+dice);
                    return dice;

                }
                else
                {
                    for (int i=0;i<3;i++)
                    {

                        if((dice = random.nextInt(6)+1)==6)
                        {
                            System.out.println("Dice roll: "+dice);
                            return dice;
                        }
                        else System.out.println("Dice roll: "+dice);
                    }
                }
                break;
                default: return 0;




        }
        return 0;

    }
}
