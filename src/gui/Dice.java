package gui;

public class Dice {
    private int value;
    private int minimum;
    private int maximum;

    public Dice() {
    }

    public Dice(int minimum, int maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    //public roll
    public int diceRoll(){
        int randomNumber = minimum + (int)(Math.random() * maximum);
        return randomNumber;
    }

//    public static void main(String[] args) {
//        Dice dice = new Dice(1,6);
//        for (int i=0; i<10; i++){
//            System.out.println(dice.diceRoll());
//        }
//    }
}
