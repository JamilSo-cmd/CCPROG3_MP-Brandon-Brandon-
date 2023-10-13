import java.util.ArrayList;

public class Inventory {
    //attributes
    private ArrayList<Creature> roster;
    //methods

    public Inventory () {

        roster = new ArrayList<Creature>();

    }

    public void addToInventory(Creature newCreature){

        roster.add(newCreature);

    }
}
    