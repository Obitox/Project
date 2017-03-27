package logicConsole;

import java.util.Random;

/**
 * Created by Vlatacom on 23.3.2017..
 */

public class Dice {
    public static int value;
    public static int diceRoll(){
        Random dice=new Random();
        return value=dice.nextInt(6)+1;
    }
}
