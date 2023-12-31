/**
 * <B>Inventory of the Player<B>
 * 
 * @author Brandon Jaramillo Anthony  
 * @author Brandon Jamil So
 * @version 1.0
 * 
 */

 import java.util.ArrayList;

public class Inventory {
    //attributes
    
    /**
     *represents the cratures the player currently owns 
     */
    private ArrayList<Creature> roster;
    //methods

    /**
     * creates the array to store creatures
     * @param roster
     * represents the player's currently owned creatures
     */
    public Inventory () {

        roster = new ArrayList<Creature>();

    }

    /**
     * gets a creature from the player's inventory
     * @param roster
     * represents the creatures the player currently owns
     * @param targetCreature
     * represents the creature to be selected
     * @param index 
     * represents the number of target creature
     * @return
     * the target creature
     */
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
    
