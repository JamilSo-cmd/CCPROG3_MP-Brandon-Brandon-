/**
 * <B>Player object of the program<B>
 * 
 * @author Brandon Jaramillo Anthony  
 * @author Brandon Jamil So
 * @version 1.0
 * 
 */
import java.util.Random;

public class Player {
    //attributes

    /**
     *represents the player's inventory
     */
    private Inventory playerInv;    
    /**
     * represents the player's active creature
     */
    private Creature activeCreature;
    /**
     * represents the player's current position on the area
     */    
    private int[][] playerPos;
    //methods

    /**
     * creates the player with obtained inventory
     * @param playerInv
     * represents the player's inventory
     */
    public Player(Inventory playerInv){

        this.playerInv = playerInv;

    }

     /**
     * sets a new active creature for the player
     * @param activeCreature
     * represent the player's current creature
     * @param playerInv
     * represents the player's inventory
     */
    public void setActiveCreature (int index){

        this.activeCreature = playerInv.getCreature(index);
        
    }

    /**
     * calculates the probility of the player catching a creature
     * @return
     * the catch value
     */
    public int catchCreature (){

        Random rand = new Random();
        int max = 100, min = 1;
        // For enemy catch Rate int catchRate = (40+50) - Enemy.getHP();
        
        int catchValue = rand.nextInt(max - min + 1) + min;
        
        return catchValue;
    }
    
     /**
     * adds a new creature into the player's inventory
     * @param playerInv
     * represents the player's inventory
     */
    public void addToInventory(Creature newCreature){

        this.playerInv.addToInventory(newCreature);

    }

    /**
     * shows the information of each creature in the player's inventory, including the current active creature
     * @param activeCreature
     * represent the player's current creature
     * @param playerInv
     * represents the player's inventory
     */
    public void viewInventory (){

        playerInv.viewInventory();
        
        System.out.println("Current Active Creature: " + activeCreature.getName());

    }
}
    
