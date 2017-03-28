package logicConsole;


import logicConsole.Figure;

public class House {
    private static int counter=1;
    private int id;
    private Figure[] figures;
    private int startPosition;
    private int endPosition;

    public House(){
        this.id=counter++;
        this.startPosition=this.calcStartPositon();
        this.endPosition=this.calcEndPosition();
        this.initFigures();
    }




    //Init methods
    private int calcStartPositon(){
       /* switch (this.id)
        {
            case 0: return 0;
            case 1: return 10;
            case 2: return 20;
            case 3: return 30;
        }
        return 0;
        */
        return (this.id-1)*10;
    }
    private int calcEndPosition(){
        return (this.startPosition+39)%40;
    }
    private void initFigures(){
        this.figures=new Figure[4];
        for (int i=0;i<figures.length;i++) figures[i]=new Figure(this.id,this.startPosition);
    }

    //Game methods
    public void resetFigure(int figureID){
        int houseID=(figureID-(figureID)%10)/10;

        if(houseID==0) System.out.println("Invalid figreID");
        else if(houseID!=this.id) System.out.println("Wrong houseID");
        else {
            int figureIndex=(figureID-(houseID*10))-1;
            this.figures[figureIndex].setInGame(false);
            this.figures[figureIndex].setPosition(this.startPosition);
        }
    } //sets fiugre.inGame to false and postiton to start position

    public boolean isInParking(int figureID){
        int figureIndex=figureID-1;
        if(figures[figureIndex].getPosition()>(endPosition%39)+40) return true;
        else return false;

    }
    public boolean isInGame(){
       // for (int i=0;i<figures.length;i++) if(figures[i].isInGame()) return true;
      //  return false;
        boolean b1=Logic.isParkingInOrder();
        boolean b2=false;
        for (int i=0;i<figures.length;i++) {
            if(figures[i].isInGame()&&!figures[i].isInParking()) b2=true;
        }
        return !b1||b2;
    }

    public Figure[] getFigures() {
        return figures;
    }

    public Figure getFigure(int figureID){
        return figures[figureID];
    }

    public int getStartPosition() {
        return startPosition;
    }

    public int getFigurePosition(int figureID) {
        return this.getFigure(figureID).getPosition();
    }

    public int getEndPosition() {
        return endPosition;
    }

    @Override
    public String toString() {
        String out="House "+this.id+": ";

        for(int i=0;i<figures.length;i++){
            if(!this.figures[i].isInGame())   out+=""+figures[i].getId()+" ";
            else out+=""+0+" ";
        }

        return out+"\n";
    }

    public static void main(String[] args) {
        House test=new House();
        System.out.printf(""+test.toString());

        test.getFigures()[2].setInGame(true);
        System.out.printf(""+test.toString());

        test.resetFigure(22);
        test.resetFigure(0);
        test.resetFigure(13);
        System.out.println(test.toString());
    }
}
