/**
 * 
 * @author Brandon Jaramillo Anthony  
 * @author Brandon Jamil So
 * @version 1.0
 * 
 */

import java.util.ArrayList;

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
    
    public void addToInventory(Creature newCreature){

        this.playerInv.addToInventory(newCreature);

    }

    public void viewInventory (){

        playerInv.viewInventory();
        
        System.out.println("Current Active Creature: " + activeCreature.getName());

    }
}
    