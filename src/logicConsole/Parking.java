package logicConsole;

/**
 * Created by Vlatacom on 23.3.2017..
 */
public class Parking {
    private static int counter=1;
    private int id;
    private int[] fields;

    public Parking(){
        id=counter++;
        fields=new int[4];
    }

    public int[] getFields() {
        return fields;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        String out="Parking "+this.id+": ";
        for (int i=0;i<fields.length;i++) out+=""+fields[i]+" ";
        return out+"\n";
    }

    public static void main(String[] args) {
        Parking test=new Parking();
        System.out.println(test.toString());

        test.getFields()[2]=11;

        System.out.println(test.toString());
    }
}
