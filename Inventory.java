/**
 * 
 * @author Brandon Jaramillo Anthony  
 * @author Brandon Jamil So
 * @version 1.0
 * 
 */

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

    public void viewInventory(){
        int i;
        Creature targetCreature;

        for (i = 0; i < roster.size() ; i++){

            targetCreature = roster.get(i);
            System.out.println("\nCreature no: [" + i + "]" +
                                "\nName: " + targetCreature.getName() +
                                "\nType: " + targetCreature.getType() +
                                "\nFamily: " + targetCreature.getFamily() +
                                "\nEvolution Lv: " + targetCreature.getEvolutionLv() + "\n");

        }

    }

}
    
