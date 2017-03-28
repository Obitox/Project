package logicConsole;

public class Table {
    /*
    4xH
    4xP
    int

     */
  private House redHouse;
  private House greenHouse;
  private House blueHouse;
  private House yellowHouse;

  private Parking redParking;
  private Parking greenParking;
  private Parking blueParking;
  private Parking yellowParking;

  private int[] fields;

  private int houseID; //turn

  private int diceValue;

  public Table(){
      redHouse=new House();
      greenHouse=new House();
      blueHouse=new House();
      yellowHouse=new House();

      redParking=new Parking();
      greenParking=new Parking();
      blueParking=new Parking();
      yellowParking=new Parking();

      fields=new int[40];

      houseID=1;
      diceValue=0;

  }

    @Override
    public String toString() {
        String out=redHouse.toString()+greenHouse.toString()+blueHouse.toString()+yellowHouse.toString()+"\n";
        for (int i=0;i<fields.length;i++) out+=""+fields[i]+" ";
        out+="\n";
        out+="\n"+redParking.toString()+greenParking.toString()+blueParking.toString()+yellowParking.toString()+"\n";
        return out;
    }

    public void incHouseID(){
      this.houseID=(++this.houseID)%5;
      if(this.houseID==0) this.houseID=1;
    }

    public House getHouseTurn(){
        switch (this.houseID){
            case 1: return redHouse;
            case 2: return greenHouse;
            case 3: return blueHouse;
            case 4: return yellowHouse;
        }
        return null;
    }
    public House getHouseWithID(int houseID){
        switch (houseID){
            case 1: return redHouse;
            case 2: return greenHouse;
            case 3: return blueHouse;
            case 4: return yellowHouse;
        }
        return null;
    }
     public Parking getParkingWithID(int houseID){
         switch (houseID){
             case 1: return redParking;
             case 2: return greenParking;
             case 3: return blueParking;
             case 4: return yellowParking;
         }
         return null;
     }
    public int getFieldValue(int index){
       return fields[index];
    }
    public House getRedHouse() {
        return redHouse;
    }

    public House getGreenHouse() {
        return greenHouse;
    }

    public House getBlueHouse() {
        return blueHouse;
    }

    public House getYellowHouse() {
        return yellowHouse;
    }

    public Parking getRedParking() {
        return redParking;
    }

    public Parking getGreenParking() {
        return greenParking;
    }

    public Parking getBlueParking() {
        return blueParking;
    }

    public Parking getYellowParking() {
        return yellowParking;
    }

    public int[] getFields() {
        return fields;
    }

    public int getHouseID() {
        return houseID;
    }

    public int getDiceValue() {
        return diceValue;
    }

    public void setRedHouse(House redHouse) {
        this.redHouse = redHouse;
    }

    public void setGreenHouse(House greenHouse) {
        this.greenHouse = greenHouse;
    }

    public void setBlueHouse(House blueHouse) {
        this.blueHouse = blueHouse;
    }

    public void setYellowHouse(House yellowHouse) {
        this.yellowHouse = yellowHouse;
    }

    public void setRedParking(Parking redParking) {
        this.redParking = redParking;
    }

    public void setGreenParking(Parking greenParking) {
        this.greenParking = greenParking;
    }

    public void setBlueParking(Parking blueParking) {
        this.blueParking = blueParking;
    }

    public void setYellowParking(Parking yellowParking) {
        this.yellowParking = yellowParking;
    }

    public void setFields(int[] fields) {
        this.fields = fields;
    }

    public void setHouseID(int houseID) {
        this.houseID = houseID;
    }

    public void setDiceValue(int diceValue) {
        this.diceValue = diceValue;
    }
}
