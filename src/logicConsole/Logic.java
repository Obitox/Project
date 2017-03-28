package logicConsole;

import logicConsole.*;

/**
 * Created by Vlatacom on 23.3.2017..
 */
public class Logic {

    private static Table table;

    public static void setTable(Table table) {
        Logic.table = table;
    }

    public static boolean canHeMove(House house){
        if(house.isInGame()){
            System.out.println(Dice.diceRoll());
            return true;
        }
        else{
            for (int i=0;i<3;i++){
                if(Dice.diceRoll()==6) {
                    System.out.println(Dice.value);
                    return true;

                }
                else System.out.println(Dice.value);
            }
            return false;
        }
    }

    public static boolean move(int figureID){
        boolean turn=true;

        if (table.getHouseTurn().isInGame()) {
            if (table.getHouseTurn().getFigure(figureID-1).isInGame()) {
                System.out.println("TEST1");
                if(table.getHouseTurn().getFigure(figureID-1).isInParking()){
                    //AKO JE FIGURA U PARKINGU
                    System.out.println("TEST2");
                   turn=moveOnParking(figureID);
                    System.out.println(table.toString());



                }
                else{
                    System.out.println("TEST3");
                    if(isDestinationInParking(figureID)){
                        System.out.println("TEST4");
                        turn=moveToParking(figureID);
                        System.out.println(table.toString());





                    }
                    else{
                        System.out.println("TEST5");
                        turn=moveOnTable(figureID);
                        System.out.println(table.toString());
                    }
                }

            } else {
                if (table.getDiceValue() == 6) {
                    turn=enterGame(figureID);
                    System.out.println(table.toString());
                }
            }
        } else {

            if (table.getDiceValue() == 6) {
                turn=enterGame(figureID);
                System.out.println(table.toString());
            }
        }
        return turn;

    }


    public static boolean enterGame(int figureID){
        int fieldValue=table.getFieldValue(table.getHouseTurn().getStartPosition());
        int startPositon=table.getHouseTurn().getStartPosition();
        if(isFieldAvailable(fieldValue)){

            if(fieldValue!=0) {

                returnFigureToHouse(fieldValue);
                setFigureOnField(figureID,startPositon);
            }
            else{

                setFigureOnField(figureID,startPositon);
            }
            return true;

        }else{

            return false;
        }
    }

    private static boolean isFieldAvailable(int field){
        int houseIdOnFiled=(field-field%10)/10;
        if((table.getHouseID()!=houseIdOnFiled)||(field==0)) return true;
        else {
            System.out.println("Start field is not free ");
            return false;
        }
    }
    private static boolean isDestinationInParking(int figureID){
        House houseTurn=table.getHouseTurn();
        int destination=(houseTurn.getFigure(figureID-1).getPosition()+table.getDiceValue());
        System.out.printf("");
        if(houseTurn.getFigure(figureID-1).getPosition()>houseTurn.getEndPosition()) return false;
        else{
            if(destination>houseTurn.getEndPosition()) return true;
            else return false;
        }
        //   if(destination>=(houseTurn.getEndPosition()%39)+40) return  true;
        //  else return false;

    }

    private static void setFigureOnField(int figureID, int destination){
        table.getHouseTurn().getFigure(figureID-1).setInGame(true);
        table.getFields()[table.getHouseTurn().getFigure(figureID-1).getPosition()]=0;
        table.getHouseTurn().getFigure(figureID-1).setPosition(destination%40);
        table.getFields()[destination%40]=table.getHouseTurn().getFigure(figureID-1).getId();

    }

    private static void returnFigureToHouse(int figureID){
        int houseID=(figureID-figureID%10)/10;
        House houseTurn=table.getHouseTurn();
        Figure figureTurn=houseTurn.getFigure((figureID-1)-houseID*10);
        table.getFields()[figureTurn.getPosition()]=0;
        table.getHouseWithID(houseID).resetFigure(figureID);

    }

    private static boolean moveOnTable(int figureID){
        House houseTurn=table.getHouseTurn();
        Figure figureTurn=houseTurn.getFigure(figureID-1);

        int destination=figureTurn.getPosition()+table.getDiceValue();
        int fieldValue=table.getFields()[destination%40];

        if(isFieldAvailable(fieldValue)){
            if(fieldValue!=0){
                returnFigureToHouse(fieldValue);
                setFigureOnField(figureID,destination);
            }
            else{
                setFigureOnField(figureID,destination);
            }
            return true;

        }
        else {
            return false;
        }
    }
    private static boolean moveToParking(int figureID){
        House houseTurn=table.getHouseTurn();
        Figure figureTurn=houseTurn.getFigure(figureID-1);
        Parking parkingTurn=table.getParkingWithID(table.getHouseID());
        int parkingFieldIndex=table.getDiceValue()-(houseTurn.getEndPosition()-figureTurn.getPosition())-1;
        int fieldValue;
        if(parkingFieldIndex<4){ fieldValue=parkingTurn.getFields()[parkingFieldIndex];}
        else return false;
        if(fieldValue==0){
            for (int i=0;i<parkingFieldIndex;i++){
                if(parkingTurn.getFields()[i]!=0) return false;
            }
            setFigureInParking(figureID,parkingFieldIndex);
            return true;
        }
        else return false;
    }
    private static void setFigureInParking(int figureID, int parkingFieldIndex){
        table.getFields()[table.getHouseTurn().getFigure(figureID-1).getPosition()]=0;
        table.getHouseTurn().getFigure(figureID-1).setPosition(parkingFieldIndex);
        table.getHouseTurn().getFigure(figureID-1).setInParking(true);
        table.getParkingWithID(table.getHouseID()).getFields()[parkingFieldIndex]= table.getHouseTurn().getFigure(figureID-1).getId();
    }

    private static boolean moveOnParking(int figureID){
        House houseTurn=table.getHouseTurn();
        Figure figureTurn=houseTurn.getFigure(figureID-1);
        Parking parkingTurn=table.getParkingWithID(table.getHouseID());
        int startIndex=figureTurn.getPosition()+1;
        int endIndex=startIndex+table.getDiceValue()-1;
        if(endIndex<4) {
            for (int i =startIndex ; i <=endIndex;i++){
                if(parkingTurn.getFields()[i]!=0) return false;
            }
            parkingTurn.getFields()[startIndex-1]=0;
            parkingTurn.getFields()[endIndex]=figureTurn.getId();
            figureTurn.setPosition(endIndex);
            return true;
        }
        else return false;
    }
    public static boolean isParkingFull(){
        Parking parkingTurn=table.getParkingWithID(table.getHouseID());

        for (int i=0;i<parkingTurn.getFields().length;i++){
            if(parkingTurn.getFields()[i]==0) return false;
        }
        return true;
    }

    public  static boolean isParkingInOrder(){
        boolean b1=false;
        boolean b2=false;

        Parking parkingTurn=table.getParkingWithID(table.getHouseID());

        for (int i=parkingTurn.getFields().length-1;i>=0;i--){
            if(b1==false && parkingTurn.getFields()[i]==0) b1=true;
            if(b1==true&&b2==false&&parkingTurn.getFields()[i]!=0) b2=true;
        }
        return !(b1&&b2);
    }
}

