/**
 * 
 * @author Brandon Jaramillo Anthony  
 * @author Brandon Jamil So
 * @version 1.0
 * 
 */
import java.util.Random;

public class Player {
    //attributes
    private Inventory playerInv;    
    private Creature activeCreature;    
    private int[][] playerPos;
    //methods


    public Player(Inventory playerInv){

        this.playerInv = playerInv;

    }

    public void setActiveCreature (int index){

        this.activeCreature = playerInv.getCreature(index);
        
    }

    public int catchCreature (){

        Random rand = new Random();
        int max = 100, min = 1;
        // For enemy catch Rate int catchRate = (40+50) - Enemy.getHP();
        
        int catchValue = rand.nextInt(max - min + 1) + min;
        
        return catchValue;
    }
    
    public void addToInventory(Creature newCreature){

        this.playerInv.addToInventory(newCreature);

    }

    public void viewInventory (){

        playerInv.viewInventory();
        
        System.out.println("Current Active Creature: " + activeCreature.getName());

    }
}
    
