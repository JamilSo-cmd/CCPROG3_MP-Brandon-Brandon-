import java.util.ArrayList;

public class Inventory {
    //attributes
    private ArrayList<Creature> roster;
    //methods

    public Inventory () {

        roster = new ArrayList<Creature>();

    }

    public Creature getCreature(int index){
        
        Creature targetCreature;

        targetCreature = roster.get(index);

        return targetCreature;
    }

    public void addToInventory(Creature newCreature){

        roster.add(newCreature);

    }
}
    